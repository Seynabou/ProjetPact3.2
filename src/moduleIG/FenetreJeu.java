package moduleIG;

import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Jeu.Manitou;
import Jeu.Score;

public class FenetreJeu {

	private JFrame fenetre=new JFrame("Enjoy!");
	private JPanel panneau=(JPanel) fenetre.getContentPane();
	private Score score;
	private Manitou manitou;
	
	public FenetreJeu(Manitou manitou){
		this.manitou=manitou;
	}
	
	public void show(){
		this.getReady();
		fenetre.pack();
		fenetre.setLocation(-50, 200);
		fenetre.setVisible(true);
	}
	
	private void getReady(){
		panneau.setLayout(new FlowLayout());
		JLabel score= new JLabel("Le score est de ");
		panneau.add(score);
		JButton pause = new JButton();
		pause.addMouseListener(new MouseAdapter() {
		
			public void mouseClicked(MouseEvent e){
				manitou.mettreEnPause_Reprendre();
			}
		});
		pause.setIcon(new ImageIcon(getClass().getResource("/ImagesGUI/play.png")));
		panneau.add(pause);
	}
	
}
