package com.company.message.dao.model;

/**
 * Model Class for DAO pattern (DAO - Data Access Object).
 * 
 * @author marcin
 *
 */

public class Message {

	private String id;

	private String title;

	private String body;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

}
