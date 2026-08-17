package com.yahya.aopdemo;

import com.yahya.aopdemo.dao.AccountDAO;
import com.yahya.aopdemo.dao.MembershipDAO;
import com.yahya.aopdemo.service.TrafficFortuneService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO accountDAO, MembershipDAO membershipDAO, TrafficFortuneService trafficFortuneService) {
		return runner -> {
//			demoBeforeAdvice(accountDAO, membershipDAO);
//			afterReturningAdvice(accountDAO);
//			demoAfterAdvice(accountDAO);
			demoArroundAdvice(trafficFortuneService);
		};
	}

	private void demoArroundAdvice(TrafficFortuneService trafficFortuneService) {
		System.out.println("Demo Around Advice Program: ");
		String data = trafficFortuneService.getFortune();
		System.out.println("My fortune is:" + data);
		System.out.println("Done");
	}

	private void demoAfterAdvice(AccountDAO accountDAO) {
		// call method to find the accounts
		List<Account> theAccounts = null;

		try {
			// add a boolean flag to simulate exceptions
			boolean tripWire = false;
			theAccounts = accountDAO.findAccounts();
		}
		catch (Exception exc) {
			System.out.println("\n\nMain Program: ... caught exception: " + exc);
		}

		// display the accounts
		System.out.println("\n\nMain Program: demoTheAfterAdvice");
		System.out.println("----");

		System.out.println(theAccounts);

		System.out.println("\n");
	}

	private void afterReturningAdvice(AccountDAO accountDAO) {
		// call method to find accounts
		List<Account> theAccounts = accountDAO.findAccounts();
		System.out.println("\n\n ====== \n\n");
		System.out.println(theAccounts);
	}

	private void demoBeforeAdvice(AccountDAO accountDAO, MembershipDAO membershipDAO) {
		accountDAO.setName("Yahya");
		accountDAO.setLevel("section 10 AOP");

		String name = accountDAO.getName();
		String level = accountDAO.getLevel();

		accountDAO.addAccount(new Account());
	}
}
