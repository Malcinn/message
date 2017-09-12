package com.company.message.dao.services;

import java.math.BigDecimal;
import java.util.List;

import com.company.message.dao.model.Message;

public class MessageDAOUtil {

	private static final String FIRST_ID = "1";

	private static final int GREATER_THAN = 1;

	public static String getNextId(List<Message> messages) {
		if (null != messages) {
			BigDecimal maxId = new BigDecimal(FIRST_ID);
			for (Message message : messages) {
				BigDecimal currentId = new BigDecimal(message.getId());
				if (currentId.compareTo(maxId) > GREATER_THAN) {
					maxId = currentId;
				}
			}
			return maxId.toString();
		}
		return FIRST_ID;
	}

	public static Integer findMessageIndex(List<Message> messages, Message message) {
		for (int i = 0; i < messages.size(); i++) {
			if (messages.get(i).equals(message)) {
				return Integer.valueOf(i);
			}
		}
		return null;
	}
}
