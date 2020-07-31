package ru.geekbrains.mortgage.services;

import org.springframework.stereotype.Service;
import ru.geekbrains.mortgage.entity.MortgageApplication;
import ru.geekbrains.mortgage.model.MortgageRequest;

import java.util.Random;

@Service
public class PoliceService {

    public boolean isTerrorist(MortgageRequest request) {
        Random random = new Random();
        return random.nextInt(100) < 10; //10%
    }
}
