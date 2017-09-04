package com.company.message.services;

import java.util.List;

import com.company.message.exceptions.MessageNotExistException;
import com.company.message.exceptions.MessageNotFoundException;
import com.company.message.model.MessageDTO;

/**
 * Service that delivers data and informations about Messages.
 * 
 * @author marcin
 *
 */
public interface IMessageService {

	/**
	 * Method find all messages.
	 * 
	 * @return {@link MessageDTO} objects representing message.
	 */
	public List<MessageDTO> getMessages();

	/**
	 * Method find message by id.
	 * 
	 * @param id
	 *            message id.
	 * @return {@link MessageDTO} object representing message.
	 */
	public MessageDTO getMessage(String id) throws MessageNotFoundException;

	/**
	 * Methods modify message with given id
	 * 
	 * @param id
	 *            : message id
	 * @param title
	 *            : new message title
	 * @param body
	 *            : new message body @
	 */
	public void modifyMessage(String id, String title, String body) throws MessageNotExistException;
}
