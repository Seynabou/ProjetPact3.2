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

public class FenetrePause {

	private JFrame fenetre=new JFrame("Menu de Pause");
	private JPanel panneau=(JPanel) fenetre.getContentPane();
	private Manitou manitou;
	
	
	public FenetrePause(Manitou manitou) {

		this.manitou=manitou;
	}

	private void getReady(){
		panneau.setLayout(new FlowLayout());
		JButton reprendre= new JButton("Reprendre");
		reprendre.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				manitou.mettreEnPause_Reprendre();
			}
		});
		reprendre.setIcon(new ImageIcon(getClass().getResource("/ImagesGUI/play.png")));
		panneau.add(reprendre);
		JButton quitter = new JButton("Quitter");
		quitter.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				System.exit(0);
			}
		});
		quitter.setIcon(new ImageIcon(getClass().getResource("/ImagesGUI/quitter.png")));
		panneau.add(quitter);
		JButton retour = new JButton("Retour au menu principal");
		retour.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				manitou.quitter();
				Affichage pong = new Affichage(manitou);
				FenetreDemarrage window = new FenetreDemarrage(manitou, pong);
				window.show();
			}
		});
		retour.setIcon(new ImageIcon(getClass().getResource("/ImagesGUI/retour.png")));
		panneau.add(retour);
	}
	
	public void show(){
		this.getReady();
		fenetre.pack();
		fenetre.setLocationRelativeTo(null);
		fenetre.setVisible(true);
	}
	

	
}
