package com.company.message;

import com.company.message.dao.model.Message;
import com.company.message.model.MessageDTO;

/**
 * Abstract Factory for creating Message model Objects
 * 
 * @author marcin
 *
 */
public interface IMessageAbstractFactory {

	public Message createMessage(String id, String title, String body);

	public MessageDTO createMessageDTO(String id, String title, String body);

	public Message createMessage(MessageDTO messageDTO);

	public MessageDTO createMessageDTO(Message message);
}
