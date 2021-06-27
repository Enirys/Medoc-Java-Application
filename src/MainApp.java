import java.sql.*;
import DAO.*;
import IHM.*;
import OO.*;

public class MainApp {

	public static void main(String[] args) {
		
		new ConnexionFrame();
	}
	
	/* Les méthodes ci-dessous sont utilisées pour tester le CRUD et DAO */
	
	/*
	public static void authenticate()
	{
		AuthenticationController authController = new AuthenticationController();
		
		Utilisateur user1 = new Utilisateur("Syrine","syrine");
		Utilisateur user2 = new Utilisateur("Enirys","enirys");
		Utilisateur user3 = new Utilisateur("Admin","admin");
		
		Utilisateur user4 = new Utilisateur("Loki","loki");
		Utilisateur user5 = new Utilisateur("Fenrir","fenrir");
		
		authController.loginUser(user1);
		authController.loginUser(user2);
		authController.loginUser(user3);
		authController.loginUser(user4);
		authController.loginUser(user5);
	}
	
	public static void crudPatient()
	{
		System.out.println("CRUD Patient");
		
		Patient patient1 = new Patient("TEST1", "TEST1", "TEST1", new Date(98,3,21), "23", "TEST1",
				0,"TEST1","TEST1","F","TEST1","TEST1","A+","TEST1",
				"TEST1","TEST1","TEST1","TEST1","TEST1",1,
				1000,false);
		
		Patient patient2 = new Patient("TEST2", "TEST2", "TEST2", new Date(97,2,26), "23", "TEST2",
				1,"TEST2","TEST2","F","TEST2","TEST2","B-","TEST2",
				"TEST2","TEST2","TEST2","TEST2","TEST2",2,
				2000,false);
		
		Patient patient3 = new Patient("TEST3", "TEST3", "TEST3", new Date(92,7,20), "23", "TEST3",
				2,"TEST3","TEST2","F","TEST3","TEST3","AB+","TEST3",
				"TEST3","TEST3","TEST3","TEST3","TEST3",5,
				3000,false);
		
		Patient patient4 = new Patient("TEST4", "TEST4", "TEST4", new Date(93,5,16), "23", "TEST4",
				3,"TEST4","TEST4","M","TEST4","TEST4","AB-","TEST4",
				"TEST4","TEST4","TEST4","TEST4","TEST4",2,
				4000,true);
		
		
		PatientDAO pDAO = new PatientDAO();
		
		pDAO.ajouter(patient1);
		pDAO.ajouter(patient2);
		pDAO.ajouter(patient3);
		pDAO.ajouter(patient4);
		
		pDAO.rechercher(0);
		pDAO.rechercher(1);
		
		patient1.setGrpSng("A-");
		patient1.setCodePostal(1111);
		patient1.setNbEnfants(1);
		
		pDAO.modifier(patient1);
		
		pDAO.rechercher(0);
		
		pDAO.supprimer(patient1);
		
		pDAO.rechercher(0);
		pDAO.rechercher(1);
	}

	public static void crudConsultation()
	{
		System.out.println("CRUD Consultation");
		
		Consultation consultation1 = new Consultation(16, "Controle", "Stress Psy", 65.000, "TestTitre", new Date(119,7,20));
		Consultation consultation2 = new Consultation(16, "Consultation", "Stress Psy", 75.502, "TestTitre", new Date(119,8,15));
		Consultation consultation3 = new Consultation(17, "Controle", "Stress Psy", 80.000, "TestTitre", new Date(117,4,12));
		Consultation consultation4 = new Consultation(18, "Consultation", "Stress Psy", 60.000, "TestTitre", new Date(116,5,21));
		
		
		cDAO.ajouter(consultation1);
		cDAO.ajouter(consultation2);
		cDAO.ajouter(consultation3);
		cDAO.ajouter(consultation4);
		
		consultation1.setCodeC(1);
		consultation1.setDateC(new Date(119,7,30));
		consultation1.setTypeC("Controle");
		consultation1.setHonoraires(69.420);
		
		cDAO.modifier(consultation1);
		
		consultation4.setCodeC(4);
		
		cDAO.supprimer(consultation4);
		ConsultationDAO cDAO = new ConsultationDAO();
		
		cDAO.rechercher(1);
		cDAO.rechercher(2);
		cDAO.rechercher(3);
		
	}

	public static void crudMedicament()
	{
		System.out.println("CRUD Medicament");
		
		Medicament medicament1 = new Medicament("Doliprane");
		Medicament medicament2 = new Medicament("Duxil");
		Medicament medicament3 = new Medicament("Efferalgan");
		Medicament medicament4 = new Medicament("Dafalgan");
		Medicament medicament5 = new Medicament("Paracetamol");
		Medicament medicament6 = new Medicament("Dexeryl");
		
		MedicamentDAO mDAO = new MedicamentDAO();
		
		mDAO.ajouter(medicament1);
		mDAO.ajouter(medicament2);
		mDAO.ajouter(medicament3);
		mDAO.ajouter(medicament4);
		mDAO.ajouter(medicament5);
		mDAO.ajouter(medicament6);
		
		mDAO.rechercher(1);
		mDAO.rechercher(2);
		mDAO.rechercher(3);
		mDAO.rechercher(4);
		mDAO.rechercher(5);
		mDAO.rechercher(6);
		
		medicament1.setCode(1);
		medicament2.setCode(2);
		medicament3.setCode(3);
		medicament4.setCode(4);
		medicament5.setCode(5);
		medicament6.setCode(6);
		medicament1.setNom("Effexor");
		medicament2.setNom("Pneumorel");
		
		mDAO.modifier(medicament1);
		mDAO.modifier(medicament2);
		
		mDAO.rechercher(1);
		mDAO.rechercher(2);
		mDAO.rechercher(3);
		mDAO.rechercher(4);
		mDAO.rechercher(5);
		mDAO.rechercher(6);
		
		mDAO.supprimer(medicament3);
		mDAO.supprimer(medicament5);
		mDAO.supprimer(medicament6);
		
		mDAO.rechercher(1);
		mDAO.rechercher(2);
		mDAO.rechercher(3);
		mDAO.rechercher(4);
		mDAO.rechercher(5);
		mDAO.rechercher(6);
		
		
	}

	public static void crudOrdonnance()
	{
		System.out.println("CRUD Ordonnance");
		
		Ordonnance ordonannce1 = new Ordonnance(1,"Ordonnance1");
		Ordonnance ordonannce2 = new Ordonnance(2,"Ordonnance2");
		Ordonnance ordonannce3 = new Ordonnance(3,"Ordonnance3");
		
		OrdonnanceDAO oDAO = new OrdonnanceDAO();
		
		oDAO.ajouter(ordonannce1);
		oDAO.ajouter(ordonannce2);
		oDAO.ajouter(ordonannce3);
		
		ordonannce1.setCode(10);
		ordonannce2.setCode(11);
		ordonannce3.setCode(12);
		
		oDAO.rechercher(10);
		oDAO.rechercher(11);
		oDAO.rechercher(12);
		
		ordonannce1.setTitre("Ordonnance12");
		ordonannce2.setCodeC(2);
		
		oDAO.modifier(ordonannce1);
		oDAO.modifier(ordonannce2);
		
		oDAO.rechercher(10);
		oDAO.rechercher(11);
		oDAO.rechercher(12);
		
		oDAO.supprimer(ordonannce3);
		
		oDAO.rechercher(10);
		oDAO.rechercher(11);
		oDAO.rechercher(12);
		
	}

	public static void crudLigneOrdonnance()
	{
		System.out.println("CRUD Ligne Ordonnance");
		
		LigneOrdonnance ligneordo1 = new LigneOrdonnance(10,1,2,3,"1 gélule matin et soir pendant 2 mois");
		LigneOrdonnance ligneordo2 = new LigneOrdonnance(10,2,2,3,"2 gélules matin et soir pendant 1 mois");
		LigneOrdonnance ligneordo3 = new LigneOrdonnance(10,4,2,3,"3 gélules matin et soir pendant 3 mois");
		LigneOrdonnance ligneordo4 = new LigneOrdonnance(11,1,2,3,"1 gélule matin et soir pendant 2 mois");
		LigneOrdonnance ligneordo5 = new LigneOrdonnance(11,2,2,3,"2 gélules matin et soir pendant 1 mois");
		LigneOrdonnance ligneordo6 = new LigneOrdonnance(11,4,2,3,"3 gélules matin et soir pendant 3 mois");
		
		LigneOrdonnanceDAO loDAO = new LigneOrdonnanceDAO();
		
		loDAO.ajouter(ligneordo1);
		loDAO.ajouter(ligneordo2);
		loDAO.ajouter(ligneordo3);
		loDAO.ajouter(ligneordo4);
		loDAO.ajouter(ligneordo5);
		loDAO.ajouter(ligneordo6);
		
		ligneordo1.setCode(7);
		ligneordo2.setCode(8);
		ligneordo3.setCode(9);
		ligneordo4.setCode(10);
		ligneordo5.setCode(11);
		ligneordo6.setCode(12);
		
		loDAO.rechercher(7);
		loDAO.rechercher(8);
		loDAO.rechercher(9);
		loDAO.rechercher(10);
		loDAO.rechercher(11);
		loDAO.rechercher(12);
		
		ligneordo5.setNbBoites(1);
		loDAO.modifier(ligneordo5);
		
		loDAO.rechercher(7);
		loDAO.rechercher(8);
		loDAO.rechercher(9);
		loDAO.rechercher(10);
		loDAO.rechercher(11);
		loDAO.rechercher(12);
		
		loDAO.supprimer(ligneordo6);
		
		loDAO.rechercher(7);
		loDAO.rechercher(8);
		loDAO.rechercher(9);
		loDAO.rechercher(10);
		loDAO.rechercher(11);
		loDAO.rechercher(12);
	}
	*/
}
