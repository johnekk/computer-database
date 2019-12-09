package com.excilys.cdb.model;

import java.time.LocalDateTime;

import com.excilys.cdb.model.Company;

public class Computer {

	private int id = 0;
	private String name = "";
	private LocalDateTime introduced ;	
	private LocalDateTime discontinued;
	private Company company;

	
	public Computer (int id, String name, LocalDateTime introduced, LocalDateTime discontinued, Company company) {
		this.id = id;
		this.name = name;
		this.introduced = introduced;
		this.discontinued = discontinued;
		this.company = company;
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

	public LocalDateTime getIntroduced() {
		return introduced;
	}


	public void setIntroduced(LocalDateTime introduced) {
		this.introduced = introduced;
	}
	
	public LocalDateTime getDiscontinued() {
		return discontinued;
	}


	public void setDiscontinued(LocalDateTime discontinued) {
		this.discontinued = discontinued;
	}


	public Company getCompany() {
		return company;
	}


	public void setCompany(Company company) {
		this.company = company;
	}


	@Override
	public String toString() {
		String str = 	"Name : " + this.getName() + "\n";
		str += 			"Date of birth : " + this.getIntroduced() + "\n";
		str += 			"Date of death : " + this.getDiscontinued() + "\n";
		str +=			this.company.toString();
		str +=			"\n.....................................\n";
		
		return str;
	}
	
}
