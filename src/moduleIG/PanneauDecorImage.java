package moduleIG;

import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanneauDecorImage {

	private JPanel panneau=new JPanel();
	private JLabel image= new JLabel();
	public JPanel getPanneau() {
		this.getReady();
		return this.panneau;
	}

	public void actualize(int choix){
		
		switch(choix){
		case 1 : image.setIcon(new ImageIcon(getClass().getResource("/ImagesGUI/jungle.jpg")));break;
		case 2 : image.setIcon(new ImageIcon(getClass().getResource("/ImagesGUI/newYork.jpg")));break;
		case 3 : image.setIcon(new ImageIcon(getClass().getResource("/ImagesGUI/ocean.jpg")));break;
		}

	}
	
	private void getReady(){
		panneau.setLayout(new FlowLayout());
		panneau.add(image);
	}
}
