package com.excilys.cdb.services;

import java.util.ArrayList;

import com.excilys.cdb.dao.exceptions.DAOException;
import com.excilys.cdb.dao.impl.CompanyDAO;
import com.excilys.cdb.model.Company;

public class CompanyService {
	
	private CompanyDAO companyDAO;
	
	/** START Singleton.ComputerService -- Lazy-Loading */
	private CompanyService() {};
	
	private static CompanyService companyService = null;
	
	public static CompanyService getInstance() {
		if (companyService == null) {
			companyService = new CompanyService();
		}
		return companyService;
	}
	
	/** END Singleton.ComputerService*/
	
	public ArrayList<Company> findAllCompanies() throws DAOException { return companyDAO.findAllCompanies(); };

}
