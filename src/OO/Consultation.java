package OO;

import java.sql.*;

public class Consultation {
	
	private int codeC;
	private int codeP;
	private String typeC;
	private String remarques;
	private Double honoraires;
	private String titre;
	private Date dateC;
	
	public Consultation(int codeC,int codeP, String typeC, String remarques, Double honoraires, String titre, Date dateC)
	{
		this.codeC = codeC;
		this.codeP = codeP;
		this.typeC = typeC;
		this.remarques = remarques;
		this.honoraires = honoraires;
		this.titre = titre;
		this.dateC = dateC;
	}
	
	public Consultation(int codeP, String typeC, String remarques, Double honoraires, String titre, Date dateC)
	{
		this.codeP = codeP;
		this.typeC = typeC;
		this.remarques = remarques;
		this.honoraires = honoraires;
		this.titre = titre;
		this.dateC = dateC;
	}
	
	public int getCodeP() {
		return codeP;
	}

	public void setCodeP(int codeP) {
		this.codeP = codeP;
	}

	public String getTypeC() {
		return typeC;
	}

	public void setTypeC(String typeC) {
		this.typeC = typeC;
	}

	public String getRemarques() {
		return remarques;
	}

	public void setRemarques(String remarques) {
		this.remarques = remarques;
	}

	public Double getHonoraires() {
		return honoraires;
	}

	public void setHonoraires(Double honoraires) {
		this.honoraires = honoraires;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public Date getDateC() {
		return dateC;
	}

	public void setDateC(Date dateC) {
		this.dateC = dateC;
	}

	public int getCodeC() {
		return codeC;
	}

	public void setCodeC(int codeC) {
		this.codeC = codeC;
	}
	
	public void afficherConsultation()
	{
		System.out.println(this.getCodeC() + "|" + this.getCodeP() + "|" + this.getTypeC() + "|" + this.getRemarques() + "|" + this.getHonoraires() + "|" + this.getTitre() + "|" + this.getDateC());
	}
}
