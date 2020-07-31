package ru.geekbrains.mortgage;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.geekbrains.mortgage.entity.MortgageApplication;
import ru.geekbrains.mortgage.entity.ResolutionStatus;
import ru.geekbrains.mortgage.repository.MortgageApplicationRepository;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
class MortgageApplicationTests {

	@Autowired
	private MortgageApplicationRepository repository;

	@BeforeEach
	public void setUp() {
		repository.deleteAll();

		List<MortgageApplication> applicationList = Arrays.asList(
			new MortgageApplication("Ivanov Ivan", ResolutionStatus.TERRORIST),
			new MortgageApplication("Ivanov Vladislav", ResolutionStatus.SUCCESSFUL),
			new MortgageApplication("Rybkin Ivan", ResolutionStatus.SUCCESSFUL),
			new MortgageApplication("Ivanova Olga", ResolutionStatus.SUCCESSFUL),
			new MortgageApplication("Ivanova Elena", ResolutionStatus.SUCCESSFUL)
		);

		repository.saveAll(applicationList);
	}

	@Test
	void contextLoads() {
		List<MortgageApplication> al = repository.getAllByStatusEquals(ResolutionStatus.TERRORIST);
		Assertions.assertThat(al.size() == 1);
	}

}
