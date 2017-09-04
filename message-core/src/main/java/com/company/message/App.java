package com.company.message;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.company.message.model.MessageDTO;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Beans.xml");

		MessageDTO messageDTO = (MessageDTO) applicationContext.getBean("message");
		System.out.println(messageDTO);
		MessageDTO messageDTO2 = (MessageDTO) applicationContext.getBean("message2");
		System.out.println(messageDTO2);
	}

}
