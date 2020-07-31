package ru.geekbrains.mortgage.services;

import org.springframework.stereotype.Service;
import ru.geekbrains.mortgage.entity.MortgageApplication;
import ru.geekbrains.mortgage.entity.ResolutionStatus;
import ru.geekbrains.mortgage.model.MortgageList;
import ru.geekbrains.mortgage.model.MortgageRequest;
import ru.geekbrains.mortgage.model.MortgageResponse;
import ru.geekbrains.mortgage.repository.MortgageApplicationRepository;

import java.util.List;

@Service
public class MortgageService {

    private final MortgageApplicationRepository repository;
    private final PoliceService policeService;
    private final NalogService nalogService;

    public MortgageService(MortgageApplicationRepository repository, PoliceService policeService, NalogService nalogService) {
        this.repository = repository;
        this.policeService = policeService;
        this.nalogService = nalogService;
    }

    public MortgageList getAllMortgages() {
        return new MortgageList(repository.findAll());
    }

    public MortgageList getAllSuccessfulMortgages() {
        List<MortgageApplication> allSuccessful =
                repository.getAllByStatusEquals(ResolutionStatus.SUCCESSFUL);

        return new MortgageList(allSuccessful);
    }

    public MortgageResponse registerApplication(MortgageRequest request) {
        MortgageApplication application = fillApplication(request);

        application = repository.save(application);

        return getMortgageResponse(request, application);
    }

    private MortgageResponse getMortgageResponse(MortgageRequest request, MortgageApplication application) {
        MortgageResponse response = new MortgageResponse();
        response.setId(application.getId());
        response.setRequest(request);

        if (application.getStatus() == ResolutionStatus.SUCCESSFUL) {
            response.setResolution("Approved");
        } else {
            response.setResolution("Not Approved");
        }

        return response;
    }

    private MortgageApplication fillApplication(MortgageRequest request) {
        MortgageApplication application = new MortgageApplication();
        application.setName(request.getName());

        if (policeService.isTerrorist(request)) {
            application.setStatus(ResolutionStatus.TERRORIST);
        } else if (nalogService.isLowBudget(request)) {
            application.setStatus(ResolutionStatus.LOW_BUDGET);
        } else {
            application.setStatus(ResolutionStatus.SUCCESSFUL);
        }
        return application;
    }
}
