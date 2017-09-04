package com.company.message.model;

/**
 * Model Class for DTO pattern. (DTO - Data Transfer Object)
 * 
 * @author marcin
 *
 */
public class MessageDTO {

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

	@Override
	public String toString() {
		return "[id: " + id + ", title: " + title + ", body: " + body + "]";
	}
}
