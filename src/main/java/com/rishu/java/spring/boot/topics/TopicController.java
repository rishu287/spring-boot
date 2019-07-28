package com.rishu.java.spring.boot.topics;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {

	@RequestMapping(value="/Topics", method = RequestMethod.GET, produces = "application/json")	
	public List<Topic> getTopics()
	{
		List<Topic> topicList = new ArrayList<>();		
		topicList.add(new Topic("1","Topic1","This is the 1st topic"));
		return topicList;
	}
	
	
	@RequestMapping(value="/Topics.xml", method = RequestMethod.GET, produces = "application/xml")	
	public Topic getTopic()
	{
		Topic topic = new Topic("2","Topic2","This is the 2st topic");
		return topic;
	}
}
