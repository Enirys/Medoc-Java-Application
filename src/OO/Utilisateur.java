package OO;

public class Utilisateur {
	private int codeU;
	private String username;
	private String pass;
	private String typeUser;
	
	public Utilisateur(String username, String pass)
	{
		this.username = username;
		this.pass = pass;
	}
	
	public Utilisateur(String username, String pass, String typeUser)
	{
		this.username = username;
		this.pass = pass;
		this.typeUser = typeUser;
	}
	
	public Utilisateur(int codeU, String username, String pass, String typeUser)
	{
		this.codeU = codeU;
		this.username = username;
		this.pass = pass;
		this.typeUser = typeUser;
	}
	
	public int getCodeU() {
		return codeU;
	}
	public void setCodeU(int codeU) {
		this.codeU = codeU;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getTypeUser() {
		return typeUser;
	}
	public void setTypeUser(String typeUser) {
		this.typeUser = typeUser;
	}
}
