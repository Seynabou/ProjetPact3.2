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

public class PanneauDifficulte {

	private JPanel panneau = new JPanel();
	private ConfigData donnees;
	private ButtonGroup section = new ButtonGroup();

	public PanneauDifficulte (ConfigData donnees) {
		this.donnees=donnees;
		this.getReady();
	}

	private void getReady() {
		panneau.setLayout(new FlowLayout());
		JRadioButton boutonFacile = new JRadioButton("Facile");
		boutonFacile.addMouseListener(new MouseAdapter() {
			public void MouseClicked(MouseEvent e){
				this.donnees.difficulte = 1;
			}
		});
		section.add(boutonFacile);
		panneau.add(boutonFacile);
		JRadioButton boutonIntermediaire = new JRadioButton("Intermediaire");
		boutonIntermediaire.addMouseListener(new MouseAdapter() {
			public void MouseClicked(MouseEvent e){
				this.donnees.difficulte = 2;
			}
		});
		section.add(boutonIntermediaire);
		panneau.add(boutonIntermediaire);
		JRadioButton boutonExpert = new JRadioButton("Expert");
		boutonExpert.addMouseListener(new MouseAdapter() {
			public void MouseClicked(MouseEvent e){
				this.donnees.difficulte = 3;
			}
		});
		section.add(boutonExpert);
		panneau.add(boutonExpert);
		panneau.setBorder(new TitledBorder(new LineBorder(Color.black, 5, true),"Difficulte"));

	}

	public JPanel getPanneau(){
		return this.panneau;
	}

}
