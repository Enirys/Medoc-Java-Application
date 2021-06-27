package DAO;

import java.sql.*;
import java.util.ArrayList;

import OO.Consultation;
import OO.Patient;

public class ConsultationDAO {
	
	public int ajouter(Consultation c)
	{
		int generatedKey = 0;
		
		// Ouverture de la connexion a la base de données
		Connection connexion = DBConnection.getConnection();
		
		if(connexion != null)
		{
			String query = "insert into consultation(codeP,typeC,remarques,honoraires,titre,dateC) values(?,?,?,?,?,?);";
			try {
				PreparedStatement ps = connexion.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
				
				ps.setInt(1, c.getCodeP());
				ps.setString(2, c.getTypeC());
				ps.setString(3, c.getRemarques());
				ps.setDouble(4, c.getHonoraires());
				ps.setString(5, c.getTitre());
				ps.setDate(6, c.getDateC());
				
				int res = ps.executeUpdate();
				
				if (res != 0) { 
					System.out.println("Consultation ajoutée!");
					ResultSet generatedKeys = ps.getGeneratedKeys();
					if(generatedKeys.next())
					{
						System.out.println(generatedKeys.getInt(1));
						generatedKey = generatedKeys.getInt(1);
					}
				}else
				{
					System.out.println("Impossible d'ajouter la consultation");
				}
				connexion.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return generatedKey;
	}
	
	public void supprimer(Consultation c)
	{
		// Ouverture de la connexion a la base de données
		Connection connexion = DBConnection.getConnection();
				
		if(connexion != null)
		{
			String query = "delete from consultation where codeC = ?;";
			try {
				PreparedStatement ps = connexion.prepareStatement(query);
						
				ps.setInt(1, c.getCodeC());
				System.out.println("Supprimer consultation: " + c.getCodeC());
						
				int res = ps.executeUpdate();				
				if (res != 0) {
					System.out.println("Delete success!");
				}else
				{
					System.out.println("Impossible de supprimer la consultation!");
				}
						
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void modifier(Consultation c)
	{
		// Ouverture de la connexion a la base de données
		Connection connexion = DBConnection.getConnection();
				
		if(connexion != null)
		{
			String query = "update consultation set typeC = ?, remarques = ?, honoraires = ?, titre = ?, dateC = ? where codeC = ?;";
			try {
				PreparedStatement ps = connexion.prepareStatement(query);
						
				ps.setString(1, c.getTypeC());
				ps.setString(2, c.getRemarques());
				ps.setDouble(3, c.getHonoraires());
				ps.setString(4, c.getTitre());
				ps.setDate(5, c.getDateC());
				ps.setInt(6, c.getCodeC());	
				
				System.out.println("Modifier consultation: " + c.getCodeC());
						
				int res = ps.executeUpdate();
						
				if (res != 0) {
					System.out.println("Consultation mise a jour avec succes:");
				}else
				{
					System.out.println("Impossible de mettre a jour la consultation");
				}
						
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	
	public void rechercher(int id)
	{
		// Ouverture de la connexion a la base de données
		Connection connexion = DBConnection.getConnection();
				
		if(connexion != null)
		{
			String query = "select * from consultation where codeC = ?;";
			try {
				PreparedStatement ps = connexion.prepareStatement(query);
						
				ps.setInt(1, id);
						
				ResultSet res = ps.executeQuery();				
				if (res.next()) {
					Consultation c = new Consultation(res.getInt(1),res.getInt(2),res.getString(3),res.getString(4),
							res.getDouble(5),res.getString(6),res.getDate(7));
					System.out.println("Consultation trouvee!");
					c.afficherConsultation();
				}else
				{
					System.out.println("Impossible de trouver la consultation!");
				}
						
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public ArrayList<Consultation> getAllPatientConsultation(int codeP)
	{
		ArrayList<Consultation> allConsultations = new ArrayList<Consultation>();
		
		// Ouverture de la connexion a la base de données
		Connection connexion = DBConnection.getConnection();
				
		if(connexion != null)
		{
			String query = "select * from consultation where codeP = ?;";
			try {
				PreparedStatement ps = connexion.prepareStatement(query);
						
				ps.setInt(1, codeP);
						
				ResultSet res = ps.executeQuery();				
				while (res.next()) {
					Consultation c = new Consultation(res.getInt(1),res.getInt(2),res.getString(3),res.getString(4),
							res.getDouble(5),res.getString(6),res.getDate(7));
					System.out.println("Consultation trouvee!");
					allConsultations.add(c);
				}
						
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return allConsultations;
	}
}
