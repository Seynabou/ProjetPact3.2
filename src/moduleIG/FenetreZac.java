package moduleIG;

import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import moduleOPENGL.Jouer.Pong;
import Jeu.Manitou;

public class FenetreZac {

	private  JFrame fenetre=new JFrame("Menu Principal- MENTAL PONG");
	private Manitou manitou;
	private  JPanel panneauPrinc=(JPanel) this.fenetre.getContentPane();
	private FenetreConfig configurations = new FenetreConfig(this);
	public void show(){
		this.getReady();
		this.fenetre.pack();
		this.fenetre.setLocationRelativeTo(null);
		this.fenetre.setVisible(true);
		this.fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	//private Pong pong ;
	public FenetreZac(Manitou manitou){
		this.manitou=manitou;
		//	this.pong=pong;

	}

	private void getReady(){
		panneauPrinc.setLayout(new FlowLayout());
		JButton jouer = new JButton("Jouer");

		jouer.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				System.out.println("On joue!");	
			}
		});
		jouer.setIcon(new ImageIcon("src/ImagesGUI/play.png"));
		panneauPrinc.add(jouer);
		JButton config = new JButton("Configurer");
		config.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				configurations.show();
			}
		});
		config.setIcon(new ImageIcon("src/ImagesGUI/settings.png"));
		panneauPrinc.add(config);
		JButton aide = new JButton("Aide");
		aide.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				JOptionPane.showMessageDialog(fenetre, "Vous avez ouvert la fenetre d'aide.","Aide", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		aide.setIcon(new ImageIcon("src/ImagesGUI/help.png"));
		panneauPrinc.add(aide);
	}

	public void traiterDonnees(ConfigData donnees){
		System.out.println(donnees.toString());
		manitou.traiterDonnees(donnees);

	}

}
