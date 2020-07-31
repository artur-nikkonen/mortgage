package ru.geekbrains.mortgage.services;

import org.springframework.stereotype.Service;
import ru.geekbrains.mortgage.entity.MortgageApplication;

@Service
public class PoliceService {

    public boolean getIsTerrorist(MortgageApplication application) {
        return false;
    }
}
