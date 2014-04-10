package moduleIG;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanneauDecorImage {

	private JPanel panneau;
	public JPanel getPanneau() {
		return this.panneau;
	}

	public void actualize(int choix){
		switch(choix){
		case 1 : JLabel image1 = new JLabel( new ImageIcon( "jungle.jpg"));
		panneau.setLayout(new BorderLayout());
		panneau.add(image1);
		case 2 : JLabel image2 = new JLabel( new ImageIcon( "newYork.jpg"));
		panneau.setLayout(new BorderLayout());
		panneau.add(image2);
		case 3 : JLabel image3 = new JLabel( new ImageIcon( "ocean.jpg"));
		panneau.setLayout(new BorderLayout());
		panneau.add(image3);
		}

	}
}
