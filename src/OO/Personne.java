package OO;

public class Personne {
	
	protected int code;
	protected String nom;
	protected String prenom;
	
	public Personne(int code, String nom, String prenom)
	{
		this.code = code;
		this.nom = nom;
		this.prenom = prenom;
	}
	
	public Personne(String nom, String prenom)
	{
		this.nom = nom;
		this.prenom = prenom;
	}
}
