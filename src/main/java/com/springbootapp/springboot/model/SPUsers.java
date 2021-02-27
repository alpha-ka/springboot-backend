package com.springbootapp.springboot.model;

  
  

  
public class SPUsers   {
	
	 

	private String name;

	private String email;

	private String status;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "SPUsers [name=" + name + ", email=" + email + ", status=" + status + "]";
	}
	

}
