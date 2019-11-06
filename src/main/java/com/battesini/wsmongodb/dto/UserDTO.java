package com.battesini.wsmongodb.dto;

import java.io.Serializable;

import org.springframework.data.annotation.Id;

import com.battesini.wsmongodb.domain.User;

public class UserDTO implements Serializable	{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private String name;
	private String email;
	
	public UserDTO()	{
		
	}
	
	public UserDTO(User obj) {
		super();
		id = obj.getId();
		name = obj.getName();
		email = obj.getEmail();
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

}
