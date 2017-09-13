package com.company.message.services;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.company.message.IMessageAbstractFactory;
import com.company.message.dao.services.IMessageDAO;
import com.company.message.exceptions.MessageNotExistException;
import com.company.message.exceptions.MessageNotFoundException;
import com.company.message.model.MessageDTO;

public class ConsoleManager implements IConsoleManager {

	private IMessageDAO iMessageDAO;

	private IMessageAbstractFactory iMessageAbstractFactory;

	private static final Logger LOG = LogManager.getLogger(ConsoleManager.class);

	private Scanner scanner = new Scanner(System.in);

	@Override
	public void printWelcomeMessage() {
		println("Hello!");
		println("Welcome in message application.");
	}

	@Override
	public void printMenu() {
		println("Please select an action: ");
		println("1 - insert message ");
		println("2 - delete message");
		println("3 - find message");
		println("4 - update message");
		println("5 - print all messages");
		println("0 - exit");
	}

	@Override
	public Integer getInput() {
		String line = "";
		while (line != null && !line.equals("0")) {
			line = scanner.nextLine();
			try {
				return Integer.valueOf(line);
			} catch (NumberFormatException e) {
				LOG.error("Can not parse : " + line + " , to Integer.");
			}
		}
		return Integer.parseInt(line);
	}

	@Override
	public void printWrongSelectionMessage() {
		println("Wrong selection. Please select again.");
	}

	@Override
	public void printGoodbyeMessage() {
		println("bye bye :)");
	}

	public void print(String string) {
		System.out.print(string);
	}

	public void println(String string) {
		System.out.println(string);
	}

	@Override
	public boolean processAction(Integer integer) {
		boolean result = true;
		switch (integer) {
		case 1:
			insertMessageAction();
			break;
		case 2:
			deleteMessageAction();
			break;
		case 3:
			findMessageAction();
			break;
		case 4:
			updateMessageAction();
			break;
		case 5:
			printMessagesAction();
			break;
		case 0:
			result = false;
			break;
		default:
			result = false;
			break;
		}
		return result;
	}

	private void printMessagesAction() {
		println("Messages: ");
		for (MessageDTO messageDTO : iMessageDAO.getMessages()) {
			println(messageDTO.toString());
		}
	}

	private void updateMessageAction() {
		print("insert message id: ");
		String messageId = scanner.nextLine();
		println("insert title: ");
		String messageTitle = scanner.nextLine();
		println("insert body: ");
		String messageBody = scanner.nextLine();
		try {
			boolean result = iMessageDAO
					.updateMessage(iMessageAbstractFactory.createMessageDTO(messageId, messageTitle, messageBody));
			if (result) {
				println("Message updated.");
			}
		} catch (MessageNotExistException e) {
			LOG.error("Message with id : " + messageId + " NOT exist.");
		}
	}

	private void findMessageAction() {
		print("insert message id: ");
		String messageId = scanner.nextLine();
		try {
			println(iMessageDAO.findMessage(messageId).toString());
		} catch (MessageNotFoundException e) {
			LOG.error("NOT found Message with id : " + messageId);
		}
	}

	private void deleteMessageAction() {
		print("insert message id: ");
		String messageToDeleteId = scanner.nextLine();
		try {
			iMessageDAO.deleteMessage(messageToDeleteId);
		} catch (MessageNotFoundException e) {
			LOG.error("NOT found Message with id : " + messageToDeleteId);
		}
	}

	private void insertMessageAction() {
		println("insert title: ");
		String title = scanner.nextLine();
		println("insert body: ");
		String body = scanner.nextLine();
		iMessageDAO.insertMessage(new MessageDTO("", title, body));
	}

	public IMessageDAO getiMessageDAO() {
		return iMessageDAO;
	}

	public void setiMessageDAO(IMessageDAO iMessageDAO) {
		this.iMessageDAO = iMessageDAO;
	}

	public IMessageAbstractFactory getiMessageAbstractFactory() {
		return iMessageAbstractFactory;
	}

	public void setiMessageAbstractFactory(IMessageAbstractFactory iMessageAbstractFactory) {
		this.iMessageAbstractFactory = iMessageAbstractFactory;
	}

}
