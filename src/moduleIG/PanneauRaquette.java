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
	private PanneauRaquetteImage panneauImage;
	private ConfigData donnees;
	private ButtonGroup section = new ButtonGroup();

	public PanneauRaquette (ConfigData donnees,PanneauRaquetteImage panneauImage) {
		this.donnees=donnees;
		this.panneauImage=panneauImage;
		this.getReady();
		
	}

	private void getReady() {
		panneau.setLayout(new FlowLayout());
		JRadioButton boutonRaquette1 = new JRadioButton("Banane");
		boutonRaquette1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				donnees.raquette = 1;
				panneauImage.actualize(1);
			}
		});
		section.add(boutonRaquette1);
		panneau.add(boutonRaquette1);
		JRadioButton boutonRaquette2 = new JRadioButton("Raquette de Ping-pong");
		boutonRaquette2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				donnees.raquette = 2;
				panneauImage.actualize(2);
			}
		});
		section.add(boutonRaquette2);
		panneau.add(boutonRaquette2);
		JRadioButton boutonRaquette3 = new JRadioButton("Requin-marteau");
		boutonRaquette3.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				donnees.raquette = 3;
				panneauImage.actualize(3);
			}
		});
		section.add(boutonRaquette3);
		panneau.add(boutonRaquette3);
		panneau.setBorder(new TitledBorder(new LineBorder(Color.black, 1, true),"Raquette"));
		boutonRaquette1.doClick();
		panneauImage.actualize(1);

	}

	public JPanel getPanneau(){
		
		return this.panneau;
	}

	public JPanel getPanneauImage(){
		return this.panneauImage.getPanneau();
	}
}
