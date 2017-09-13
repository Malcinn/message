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

	public MessageDTO() {
		super();
	}

	public MessageDTO(String id, String title, String body) {
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
		if (obj instanceof MessageDTO) {
			MessageDTO messageDTO = (MessageDTO) obj;
			if (this.getId().equals(messageDTO.getId())) {
				return true;
			}
		}
		return false;
	}
}
