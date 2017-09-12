package com.company.message;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.company.message.dao.services.IMessageDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"Beans.xml"})
public class SimpleMessageDAOTest {

	private IMessageDAO iMessageDAO;
	
	@Test
	public void t() {
		System.out.println("dd");
	}
}
