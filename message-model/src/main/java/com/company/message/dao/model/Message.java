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

	public Message() {
		super();
	}

	public Message(String id, String title, String body) {
		super();
		this.id = id;
		this.title = title;
		this.body = body;
	}

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

	@Override
	public String toString() {
		return "[id: " + id + ", title: " + title + ", body: " + body + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj instanceof Message) {
			Message message = (Message) obj;
			if (this.getId().equals(message.getId())) {
				return true;
			}
		}
		return false;
	}
}
