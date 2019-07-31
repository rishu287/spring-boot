package com.rishu.java.spring.boot.controller;

import com.rishu.java.spring.boot.service.MessageService;
import com.rishu.java.spring.boot.model.Message;
import java.util.List;

import javax.xml.ws.Response;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageResourceController {

	MessageService messageService = new MessageService();

	@RequestMapping("/testmessages/{testMessageId}")
	public String response(@PathVariable("testMessageId") String messageId) {
		return "Hi" + messageId;
	}

	@RequestMapping(value = "/messages", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Message> Messages() {
		return messageService.getAllmessages();
	}

	@RequestMapping(value = "/messages/{messageId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE)
	public Message testXml(@PathVariable("messageId") long messageId) {
		return messageService.getMessage(messageId);
	}

	@RequestMapping(value = "/messagesJson/{messageId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Message testJson(@PathVariable("messageId") long messageId) {
		return messageService.getMessage(messageId);
	}

	
	@RequestMapping(value = "/PostMessages", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Message PostMessage(@RequestBody Message message) {
		System.out.println(message.getAuthor());		
		return messageService.addMessage(message);
	}

	@RequestMapping(value = "/PostMessagesWithStatusCode", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity PostMessageWithStatusCode(@RequestBody Message message) {		
		return new ResponseEntity<>(messageService.addMessage(message), HttpStatus.CREATED);
	}
	
	
	@RequestMapping(value = "/UpdateMessage/{messageId}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Message updateMessage(@PathVariable("messageId") long messageId, @RequestBody Message message) {
		System.out.println(message.getMessageId());
		message.setMessageId(messageId);
		return messageService.updateMessage(message);
	}
	
	@RequestMapping(value = "/deleteMessage/{messageId}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Message deletemessage(@PathVariable("messageId") long messageId, @RequestBody Message message) {
		System.out.println(message.getMessageId());
		message.setMessageId(messageId);
		return messageService.removeMessage(message);
	}

}
