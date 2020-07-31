package ru.geekbrains.mortgage.services;

import org.springframework.stereotype.Service;
import ru.geekbrains.mortgage.entity.MortgageApplication;
import ru.geekbrains.mortgage.model.MortgageRequest;

import java.util.Random;

@Service
public class NalogService {

    public boolean isLowBudget(MortgageRequest request){
        Random random = new Random();
        return random.nextInt(100) < 50; //50%
    }
}
