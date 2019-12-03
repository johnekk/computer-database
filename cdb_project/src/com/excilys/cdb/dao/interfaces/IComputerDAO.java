package com.excilys.cdb.dao.interfaces;

import com.excilys.cdb.dao.exceptions.DAOException;
import com.excilys.cdb.model.Computer;

public interface IComputerDAO {

	public Computer createComputer(Computer computer) 	throws DAOException;

	public Computer findAllComputers(Computer computer) throws DAOException; 

	public Computer findComputerById(long id) 			throws DAOException;

	public Computer updateComputer(Computer computer) 	throws DAOException;

	public Computer deleteComputer(long id) 			throws DAOException;
}
