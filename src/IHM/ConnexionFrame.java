package IHM;

import javax.swing.*;

import CustomUI.*;
import DAO.*;
import OO.Utilisateur;

import java.awt.*;
import java.awt.event.*;

public class ConnexionFrame extends JFrame implements ActionListener{
	
	// Declaration des elements de l'interface
	
    private CustomAuthButton creerCompteBtn;
    private CustomButton connexionBtn;
    private CustomJLabel titleLbl;
    private JLabel imgLbl;
    private CustomJLabel usernameLbl;
    private CustomJLabel passwordLbl;
    private JPanel mainPanel;
    private JPanel leftPanel;
    private JPanel rightPanel;
    private CustomJTextField passwordTxt;
    private CustomJTextField usernameTxt;
    
    public ConnexionFrame()
    {
    	// Customisation de la fenetre
    	this.setTitle("Connexion");
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(new Dimension(690, 330));
        mainPanel = new JPanel();
        mainPanel.setBackground(new Color(255, 255, 255));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 40, 10, 10));
        this.setLocationRelativeTo(null);
        
        leftPanel = new JPanel();
        rightPanel = new JPanel();
        leftPanel.setBackground(new Color(255, 255, 255));
        rightPanel.setBackground(new Color(255, 255, 255));
        
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(leftPanel,BorderLayout.WEST);
        mainPanel.add(rightPanel,BorderLayout.EAST);
        
        leftPanel.setLayout(new GridLayout(6,1,10,10));
        
        // Creation des labels
        titleLbl = new CustomJLabel("Authentification.",new Color(38, 52, 50),new Font("Montserrat", 1, 18));
        usernameLbl = new CustomJLabel("Nom d'utilisateur",new Color(38, 52, 50),new Font("Montserrat", 0, 14));
        passwordLbl = new CustomJLabel("Mot de passe",new Color(38, 52, 50),new Font("Montserrat", 0, 14));
        
        // Creation des TextFields
        usernameTxt = new CustomJTextField(new Color(238, 238, 238), new Font("Montserrat", 0, 14),20);
        passwordTxt = new CustomJTextField(new Color(238, 238, 238), new Font("Montserrat", 0, 14),20);
        
        // Creation des boutons
        creerCompteBtn = new CustomAuthButton("Vous n'avez pas de compte? Créer.",new Font("Montserrat", 0, 14),new Color(25, 130, 196));
        connexionBtn = new CustomButton(new ImageIcon("AuthUI\\connexionBtn.png"));
        
        // Ajout du ActionListener aux boutons
        creerCompteBtn.addActionListener(this);
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
        leftPanel.add(connexionBtn);
        leftPanel.add(creerCompteBtn);
        rightPanel.add(imgLbl);
        
        // Ajout du panel dans le JFrame
        this.getContentPane().add(mainPanel);
        this.setVisible(true);
    }
    
    public void authenticate()
    {
    	AuthenticationController authController = new AuthenticationController();
    	
    	String username = usernameTxt.getText();
    	String password = passwordTxt.getText();
    	
    	Utilisateur user = new Utilisateur(username,password);
    	
    	boolean authSuccess = authController.loginUser(user);
    	if(authSuccess)
    	{
    		this.setVisible(false);
    	}
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		
		if(o == creerCompteBtn)
		{
			this.setVisible(false);
			new InscriptionFrame();
		}
		if(o == connexionBtn)
		{
			// Check for user inputs
			System.out.println("Connexion ...");
			authenticate();
		}
	}

}
