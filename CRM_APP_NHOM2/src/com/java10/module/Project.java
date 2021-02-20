package com.java10.module;

public class Project {
	private int id;
	private String name;
	private String range;
	public Project(int id, String name, String range) {
		this.id = id;
		this.name = name;
		this.range = range;
	}
	public Project(String name, String range) {
		super();
		this.name = name;
		this.range = range;
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
	public String getRange() {
		return range;
	}
	public void setRange(String range) {
		this.range = range;
	}
	
}
