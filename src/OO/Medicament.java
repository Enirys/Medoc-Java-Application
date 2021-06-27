package OO;

public class Medicament {
	
	private int code;
	private String nom;
	
	public Medicament(int code,String nom)
	{
		this.code = code;
		this.nom = nom;
	}
	
	public Medicament(String nom)
	{
		this.nom = nom;
	}
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public void afficherMedicament()
	{
		System.out.println(this.getCode() + "|" + this.getNom());
	}

}
