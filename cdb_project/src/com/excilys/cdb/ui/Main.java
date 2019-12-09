package com.excilys.cdb.ui;
import java.util.Scanner;
import java.util.ArrayList;

import com.excilys.cdb.dao.MySQLConnection;
import com.excilys.cdb.services.CompanyService;
import com.excilys.cdb.services.ComputerService;
import com.excilys.cdb.ui.Cli;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String repUser = "";
		ComputerService computerService = ComputerService.getInstance();
		CompanyService companyService 	= CompanyService.getInstance();
		
		System.out.println("Bonjour et bienvenue sur CDB. Que souhaitez-vous faire?");
		
		do {
			Cli.MenuCli();
			repUser = sc.nextLine().trim();
			
			
			switch (repUser) {
			case "1":
				
				computerService.findAllComputers();
				break;
				
			case "2":
				companyService.findAllCompanies();
				break;

			default:
				System.out.println("Réponse incorrecte!! Veuillez saisir une autre réponse entre 0 et 6");
				break;
			}
		} while (!repUser.equals("0"));
			sc.close();
        }
		
		/**MySQLConnection.myConnection();
		CompanyDAO companies = new CompanyDAO();
		System.out.println(companies.findAllCompanies());
		*/
	}		