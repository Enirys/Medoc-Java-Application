package IHM;

import javax.swing.*;

import CustomUI.*;
import DAO.*;
import OO.*;

import java.awt.*;
import java.awt.event.*;

public class InscriptionFrame extends JFrame implements ActionListener{
	
    private CustomAuthButton connexionBtn;
    private CustomButton creerBtn;
    private JComboBox<String> userType;
    private JComboBox<String> specialite;
    private CustomJLabel usernameLbl;
    private CustomJLabel passwordLbl;
    private CustomJLabel titleLbl;
    private JLabel imgLbl;
    private JPanel mainPanel;
    private JPanel leftPanel;
    private JPanel rightPanel;
    private CustomJTextField passwordTxt;
    private CustomJTextField usernameTxt;
    
    private String[] userTypeStrings = {"Type d'utilisateur", "Secrétaire", "Médecin"};
    private String[] specialiteStrings = {"Spécialité", "Chirurgie", "Psychiatrie", "Pédiatrie"};
    
    public InscriptionFrame()
    {
    	// Customisation de la fenetre
    	this.setTitle("Inscription");
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(new Dimension(690, 400));
        mainPanel = new JPanel();
        mainPanel.setBackground(new Color(255, 255, 255));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(40, 20, 10, 40));
        this.setLocationRelativeTo(null);
        
        leftPanel = new JPanel();
        rightPanel = new JPanel();
        leftPanel.setBackground(new Color(255, 255, 255));
        rightPanel.setBackground(new Color(255, 255, 255));
        
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(leftPanel,BorderLayout.WEST);
        mainPanel.add(rightPanel,BorderLayout.EAST);
        
        leftPanel.setLayout(new GridLayout(10,1,10,10));
        
        // Creation des labels
        titleLbl = new CustomJLabel("Création de compte.",new Color(38, 52, 50),new Font("Montserrat", 1, 18));
        usernameLbl = new CustomJLabel("Nom d'utilisateur",new Color(38, 52, 50),new Font("Montserrat", 0, 14));
        passwordLbl = new CustomJLabel("Mot de passe",new Color(38, 52, 50),new Font("Montserrat", 0, 14));
        
        // Creation des TextFields
        usernameTxt = new CustomJTextField(new Color(238, 238, 238), new Font("Montserrat", 0, 14),20);
        passwordTxt = new CustomJTextField(new Color(238, 238, 238), new Font("Montserrat", 0, 14),20);
        
        // Creation des boutons
        connexionBtn = new CustomAuthButton("Vous avez deja un compte? Connexion.",new Font("Montserrat", 0, 14),new Color(25, 130, 196));
        creerBtn = new CustomButton(new ImageIcon("AuthUI\\creerBtn.png"));
        
        // Creation des combobox
        userType = new JComboBox<>();
        specialite = new JComboBox<>();
        
        // Chargement et customisation des ComboBox
        userType.setFont(new Font("Montserrat", 0, 12));
        specialite.setFont(new Font("Montserrat", 0, 12));
        
        userType.setModel(new DefaultComboBoxModel<>(userTypeStrings));
        specialite.setModel(new DefaultComboBoxModel<>(specialiteStrings));
        
        // Ajout du ActionListener aux boutons
        creerBtn.addActionListener(this);
        connexionBtn.addActionListener(this);
        
        // Creation de l'illustration
        imgLbl = new JLabel();
        imgLbl.setIcon(new ImageIcon("AuthUI\\authImg.png"));
        
        // Ajout des elements dans le panel
        mainPanel.add(titleLbl,BorderLayout.NORTH);
        leftPanel.add(usernameLbl);
        leftPanel.add(usernameTxt);
        leftPanel.add(passwordLbl);
        leftPanel.add(passwordTxt);
        
        leftPanel.add(userType);
        leftPanel.add(specialite);
        
        leftPanel.add(creerBtn);
        leftPanel.add(connexionBtn);
        rightPanel.add(imgLbl);
        
        // Ajout du panel dans le JFrame
        this.getContentPane().add(mainPanel);
        
        this.setVisible(true);
    }
    
    public void inscription()
    {
    	String username = usernameTxt.getText();
    	String password = passwordTxt.getText();
    	
    	String typeUser = userType.getSelectedItem().toString();
    	
    	if(typeUser.equals("Médecin"))
    	{
    		String specialiteMed = specialite.getSelectedItem().toString();
    	}
    	
    	AuthenticationController authController = new AuthenticationController();
    	
    	Utilisateur user = new Utilisateur(username,password,typeUser);
    	authController.registerUser(user);
    	
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
				
		if(o == connexionBtn)
		{
			this.setVisible(false);
			new ConnexionFrame();
		}
		if(o == creerBtn)
		{
			// Check for user inputs
			System.out.println("Inscription ...");
			inscription();
		}
		
	}

}
