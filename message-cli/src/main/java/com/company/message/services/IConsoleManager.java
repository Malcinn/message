package com.company.message.services;

public interface IConsoleManager {

	/**
	 * Method prints welcome message.
	 */
	public void printWelcomeMessage();

	/**
	 * Method prints menu of CLI application.
	 */
	public void printMenu();

	/**
	 * Methods process actions for responding number.
	 * 
	 * @param integer
	 *            action number.
	 * @return true if action was processed, in other case false.
	 */
	public boolean processAction(Integer integer);

	/**
	 * Method gets input from user.
	 * 
	 * @return user input
	 */
	public Integer getInput();

	/**
	 * Method prints wrong selection message.
	 */
	public void printWrongSelectionMessage();

	/**
	 * Method prints goodbye message.
	 */
	public void printGoodbyeMessage();
}
