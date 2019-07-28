package com.rishu.java.spring.boot.model;

import java.util.HashMap;
import java.util.Map;

public class DataBase {

	private static Map<Long,Message> messages= new HashMap<>();
	
	public static  Map<Long,Message> getMessages()
	{
		return messages;
	}
	
}
