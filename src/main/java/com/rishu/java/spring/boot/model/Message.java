package com.rishu.java.spring.boot.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Message {

	private long messageId;
	private String messageContent;
	private String author;

	public Message(long messageId, String messageContent, String author) {
		this.messageId = messageId;
		this.messageContent = messageContent;
		this.author = author;
	}
	
	
	public Message() {		
	}

	public long getMessageId() {
		return messageId;
	}

	public void setMessageId(long messageId) {
		this.messageId = messageId;
	}

	public String getMessageContent() {
		return messageContent;
	}

	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

}
