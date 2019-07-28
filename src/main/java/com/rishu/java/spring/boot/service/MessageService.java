package com.rishu.java.spring.boot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.rishu.java.spring.boot.model.DataBase;
import com.rishu.java.spring.boot.model.Message;

public class MessageService {

	private Map<Long, Message> messages = DataBase.getMessages();

	public MessageService() {
		messages.put(1L, new Message(1, "Hello World", "Rishu Ghose"));
		messages.put(2L, new Message(2, "Hello Shopping", "Sritama Ghosh"));
		messages.put(3L, new Message(3, "Hello Diapers", "Sreyanshu Ghosh"));
	}

	public List<Message> getAllmessages() {
		return new ArrayList(messages.values());
	}

	public Message getMessage(long id) {
		return messages.get(id);
	}

	public Message addMessage(Message message) {
		message.setMessageId(messages.size() + 1);
		messages.put(message.getMessageId(), message);
		return message;
	}

	public Message updateMessage(Message message) {
		if (message.getMessageId() <= 0) {
			return null;
		}
		messages.put(message.getMessageId(), message);
		return message;
	}

	public Message removeMessage(Message message) {
		return messages.remove(message.getMessageId());
	}

}
