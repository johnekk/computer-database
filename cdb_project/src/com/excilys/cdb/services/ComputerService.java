package com.excilys.cdb.services;

import java.util.ArrayList;
import java.util.Optional;

import com.excilys.cdb.dao.exceptions.DAOException;
import com.excilys.cdb.model.Computer;

public class ComputerService {

	public Computer createComputer(Computer computer) throws DAOException { return computer; };
	
	public ArrayList<Computer> findAllComputers(ArrayList<Computer> computer) throws DAOException { return computer; };
	
	public Optional<Computer> findComputerByID(int id) throws DAOException { return Optional.empty(); };
	
	public Computer updateComputer(Computer computer) throws DAOException {return computer ; };
	
	public void deleteComputer(int id) throws DAOException {};
	
}
