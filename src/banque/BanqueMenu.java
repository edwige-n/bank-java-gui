package banque;
/**
 * @author Edwige
 * 
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;  


public class BanqueMenu extends JFrame {
	/**
	 * la classe qui contient le menu interractif
	 */
	
	private JButton voirSolde 				= new JButton("Voir mon solde"); 
	private JButton faireVersement 			= new JButton("Faire un versement");
	private JButton faireRetrait			= new JButton("Faire un retrait");
	private static JButton validerVersement = new JButton("Valider le versement"); 
	private static JButton validerRetrait	= new JButton("Valider le retrait"); 
	private JLabel label					= new JLabel("Mon texte");
	private JTextField textfield			= new JTextField(20); 
	private JPanel textPanel 				= new JPanel(); 
	private JPanel boutonsPanel				= new JPanel(); 
	private JPanel versementsPanel 	    	= new JPanel(); 
	private JPanel retraitsPanel			= new JPanel(); 
	private double montant; 
/**
 * La fenetre 
 */
	public BanqueMenu(){
		
		this.setTitle("Banque"); 
		this.setSize(600, 700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setLayout(new GridLayout(6,1)); 
		this.getContentPane().add(textPanel); 
		label.setFont(label.getFont().deriveFont(20.0F));
		label.setForeground(Color.black); 
		label.setText("Bonjour " + CompteBancaire.getNomClient() + '\n' + ", bienvenue sur votre compte !");
		textPanel.add(label, BorderLayout.CENTER); 
		this.getContentPane().add(versementsPanel);
		this.getContentPane().add(retraitsPanel); 
		this.getContentPane().add(voirSolde); 
		this.getContentPane().add(faireVersement); 
	    this.getContentPane().add(faireRetrait);
		voirSolde.addActionListener(new AfficherSolde()); 
		faireVersement.addActionListener(new FaireUnVersement()); 
		faireRetrait.addActionListener(new FaireUnRetrait()); 
		this.setVisible(true);
	}
	
	public class AfficherSolde implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			label.setText("Voici votre solde : " + CompteBancaire.getSolde()); 
			versementsPanel.setVisible(false);
			retraitsPanel.setVisible(false);
		}
	}
	public class FaireUnVersement implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			retraitsPanel.setVisible(false);
			versementsPanel.setVisible(true);
			versementsPanel.add(textfield); 
			label.setText("Veuillez saisir le montant du versement : "); 
			versementsPanel.add(validerVersement); 
			validerVersement.addActionListener(new validerVersement());
		}
		
	}
	public class validerVersement implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String a = textfield.getText(); 
			try {
			montant = Double.parseDouble(a); 
			}
			catch (NumberFormatException exception) {
				System.out.println("Caster une chaine de caractère en type Double");
			}
			CompteBancaire.versements(montant); 
		}
		
	}
	public class FaireUnRetrait implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			versementsPanel.setVisible(false);
			retraitsPanel.setVisible(true);
			label.setText("Veuillez saisir le montant que vous souhaitez retirer :");
			retraitsPanel.add(textfield); 
			retraitsPanel.add(validerRetrait);
		    validerRetrait.addActionListener(new ValiderRetrait());
		}
		
	}
	public class ValiderRetrait implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String a = textfield.getText(); 
			try {
			montant = Double.parseDouble(a); 
			}
			catch (NumberFormatException exception) {
				System.out.println("Caster une chaine de caractère en type Double");
			}
			CompteBancaire.retrait(montant); 
		}
	}

}
