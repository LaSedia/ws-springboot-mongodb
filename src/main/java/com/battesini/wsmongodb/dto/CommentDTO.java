package com.battesini.wsmongodb.dto;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;

public class CommentDTO implements Serializable	{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private AuthorDTO author;
	private Date date;
	private String text;
	
	public CommentDTO()	{
		
	}

	public CommentDTO(AuthorDTO author, Date date, String text) {
		super();
		this.author = author;
		this.date = date;
		this.text = text;
	}

	public AuthorDTO getAuthor() {
		return author;
	}

	public void setAuthor(AuthorDTO author) {
		this.author = author;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
}
