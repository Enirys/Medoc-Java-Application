package IHM;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import CustomUI.*;
import DAO.*;
import OO.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.Date;
import java.util.ArrayList;

public class ConsultationFrame extends JFrame implements ActionListener{
	
	private int codePatient;
	private int codeConsultation;
	
	private JPanel mainPanel;
	private JPanel topPanel;
	private JPanel topTopPanel;
	private JPanel topCenterPanel;
	private JPanel topBottomPanel;
	private JPanel centerPanel;
	private JPanel centerCenterPanel;
	private JPanel bottomCenterPanel;
	private JPanel leftCenterMainPanel;
	private JPanel leftCenterPlacePanel;
	private JPanel leftCenterPanel;
	private JPanel consultationSettingsPanel;
	private JPanel editBtnPanel;
	
	private JMenuBar frameMenu;
	private JMenu fichierMenu;
	private JMenu paramMenu;
	private JMenu gestionMenu;
	private JMenu consultationMenu;
	private JMenu statistiqueMenu;
	private JMenu editionMenu;
	private JMenu fenetreMenu;
	private JMenu outilsMenu;
	private JMenu aideMenu;
	
	private CustomJLabel titleLbl;
	private CustomJLabel numeroPatientLbl;
	private CustomJLabel titrePatientLbl;
	private CustomJLabel prenomLbl;
	private CustomJLabel nomLbl;
	private CustomJLabel ageLbl;
	private CustomJLabel etatLbl;
	private CustomJLabel dateLbl;
	private CustomJLabel honorairesLbl;
	private CustomJLabel clicheLbl;
	private CustomJLabel titreConsultationLbl;
	private CustomJLabel typeConsultationLbl;
    
    private CustomButton ajouterConsultationBtn;
    private CustomButton cnamBtn;
    private CustomButton dateEtTitreBtn;
    private CustomButton modeleConsultationBtn;
    private CustomButton assistantConsultationBtn;
    private CustomButton uploadClicheBtn;
    private CustomButton saveBtn;
    
    private CustomButton italicBtn;
    private CustomButton boldBtn;
    private CustomButton underlinedBtn; 
    private CustomButton centerAlignBtn;
    private CustomButton rightAlignBtn;
    private CustomButton leftAlignBtn;
    private CustomButton undoBtn;
    private CustomButton doBtn;
    private CustomButton colorBtn;
    

    private CustomButton infosBtn;
    private CustomButton antecedantsBtn;
    private CustomButton consultationBtn;
    private CustomButton ordonnanceBtn;
    private CustomButton certificatBtn;
    private CustomButton lettreBtn;
    private CustomButton bioBtn; 
    private CustomButton radioBtn;
    private CustomButton interventionsBtn;
    private CustomButton annexesBtn;
    private CustomButton actesBtn;
    private CustomButton comptabiliteBtn;
    private CustomButton rendezvousBtn;
    
    private JComboBox<Integer> numPatientCmbx;
    private JComboBox<String> nomPatientCmbx;
    private JComboBox<String> prenomPatientCmbx;
    private JComboBox<Integer> jourCmbx;
    private JComboBox<Integer> moisCmbx;
    private JComboBox<Integer> anneeCmbx;
    private JComboBox<Double> honorairesCmbx;
    private JComboBox<String> typeConsultationCmbx;
    
    private JScrollPane textAreaScroll;
    private JScrollPane consultationsTableScroll;
    
    private JTextArea remarquesTxt;
    
    private JTable consultationsTable;
    
    private CustomJTextField clicheTxt;
    private CustomJTextField ageTxt;
    private CustomJTextField titreConsultationTxt;
    private CustomJTextField titrePatientTxt;
    private CustomJTextField etatPatientTxt;
    
    private ArrayList<Patient> allPatients = new ArrayList<Patient>();
    private ArrayList<Consultation> allConsultations = new ArrayList<Consultation>();
    DefaultTableModel consultationModel = new DefaultTableModel();
	
	public ConsultationFrame(int codeP)
	{
		this.codePatient = codeP;
		
		// Customisation de la fenetre
    	this.setTitle("Gestion des patients");
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(new Dimension(1200, 600));
        mainPanel = new JPanel();
        mainPanel.setBackground(new Color(255, 255, 255));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 10));
		this.setLocationRelativeTo(null);
		
		topPanel = new JPanel();
		topTopPanel = new JPanel();
		topCenterPanel = new JPanel();
		topBottomPanel = new JPanel();
		centerPanel = new JPanel();
		centerCenterPanel = new JPanel();
		bottomCenterPanel = new JPanel();
		leftCenterPanel = new JPanel();
		consultationSettingsPanel = new JPanel();
		editBtnPanel = new JPanel();
		leftCenterMainPanel = new JPanel();
		leftCenterPlacePanel = new JPanel();
		
		topPanel.setBackground(new Color(255, 255, 255));
		topTopPanel.setBackground(new Color(255, 255, 255));
		topCenterPanel.setBackground(new Color(255, 255, 255));
		topBottomPanel.setBackground(new Color(255, 255, 255));
		centerPanel.setBackground(new Color(255, 255, 255));
		centerCenterPanel.setBackground(new Color(255, 255, 255));
		bottomCenterPanel.setBackground(new Color(255, 255, 255));
		leftCenterPanel.setBackground(new Color(255, 255, 255));
		consultationSettingsPanel.setBackground(new Color(255, 255, 255));
		editBtnPanel.setBackground(new Color(255, 255, 255));
		leftCenterMainPanel.setBackground(new Color(255, 255, 255));
		leftCenterPlacePanel.setBackground(new Color(255, 255, 255));
		
		mainPanel.setLayout(new BorderLayout(10,10));
		topPanel.setLayout(new BorderLayout());
		centerPanel.setLayout(new BorderLayout(10,10));
		leftCenterMainPanel.setLayout(new BorderLayout());
		
		bottomCenterPanel.setLayout(new FlowLayout());
		centerCenterPanel.setLayout(new GridLayout(7,1,2,2));
		topCenterPanel.setLayout(new GridLayout(2,6,10,5));
		topBottomPanel.setLayout(new GridLayout(1,13,2,0));
		consultationSettingsPanel.setLayout(new GridLayout(1,8,2,2));
		editBtnPanel.setLayout(new GridLayout(1,9,2,2));
		leftCenterPanel.setLayout(new GridLayout(3,1,10,10));
		centerCenterPanel.setMinimumSize(new Dimension(400,400));
		
		leftCenterMainPanel.add(leftCenterPanel,BorderLayout.WEST);
		leftCenterMainPanel.add(leftCenterPlacePanel,BorderLayout.EAST);
		
		mainPanel.add(topPanel,BorderLayout.NORTH);
		mainPanel.add(centerPanel,BorderLayout.CENTER);
		
		topPanel.add(topTopPanel,BorderLayout.NORTH);
		topPanel.add(topCenterPanel,BorderLayout.CENTER);
		topPanel.add(topBottomPanel,BorderLayout.SOUTH);
		
		centerPanel.add(centerCenterPanel,BorderLayout.CENTER);
		centerPanel.add(bottomCenterPanel,BorderLayout.SOUTH);
		centerPanel.add(leftCenterPanel,BorderLayout.WEST);
		
		// Créations des menus
		
		frameMenu = new JMenuBar();
		fichierMenu = new JMenu("Fichier");
		paramMenu = new JMenu("Paramétrage");
		gestionMenu = new JMenu("Gestion");
		consultationMenu = new JMenu("Consultation");
		statistiqueMenu = new JMenu("Statistique");
		editionMenu = new JMenu("Edition");
		fenetreMenu = new JMenu("Fenêtre");
		outilsMenu = new JMenu("Outils");
		aideMenu = new JMenu("?");
		
		frameMenu.add(fichierMenu);
		frameMenu.add(paramMenu);
		frameMenu.add(gestionMenu);
		frameMenu.add(consultationMenu);
		frameMenu.add(statistiqueMenu);
		frameMenu.add(editionMenu);
		frameMenu.add(fenetreMenu);
		frameMenu.add(outilsMenu);
		frameMenu.add(aideMenu);
		
		setJMenuBar(frameMenu);
		
		// Créations des Labels
        titleLbl = new CustomJLabel("Gestion des patients.",new Color(38, 52, 50),new Font("Montserrat", 1, 18));
        numeroPatientLbl = new CustomJLabel("N°",new Color(38, 52, 50),new Font("Montserrat", 0, 12));
    	titrePatientLbl = new CustomJLabel("Titre",new Color(38, 52, 50),new Font("Montserrat", 0, 12));
    	prenomLbl = new CustomJLabel("Prenom",new Color(38, 52, 50),new Font("Montserrat", 0, 12));
    	nomLbl = new CustomJLabel("Nom",new Color(38, 52, 50),new Font("Montserrat", 0, 12));
    	ageLbl = new CustomJLabel("Age",new Color(38, 52, 50),new Font("Montserrat", 0, 12));
    	etatLbl = new CustomJLabel("Etat",new Color(38, 52, 50),new Font("Montserrat", 0, 12));
    	dateLbl = new CustomJLabel("Date",new Color(38, 52, 50),new Font("Montserrat", 0, 12));
    	honorairesLbl = new CustomJLabel("Honoraires",new Color(38, 52, 50),new Font("Montserrat", 0, 12));
    	clicheLbl = new CustomJLabel("Cliche",new Color(38, 52, 50),new Font("Montserrat", 0, 12));
    	titreConsultationLbl = new CustomJLabel("Titre",new Color(38, 52, 50),new Font("Montserrat", 0, 12));
    	typeConsultationLbl = new CustomJLabel("Type",new Color(38, 52, 50),new Font("Montserrat", 0, 12));
        
		// Créations des boutons
    	ajouterConsultationBtn = new CustomButton(new ImageIcon("ConsultationUI\\nvConstBtn.png"));
        cnamBtn = new CustomButton(new ImageIcon("ConsultationUI\\cnamBtn.png"));
        dateEtTitreBtn = new CustomButton(new ImageIcon("ConsultationUI\\dateTitreBtn.png"));
        modeleConsultationBtn = new CustomButton(new ImageIcon("ConsultationUI\\modelConstBtn1.png"));
        assistantConsultationBtn = new CustomButton(new ImageIcon("\\ConsultationUI\\assistantConstBtn1.png"));
        uploadClicheBtn = new CustomButton(new ImageIcon("ConsultationUI\\uploadBtn.png"));
        saveBtn = new CustomButton(new ImageIcon("ConsultationUI\\saveBtn.png"));
    	
        // Création des boutons d'éditions
        italicBtn = new CustomButton(new ImageIcon("ConsultationUI\\italicBtn.png"));
        boldBtn = new CustomButton(new ImageIcon("ConsultationUI\\boldBtn.png"));
        underlinedBtn = new CustomButton(new ImageIcon("ConsultationUI\\underlinedBtn.png"));
        leftAlignBtn = new CustomButton(new ImageIcon("ConsultationUI\\alignLeftBtn.png"));
        centerAlignBtn = new CustomButton(new ImageIcon("ConsultationUI\\alignCenterBtn.png"));
        rightAlignBtn = new CustomButton(new ImageIcon("ConsultationUI\\alignRightBtn.png"));
        undoBtn = new CustomButton(new ImageIcon("ConsultationUI\\undoBtn.png"));
        doBtn = new CustomButton(new ImageIcon("ConsultationUI\\redoBtn.png"));
        colorBtn = new CustomButton(new ImageIcon("ConsultationUI\\colorsBtn.png"));
        
        // Création des boutons/Tabs
        infosBtn = new CustomButton(new ImageIcon("ConsultationUI\\infosBtn.png"));
        antecedantsBtn = new CustomButton(new ImageIcon("ConsultationUI\\antecBtn.png"));
        consultationBtn = new CustomButton(new ImageIcon("ConsultationUI\\consultBtn.png"));
        ordonnanceBtn = new CustomButton(new ImageIcon("ConsultationUI\\ordoBtn.png"));
        certificatBtn = new CustomButton(new ImageIcon("ConsultationUI\\certifsBtn.png"));
        lettreBtn = new CustomButton(new ImageIcon("ConsultationUI\\lettreBtn.png"));
        bioBtn = new CustomButton(new ImageIcon("ConsultationUI\\bioBtn.png"));
        radioBtn = new CustomButton(new ImageIcon("ConsultationUI\\radioBtn.png"));
        interventionsBtn = new CustomButton(new ImageIcon("ConsultationUI\\intervBtn.png"));
        annexesBtn = new CustomButton(new ImageIcon("ConsultationUI\\annexBtn.png"));
        actesBtn = new CustomButton(new ImageIcon("ConsultationUI\\actesBtn.png"));
        comptabiliteBtn = new CustomButton(new ImageIcon("ConsultationUI\\comptaBtn.png"));
        rendezvousBtn = new CustomButton(new ImageIcon("ConsultationUI\\rendezBtn.png"));
        
        // Ajout des Listenser aux boutons
        infosBtn.addActionListener(this);
        antecedantsBtn.addActionListener(this);
        consultationBtn.addActionListener(this);
        ordonnanceBtn.addActionListener(this);
        certificatBtn.addActionListener(this);
        lettreBtn.addActionListener(this);
        bioBtn.addActionListener(this);
        radioBtn.addActionListener(this);
        interventionsBtn.addActionListener(this);
        annexesBtn.addActionListener(this);
        actesBtn.addActionListener(this);
        comptabiliteBtn.addActionListener(this);
        rendezvousBtn.addActionListener(this);
        
		// Ajout des Listeners aux boutons
        ajouterConsultationBtn.addActionListener(this);
        cnamBtn.addActionListener(this);
        dateEtTitreBtn.addActionListener(this);
        modeleConsultationBtn.addActionListener(this);
        assistantConsultationBtn.addActionListener(this);
        uploadClicheBtn.addActionListener(this);
        
        // Ajout des Listeners aux boutons d'éditions
        italicBtn.addActionListener(this);
        boldBtn.addActionListener(this);
        underlinedBtn.addActionListener(this);
        centerAlignBtn.addActionListener(this);
        rightAlignBtn.addActionListener(this);
        leftAlignBtn.addActionListener(this);
        undoBtn.addActionListener(this);
        doBtn.addActionListener(this);
        colorBtn.addActionListener(this);
		
		// Création des comboboxes
        numPatientCmbx = new JComboBox<Integer>();
        nomPatientCmbx = new JComboBox<String>();
        prenomPatientCmbx = new JComboBox<String>();
        jourCmbx = new JComboBox<Integer>();
        moisCmbx = new JComboBox<Integer>();
        anneeCmbx = new JComboBox<Integer>();
        honorairesCmbx = new JComboBox<Double>();
        typeConsultationCmbx = new JComboBox<String>();
		
		// Chargement des comboboxes
        jourCmbx.setModel(new DefaultComboBoxModel<Integer>(remplirDateComboBox(1,31,0)));
    	moisCmbx.setModel(new DefaultComboBoxModel<Integer>(remplirDateComboBox(1,12,0)));
    	anneeCmbx.setModel(new DefaultComboBoxModel<Integer>(remplirDateComboBox(1,122,1899)));
    	typeConsultationCmbx.setModel(new DefaultComboBoxModel<>(new String[] { "Contrôle","Consultation" }));
    	honorairesCmbx.setModel(new DefaultComboBoxModel<>(remplirHonorairesCmbx()));
    	loadPatients();
    	
		// Création des Textfields, JTable et JTextArea
    	remarquesTxt = new JTextArea(20,10);
    	titrePatientTxt = new CustomJTextField(new Color(238, 238, 238), new Font("Montserrat", 0, 14),20);
    	ageTxt = new CustomJTextField(new Color(238, 238, 238), new Font("Montserrat", 0, 14),20);
    	etatPatientTxt = new CustomJTextField(new Color(238, 238, 238), new Font("Montserrat", 0, 14),20);
    	clicheTxt = new CustomJTextField(new Color(238, 238, 238), new Font("Montserrat", 0, 14),20);
    	titreConsultationTxt = new CustomJTextField(new Color(238, 238, 238), new Font("Montserrat", 0, 14),20);
    	consultationsTable = new JTable();
    	
    	// Chargement des consultations du patient
    	loadConsultationsPatient();
    	
    	// Creation des JScrollPane
    	textAreaScroll = new JScrollPane(remarquesTxt);
    	consultationsTableScroll = new JScrollPane(consultationsTable);
    	
    	// Ajout des elements
    	
    	topTopPanel.add(titleLbl);
    	topCenterPanel.add(numeroPatientLbl);
    	topCenterPanel.add(titrePatientLbl);
    	topCenterPanel.add(nomLbl);
    	topCenterPanel.add(prenomLbl);
    	topCenterPanel.add(ageLbl);
    	topCenterPanel.add(etatLbl);
    	
    	topCenterPanel.add(numPatientCmbx);
    	topCenterPanel.add(titrePatientTxt);
    	topCenterPanel.add(nomPatientCmbx);
    	topCenterPanel.add(prenomPatientCmbx);
    	topCenterPanel.add(ageTxt);
    	topCenterPanel.add(etatPatientTxt);
    	
    	topBottomPanel.add(infosBtn);
    	topBottomPanel.add(antecedantsBtn);
    	topBottomPanel.add(consultationBtn);
    	topBottomPanel.add(ordonnanceBtn);
    	topBottomPanel.add(certificatBtn);
    	topBottomPanel.add(lettreBtn);
    	topBottomPanel.add(bioBtn);
    	topBottomPanel.add(radioBtn);
    	topBottomPanel.add(interventionsBtn);
    	topBottomPanel.add(annexesBtn);
    	topBottomPanel.add(comptabiliteBtn);
    	topBottomPanel.add(rendezvousBtn);
    	
    	consultationSettingsPanel.add(dateLbl);
    	consultationSettingsPanel.add(jourCmbx);
    	consultationSettingsPanel.add(moisCmbx);
    	consultationSettingsPanel.add(anneeCmbx);
    	consultationSettingsPanel.add(honorairesLbl);
    	consultationSettingsPanel.add(honorairesCmbx);
    	consultationSettingsPanel.add(cnamBtn);
    	consultationSettingsPanel.add(clicheLbl);
    	consultationSettingsPanel.add(clicheTxt);
    	consultationSettingsPanel.add(uploadClicheBtn);
    	
    	editBtnPanel.add(italicBtn);
    	editBtnPanel.add(boldBtn);
    	editBtnPanel.add(underlinedBtn);
    	editBtnPanel.add(centerAlignBtn);
    	editBtnPanel.add(rightAlignBtn);
    	editBtnPanel.add(leftAlignBtn);
    	editBtnPanel.add(undoBtn);
    	editBtnPanel.add(doBtn);
    	editBtnPanel.add(colorBtn);
        
		centerCenterPanel.add(consultationSettingsPanel);
		centerCenterPanel.add(titreConsultationLbl);
		centerCenterPanel.add(titreConsultationTxt);
		centerCenterPanel.add(typeConsultationLbl);
		centerCenterPanel.add(typeConsultationCmbx);
		centerCenterPanel.add(editBtnPanel);
		centerCenterPanel.add(textAreaScroll);
		
		bottomCenterPanel.add(modeleConsultationBtn);
		bottomCenterPanel.add(assistantConsultationBtn);
		bottomCenterPanel.add(saveBtn);
		
		leftCenterPanel.add(ajouterConsultationBtn);
		leftCenterPanel.add(consultationsTableScroll);
		leftCenterPanel.add(dateEtTitreBtn);
		
		this.getContentPane().add(mainPanel);
		
		this.setVisible(true);
	}
	
	private void loadConsultationsPatient()
	{
		consultationModel.addColumn("Dates Consultations");
		consultationModel.addColumn("Type Consultations");
		
		ConsultationDAO cDAO = new ConsultationDAO();
		allConsultations = cDAO.getAllPatientConsultation(codePatient);
		
		consultationsTable.setModel(consultationModel);
		
		for (Consultation consultation : allConsultations) {
			consultationModel.addRow(new Object[] {consultation.getDateC(), consultation.getTypeC()});
		}
	}
	
	private void loadPatients()
	{
		PatientDAO pDAO = new PatientDAO();
		
		allPatients = pDAO.getAllPatients();
		DefaultComboBoxModel numPatientsModel = new DefaultComboBoxModel();
		DefaultComboBoxModel nomPatientsModel = new DefaultComboBoxModel();
		DefaultComboBoxModel prenomPatientsModel = new DefaultComboBoxModel();
		
		numPatientCmbx.setModel(numPatientsModel);
        nomPatientCmbx.setModel(nomPatientsModel);
        prenomPatientCmbx.setModel(prenomPatientsModel);
		
		for (Patient patient : allPatients) {
			numPatientsModel.addElement(patient.getNip());
			nomPatientsModel.addElement(patient.getNom());
			prenomPatientsModel.addElement(patient.getPrenom());
		}
	}
	
	private Double[] remplirHonorairesCmbx()
	{
		Double[] values = new Double[994];
		
		for(int i = 0; i < 994; i++)
		{
			values[i] = i * 1000.0;
		}
		return values;
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
    
    private void ajouterConsultation()
    {
    	String typeC =  typeConsultationCmbx.getSelectedItem().toString();
    	String remarques = remarquesTxt.getText();
    	Double honoraires = Double.parseDouble(honorairesCmbx.getSelectedItem().toString());
    	String titre = titreConsultationTxt.getText();
    	
    	int dayNumber = Integer.parseInt(jourCmbx.getSelectedItem().toString());
    	int monthNumber = Integer.parseInt(moisCmbx.getSelectedItem().toString());
    	int anneeNumber = Integer.parseInt(anneeCmbx.getSelectedItem().toString());
    	
    	Date dateConsultation = new Date(anneeNumber - 1900, monthNumber - 1 , dayNumber);
    	
    	ConsultationDAO cDAO = new ConsultationDAO();
    	Consultation c= new Consultation(codePatient,typeC,remarques, honoraires, titre, dateConsultation);
    	
    	codeConsultation = cDAO.ajouter(c);
    	consultationModel.addRow(new Object[] {c.getDateC(), c.getTypeC()});
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == ajouterConsultationBtn)
		{
			ajouterConsultation();
		}
		if(e.getSource() == ordonnanceBtn)
		{
			new OrdonnanceFrame(codeConsultation);
		}
		if(e.getSource() == infosBtn)
		{
			new ModifierFichePatientFrame(codePatient);
		}
		
	}

}
