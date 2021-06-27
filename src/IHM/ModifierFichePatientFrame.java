package IHM;

import javax.swing.*;
import java.text.DateFormatSymbols;

import CustomUI.*;
import DAO.*;
import OO.*;

import java.awt.*;
import java.awt.event.*;
import java.time.*;
import java.util.*;
import java.sql.*;
import java.sql.Date;

public class ModifierFichePatientFrame extends JFrame implements ActionListener{
	
	private int codePatient;
	
	private CustomButton photoBtn;
    private CustomButton femBtn;
    private CustomButton maleBtn;
    private CustomButton agendaBtn;
    private CustomButton mailsBtn;
    private CustomButton carteVitaleBtn;
    private CustomButton courrielBtn;
    private CustomButton cerfacilBtn;
    private CustomButton phoneBtn;
    private CustomButton uploadBtn;
    private CustomButton mtBtn;
    private CustomButton longueDureeBtn;
    private CustomButton updateBtn;
    private CustomButton annulerBtn;
    private JComboBox<String> civiliteCmbx;
    private JComboBox<Integer> jourCmbx;
    private JComboBox<Integer> moisCmbx;
    private JComboBox<Integer> anneeCmbx;
    private JComboBox<String> grpSngCmbx;
    private JComboBox<String> sitFamCmbx;
    private JComboBox<String> professionCmbx;
    private CustomJLabel titleLbl;
    private CustomJLabel nomFamilleLbl;
    private CustomJLabel nomJFLbl;
    private CustomJLabel prenomLbl;
    private CustomJLabel numImmLbl;
    private CustomJLabel civiliteLbl;
    private CustomJLabel nipLbl;
    private CustomJLabel jourLbl;
    private CustomJLabel moisLbl;
    private CustomJLabel anneeLbl;
    private CustomJLabel ageLbl;
    private CustomJLabel grpSngLbl;
    private CustomJLabel sitFamLbl;
    private CustomJLabel nbEnfantsLbl;
    private CustomJLabel adresseLbl;
    private CustomJLabel codePostalLbl;
    private CustomJLabel villeLbl;
    private CustomJLabel portableLbl;
    private CustomJLabel domicileLbl;
    private CustomJLabel profLbl;
    private CustomJLabel professionLbl;
    private CustomJLabel addresseParLbl;
    private CustomJLabel emailLbl;
    private JPanel mainPanel;
    private JPanel centerPanel;
    private JPanel centerLeftPanel;
    private JPanel centerCenterPanel;
    private JPanel centerRightPanel;
    private JPanel bottomPanel;
    private JPanel topPanel;
    private JPanel genderPanel;
    private JPanel dateNaissancePanel;
    private JPanel questionnaireTabPanel;
    private JPanel socialeTabPanel;
    private JPanel dmpTabPanel;
    private JTabbedPane mainTabbedPane; 
    private CustomJTextField nomFamilleTxt;
    private CustomJTextField nomJFTxt;
    private CustomJTextField prenomTxt;
    private CustomJTextField numImmTxt;
    private CustomJTextField nipTxt;
    private CustomJTextField ageTxt;
    private CustomJTextField nbEnfantsTxt;
    private CustomJTextField adresseTxt;
    private CustomJTextField codePostalTxt;
    private CustomJTextField villeTxt;
    private CustomJTextField portableTxt;
    private CustomJTextField domicileTxt;
    private CustomJTextField profTxt;
    private CustomJTextField addresseParTxt;
    private CustomJTextField emailTxt;
    
    private boolean affLD = false;
    private Date dateNaissance;
    private String genre;
    
    public ModifierFichePatientFrame(int codeP)
    {
    	this.codePatient = codeP;
    	
    	// Customisation de la fenetre
    	this.setTitle("Modifier Fiche patient");
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(new Dimension(1200, 650));
        
    	mainPanel = new JPanel();
        centerPanel = new JPanel();
        centerCenterPanel = new JPanel();
        centerLeftPanel = new JPanel();
        centerRightPanel = new JPanel();
        bottomPanel = new JPanel();
        topPanel = new JPanel();
        genderPanel = new JPanel();
        dateNaissancePanel = new JPanel();
        
        mainPanel.setBackground(new Color(255, 255, 255));
        dateNaissancePanel.setBackground(new Color(255, 255, 255));
        genderPanel.setBackground(new Color(255, 255, 255));
        centerPanel.setBackground(new Color(255, 255, 255));
        centerLeftPanel.setBackground(new Color(255, 255, 255));
        centerRightPanel.setBackground(new Color(255, 255, 255));
        centerCenterPanel.setBackground(new Color(255, 255, 255));
        bottomPanel.setBackground(new Color(255, 255, 255));
        topPanel.setBackground(new Color(255, 255, 255));
        
        mainPanel.setLayout(new BorderLayout());
        centerPanel.setLayout(new GridLayout(1,3,5,5));
        centerLeftPanel.setLayout(new GridLayout(4,1,5,5));
        centerRightPanel.setLayout(new GridLayout(10,3,5,5));
        centerCenterPanel.setLayout(new GridLayout(10,3,5,5));
        dateNaissancePanel.setLayout(new GridLayout(2,3,5,5));
        
        centerPanel.add(centerLeftPanel);
        centerPanel.add(centerCenterPanel);
        centerPanel.add(centerRightPanel);
        
        mainPanel.add(centerPanel,BorderLayout.CENTER);
        mainPanel.add(topPanel,BorderLayout.NORTH);
        mainPanel.add(bottomPanel,BorderLayout.SOUTH);
        
        this.setLocationRelativeTo(null);
        
        // Creation des Labels
        titleLbl = new CustomJLabel("Modifier la fiche patient.",new Color(38, 52, 50),new Font("Montserrat", 1, 18));
        nomFamilleLbl = new CustomJLabel("Nom de famille",new Color(38, 52, 50),new Font("Montserrat", 0, 12));
        nomJFLbl = new CustomJLabel("Nom de jeune fille",new Color(38, 52, 50),new Font("Montserrat", 0, 12));
        prenomLbl = new CustomJLabel("Prénom",new Color(38, 52, 50),new Font("Montserrat", 0, 12));
        numImmLbl = new CustomJLabel("Numéro d'immatriculation Ss",new Color(38, 52, 50),new Font("Montserrat", 0, 12));
        civiliteLbl = new CustomJLabel("Civilité",new Color(38, 52, 50),new Font("Montserrat", 0, 12));
        nipLbl = new CustomJLabel("NIP",new Color(38, 52, 50),new Font("Montserrat", 0, 12));
        jourLbl = new CustomJLabel("Jour",new Color(38, 52, 50),new Font("Montserrat", 0, 12));
        moisLbl = new CustomJLabel("Mois",new Color(38, 52, 50),new Font("Montserrat", 0, 12));
        anneeLbl = new CustomJLabel("Année",new Color(38, 52, 50),new Font("Montserrat", 0, 12));
        ageLbl = new CustomJLabel("Age",new Color(38, 52, 50),new Font("Montserrat", 0, 12));
        grpSngLbl = new CustomJLabel("GrpSng",new Color(38, 52, 50),new Font("Montserrat", 0, 12));
        sitFamLbl = new CustomJLabel("SitFam.",new Color(38, 52, 50),new Font("Montserrat", 0, 12));
        nbEnfantsLbl = new CustomJLabel("Nb Enfants",new Color(38, 52, 50),new Font("Montserrat", 0, 12));
        adresseLbl = new CustomJLabel("Adresse",new Color(38, 52, 50),new Font("Montserrat", 0, 12));
        codePostalLbl = new CustomJLabel("Code postal",new Color(38, 52, 50),new Font("Montserrat", 0, 12));
        villeLbl = new CustomJLabel("Ville",new Color(38, 52, 50),new Font("Montserrat", 0, 12));
        portableLbl = new CustomJLabel("Portable",new Color(38, 52, 50),new Font("Montserrat", 0, 12));
        domicileLbl = new CustomJLabel("Domicile",new Color(38, 52, 50),new Font("Montserrat", 0, 12));
        profLbl = new CustomJLabel("Prof.",new Color(38, 52, 50),new Font("Montserrat", 0, 12));
        professionLbl = new CustomJLabel("Profession",new Color(38, 52, 50),new Font("Montserrat", 0, 12));
        addresseParLbl = new CustomJLabel("Adressé par",new Color(38, 52, 50),new Font("Montserrat", 0, 12));
        emailLbl = new CustomJLabel("E-mail",new Color(38, 52, 50),new Font("Montserrat", 0, 12));

        // Creation des TextFields
        nomFamilleTxt = new CustomJTextField(new Color(238, 238, 238), new Font("Montserrat", 0, 14),20);
        nomJFTxt = new CustomJTextField(new Color(238, 238, 238), new Font("Montserrat", 0, 14),20);
        prenomTxt = new CustomJTextField(new Color(238, 238, 238), new Font("Montserrat", 0, 14),20);
        numImmTxt = new CustomJTextField(new Color(238, 238, 238), new Font("Montserrat", 0, 14),20);
        nipTxt = new CustomJTextField(new Color(238, 238, 238), new Font("Montserrat", 0, 14),20);
        ageTxt = new CustomJTextField(new Color(238, 238, 238), new Font("Montserrat", 0, 14),20);
        nbEnfantsTxt = new CustomJTextField(new Color(238, 238, 238), new Font("Montserrat", 0, 14),20);
        adresseTxt = new CustomJTextField(new Color(238, 238, 238), new Font("Montserrat", 0, 14),20);
        codePostalTxt = new CustomJTextField(new Color(238, 238, 238), new Font("Montserrat", 0, 14),20);
        villeTxt = new CustomJTextField(new Color(238, 238, 238), new Font("Montserrat", 0, 14),20);
        portableTxt = new CustomJTextField(new Color(238, 238, 238), new Font("Montserrat", 0, 14),20);
        domicileTxt = new CustomJTextField(new Color(238, 238, 238), new Font("Montserrat", 0, 14),20);
        profTxt = new CustomJTextField(new Color(238, 238, 238), new Font("Montserrat", 0, 14),20);
        addresseParTxt = new CustomJTextField(new Color(238, 238, 238), new Font("Montserrat", 0, 14),20);
        emailTxt = new CustomJTextField(new Color(238, 238, 238), new Font("Montserrat", 0, 14),20);
        
        // Creation des boutons
    	photoBtn = new CustomButton(new ImageIcon("C:\\Dev\\JavaProjects\\ProjetTPUI\\FichePatientUI\\photo.png"));
    	femBtn = new CustomButton(new ImageIcon("C:\\Dev\\JavaProjects\\ProjetTPUI\\FichePatientUI\\femBtn.png"));
    	maleBtn = new CustomButton(new ImageIcon("C:\\Dev\\JavaProjects\\ProjetTPUI\\FichePatientUI\\malBtn.png"));
    	agendaBtn = new CustomButton(new ImageIcon("C:\\Dev\\JavaProjects\\ProjetTPUI\\FichePatientUI\\agendaBtn.png"));
    	mailsBtn = new CustomButton(new ImageIcon("C:\\Dev\\JavaProjects\\ProjetTPUI\\FichePatientUI\\mailsBtn.png"));
    	carteVitaleBtn = new CustomButton(new ImageIcon("C:\\Dev\\JavaProjects\\ProjetTPUI\\FichePatientUI\\carteVitaleBtn.png"));
    	courrielBtn = new CustomButton(new ImageIcon("C:\\Dev\\JavaProjects\\ProjetTPUI\\FichePatientUI\\courrielBtn.png"));
    	cerfacilBtn = new CustomButton(new ImageIcon("C:\\Dev\\JavaProjects\\ProjetTPUI\\FichePatientUI\\cerfaCILBtn.png"));
    	phoneBtn = new CustomButton(new ImageIcon("C:\\Dev\\JavaProjects\\ProjetTPUI\\FichePatientUI\\phoneBtn.png"));
    	uploadBtn = new CustomButton(new ImageIcon("C:\\Dev\\JavaProjects\\ProjetTPUI\\FichePatientUI\\uploadBtn.png"));
    	mtBtn = new CustomButton(new ImageIcon("C:\\Dev\\JavaProjects\\ProjetTPUI\\FichePatientUI\\mtBtn.png"));
    	longueDureeBtn = new CustomButton(new ImageIcon("C:\\Dev\\JavaProjects\\ProjetTPUI\\FichePatientUI\\ldBtn.png"));
    	updateBtn = new CustomButton(new ImageIcon("C:\\Dev\\JavaProjects\\ProjetTPUI\\FichePatientUI\\modifierBtn.png"));
    	annulerBtn = new CustomButton(new ImageIcon("C:\\Dev\\JavaProjects\\ProjetTPUI\\OtherUI\\annulerBtn.png"));
    	
    	// Ajout des Listeners aux boutons
    	photoBtn.addActionListener(this);
    	femBtn.addActionListener(this);
    	maleBtn.addActionListener(this);
    	agendaBtn.addActionListener(this);
    	mailsBtn.addActionListener(this);
    	carteVitaleBtn.addActionListener(this);
    	courrielBtn.addActionListener(this);
    	cerfacilBtn.addActionListener(this);
    	phoneBtn.addActionListener(this);
    	uploadBtn.addActionListener(this);
    	mtBtn.addActionListener(this);
    	longueDureeBtn.addActionListener(this);
    	updateBtn.addActionListener(this);
    	annulerBtn.addActionListener(this);
        
    	// Creation des combobox
    	civiliteCmbx = new JComboBox<String>();
    	jourCmbx = new JComboBox<Integer>();
    	moisCmbx = new JComboBox<Integer>();
    	anneeCmbx = new JComboBox<Integer>();
    	grpSngCmbx = new JComboBox<String>();
    	sitFamCmbx = new JComboBox<String>();
    	professionCmbx = new JComboBox<String>();
    	
    	// Chargement des combobox
    	civiliteCmbx.setModel(new DefaultComboBoxModel<>(new String[] {"Automatique", "Mr", "Mme", "Mlle"}));
    	grpSngCmbx.setModel(new DefaultComboBoxModel<>(new String[] {"A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-"}));
    	sitFamCmbx.setModel(new DefaultComboBoxModel<>(new String[] {"Célibatiare", "Marié(e)", "Divorcé(e)", "Veuf(ve)"}));
    	professionCmbx.setModel(new DefaultComboBoxModel<>(new String[] {"Profession", "Ingénieur", "Dentiste", "Professeur", "Pompier"}));
    	
    	jourCmbx.setModel(new DefaultComboBoxModel<>(remplirDateComboBox(1,31,0)));
    	moisCmbx.setModel(new DefaultComboBoxModel<>(remplirDateComboBox(1,12,0)));
    	anneeCmbx.setModel(new DefaultComboBoxModel<>(remplirDateComboBox(1,122,1899)));
    	
    	loadPatientInfos();
    	
    	topPanel.add(titleLbl);
    	genderPanel.add(femBtn);
    	genderPanel.add(maleBtn);
    	centerLeftPanel.add(photoBtn);
    	centerLeftPanel.add(genderPanel);
    	centerLeftPanel.add(agendaBtn);
    	centerLeftPanel.add(mailsBtn);
    	
    	centerCenterPanel.add(nomFamilleLbl);
    	centerCenterPanel.add(nomJFLbl);
    	centerCenterPanel.add(nomFamilleTxt);
    	centerCenterPanel.add(nomJFTxt);
    	centerCenterPanel.add(prenomLbl);
    	centerCenterPanel.add(numImmLbl);
    	centerCenterPanel.add(prenomTxt);
    	centerCenterPanel.add(numImmTxt);
    	dateNaissancePanel.add(jourLbl);
    	dateNaissancePanel.add(moisLbl);
    	dateNaissancePanel.add(anneeLbl);
    	dateNaissancePanel.add(jourCmbx);
    	dateNaissancePanel.add(moisCmbx);
    	dateNaissancePanel.add(anneeCmbx);
    	centerCenterPanel.add(dateNaissancePanel);
    	centerCenterPanel.add(ageLbl);
    	centerCenterPanel.add(ageTxt);
    	centerCenterPanel.add(adresseLbl);
    	centerCenterPanel.add(adresseTxt);
    	centerCenterPanel.add(codePostalLbl);
    	centerCenterPanel.add(codePostalTxt);
    	centerCenterPanel.add(villeLbl);
    	centerCenterPanel.add(villeTxt);
    	centerCenterPanel.add(emailLbl);
    	centerCenterPanel.add(emailTxt);
    	
    	bottomPanel.add(addresseParLbl);
    	bottomPanel.add(addresseParTxt);
    	bottomPanel.add(uploadBtn);
    	bottomPanel.add(mtBtn);
    	bottomPanel.add(longueDureeBtn);
    	bottomPanel.add(updateBtn);
    	bottomPanel.add(annulerBtn);

    	centerRightPanel.add(carteVitaleBtn);
    	centerRightPanel.add(courrielBtn);
    	centerRightPanel.add(cerfacilBtn);

    	centerRightPanel.add(civiliteLbl);
    	centerRightPanel.add(civiliteCmbx);
    	centerRightPanel.add(nipLbl);
    	centerRightPanel.add(nipTxt);

    	centerRightPanel.add(grpSngLbl);
    	centerRightPanel.add(grpSngCmbx);
    	centerRightPanel.add(sitFamLbl);
    	centerRightPanel.add(sitFamCmbx);
    	centerRightPanel.add(nbEnfantsLbl);
    	centerRightPanel.add(nbEnfantsTxt);

    	centerRightPanel.add(portableLbl);
    	centerRightPanel.add(portableTxt);
    	centerRightPanel.add(domicileLbl);
    	centerRightPanel.add(domicileTxt);
    	centerRightPanel.add(profLbl);
    	centerRightPanel.add(profTxt);
    	centerRightPanel.add(professionLbl);
    	centerRightPanel.add(professionCmbx);
    	
    	this.getContentPane().add(mainPanel);
    	this.setVisible(true);
    }
    
    private Integer[] remplirDateComboBox(int debut, int fin, int additional)
    {
    	int number = fin - debut + 1;
    	Integer[] values = new Integer[number];
    	
    	for(int i = 0; i < fin; i++)
    	{
    		values[i] = i + additional + 1;
    	}
    	
    	return values;
    }
    
    private Date calculerAge()
    {
    	int dayNumber = Integer.parseInt(jourCmbx.getSelectedItem().toString());
    	int monthNumber = Integer.parseInt(moisCmbx.getSelectedItem().toString());
    	int anneeNumber = Integer.parseInt(anneeCmbx.getSelectedItem().toString());
    	
    	Month month = Month.of(monthNumber);
    	
    	LocalDate today = LocalDate.now();
    	LocalDate birthday = LocalDate.of(anneeNumber, month, dayNumber);
    	Date dbBirthday = new Date(anneeNumber - 1900, monthNumber - 1 , dayNumber);

    	Period period = Period.between(birthday, today);
    	
    	ageTxt.setText(period.getYears() + " année(s) et " + period.getMonths() + " mois et " + period.getDays() + " jours.");
    	return dbBirthday;
    }
    
    private void affectationLongueDuree()
    {
    	if(!affLD)
		{
    		affLD = true;
		}else if(affLD)
		{
			affLD = false;
		}
    }
    
    private void loadPatientInfos()
    {
    	PatientDAO pDAO = new PatientDAO();
    	Patient p = pDAO.rechercher(codePatient);
    	
        nomFamilleTxt.setText(p.getNom());
        nomJFTxt.setText(p.getNomJeuneF());
        prenomTxt.setText(p.getPrenom());
        numImmTxt.setText(p.getNumImmatriculation());
        //nipTxt.setText(p.getNip());
        ageTxt.setText(p.getAge());
        //nbEnfantsTxt.setText(p.getNbEnfants());
        adresseTxt.setText(p.getAdresse());
        //codePostalTxt.setText(p.getCodePostal());
        villeTxt.setText(p.getVille());
        portableTxt.setText(p.getTelPortable());
        domicileTxt.setText(p.getTelDomicile());
        profTxt.setText(p.getTelProf());
    }
    
    private void modifierPatient()
    {
    	dateNaissance = calculerAge();
    	
    	Patient patient = new Patient(codePatient,nomFamilleTxt.getText(), prenomTxt.getText(), nomJFTxt.getText(), dateNaissance, ageTxt.getText(), numImmTxt.getText(),
    			Integer.parseInt(nipTxt.getText()),adresseTxt.getText(),emailTxt.getText(),genre,"TEST4",civiliteCmbx.getSelectedItem().toString(),grpSngCmbx.getSelectedItem().toString(),
    			sitFamCmbx.getSelectedItem().toString(),villeTxt.getText(),domicileTxt.getText(),profTxt.getText(),portableTxt.getText(),professionCmbx.getSelectedItem().toString(),
    			Integer.parseInt(nbEnfantsTxt.getText()),
    			Integer.parseInt(codePostalTxt.getText()),affLD);
    	
    	PatientDAO pDAO = new PatientDAO();
		pDAO.modifier(patient);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		
		if(o == updateBtn)
		{
			System.out.println("Modification de patient!");
			modifierPatient();
		}
		if(o == femBtn)
		{
			genre = "Female";
	    	
		}else if(o == maleBtn)
		{
			genre = "Male";
		}
		if(o == longueDureeBtn)
		{
			affectationLongueDuree();
		}
		if(o == annulerBtn)
		{
			System.exit(0);
		}
		
	}

}
