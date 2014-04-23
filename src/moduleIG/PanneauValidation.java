package moduleIG;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanneauValidation {

	private JPanel panneau=new JPanel();
	private ConfigData donnees;
	private FenetreConfig fenetreConfig;
	
	public PanneauValidation(ConfigData donnees, FenetreConfig fenetreConfig){
		this.donnees=donnees;
		this.fenetreConfig=fenetreConfig;
		this.getReady();
	}
	
	private void getReady() {
		panneau.setLayout(new FlowLayout());
		JButton valider = new JButton("OK");
		valider.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				fenetreConfig.traiterDonnees(donnees);
			}
		});
		valider.setBackground(Color.green);
		panneau.add(valider);
		JButton annuler = new JButton("Annuler");
		annuler.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				fenetreConfig.getFenetre().setVisible(false);
			}
		});
		
		annuler.setBackground(Color.red);
		panneau.add(annuler);
	}

	public JPanel getPanneau() {
		return this.panneau;
	}
}
