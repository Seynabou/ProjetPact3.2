package moduleIG;

import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FenetrePause {

	private JFrame fenetre=new JFrame("Menu de Pause");
	private JPanel panneau=(JPanel) fenetre.getContentPane();
	
	
	public FenetrePause() {
		// TODO Auto-generated constructor stub
	}

	private void getReady(){
		panneau.setLayout(new FlowLayout());
		JButton reprendre= new JButton("Reprendre");
		reprendre.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				
			}
		});
		reprendre.setIcon(new ImageIcon(getClass().getResource("/ImagesGUI/play.png")));
		panneau.add(reprendre);
		JButton quitter = new JButton("Quitter");
		quitter.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				
			}
		});
		quitter.setIcon(new ImageIcon(getClass().getResource("/ImagesGUI/quitter.png")));
		panneau.add(quitter);
		JButton retour = new JButton("Retour au menu principal");
		retour.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				
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
