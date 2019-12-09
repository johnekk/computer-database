package com.excilys.cdb.ui;

import java.util.ArrayList;

import com.excilys.cdb.dao.*;
import com.excilys.cdb.dao.impl.CompanyDAO;
import com.excilys.cdb.model.Company;

public class Main {

	public static void main(String[] args) {
		MySQLConnection.myConnection();
		CompanyDAO companies = new CompanyDAO();
		System.out.println(companies.findAllCompanies());
		}
		
	}


