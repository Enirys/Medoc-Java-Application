package OO;

import java.sql.Date;

public class Patient extends Personne {

	private String nomJF;
	private Date dateNaiss;
	private String genre;
	private String email;
	private String photo;
	private String numImm;
	private String age;
	private int nip;
	private String civilite;
	private String grpSng;
	private String sitFam;
	private int nbEnfants;
	private String adresse;
	private int codePostal;
	private String ville;
	private String telDomicile;
	private String telProf;
	private String telPortable;
	private String profession;
	private boolean affLduree;
	
	public Patient(String nom, String prenom, String nomJF, Date dateNaiss, String age, String numImm,
			int nip,String adresse,String email,String genre,String photo,String civilite,String grpSng,String sitFam,
			String ville,String telDomicile,String telProf,String telPortable,String profession,int nbEnfants,
			int codePostal,boolean affLduree)
	{
		super(nom,prenom);
		
		this.setNomJeuneF(nomJF);
		this.setGenre(genre);
		this.setEmail(email);
		this.setPhoto(photo);
		this.setCivilite(civilite);
		this.setGrpSng(grpSng);
		this.setSitFam(sitFam);
		this.setAdresse(adresse);
		this.setVille(ville);
		this.setTelDomicile(telDomicile);
		this.setTelProf(telProf);
		this.setTelPortable(telPortable);
		this.setProfession(profession);
		this.setDateNaissance(dateNaiss);
		this.setNumImmatriculation(numImm);
		this.setNip(nip);
		this.setNbEnfants(nbEnfants);
		this.setCodePostal(codePostal);
		this.setAge(age);
		this.setAffLduree(affLduree);
	}
	
	public Patient(int code, String nom, String prenom, String nomJF, Date dateNaiss, String age, String numImm,
			int nip,String adresse,String email,String genre,String photo,String civilite,String grpSng,String sitFam,
			String ville,String telDomicile,String telProf,String telPortable,String profession,int nbEnfants,
			int codePostal,boolean affLduree)
	{
		super(code,nom,prenom);
		
		this.setNomJeuneF(nomJF);
		this.setGenre(genre);
		this.setEmail(email);
		this.setPhoto(photo);
		this.setCivilite(civilite);
		this.setGrpSng(grpSng);
		this.setSitFam(sitFam);
		this.setAdresse(adresse);
		this.setVille(ville);
		this.setTelDomicile(telDomicile);
		this.setTelProf(telProf);
		this.setTelPortable(telPortable);
		this.setProfession(profession);
		this.setDateNaissance(dateNaiss);
		this.setNumImmatriculation(numImm);
		this.setNip(nip);
		this.setNbEnfants(nbEnfants);
		this.setCodePostal(codePostal);
		this.setAge(age);
		this.setAffLduree(affLduree);
	}
	
	public int getCode()
	{
		return code;
	}
	
	public void setCode(int code)
	{
		this.code = code;
	}
	
	public String getNom() {
		return this.nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getPrenom() {
		return this.prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNomJeuneF() {
		return nomJF;
	}
	public void setNomJeuneF(String nomJF) {
		this.nomJF = nomJF;
	}

	public Date getDateNaissance() {
		return dateNaiss;
	}
	public void setDateNaissance(Date dateNaiss) {
		this.dateNaiss = dateNaiss;
	}

	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getNumImmatriculation() {
		return numImm;
	}
	public void setNumImmatriculation(String numImm) {
		this.numImm = numImm;
	}

	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}

	public int getNip() {
		return nip;
	}
	public void setNip(int nip) {
		this.nip = nip;
	}

	public String getCivilite() {
		return civilite;
	}
	public void setCivilite(String civilite) {
		this.civilite = civilite;
	}

	public String getGrpSng() {
		return grpSng;
	}
	public void setGrpSng(String grpSng) {
		this.grpSng = grpSng;
	}

	public int getNbEnfants() {
		return nbEnfants;
	}
	public void setNbEnfants(int nbEnfants) {
		this.nbEnfants = nbEnfants;
	}

	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getSitFam() {
		return sitFam;
	}
	public void setSitFam(String sitFam) {
		this.sitFam = sitFam;
	}

	public int getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getTelDomicile() {
		return telDomicile;
	}
	public void setTelDomicile(String telDomicile) {
		this.telDomicile = telDomicile;
	}

	public String getTelProf() {
		return telProf;
	}
	public void setTelProf(String telProf) {
		this.telProf = telProf;
	}

	public String getTelPortable() {
		return telPortable;
	}
	public void setTelPortable(String telPortable) {
		this.telPortable = telPortable;
	}

	
	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public boolean isAffLduree() {
		return affLduree;
	}

	public void setAffLduree(boolean affLduree) {
		this.affLduree = affLduree;
	}
	
	public void afficherPatient()
	{
		System.out.println(this.getCode() + "|" + this.getNom() + "|" +this.getPrenom() + "|" +this.getNomJeuneF() + "|" +this.getGenre() + "|" +this.getGrpSng());
	}
}
