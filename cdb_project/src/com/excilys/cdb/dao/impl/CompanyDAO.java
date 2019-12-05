package com.excilys.cdb.dao.impl;

import com.excilys.cdb.dao.exceptions.DAOException;
import com.excilys.cdb.model.Company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.excilys.cdb.dao.MySQLConnection;;


public class CompanyDAO {

	private Connection connect = null;
	private PreparedStatement statement;
	private ResultSet res;
	
	
	public ArrayList<Company> findAllCompanies() throws DAOException {
		final String query = "SELECT ca.id, ca.name FROM company ca"; 	
		ArrayList<Company> c = new ArrayList<>();
		
		try {
			/** On se connecte, on prépare la requete, on l'éxécute et on récupère le resultat*/
			connect = MySQLConnection.myConnection();
			statement = this.connect.prepareStatement(query);
			res = statement.executeQuery(query);
			
			while (res.next()) {
				c.add(
						new Company(
								res.getInt("id"),
								res.getString("name")
								)
					);
			}
			
		} catch (SQLException e) {
			throw new DAOException( e );
		}
		return c;
	}
}
