package ru.geekbrains.mortgage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.mortgage.entity.MortgageApplication;
import ru.geekbrains.mortgage.entity.ResolutionStatus;

import java.util.List;

public interface MortgageApplicationRepository extends JpaRepository<MortgageApplication, Long> {

    List<MortgageApplication> getAllByStatusEquals(ResolutionStatus status);

}
