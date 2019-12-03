package com.excilys.cdb.dao.impl;

import com.excilys.cdb.dao.exceptions.DAOException;
import com.excilys.cdb.dao.interfaces.ICompanyDAO;
import com.excilys.cdb.model.Company;


public class CompanyDAOImpl implements ICompanyDAO {

	private static final String sql = "SELECT ca.id, ca.name FROM company ca"; 
	
	@Override
	public Company findAllCompanies(Company company) throws DAOException {
		
		
		
		return null;
	}
}
