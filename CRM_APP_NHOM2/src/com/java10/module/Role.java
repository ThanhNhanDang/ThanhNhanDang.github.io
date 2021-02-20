package com.java10.module;

public class Role {
	private int id;
	private String name;
	private String description;
	
	public Role (String name, String des){
		this.description = des;
		this.name   	 = name;
	}
	
	public Role() {
		super();
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
		
}
