package DAO;

import java.sql.*;

import OO.LigneOrdonnance;

public class LigneOrdonnanceDAO {
	public void ajouter(LigneOrdonnance lo)
	{
		// Ouverture de la connexion a la base de données
		Connection connexion = DBConnection.getConnection();
		
		if(connexion != null)
		{
			String query = "insert into ligneordonnance(codeO,codeMed,nbPrise,nbBoites,posologie) values(?,?,?,?,?);";
			try {
				PreparedStatement ps = connexion.prepareStatement(query);
				
				ps.setInt(1, lo.getCodeO());
				ps.setInt(2, lo.getCodeMed());
				ps.setInt(3, lo.getNbPrises());
				ps.setInt(4, lo.getNbBoites());
				ps.setString(5, lo.getPosologie());
				
				int res = ps.executeUpdate();
				
				if (res != 0) { 
					System.out.println("Ligne Ordonnance ajoutée!");
				}else
				{
					System.out.println("Impossible d'ajouter la Ligne Ordonnance");
				}
				connexion.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void supprimer(LigneOrdonnance lo)
	{
		// Ouverture de la connexion a la base de données
		Connection connexion = DBConnection.getConnection();
				
		if(connexion != null)
		{
			String query = "delete from ligneordonnance where code = ?;";
			try {
				PreparedStatement ps = connexion.prepareStatement(query);
						
				ps.setInt(1, lo.getCode());
						
				int res = ps.executeUpdate();				
				if (res != 0) {
					System.out.println("Delete success!");
				}else
				{
					System.out.println("Impossible de supprimer la Ligne Ordonnance!");
				}
						
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void modifier(LigneOrdonnance lo)
	{
		// Ouverture de la connexion a la base de données
		Connection connexion = DBConnection.getConnection();
				
		if(connexion != null)
		{
			String query = "update ligneordonnance set codeO = ?, codeMed = ?, nbPrises = ?, nbBoites = ?, posologie = ? where code = ?;";
			try {
				PreparedStatement ps = connexion.prepareStatement(query);
						
				ps.setInt(1, lo.getCodeO());
				ps.setInt(2, lo.getCodeMed());
				ps.setInt(3, lo.getNbPrises());
				ps.setInt(4, lo.getNbBoites());
				ps.setString(5, lo.getPosologie());
				ps.setInt(6, lo.getCode());	
						
				int res = ps.executeUpdate();
						
				if (res != 0) {
					System.out.println("Ligne ordonnance mise a jour avec succes!");
				}else
				{
					System.out.println("Impossible de mettre a jour la Ligne ordonnance");
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
			String query = "select * from ligneordonnance where code = ?;";
			try {
				PreparedStatement ps = connexion.prepareStatement(query);
						
				ps.setInt(1, id);
						
				ResultSet res = ps.executeQuery();				
				if (res.next()) {
					LigneOrdonnance lo = new LigneOrdonnance(res.getInt(1),res.getInt(2),res.getInt(3),res.getInt(4),
							res.getInt(5),res.getString(6));
					System.out.println("Ligne ordonnance trouvee!");
					lo.afficherLigneOrdonnance();
				}else
				{
					System.out.println("Impossible de trouver la ligne ordonnance!");
				}
						
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
