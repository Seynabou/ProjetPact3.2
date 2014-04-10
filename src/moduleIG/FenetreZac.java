package moduleIG;

import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import moduleOPENGL.Jouer.Pong;
import Jeu.Manitou;

public class FenetreZac {

	private  JFrame fenetre;
	private Manitou manitou;
	private  JPanel panneauPrinc;
	private JPanel panneauConfig=new JPanel();
	private JPanel panneauAide= new JPanel();
	public void show(){
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

	public void traiterDonnees(ConfigData donnes){
		
	}
	
}
