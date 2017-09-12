package com.company.message;

import com.company.message.dao.model.Message;
import com.company.message.model.MessageDTO;

public class SimpleMessageAbstractFactory implements IMessageAbstractFactory {

	@Override
	public Message createMessage(String id, String title, String body) {
		Message message = new Message();
		message.setId(id);
		message.setTitle(title);
		message.setBody(body);
		return message;
	}

	@Override
	public MessageDTO createMessageDTO(String id, String title, String body) {
		MessageDTO messageDTO = new MessageDTO();
		messageDTO.setId(id);
		messageDTO.setTitle(title);
		messageDTO.setBody(body);
		return messageDTO;
	}

	@Override
	public Message createMessage(MessageDTO messageDTO) {
		Message message = new Message();
		message.setId(messageDTO.getId());
		message.setTitle(messageDTO.getTitle());
		message.setBody(messageDTO.getBody());
		return message;
	}

	@Override
	public MessageDTO createMessageDTO(Message message) {
		MessageDTO messageDTO = new MessageDTO();
		messageDTO.setId(message.getId());
		messageDTO.setTitle(message.getTitle());
		messageDTO.setBody(message.getBody());
		return messageDTO;
	}

}
