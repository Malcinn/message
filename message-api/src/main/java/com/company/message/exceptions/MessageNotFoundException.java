package com.company.message.exceptions;

@SuppressWarnings("serial")
public class MessageNotFoundException extends Exception {

	public MessageNotFoundException(String message) {
		super(message);
	}

}
