package IHM;
import javax.swing.*;

import CustomUI.*;
import DAO.*;
import OO.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.Date;
import java.util.ArrayList;

public class OrdonnanceFrame extends JFrame implements ActionListener,MouseListener{
	
	private int codeConsultation;
	
	private CustomButton rechercherMedBtn;
	private CustomButton ajouterMedBtn;
	private CustomButton modifierMedBtn;
	private CustomButton supprimerMedBtn;
	private CustomButton ajouterLigneBtn;
	private CustomButton modifierLigneBtn;
	private CustomButton sautLigneBtn;
	private CustomButton creerOrdoBtn;
	private CustomButton effacerBtn;
	private CustomButton annulerBtn;
    private CustomButton ordoMemoBtn;
    private JCheckBox ordoADLCheck;
    private JCheckBox duplicataCheck;
    private JCheckBox triplicataCheck;
    private JComboBox<Integer> nbPrisesCmbx;
    private JComboBox<Integer> nbBoitesCmbx;
    private CustomJLabel titleLbl;
    private CustomJLabel rechercheLbl;
    private CustomJLabel medicamentsLbl;
    private CustomJLabel medicamentChoisiLbl;
    private CustomJLabel posologieLbl;
    private CustomJLabel nbPrisesLbl;
    private CustomJLabel nbBoitesLbl;
    private JList<String> medicamentList;
    private JList<String> ligneOrdoList;
    private JPanel mainPanel;
    private JPanel medListPanel;
    private JPanel topPanel;
    private JPanel topCenterPanel;
    private JPanel bottomPanel;
    private JPanel bottomLeftPanel;
    private JPanel bottomRightPanel;
    private JPanel bottomBottomPanel;
    private JPanel bottomCenterPanel;
    private JScrollPane scrollPaneMedicament;
    private JScrollPane scrollPaneLigneOrdo;
    private CustomJTextField searchTxt;
    private CustomJTextField medicamentTxt;
    private CustomJTextField posologieTxt;
    
    int codeOrdonnance = 0;
    
    ArrayList<Medicament> allMedicaments = new ArrayList<Medicament>();
    ArrayList<LigneOrdonnance> allLignes = new ArrayList<LigneOrdonnance>();
    
    private DefaultListModel<String> medicamentModel = new DefaultListModel<String>();
    private DefaultListModel<String> ligneOrdoModel = new DefaultListModel<String>();
    
    public OrdonnanceFrame(int codeConsultation)
    {
    	this.codeConsultation = codeConsultation;
    	
    	// Customisation de la fenetre
    	this.setTitle("Ordonnance");
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(new Dimension(664, 720));
        mainPanel = new JPanel();
        mainPanel.setBackground(new Color(255, 255, 255));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 10, 10));
        this.setLocationRelativeTo(null);
        
        topPanel = new JPanel();
        topCenterPanel = new JPanel();
        bottomPanel = new JPanel();
        bottomLeftPanel = new JPanel();
        bottomRightPanel = new JPanel();
        bottomBottomPanel = new JPanel();
        bottomCenterPanel = new JPanel();
        medListPanel = new JPanel();
        
        medListPanel.setBackground(new Color(255, 255, 255));
        topPanel.setBackground(new Color(255, 255, 255));
        topCenterPanel.setBackground(new Color(255, 255, 255));
        bottomPanel.setBackground(new Color(255, 255, 255));
        bottomLeftPanel.setBackground(new Color(255, 255, 255));
        bottomRightPanel.setBackground(new Color(255, 255, 255));
        bottomBottomPanel.setBackground(new Color(255, 255, 255));
        bottomCenterPanel.setBackground(new Color(255, 255, 255));
        
        topPanel.setLayout(new GridLayout(10,1));
        mainPanel.setLayout(new BorderLayout());
        topCenterPanel.setLayout(new FlowLayout());
        bottomPanel.setLayout(new BorderLayout());
        bottomBottomPanel.setLayout(new FlowLayout());
        bottomLeftPanel.setLayout(new GridLayout(6,1));
        bottomCenterPanel.setLayout(new GridLayout(1,1));
        bottomRightPanel.setLayout(new GridLayout(4,1,30,30));

        mainPanel.add(topPanel,BorderLayout.CENTER);
        mainPanel.add(bottomPanel,BorderLayout.SOUTH);
        
        bottomPanel.add(bottomLeftPanel,BorderLayout.WEST);
        bottomPanel.add(bottomCenterPanel,BorderLayout.CENTER);
        bottomPanel.add(bottomRightPanel,BorderLayout.EAST);
        bottomPanel.add(bottomBottomPanel,BorderLayout.SOUTH);
        
        // Creation des labels
        titleLbl = new CustomJLabel("Créer une ordonnance.",new Color(38, 52, 50),new Font("Montserrat", 1, 18));
        rechercheLbl = new CustomJLabel("Recherche rapide.",new Color(38, 52, 50),new Font("Montserrat", 0, 12));
        medicamentsLbl = new CustomJLabel("Médicaments.",new Color(38, 52, 50),new Font("Montserrat", 0, 12));
        medicamentChoisiLbl = new CustomJLabel("Médicament choisi.",new Color(38, 52, 50),new Font("Montserrat", 0, 12));
        posologieLbl = new CustomJLabel("Posologie.",new Color(38, 52, 50),new Font("Montserrat", 0, 12));
        nbPrisesLbl = new CustomJLabel("Nb prises par jour.",new Color(38, 52, 50),new Font("Montserrat", 0, 12));
        nbBoitesLbl = new CustomJLabel("Nb boites.",new Color(38, 52, 50),new Font("Montserrat", 0, 12));
        
        // Creation des TextFields
        searchTxt = new CustomJTextField(new Color(238, 238, 238), new Font("Montserrat", 0, 14),20);
        medicamentTxt = new CustomJTextField(new Color(238, 238, 238), new Font("Montserrat", 0, 14),20);
        posologieTxt = new CustomJTextField(new Color(238, 238, 238), new Font("Montserrat", 0, 14),20);
        
        // Creation des boutons
        rechercherMedBtn = new CustomButton(new ImageIcon("OrdonnanceUI\\rechercherMedBtn.png"));
        ajouterMedBtn = new CustomButton(new ImageIcon("OrdonnanceUI\\ajouteerMedBtn.png"));
        modifierMedBtn = new CustomButton(new ImageIcon("OrdonnanceUI\\modifierMedBtn.png"));
        supprimerMedBtn = new CustomButton(new ImageIcon("OrdonnanceUI\\supprimerMedBtn.png"));
        ajouterLigneBtn = new CustomButton(new ImageIcon("OrdonnanceUI\\ajouterBtn2.png"));
        modifierLigneBtn = new CustomButton(new ImageIcon("OrdonnanceUI\\modifierBtn2.png"));
        sautLigneBtn = new CustomButton(new ImageIcon("OrdonnanceUI\\sautLigneBtn.png"));
        creerOrdoBtn = new CustomButton(new ImageIcon("OrdonnanceUI\\creerOrdoBtn.png"));
        effacerBtn = new CustomButton(new ImageIcon("OrdonnanceUI\\toutEffBtn.png"));
        annulerBtn = new CustomButton(new ImageIcon("OtherUI\\annulerBtn.png"));
        ordoMemoBtn = new CustomButton(new ImageIcon("OrdonnanceUI\\ordoMemoBtn.png"));
        
        // Ajout du ActionListener aux boutons
        rechercherMedBtn.addActionListener(this);
        ajouterMedBtn.addActionListener(this);
        modifierMedBtn.addActionListener(this);
        supprimerMedBtn.addActionListener(this);
        ajouterLigneBtn.addActionListener(this);
        modifierLigneBtn.addActionListener(this);
        sautLigneBtn.addActionListener(this);
        creerOrdoBtn.addActionListener(this);
        effacerBtn.addActionListener(this);
        annulerBtn.addActionListener(this);
        ordoMemoBtn.addActionListener(this);
        
        // Creation des Listes
        medicamentList = new JList<>();
        ligneOrdoList = new JList<>();
        
        // Ajout des Listeners aux listes
        medicamentList.addMouseListener(this);
        ligneOrdoList.addMouseListener(this);
        
        // Creation des ScrollPane
        scrollPaneMedicament = new JScrollPane(medicamentList);
        scrollPaneLigneOrdo = new JScrollPane(ligneOrdoList);
        
        // Chargement des Listes
        medicamentList.setModel(medicamentModel);
        ligneOrdoList.setModel(ligneOrdoModel);
        
        // Creation des combobox
        nbPrisesCmbx = new JComboBox<>();
        nbBoitesCmbx = new JComboBox<>();
        
        // Chargement des combobox
        nbPrisesCmbx.setModel(new DefaultComboBoxModel<>(remplirPrisesCmbx(20)));
        nbBoitesCmbx.setModel(new DefaultComboBoxModel<>(remplirPrisesCmbx(20)));
        
        // Creation des checkbox
        ordoADLCheck = new JCheckBox("Ordonnance ADL");
        duplicataCheck = new JCheckBox("Imprimer Duplicata");
        triplicataCheck = new JCheckBox("Imprimer Triplicata");
        
        loadMedicaments();
        
        // Ajout des elements dans le panel
        topPanel.add(titleLbl);
        topPanel.add(rechercheLbl);
        topPanel.add(searchTxt);
        topPanel.add(medicamentsLbl);
        topPanel.add(scrollPaneMedicament);
        topCenterPanel.add(ajouterMedBtn);
        topCenterPanel.add(modifierMedBtn);
        topCenterPanel.add(supprimerMedBtn);
        topPanel.add(topCenterPanel);
        topPanel.add(medicamentChoisiLbl);
        topPanel.add(medicamentTxt);
        topPanel.add(posologieLbl);
        topPanel.add(posologieTxt);
        bottomLeftPanel.add(ajouterLigneBtn);
        bottomLeftPanel.add(modifierLigneBtn);
        bottomLeftPanel.add(sautLigneBtn);
        bottomLeftPanel.add(ordoADLCheck);
        bottomLeftPanel.add(duplicataCheck);
        bottomLeftPanel.add(triplicataCheck);
        bottomCenterPanel.add(scrollPaneLigneOrdo);
        bottomRightPanel.add(nbPrisesLbl);
        bottomRightPanel.add(nbPrisesCmbx);
        bottomRightPanel.add(nbBoitesLbl);
        bottomRightPanel.add(nbBoitesCmbx);
        
        bottomBottomPanel.add(creerOrdoBtn);
        bottomBottomPanel.add(effacerBtn);
        bottomBottomPanel.add(annulerBtn);
        bottomBottomPanel.add(ordoMemoBtn);
        
        // Ajout du panel dans le JFrame
        
        this.getContentPane().add(mainPanel);
        this.setVisible(true);
    }
    
    public void loadMedicaments()
    {
    	MedicamentDAO mDAO = new MedicamentDAO();
    	allMedicaments = mDAO.getAllMedicaments();
    	for (Medicament medicament : allMedicaments) {
    		medicamentModel.addElement(medicament.getNom());
		}
    }
    
    private Integer[] remplirPrisesCmbx(int taille)
    {
    	Integer[] values = new Integer[taille];
    	
    	for(int i = 0; i < taille; i++)
    	{
    		values[i] = i + 1;
    	}
    	return values;
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		
		if(o == ajouterMedBtn)
		{
			Medicament m = new Medicament(medicamentTxt.getText());
			medicamentModel.addElement(medicamentTxt.getText());
			MedicamentDAO mDAO = new MedicamentDAO();
			mDAO.ajouter(m);
		}
		if(o == supprimerMedBtn)
		{
			MedicamentDAO mDAO = new MedicamentDAO();
			String selectedItem = medicamentList.getSelectedValue().toString();
			int selectedIndex = medicamentList.getSelectedIndex();
			Medicament m = mDAO.rechercherParNom(selectedItem);
			mDAO.supprimer(m);
			medicamentModel.removeElementAt(selectedIndex);
			medicamentTxt.setText("");
			
		}
		if(o == modifierMedBtn)
		{
			MedicamentDAO mDAO = new MedicamentDAO();
			
			String selectedItem = medicamentList.getSelectedValue().toString();
			Medicament m = mDAO.rechercherParNom(selectedItem);
			int selectedIndex = medicamentList.getSelectedIndex();
			medicamentModel.setElementAt(medicamentTxt.getText(),selectedIndex);
			m.setNom(medicamentTxt.getText());
			mDAO.modifier(m);
		}
		
		if(o == ajouterLigneBtn)
		{
			int nbPrises = Integer.parseInt(nbPrisesCmbx.getSelectedItem().toString());
			int nbBoites = Integer.parseInt(nbBoitesCmbx.getSelectedItem().toString());
			String posologie = posologieTxt.getText();
			
	    	String selectedItem = medicamentTxt.getText();
	    	
			MedicamentDAO mDAO = new MedicamentDAO();
			Medicament m = mDAO.rechercherParNom(selectedItem);
			
			LigneOrdonnance ligneOrdo = new LigneOrdonnance(m.getCode(),nbPrises,nbBoites,posologie);
			allLignes.add(ligneOrdo);
			ligneOrdoModel.addElement(medicamentTxt.getText() + " " + nbBoites + " Boite(s)");
		}
		if(o == modifierLigneBtn)
		{
			int selectedIndex = medicamentList.getSelectedIndex();
			int nbPrises = Integer.parseInt(nbPrisesCmbx.getSelectedItem().toString());
			int nbBoites = Integer.parseInt(nbBoitesCmbx.getSelectedItem().toString());
			String posologie = posologieTxt.getText();
			
	    	String selectedItem = medicamentTxt.getText();
	    	
			MedicamentDAO mDAO = new MedicamentDAO();
			Medicament m = mDAO.rechercherParNom(selectedItem);
			
			LigneOrdonnance ligneOrdo = new LigneOrdonnance(m.getCode(),nbPrises,nbBoites,posologie);
			allLignes.set(selectedIndex,ligneOrdo);
			ligneOrdoModel.setElementAt(medicamentTxt.getText() + " " + nbBoites + " Boite(s)",selectedIndex);
		}
		if(o == creerOrdoBtn)
		{
	        OrdonnanceDAO oDAO = new OrdonnanceDAO();
	        Ordonnance ordonnance = new Ordonnance(codeConsultation,"OrdonnanceTest");
	        codeOrdonnance = oDAO.ajouter(ordonnance);
	        
	        LigneOrdonnanceDAO lDAO = new LigneOrdonnanceDAO();
	        
	        for (LigneOrdonnance ligneOrdonnance : allLignes) {
	        	ligneOrdonnance.setCodeO(codeOrdonnance);
	        	lDAO.ajouter(ligneOrdonnance);
			}
		}
		if(o == effacerBtn)
		{
			allLignes.clear();
			medicamentTxt.setText("");
			posologieTxt.setText("");
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == medicamentList)
		{
			String selectedItem = medicamentList.getSelectedValue().toString();
			medicamentTxt.setText(selectedItem);
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
