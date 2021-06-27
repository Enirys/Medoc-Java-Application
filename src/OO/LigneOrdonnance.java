package OO;

public class LigneOrdonnance {
	
	private int code;
	private int codeO;
	private int codeMed;
	private int nbPrises;
	private int nbBoites;
	private String posologie;
	
	public LigneOrdonnance(int code, int codeO, int codeMed, int nbPrises, int nbBoites, String posologie)
	{
		this.code = code;
		this.codeO = codeO;
		this.codeMed = codeMed;
		this.nbPrises = nbPrises;
		this.nbBoites = nbBoites;
		this.posologie = posologie;
	}
	
	public LigneOrdonnance(int codeO, int codeMed, int nbPrises, int nbBoites, String posologie)
	{
		this.codeO = codeO;
		this.codeMed = codeMed;
		this.nbPrises = nbPrises;
		this.nbBoites = nbBoites;
		this.posologie = posologie;
	}
	
	public LigneOrdonnance(int codeMed, int nbPrises, int nbBoites, String posologie)
	{
		this.codeMed = codeMed;
		this.nbPrises = nbPrises;
		this.nbBoites = nbBoites;
		this.posologie = posologie;
	}
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public int getCodeO() {
		return codeO;
	}
	public void setCodeO(int codeO) {
		this.codeO = codeO;
	}
	public int getCodeMed() {
		return codeMed;
	}
	public void setCodeMed(int codeMed) {
		this.codeMed = codeMed;
	}
	public int getNbPrises() {
		return nbPrises;
	}
	public void setNbPrises(int nbPrises) {
		this.nbPrises = nbPrises;
	}
	public int getNbBoites() {
		return nbBoites;
	}
	public void setNbBoites(int nbBoites) {
		this.nbBoites = nbBoites;
	}
	public String getPosologie() {
		return posologie;
	}
	public void setPosologie(String posologie) {
		this.posologie = posologie;
	}
	
	public void afficherLigneOrdonnance()
	{
		System.out.println(this.getCode() + "|" + this.getCodeO() + "|" + this.getCodeMed() + "|" + this.getNbPrises() + "|" + this.getNbBoites() + this.getPosologie());
	} 

}
