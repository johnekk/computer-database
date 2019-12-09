package com.excilys.cdb.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Optional;

import com.excilys.cdb.dao.MySQLConnection;
import com.excilys.cdb.dao.exceptions.DAOException;
import com.excilys.cdb.model.Company;
import com.excilys.cdb.model.Computer;

public class ComputerDAO {
	
	private Connection connect = null;
	private PreparedStatement statement;
	private ResultSet res;
	
	private final static String CREATE_COMPUTER = "INSERT INTO computer (name, introduced, discontinued, company_id) VALUES (?,?,?,?)";
	
	private final static String FIND_ALL_COMPUTERS = "SELECT cu.*, ca.id, ca.name AS 'company_name' FROM computer cu, company ca WHERE ca.id = cu.company_id";
	private final static String FIND_COMPUTER_BY_ID = "SELECT cu.*, ca.id, ca.name AS 'company_name' FROM computer cu, company ca WHERE ca.id = cu.company_id AND id = ?";
	
	private final static String UPDATE_COMPUTER = "UPDATE computer SET name = ?, introduce = ?, discontinued = ?, company_id = ? WHERE id = ?";
	
	private final static String DELETE_COMPUTER = "DELETE * FROM computer WHERE id = ?";
	
	
	public Computer createComputer(Computer computer) throws DAOException {
		try {
			connect = MySQLConnection.myConnection();
			statement = connect.prepareStatement(CREATE_COMPUTER);
			System.out.println("Connected !!!");
			
			statement.setString(1, computer.getName());
			statement.setObject(2, computer.getIntroduced());
			statement.setObject(3, computer.getDiscontinued());
			statement.setInt(4, (int) computer.getCompany().getId());
	
			statement.executeUpdate();
			
			System.out.println("Computer " + computer.getName() + " created successfully!");
		} catch (SQLException error) {
			throw new DAOException( error );
		}
		
		
		return null;
	}

	public ArrayList<Computer> findAllComputers() throws DAOException {	
		ArrayList<Computer> c = new ArrayList<>();
		
		try {
			/** On se connecte, on prépare la requete, on l'éxécute et on récupère le resultat*/
			connect = MySQLConnection.myConnection();
			statement = connect.prepareStatement(FIND_ALL_COMPUTERS);
			System.out.println("Connected !!!");
			
			while (res.next()) {
				
				c.add(new Computer(	res.getInt("id"),
									res.getString("name"),
									res.getTimestamp("introduced").toLocalDateTime(),
									res.getTimestamp("discontinued").toLocalDateTime(),
									new Company(res.getInt("id"),
												res.getString("name"))
								)
					);
			}
			statement.executeUpdate();
		} catch (SQLException error) {
			throw new DAOException( error );
		}
		return c;
	}

	public Optional<Computer> findComputerById(int id) throws DAOException {
		
		try {
			connect = MySQLConnection.myConnection();
			statement = connect.prepareStatement(FIND_COMPUTER_BY_ID);
			
			System.out.println("Connected !!!");
			
			statement.executeUpdate();
			if (res.first()) {
			Computer computer = new Computer( res.getInt("id"),
									 res.getString("name"),
									 res.getTimestamp("introduced").toLocalDateTime(),
									 res.getTimestamp("discontinued").toLocalDateTime(),
									 new Company(res.getInt("id"),
											     res.getString("name"))
									 );
			}
		}  catch (SQLException error) {
			throw new DAOException( error );
		}
		
		return Optional.empty();
	}

	public Computer updateComputer(Computer computer) throws DAOException {

		try {
			connect = MySQLConnection.myConnection();
			statement = connect.prepareStatement(UPDATE_COMPUTER);
			System.out.println("Connected !!!");
			
			if(res.first()) {
				statement.setString(1, computer.getName());
				statement.setObject(2, computer.getIntroduced());
				statement.setObject(3, computer.getDiscontinued());
				statement.setInt(4, (int) computer.getCompany().getId());
			}
			statement.executeUpdate();
		} catch (SQLException error) {
			throw new DAOException( error);
		}
		return computer;
	}

	public void deleteComputer(int id) throws DAOException {
		try {
			connect = MySQLConnection.myConnection();
			statement = connect.prepareStatement(DELETE_COMPUTER);
			statement.executeUpdate();
			
			System.out.println("Computer" + id + "is removed!!");
		} catch (SQLException error) {
			throw new DAOException(error);
		}
	}

}
