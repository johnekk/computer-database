package com.excilys.cdb.dao.impl;

import com.excilys.cdb.dao.exceptions.DAOException;
import com.excilys.cdb.dao.interfaces.ICompanyDAO;
import com.excilys.cdb.model.Company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.excilys.cdb.dao.MySQLConnection;;


public class CompanyDAOImpl implements ICompanyDAO {

	private Connection connect;
	private PreparedStatement statement;
	private ResultSet res;
	
	private static final String query = "SELECT ca.id, ca.name FROM company ca"; 
	
	@Override
	public Company findAllCompanies(Company company) throws DAOException {

		Company c;
	/** */
		try {
			connect = MySQLConnection.myConnection();
			res = statement.executeQuery(query);
			
			if (res.next()) {
				c = new Company(res.getInt("id"),
								res.getString("name")
								);
			}
		} catch (SQLException e) {
			throw new DAOException( e );
		}
		
		return null;
	}
}
