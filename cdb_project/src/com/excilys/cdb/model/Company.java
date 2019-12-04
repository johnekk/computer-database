package com.excilys.cdb.model;

public class Company {
	private int id = 0;
	
	private String name = "";
	
	public Company (int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public long getId() {
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

}
