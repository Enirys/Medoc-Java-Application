package DAO;

import java.sql.*;
import java.util.ArrayList;

import OO.Medicament;
import OO.Patient;

public class PatientDAO {
	
	public void ajouter(Patient p)
	{
		// Ouverture de la connexion a la base de données
		Connection connexion = DBConnection.getConnection();
		
		if(connexion != null)
		{
			String query = "insert into patient(nom,prenom,nomJF,dateNaiss,age,numImm,nip,adresse,email,genre,photo,civilite,grpSng,sitFam,ville,telDomicile,telProf,telPortable,profession,nbEnfants,codePostal,affLduree) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
			try {
				PreparedStatement ps = connexion.prepareStatement(query);
				
				ps.setString(1, p.getNom());
				ps.setString(2, p.getPrenom());
				ps.setString(3, p.getNomJeuneF());
				ps.setDate(4, p.getDateNaissance());
				ps.setString(5, p.getAge());
				ps.setString(6, p.getNumImmatriculation());	
				ps.setInt(7, p.getNip());
				ps.setString(8, p.getAdresse());
				ps.setString(9, p.getEmail());
				ps.setString(10, p.getGenre());
				ps.setString(11, p.getPhoto());
				ps.setString(12, p.getCivilite());
				ps.setString(13, p.getGrpSng());
				ps.setString(14, p.getSitFam());
				ps.setString(15, p.getVille());
				ps.setString(16, p.getTelDomicile());
				ps.setString(17, p.getTelProf());
				ps.setString(18, p.getTelPortable());
				ps.setString(19, p.getProfession());
				ps.setInt(20, p.getNbEnfants());
				ps.setInt(21, p.getCodePostal());
				ps.setBoolean(22, p.isAffLduree());
				
				int res = ps.executeUpdate();
				
				if (res != 0) { 
					System.out.println("Patient ajouté!");
				}else
				{
					System.out.println("Impossible d'ajouter le patient");
				}
				connexion.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void supprimer(Patient p)
	{
		// Ouverture de la connexion a la base de données
		Connection connexion = DBConnection.getConnection();
		
		if(connexion != null)
		{
			String query = "delete from patient where nip = ?;";
			try {
				PreparedStatement ps = connexion.prepareStatement(query);
				
				ps.setInt(1, p.getNip());
				
				int res = ps.executeUpdate();				
				if (res != 0) {
					System.out.println("Delete success!");
				}else
				{
					System.out.println("Impossible de supprimer le patient!");
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void modifier(Patient p)
	{
		// Ouverture de la connexion a la base de données
		Connection connexion = DBConnection.getConnection();
		
		if(connexion != null)
		{
			String query = "update patient set nom = ?, prenom = ?, nomJF = ?, dateNaiss = ?, age = ?, numImm = ?,nip = ?,adresse = ?,email = ?,genre = ?,photo = ?,civilite = ?,grpSng = ?,sitFam = ?,ville = ?,telDomicile = ?,telProf = ?,telPortable = ?,profession = ?,nbEnfants = ?,codePostal = ?,affLduree = ? where nip = ?;";
			try {
				PreparedStatement ps = connexion.prepareStatement(query);
				
				ps.setString(1, p.getNom());
				ps.setString(2, p.getPrenom());
				ps.setString(3, p.getNomJeuneF());
				ps.setDate(4, p.getDateNaissance());
				ps.setString(5, p.getAge());
				ps.setString(6, p.getNumImmatriculation());	
				ps.setInt(7, p.getNip());
				ps.setString(8, p.getAdresse());
				ps.setString(9, p.getEmail());
				ps.setString(10, p.getGenre());
				ps.setString(11, p.getPhoto());
				ps.setString(12, p.getCivilite());
				ps.setString(13, p.getGrpSng());
				ps.setString(14, p.getSitFam());
				ps.setString(15, p.getVille());
				ps.setString(16, p.getTelDomicile());
				ps.setString(17, p.getTelProf());
				ps.setString(18, p.getTelPortable());
				ps.setString(19, p.getProfession());
				ps.setInt(20, p.getNbEnfants());
				ps.setInt(21, p.getCodePostal());
				ps.setBoolean(22, p.isAffLduree());
				ps.setInt(23, p.getNip());
				
				int res = ps.executeUpdate();
				
				if (res != 0) {
					System.out.println("Patient mis a jour avec succes!");
				}else
				{
					System.out.println("Impossible de mettre a jour le patient");
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public Patient rechercher(int id)
	{
		Patient p = null;
		
		// Ouverture de la connexion a la base de données
		Connection connexion = DBConnection.getConnection();
		
		if(connexion != null)
		{
			String query = "select * from patient where code = ?;";
			try {
				PreparedStatement ps = connexion.prepareStatement(query);
				
				ps.setInt(1, id);
				
				ResultSet res = ps.executeQuery();				
				if (res.next()) {
					p = new Patient(res.getInt(1),res.getString(2), res.getString(3), res.getString(4), res.getDate(5), res.getString(6), 
							res.getString(7),res.getInt(8),res.getString(9),res.getString(10),res.getString(11),res.getString(12),
							res.getString(13),res.getString(14),res.getString(15),res.getString(16),res.getString(17),
							res.getString(18),res.getString(19),res.getString(20),res.getInt(21),res.getInt(22),res.getBoolean(23));
					System.out.println("Patient trouvé!");
				}else
				{
					System.out.println("Impossible de trouver le patient!");
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return p;
	}
	
	public ArrayList<Patient> getAllPatients()
	{
		ArrayList<Patient> allPatients = new ArrayList<Patient>();
		
		// Ouverture de la connexion a la base de données
		Connection connexion = DBConnection.getConnection();
				
		if(connexion != null)
		{
			String query = "select * from patient;";
			try {
				PreparedStatement ps = connexion.prepareStatement(query);
						
				ResultSet res = ps.executeQuery();				
				while (res.next()) {
					Patient p = new Patient(res.getInt(1),res.getString(2), res.getString(3), res.getString(4), res.getDate(5), res.getString(6), 
							res.getString(7),res.getInt(8),res.getString(9),res.getString(10),res.getString(11),res.getString(12),
							res.getString(13),res.getString(14),res.getString(15),res.getString(16),res.getString(17),
							res.getString(18),res.getString(19),res.getString(20),res.getInt(21),res.getInt(22),res.getBoolean(23));
					allPatients.add(p);
				}
						
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return allPatients;
	}
}
