package com.company.message.exceptions;

@SuppressWarnings("serial")
public class MessageNotExistException extends Exception {

	public MessageNotExistException(String message) {
		super(message);
	}
}
