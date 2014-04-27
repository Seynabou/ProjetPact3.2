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

public class PanneauDecor {

	private JPanel panneau = new JPanel();
	private ConfigData donnees;
	private PanneauDecorImage panneauImage;
	private ButtonGroup section = new ButtonGroup();

	public PanneauDecor (ConfigData donnees, PanneauDecorImage panneauImage) {
		this.donnees=donnees;
		
		this.panneauImage=panneauImage;
		this.getReady();
	}

	private void getReady() {
		panneau.setLayout(new FlowLayout());
		JRadioButton boutonDecor1 = new JRadioButton("Welcome to the Jungle");
		boutonDecor1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				
				donnees.decor = 1;
				panneauImage.actualize(1);
			}
		});
		section.add(boutonDecor1);
		panneau.add(boutonDecor1);
		JRadioButton boutonDecor2 = new JRadioButton("City");
		boutonDecor2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				donnees.decor = 2;
				panneauImage.actualize(2);
			}
		});
		section.add(boutonDecor2);
		panneau.add(boutonDecor2);
		JRadioButton boutonDecor3 = new JRadioButton("Peur Bleue");
		boutonDecor3.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				donnees.decor = 3;
				panneauImage.actualize(3);
			}
		});
		section.add(boutonDecor3);
		panneau.add(boutonDecor3);
		panneau.setBorder(new TitledBorder(new LineBorder(Color.black, 1, true),"Decor"));
		boutonDecor1.doClick();
		panneauImage.actualize(1);

	}

	public JPanel getPanneau(){
		return this.panneau;
	}

	public JPanel getPanneauImage() {
		return this.panneauImage.getPanneau();
	}
}
