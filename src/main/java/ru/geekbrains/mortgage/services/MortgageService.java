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

    public MortgageService(
        MortgageApplicationRepository repository,
        PoliceService policeService) {
        this.repository = repository;
        this.policeService = policeService;
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
        MortgageApplication application = new MortgageApplication();
        application.setName(request.getName());
        application.setStatus(ResolutionStatus.SUCCESSFUL);

        application = repository.save(application);
        MortgageResponse response = new MortgageResponse();
        response.setId(application.getId());
        response.setRequest(request);
        response.setResolution("OK");
        return response;
    }
}




/*
    @Service
    @Repository
    @Controller

    @Component
 */