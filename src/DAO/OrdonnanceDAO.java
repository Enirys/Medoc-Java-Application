package DAO;

import java.sql.*;

import OO.Ordonnance;

public class OrdonnanceDAO {

	public int ajouter(Ordonnance o)
	{
		int generatedKey = 0;
		
		// Ouverture de la connexion a la base de données
		Connection connexion = DBConnection.getConnection();
		
		if(connexion != null)
		{
			String query = "insert into ordonnance(codeC,titre) values(?,?);";
			try {
				PreparedStatement ps = connexion.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
				
				ps.setInt(1, o.getCodeC());
				ps.setString(2, o.getTitre());
				
				int res = ps.executeUpdate();
				
				if (res != 0) { 
					System.out.println("Ordonnance ajoutee!");
					ResultSet generatedKeys = ps.getGeneratedKeys();
					if(generatedKeys.next())
					{
						System.out.println(generatedKeys.getInt(1));
						generatedKey = generatedKeys.getInt(1);
					}
					
				}else
				{
					System.out.println("Impossible d'ajouter l'ordonnance");
				}
				connexion.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return generatedKey;
	}
	
	public void supprimer(Ordonnance o)
	{
		// Ouverture de la connexion a la base de données
		Connection connexion = DBConnection.getConnection();
				
		if(connexion != null)
		{
			String query = "delete from ordonnance where code = ?;";
			try {
				PreparedStatement ps = connexion.prepareStatement(query);
						
				ps.setInt(1, o.getCode());
						
				int res = ps.executeUpdate();				
				if (res != 0) {
					System.out.println("Delete success!");
				}else
				{
					System.out.println("Impossible de supprimer l'ordonnance!");
				}
						
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void modifier(Ordonnance o)
	{
		// Ouverture de la connexion a la base de données
		Connection connexion = DBConnection.getConnection();
				
		if(connexion != null)
		{
			String query = "update ordonnance set titre = ? ,codeC = ? where code = ?;";
			try {
				PreparedStatement ps = connexion.prepareStatement(query);
						
				ps.setString(1, o.getTitre());
				ps.setInt(2, o.getCodeC());
				ps.setInt(3, o.getCode()); 
						
				int res = ps.executeUpdate();
						
				if (res != 0) {
					System.out.println("Ordonnance mise a jour avec succes!");
				}else
				{
					System.out.println("Impossible de mettre a jour l'ordonnance");
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
			String query = "select * from ordonnance where code = ?;";
			try {
				PreparedStatement ps = connexion.prepareStatement(query);
						
				ps.setInt(1, id);
						
				ResultSet res = ps.executeQuery();				
				if (res.next()) {
					Ordonnance o = new Ordonnance(res.getInt(1),res.getInt(2),res.getString(3));
					System.out.println("Ordonnance trouvee!");
					o.afficherOrdonnance();
				}else
				{
					System.out.println("Impossible de trouver l'ordonnance!");
				}
						
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
