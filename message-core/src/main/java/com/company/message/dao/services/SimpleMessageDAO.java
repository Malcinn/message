package com.company.message.dao.services;

import java.util.ArrayList;
import java.util.List;

import com.company.message.IMessageAbstractFactory;
import com.company.message.dao.model.Message;
import com.company.message.exceptions.MessageNotExistException;
import com.company.message.exceptions.MessageNotFoundException;
import com.company.message.model.MessageDTO;

public class SimpleMessageDAO implements IMessageDAO {

	private List<Message> messages = new ArrayList<Message>();

	private IMessageAbstractFactory iMessageAbstractFactory;

	@Override
	public String insertMessage(MessageDTO messageDTO) {
		Message message = iMessageAbstractFactory.createMessage(messageDTO);
		message.setId(MessageDAOUtil.getNextId(messages));
		messages.add(message);
		return message.getId();
	}

	@Override
	public boolean deleteMessage(String id) throws MessageNotFoundException {
		MessageDTO messageDTO = findMessage(id);
		if (messageDTO != null) {
			Message messageToRemove = iMessageAbstractFactory.createMessage(messageDTO);
			Integer messageToRemoveIndex = MessageDAOUtil.findMessageIndex(messages, messageToRemove);
			if (messageToRemoveIndex != null) {
				messages.remove(messageToRemoveIndex.intValue());
				return true;
			}
		}
		return false;
	}

	@Override
	public MessageDTO findMessage(String id) throws MessageNotFoundException {
		for (Message message : messages) {
			if (message.getId().equals(id)) {
				return iMessageAbstractFactory.createMessageDTO(message);
			}
		}
		throw new MessageNotFoundException("Not found message with id : " + id);
	}

	@Override
	public boolean updateMessage(MessageDTO messageDTO) throws MessageNotExistException {
		Message messageToUpdate = iMessageAbstractFactory.createMessage(messageDTO);
		Integer messageToUpdateIndex = MessageDAOUtil.findMessageIndex(messages, messageToUpdate);
		if (null != messageToUpdateIndex) {
			messageToUpdate = messages.get(messageToUpdateIndex.intValue());
			messageToUpdate.setBody(messageDTO.getBody());
			messageToUpdate.setTitle(messageDTO.getTitle());
			return true;
		} else {
			throw new MessageNotExistException("Message with id : " + messageDTO.getId() + " not exist.");
		}
	}

	@Override
	public List<MessageDTO> getMessages() {
		List<MessageDTO> returnList = new ArrayList<MessageDTO>();
		for (Message message : messages) {
			returnList.add(iMessageAbstractFactory.createMessageDTO(message));
		}
		return returnList;
	}

	public void clean() {
		messages.clear();
	}

	public IMessageAbstractFactory getiMessageAbstractFactory() {
		return iMessageAbstractFactory;
	}

	public void setiMessageAbstractFactory(IMessageAbstractFactory iMessageAbstractFactory) {
		this.iMessageAbstractFactory = iMessageAbstractFactory;
	}

}
