package moduleIG;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanneauValidation {

	private JPanel panneau;
	private ConfigData donnees;
	private FenetreZac fenetrePrinc;
	private FenetreConfig fenetreConfig;
	
	public PanneauValidation(FenetreZac fenetrePrinc, ConfigData donnees, FenetreConfig fenetreConfig){
		this.fenetrePrinc=fenetrePrinc;
		this.donnees=donnees;
		this.fenetreConfig=fenetreConfig;
		this.getReady();
	}
	
	private void getReady() {
		panneau.setLayout(new FlowLayout());
		JButton valider = new JButton("OK");
		valider.addMouseListener(new MouseAdapter(){
			public void MouseClicked(MouseEvent e){
				fenetrePrinc.traiterDonnees(donnes);
				fenetreConfig.getFenetre().setVisible(false);
			}
		});
		valider.setBackground(Color.green);
		panneau.add(valider);
		JButton annuler = new JButton("Annuler");
		annuler.addMouseListener(new MouseAdapter(){
			public void MouseClicked(MouseEvent e){
				fenetreConfig.getFenetre().setVisible(false);
			}
		});
		panneau.add(annuler);
		annuler.setBackground(Color.red);
	}

	public JPanel getPanneau() {
		return this.panneau;
	}
}
