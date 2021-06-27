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

public class DashboardFrame  extends JFrame implements ActionListener,MouseListener{

	private Utilisateur user;
	
	private int selectedCodePatient;
	
	private JPanel mainPanel;
	
	private CustomJLabel titleLbl;
	
	private CustomButton ajouterFichePatientBtn;
	private CustomButton ajouterConsultationBtn;
	
	private JTable patientsTable;
	
	private JScrollPane patientsTableScroll;
	
	private ArrayList<Patient> allPatients = new ArrayList<Patient>();
	DefaultTableModel patientModel = new DefaultTableModel();
	
	public DashboardFrame(Utilisateur user)
	{
		this.user = user;
		
		// Customisation de la fenetre
    	this.setTitle("Dashboard");
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(new Dimension(500, 600));
        mainPanel = new JPanel();
        mainPanel.setBackground(new Color(255, 255, 255));
        this.setLocationRelativeTo(null);
        
        // Créations des Labels
        titleLbl = new CustomJLabel("Bienvenue " + user.getTypeUser() + " " + user.getUsername(),new Color(38, 52, 50),new Font("Montserrat", 1, 18));
        
        // Creation des boutons
        ajouterFichePatientBtn = new CustomButton(new ImageIcon("C:\\Dev\\JavaProjects\\ProjetTPUI\\DashboardUI\\fichePatientBtn.png"));
        ajouterConsultationBtn = new CustomButton(new ImageIcon("C:\\Dev\\JavaProjects\\ProjetTPUI\\DashboardUI\\consultationBtn.png"));
        
        // Ajout des Listenser aux boutons
        ajouterFichePatientBtn.addActionListener(this);
        ajouterConsultationBtn.addActionListener(this);
        
        patientsTable = new JTable();
        
        patientsTable.addMouseListener(this);
        
        patientsTableScroll = new JScrollPane(patientsTable);
        patientsTable.setModel(patientModel);
        patientModel.addColumn("Code");
        patientModel.addColumn("NIP");
        patientModel.addColumn("Nom de Famille");
        patientModel.addColumn("Prénom");
        loadPatients();
        
        mainPanel.add(titleLbl);
        
        mainPanel.add(patientsTableScroll);
        
        mainPanel.add(ajouterFichePatientBtn);
        mainPanel.add(ajouterConsultationBtn);
        
        this.getContentPane().add(mainPanel);
        
        
        this.setVisible(true);
	}
	
	private void loadPatients()
	{
		PatientDAO pDAO = new PatientDAO();
		allPatients = pDAO.getAllPatients();
		
		for (Patient patient : allPatients) {
			patientModel.addRow(new Object[] {patient.getCode(),patient.getNip(), patient.getNom(), patient.getPrenom()});
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		
		if(o == ajouterFichePatientBtn)
		{
			new FichePatientFrame();
		}
		if(o == ajouterConsultationBtn)
		{
			new ConsultationFrame(selectedCodePatient);
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == patientsTable)
		{
			int selectedItem = patientsTable.getSelectedRow();
			selectedCodePatient = Integer.parseInt(patientsTable.getValueAt(selectedItem, 0).toString());
			System.out.println(selectedCodePatient);
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
