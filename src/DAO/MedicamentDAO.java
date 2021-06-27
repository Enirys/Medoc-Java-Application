package DAO;

import java.sql.*;
import java.util.ArrayList;

import OO.Medicament;

public class MedicamentDAO {
	public void ajouter(Medicament m)
	{
		// Ouverture de la connexion a la base de données
		Connection connexion = DBConnection.getConnection();
		
		if(connexion != null)
		{
			String query = "insert into medicament(nom) values(?);";
			try {
				PreparedStatement ps = connexion.prepareStatement(query);
				
				ps.setString(1, m.getNom());
				
				int res = ps.executeUpdate();
				
				if (res != 0) { 
					System.out.println("Medicament ajoute!");
				}else
				{
					System.out.println("Impossible d'ajouter le medicament");
				}
				connexion.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void supprimer(Medicament m)
	{
		// Ouverture de la connexion a la base de données
		Connection connexion = DBConnection.getConnection();
				
		if(connexion != null)
		{
			String query = "delete from medicament where code = ?;";
			try {
				PreparedStatement ps = connexion.prepareStatement(query);
						
				ps.setInt(1, m.getCode());
						
				int res = ps.executeUpdate();				
				if (res != 0) {
					System.out.println("Delete success!");
				}else
				{
					System.out.println("Impossible de supprimer le medicament!");
				}
						
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void modifier(Medicament m)
	{
		// Ouverture de la connexion a la base de données
		Connection connexion = DBConnection.getConnection();
				
		if(connexion != null)
		{
			String query = "update medicament set nom = ? where code = ?;";
			try {
				PreparedStatement ps = connexion.prepareStatement(query);
						
				ps.setString(1, m.getNom());
				ps.setInt(2, m.getCode());
						
				int res = ps.executeUpdate();
						
				if (res != 0) {
					System.out.println("Medicament mis a jour avec succes!");
					System.out.println(m.getNom());
				}else
				{
					System.out.println("Impossible de mettre a jour la medicament");
				}
						
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public Medicament rechercherParNom(String nom)
	{
		Medicament m = null;
		// Ouverture de la connexion a la base de données
		Connection connexion = DBConnection.getConnection();
				
		if(connexion != null)
		{
			String query = "select * from medicament where nom = ?;";
			try {
				PreparedStatement ps = connexion.prepareStatement(query);
						
				ps.setString(1, nom);
						
				ResultSet res = ps.executeQuery();				
				if (res.next()) {
					m = new Medicament(res.getInt(1),res.getString(2));
				}else
				{
					System.out.println("Impossible de trouver le medicament!");
				}
						
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return m;
	}
	
	public void rechercher(int id)
	{
		// Ouverture de la connexion a la base de données
		Connection connexion = DBConnection.getConnection();
				
		if(connexion != null)
		{
			String query = "select * from medicament where code = ?;";
			try {
				PreparedStatement ps = connexion.prepareStatement(query);
						
				ps.setInt(1, id);
						
				ResultSet res = ps.executeQuery();				
				if (res.next()) {
					Medicament m = new Medicament(res.getInt(1),res.getString(2));
					System.out.println("Medicament trouve!");
					m.afficherMedicament();
				}else
				{
					System.out.println("Impossible de trouver le medicament!");
				}
						
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public ArrayList<Medicament> getAllMedicaments()
	{
		ArrayList<Medicament> allMedicaments = new ArrayList<Medicament>();
		
		// Ouverture de la connexion a la base de données
		Connection connexion = DBConnection.getConnection();
				
		if(connexion != null)
		{
			String query = "select * from medicament;";
			try {
				PreparedStatement ps = connexion.prepareStatement(query);
						
				ResultSet res = ps.executeQuery();				
				while (res.next()) {
					Medicament m = new Medicament(res.getInt(1),res.getString(2));
					allMedicaments.add(m);
				}
						
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return allMedicaments;
	}
}
