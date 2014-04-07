package moduleIG;

import java.awt.event.KeyEvent;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import moduleOPENGL.Jouer.Pong;
import Jeu.Manitou;

public class FenetreZac {

	private  JFrame fenetre;
	private  Manitou manitou;
	private  JPanel panneauPrinc;
	private JPanel panneauConfig=new JPanel();
	private JPanel panneauAide= new JPanel();
	public void show(){
		this.addComponentsToPanePrinc(panneauPrinc);
		this.fenetre.pack();
		this.fenetre.setLocationRelativeTo(null);
		this.fenetre.setVisible(true);
	}

	private Pong pong ;
	public FenetreZac(Manitou manitou, Pong pong){
		this.manitou=manitou;
		this.pong=pong;
		this.fenetre=new JFrame("Menu principal");
		this.panneauPrinc=(JPanel) fenetre.getContentPane();
	}
	public void addComponentsToPanePrinc(JPanel panneau){
		
	}
	public void addComponentsToPaneConfig(JPanel panneau){
		panneau.setLayout(new BoxLayout(panneau, 0));
		ButtonGroup sectionDifficulte= new ButtonGroup();
		JRadioButton boutonFacile= new JRadioButton("Facile");
		boutonFacile.setMnemonic(KeyEvent.VK_F);
		boutonFacile.setActionCommand("Vitesse facile slectionnee");
		sectionDifficulte.add(boutonFacile);
		panneau.add(boutonFacile);
		JRadioButton boutonIntermediaire= new JRadioButton("Intermediaire");
		boutonIntermediaire.setMnemonic(KeyEvent.VK_I);
		boutonIntermediaire.setActionCommand("Vitesse intermediaire slectionnee");
		sectionDifficulte.add(boutonIntermediaire);
		panneau.add(boutonIntermediaire);
		JRadioButton boutonExpert= new JRadioButton("Expert");
		boutonExpert.setMnemonic(KeyEvent.VK_E);
		boutonExpert.setActionCommand("Vitesse expert slectionnee");
		sectionDifficulte.add(boutonExpert);
		panneau.add(boutonExpert);
		
		ButtonGroup sectionDecor= new ButtonGroup();
		ButtonGroup sectionRaquette = new ButtonGroup();
		
	}
	public void addComponentsToPaneAide(JPanel panneau){
		
	}
}
