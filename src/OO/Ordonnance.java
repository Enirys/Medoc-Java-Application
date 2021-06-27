package OO;

public class Ordonnance {
	private int code;
	private int codeC;
	private String titre;
	
	public Ordonnance(int code, int codeC, String titre)
	{
		this.code = code;
		this.codeC = codeC;
		this.setTitre(titre);
	}
	
	public Ordonnance(int codeC, String titre)
	{
		this.codeC = codeC;
		this.setTitre(titre);
	}
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public int getCodeC() {
		return codeC;
	}
	public void setCodeC(int codeC) {
		this.codeC = codeC;
	}
	
	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}
	
	public void afficherOrdonnance()
	{
		System.out.println(this.getCode() + "|" + this.getCodeC() + "|" + this.getTitre());
	}

	
}
