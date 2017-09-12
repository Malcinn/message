package com.company.message.dao.services;

import com.company.message.exceptions.MessageNotExistException;
import com.company.message.exceptions.MessageNotFoundException;
import com.company.message.model.MessageDTO;

public interface IMessageDAO {

	/**
	 * Method insert object to data source.
	 * 
	 * @param messageDTO
	 *            message to insert.
	 * @return id of newly created message.
	 */
	public String insertMessage(MessageDTO messageDTO);

	/**
	 * Method deletes message object from data source.
	 * 
	 * @param id
	 *            message id which will be removed.
	 * @return true if message will be deleted. Either false.
	 */
	public boolean deleteMessage(String id) throws MessageNotFoundException;

	/**
	 * Method find message.
	 * 
	 * @param id
	 *            message id.
	 * @return {@link MessageDTO} if message exist in data source. Either null.
	 */
	public MessageDTO findMessage(String id) throws MessageNotFoundException;

	/**
	 * Method updates message
	 * 
	 * @param messageDTO
	 *            message that will be updated.
	 * @return true if message successfully updated. Either false.
	 */
	public boolean updateMessage(MessageDTO messageDTO) throws MessageNotExistException;
}
