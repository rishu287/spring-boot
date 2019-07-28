package com.rishu.java.spring.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBoot {
	
	public static void main (String args [])
	{
		System.out.println("Calling SpringBoot Application");
		SpringApplication.run(SpringBoot.class, args);
	}
}
