package com.excilys.cdb.services;

import java.util.ArrayList;
import java.util.Optional;

import com.excilys.cdb.dao.exceptions.DAOException;
import com.excilys.cdb.dao.impl.ComputerDAO;
import com.excilys.cdb.model.Computer;

public class ComputerService {
	
	private ComputerDAO computerDAO;
	
	/** START Singleton.ComputerService -- Lazy-Loading */
	private static ComputerService computerService;
	
	public static ComputerService getInstance() {
		if (computerService == null) {
			computerService = new ComputerService();
		}
		return computerService;
	}
	
	/** END Singleton.ComputerService*/

	public Computer createComputer(Computer computer) throws DAOException { return computerDAO.createComputer(computer); };
	
	public ArrayList<Computer> findAllComputers() throws DAOException { return computerDAO.findAllComputers(); };
	
	public Optional<Computer> findComputerByID(int id) throws DAOException { return Optional.empty(); };
	
	public Computer updateComputer(Computer computer) throws DAOException { return computer; };
	
	public void deleteComputer(int id) throws DAOException {}
}
