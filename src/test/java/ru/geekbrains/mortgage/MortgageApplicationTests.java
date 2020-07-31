package ru.geekbrains.mortgage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.geekbrains.mortgage.controller.MortgageController;
import ru.geekbrains.mortgage.entity.MortgageApplication;
import ru.geekbrains.mortgage.entity.ResolutionStatus;
import ru.geekbrains.mortgage.model.MortgageRequest;
import ru.geekbrains.mortgage.repository.MortgageApplicationRepository;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.closeTo;

@SpringBootTest
class MortgageApplicationTests {

    @Autowired
    private MortgageApplicationRepository repository;
    @Autowired
    private MortgageController controller;

    @BeforeEach
    public void setUp() {
        repository.deleteAll();
    }

    @Test
    void applicationStatusTest() {

        for (int i = 0; i < 100; i++) {
            MortgageRequest mortgageRequest = new MortgageRequest();
            mortgageRequest.setName("Client " + i);
            controller.registerApplication(mortgageRequest);
        }

        List<MortgageApplication> terrorists = repository.getAllByStatusEquals(ResolutionStatus.TERRORIST);
        List<MortgageApplication> lowBudgets = repository.getAllByStatusEquals(ResolutionStatus.LOW_BUDGET);
        List<MortgageApplication> successful = repository.getAllByStatusEquals(ResolutionStatus.SUCCESSFUL);

        int total = terrorists.size() + lowBudgets.size() + successful.size();
        double terroristsPercent = (double) terrorists.size() / total;
        double lowBudgetPercent = (double) lowBudgets.size() / (total - terrorists.size());

        assertThat(terroristsPercent, closeTo(0.1, 0.02));
        assertThat(lowBudgetPercent, closeTo(0.5, 0.1));
    }
}
