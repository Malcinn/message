package com.company.message;

import static org.junit.Assert.assertNotNull;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.company.message.dao.services.SimpleMessageDAO;
import com.company.message.exceptions.MessageNotExistException;
import com.company.message.exceptions.MessageNotFoundException;
import com.company.message.model.MessageDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "../../../Beans.xml" })
public class SimpleMessageDAOTest {

	@Autowired
	private SimpleMessageDAO simpleMessageDAO;

	@Before
	public void beforeSetUp() {
		simpleMessageDAO.clean();
	}

	@Test
	public void emptyListTest() {
		Assert.assertEquals(0, simpleMessageDAO.getMessages().size());
	}

	@Test
	public void AddElementsTest() {
		Assert.assertEquals("1", simpleMessageDAO.insertMessage(new MessageDTO("", "title", "body")));
		Assert.assertEquals("2", simpleMessageDAO.insertMessage(new MessageDTO("", "title", "body")));
		Assert.assertEquals("3", simpleMessageDAO.insertMessage(new MessageDTO("", "title", "body")));
		Assert.assertEquals(3, simpleMessageDAO.getMessages().size());
	}

	@Test(expected = MessageNotFoundException.class)
	public void findMessageTestFauled() throws MessageNotFoundException {
		simpleMessageDAO.findMessage("1");
	}

	@Test
	public void findMessageTestSuccess() throws MessageNotFoundException {
		Assert.assertEquals("1", simpleMessageDAO.insertMessage(new MessageDTO("", "title", "body")));
		Assert.assertEquals("2", simpleMessageDAO.insertMessage(new MessageDTO("", "title", "body")));
		Assert.assertEquals("3", simpleMessageDAO.insertMessage(new MessageDTO("", "title", "body")));
		Assert.assertNotNull(simpleMessageDAO.findMessage("2"));
	}

	@Test(expected = MessageNotExistException.class)
	public void updateMessageTestFail() throws MessageNotExistException {
		simpleMessageDAO.updateMessage(new MessageDTO("213", "title", "body"));
	}

	@Test
	public void updateMessageTestSuccess() throws MessageNotExistException, MessageNotFoundException {
		Assert.assertEquals("1", simpleMessageDAO.insertMessage(new MessageDTO("", "title", "body")));
		Assert.assertEquals("2", simpleMessageDAO.insertMessage(new MessageDTO("", "title", "body")));
		Assert.assertEquals("3", simpleMessageDAO.insertMessage(new MessageDTO("", "title", "body")));
		Assert.assertTrue(simpleMessageDAO.updateMessage(new MessageDTO("2", "new_title", "new_body")));
		MessageDTO messageDTO = simpleMessageDAO.findMessage("2");
		assertNotNull(messageDTO);
		Assert.assertEquals("new_title", messageDTO.getTitle());
		Assert.assertEquals("new_body", messageDTO.getBody());
	}

	@Test(expected = MessageNotFoundException.class)
	public void deleteMessageTestFail() throws MessageNotFoundException {
		simpleMessageDAO.deleteMessage("1");
	}

	@Test
	public void deleteMessageTestSuccess() throws MessageNotFoundException {
		Assert.assertEquals("1", simpleMessageDAO.insertMessage(new MessageDTO("", "title", "body")));
		Assert.assertEquals("2", simpleMessageDAO.insertMessage(new MessageDTO("", "title", "body")));
		Assert.assertEquals("3", simpleMessageDAO.insertMessage(new MessageDTO("", "title", "body")));
		Assert.assertTrue(simpleMessageDAO.deleteMessage("2"));
		Assert.assertEquals("4", simpleMessageDAO.insertMessage(new MessageDTO("", "title", "body")));

		MessageDTO messageDTO = null;
		try {
			messageDTO = simpleMessageDAO.findMessage("2");
		} catch (MessageNotFoundException e) {

		}
		Assert.assertNull(messageDTO);

	}
}
