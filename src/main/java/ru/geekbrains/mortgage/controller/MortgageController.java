package ru.geekbrains.mortgage.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.geekbrains.mortgage.model.MortgageList;
import ru.geekbrains.mortgage.model.MortgageRequest;
import ru.geekbrains.mortgage.model.MortgageResponse;
import ru.geekbrains.mortgage.services.MortgageService;

@RestController
public class MortgageController {

    private final MortgageService service;

    public MortgageController(
        MortgageService service) {
        this.service = service;
    }

    @GetMapping("/mortgages")
    public MortgageList getAll() {
        return service.getAllMortgages();
    }

    @GetMapping("/mortgages/successful")
    public MortgageList getAllSuccessful() {
        return service.getAllSuccessfulMortgages();
    }

    @PostMapping("/mortgage")
    public MortgageResponse registerApplication(@RequestBody MortgageRequest request) {
        return service.registerApplication(request);
    }
}
