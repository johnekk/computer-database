package com.excilys.cdb.dao.interfaces;

import com.excilys.cdb.dao.exceptions.DAOException;
import com.excilys.cdb.model.Company;

public interface ICompanyDAO {
	
	public Company findAllCompanies(Company company) 	throws DAOException;

}
