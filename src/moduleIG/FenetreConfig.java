package moduleIG;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class FenetreConfig {

	private JFrame fenetre = new JFrame("Configurations");
	private FenetreZac fenetrePrinc ;
	private JPanel panneauPrinc = (JPanel) this.fenetre.getContentPane();
	private ConfigData donnees = new ConfigData();
	
	public void show(){
		this.fenetre.pack();
		this.fenetre.setLocationRelativeTo(null);
		this.fenetre.setVisible(true);
	}

	public FenetreConfig(FenetreZac fenetrePrinc){
		this.fenetrePrinc=fenetrePrinc;
	}
	public void getReady() {
		panneauPrinc.setLayout(new GridLayout(3,2,1, 1));
		PanneauDecor decor = new PanneauDecor(donnees);
		PanneauRaquette raquette = new PanneauRaquette(donnees);
		PanneauDifficulte difficulte = new PanneauDifficulte(donnees);
		PanneauValidation validation = new PanneauValidation(fenetrePrinc, donnees, this);
		panneauPrinc.add(decor.getPanneau());
		panneauPrinc.add(raquette.getPanneau());
		panneauPrinc.add(difficulte.getPanneau());
		panneauPrinc.add(decor.getPanneauImage());
		panneauPrinc.add(raquette.getPanneauImage());
		panneauPrinc.add(validation.getPanneau());
	}

	public JFrame getFenetre(){
		return this.fenetre;
	}
}
