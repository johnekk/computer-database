package com.excilys.cdb.ui;

import java.time.LocalDate;
import java.util.Scanner;

import com.excilys.cdb.model.Company;
import com.excilys.cdb.model.Computer;
import com.excilys.cdb.services.ComputerService;

public class Actions {
	
	static Scanner sc = new Scanner(System.in);
	
	static LocalDate introduced = null;
	static LocalDate discontinued = null;

	static int companyId;
	
	public static void addCLI() {
		
		System.out.println("Veuillez saisir les caracteristiques du nouveau computer dans l'ordre: "  );
		System.out.println( "nom du computer" );
		String computerName = sc.nextLine();
		System.out.println(computerName);
		
		System.out.println("la date de fabrication au format yyyy-MM-dd");
        String dateString= sc.nextLine();
        if (!dateString.equals(""))
        	introduced = LocalDate.parse(dateString);      	

        System.out.println("la date de mise hors-service au format yyyy-MM-dd");
        dateString = sc.nextLine();
        if (!dateString.equals(""))
        	introduced = LocalDate.parse(dateString);
        
        System.out.println("l'id de la company");
        int companyId = sc.nextInt();
        String newId = String.valueOf(companyId);
        if (!newId.equals("")) {
        	Computer computer = new Computer(0, computerName, introduced, discontinued, new Company(companyId, null));
        	ComputerService.create(computer);
        }
	}
}
