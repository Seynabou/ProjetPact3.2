package moduleIG;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class PanneauRaquette {

	private JPanel panneau = new JPanel();
	private PanneauRaquetteImage panneauImage = new PanneauRaquetteImage();
	private ConfigData donnees;
	private ButtonGroup section = new ButtonGroup();

	public PanneauRaquette (ConfigData donnees) {
		this.donnees=donnees;
		this.getReady();
	}

	private void getReady() {
		panneau.setLayout(new FlowLayout());
		JRadioButton boutonRaquette1 = new JRadioButton("Raquette 1");
		boutonRaquette1.addMouseListener(new MouseAdapter() {
			public void MouseClicked(MouseEvent e){
				donnees.raquette = 1;
			}
		});
		section.add(boutonRaquette1);
		panneau.add(boutonRaquette1);
		JRadioButton boutonRaquette2 = new JRadioButton("Raquette 2");
		boutonRaquette2.addMouseListener(new MouseAdapter() {
			public void MouseClicked(MouseEvent e){
				donnees.raquette = 2;
			}
		});
		section.add(boutonRaquette2);
		panneau.add(boutonRaquette2);
		JRadioButton boutonRaquette3 = new JRadioButton("Raquette 3");
		boutonRaquette3.addMouseListener(new MouseAdapter() {
			public void MouseClicked(MouseEvent e){
				donnees.raquette = 3;
			}
		});
		section.add(boutonRaquette3);
		panneau.add(boutonRaquette3);
		panneau.setBorder(new TitledBorder(new LineBorder(Color.black, 5, true),"Raquette"));

	}

	public JPanel getPanneau(){
		
		return this.panneau;
	}

	public JPanel getPanneauImage(){
		return this.panneauImage.getPanneau();
	}
}
