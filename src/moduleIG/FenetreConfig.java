package moduleIG;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class FenetreConfig {

	private JFrame fenetre = new JFrame("Configurations");
	private FenetreZac fenetrePrinc ;
	private JPanel panneauPrinc = (JPanel) this.fenetre.getContentPane();
	private ConfigData donnees = new ConfigData();
	private PanneauDecorImage panneauDecorImage;
	private PanneauRaquetteImage panneauRaquetteImage;
	
	public void show(){
		this.getReady();
		this.fenetre.pack();
		this.fenetre.setLocationRelativeTo(null);
		this.fenetre.setVisible(true);
	}

	public FenetreConfig(FenetreZac fenetrePrinc){
		this.fenetrePrinc=fenetrePrinc;
	}
	private void getReady() {
		panneauPrinc.setLayout(new GridLayout(3,2,1, 1));
		panneauDecorImage = new PanneauDecorImage();
		panneauRaquetteImage= new PanneauRaquetteImage();
		PanneauDecor decor = new PanneauDecor(donnees,panneauDecorImage);
		PanneauRaquette raquette = new PanneauRaquette(donnees,panneauRaquetteImage);
		PanneauDifficulte difficulte = new PanneauDifficulte(donnees);
		PanneauValidation validation = new PanneauValidation(donnees, this);
		panneauPrinc.add(decor.getPanneau());
		panneauPrinc.add(decor.getPanneauImage());
		panneauPrinc.add(raquette.getPanneau());
		panneauPrinc.add(raquette.getPanneauImage());
		panneauPrinc.add(difficulte.getPanneau());
		panneauPrinc.add(validation.getPanneau());
	}

	public JFrame getFenetre(){
		return this.fenetre;
	}
	
	public void traiterDonnees(ConfigData donnees){
		fenetrePrinc.traiterDonnees(donnees);
		fenetre.setVisible(false);
		fenetre.dispose();
	}
}
