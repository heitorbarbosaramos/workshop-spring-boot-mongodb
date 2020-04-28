package com.heitor.workshopmongodb.dto;

import com.heitor.workshopmongodb.domain.User;

public class UserDTO {

	private String id;
	private String name;
	private String email;
	
	public UserDTO() {
	}

	public UserDTO(User obj) {
		super();
		this.id = obj.getId();
		this.name = obj.getName();
		this.email = obj.getEmail();
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
	public String toString() {
		return "UserDTO [id=" + id + ", name=" + name + ", email=" + email + "]";
	}
}
