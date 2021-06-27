package DAO;
import java.sql.*;

import IHM.DashboardFrame;
import OO.*;

public class AuthenticationController {
	
	public boolean loginUser(Utilisateur user)
	{
		boolean authSuccess = false;
		// Connexion à la base de données
		Connection connexion = DBConnection.getConnection();
		
		if(connexion != null)
		{
			// Rechercher l'utilisateur dans la table user
			try {
				PreparedStatement ps = connexion.prepareStatement("select * from user where username = ? and pass = ?;");
				
				ps.setString(1, user.getUsername());
				ps.setString(2, user.getPass());
				
				ResultSet res = ps.executeQuery();
				
				if(res.next())
				{
					System.out.println("Login Success!");
					
					user = new Utilisateur(res.getInt(1), res.getString(2), res.getString(3), res.getString(4));
					
					if(user.getTypeUser().equals("Medecin"))
					{
						// Afficher interface medecin
						System.out.println("Interface Médecin");
						new DashboardFrame(user);
						authSuccess = true;
					}else if(user.getTypeUser().equals("Secretaire"))
					{
						// Afficher interface secretaire
						System.out.println("Interface Secrétaire");
						new DashboardFrame(user);
						authSuccess = true;
					}else if(user.getTypeUser().equals("Administrateur"))
					{
						// Afficher interface admin
						System.out.println("Interface Administrateur");
						new DashboardFrame(user);
						authSuccess = true;
					}
				}else
				{
					System.out.println("Username/Password is incorrect!");
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		// Fermeture de la connexion à la base de données
		try {
			connexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return authSuccess;
	}
	
	public void registerUser(Utilisateur user)
	{
		// Connexion à la base de données
		Connection connexion = DBConnection.getConnection();
				
		if(connexion != null)
		{
			String query = "insert into user(username,pass,userType) values(?,?,?);";
			try {
				PreparedStatement ps = connexion.prepareStatement(query);
				
				ps.setString(1, user.getUsername());
				ps.setString(1, user.getPass());
				ps.setString(1, user.getTypeUser());
				
				int res = ps.executeUpdate();
				
				if (res != 0) { 
					System.out.println("Utilisateur ajoute!");
				}else
				{
					System.out.println("Impossible d'ajouter l'utilisateur");
				}
				connexion.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
