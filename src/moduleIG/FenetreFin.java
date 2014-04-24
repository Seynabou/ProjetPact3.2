package moduleIG;

import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Affichage.Affichage;
import Jeu.Manitou;

public class FenetreFin {

	private  JFrame fenetre=new JFrame("Game Over");
	private Manitou manitou;
	private Affichage pong;
	private  JPanel panneauPrinc=(JPanel) this.fenetre.getContentPane();

	public void show(){
		this.getReady();
		this.fenetre.pack();
		this.fenetre.setLocationRelativeTo(null);
		this.fenetre.setVisible(true);

	}
	
	public FenetreFin(Manitou manitou,Affichage pong){
		this.manitou=manitou;
			this.pong=pong;

	}

	private void getReady(){
		panneauPrinc.setLayout(new FlowLayout());
		JButton boutonRejouer = new JButton("Rejouer");
		boutonRejouer.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				
			}
		});
		boutonRejouer.setIcon(new ImageIcon(getClass().getResource("/ImagesGUI/rejouer.jpg")));
		panneauPrinc.add(boutonRejouer);
		JButton boutonQuitter = new JButton("Quitter");
		boutonQuitter.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
			System.exit(0);	
			}
		});
		boutonQuitter.setIcon(new ImageIcon(getClass().getResource("/ImagesGUI/quitter.png")));
		panneauPrinc.add(boutonQuitter);
		JButton boutonNew = new JButton("Rejouer dans une nouvelle configuration");
		boutonNew.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				FenetreDemarrage window = new FenetreDemarrage(manitou,pong);
				window.show();
			}
		});
		boutonNew.setIcon(new ImageIcon(getClass().getResource("/ImagesGUI/settings.png")));
		panneauPrinc.add(boutonNew);
		
	}
	
	

}
