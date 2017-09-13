package com.company.message;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.company.message.services.IConsoleManager;

public class Application {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Beans.xml");
		IConsoleManager consoleManager = applicationContext.getBean("consoleManager", IConsoleManager.class);

		consoleManager.printWelcomeMessage();
		consoleManager.printMenu();

		Integer input = 10;
		while (input != null && input != 0) {
			input = consoleManager.getInput();
			if (consoleManager.processAction(input)) {
				consoleManager.printMenu();
			} else {
				consoleManager.printWrongSelectionMessage();
			}
		}
	}

}
