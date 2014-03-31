/*
 * 
 */




package moduleIG;
import Jeu.Manitou;

import javax.swing.*;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import moduleIntegration.ReproduireExec;
//import moduleOPENGL.Jouer.Pong;

public class Interface1 extends JPanel {

	
	private static final long serialVersionUID = 1L;
	
	//private  JFrame fenetre;
	//private Pong pong ;
	private  Manitou manitou;
	public  boolean RIGHT_TO_LEFT = false;
	
	private String chemin = "data\\ReproductionEXEC.txt";
	private String message = "NOUVEAU JEU: \n";
	
	JTabbedPane tabbedPane = new JTabbedPane();
	ImageIcon icon = new ImageIcon();

	public Interface1(Manitou manitou){	
		//this.fenetre= new JFrame("Menu principal");
		this.manitou= manitou;

	}
	
	protected JComponent makeTextPanel() {
		JPanel panel = new JPanel(false);
		//panel.setLayout(new GridLayout(1,1 )); //voir avec 2,2 et autres c'est drôle!
		//panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		return panel;
	}

	public void show(){


		JFrame frame = new JFrame("Choisis tes paramètres");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Add content to the window.
		frame.add(new Interface1(), BorderLayout.CENTER);									////////

		//Display the window.
		frame.pack();
		// dimensionner ma fenêtre à la dimension de mon ecran
		try{
			frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
			frame.setLocation(0, 0);
			
			
		}
		catch(Exception e)
		{ e.printStackTrace();}

		//frame.setLocationRelativeTo(null); //On centre la fenêtre sur l'écran
		frame.setVisible(true);

	}

	protected void setIcon(JButton button, String iconPath){
		ImageIcon icon = new ImageIcon(iconPath) ;

		// Dimensionne le bouton selon la taille de l'icône.
		button.setPreferredSize(new Dimension(icon.getIconWidth(), icon
				.getIconHeight())) ;
		// Habille le bouton de l'icône.
		button.setIcon(icon) ;
	}

	protected static ImageIcon createImageIcon(String path) {
		
		/** Returns an ImageIcon, or null if the path was invalid. */
		
		java.net.URL imgURL = TabbedPaneDemo.class.getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL);
		} else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}
	}
	
	
	public Interface1() {

		super(new GridLayout(3, 2));  //comment faire pour que cela ne s'applique que sur le premier onglet?
		JComponent panel1 = makeTextPanel();

	tabbedPane.addTab("Difficulté", icon, panel1,
				"Choisis la difficulté du jeu");

		JButton buttonFacile = new JButton();
		String facilePath = "src/ImagesGUI/facile.jpg";
		setIcon(buttonFacile, facilePath);
		buttonFacile.setAlignmentX(Component.CENTER_ALIGNMENT);
		buttonFacile.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e){
				manitou.setSpeed(1);
				System.out.println("Vitesse facile selectionnee ");
				message=message+"Speed envoyée : 1(FACILE)\n";

			}

		});
		panel1.add(buttonFacile, BorderLayout.PAGE_START);
		//panel1.add(buttonFacile);														//////

		JButton buttonNormal = new JButton();
		String NormalPath = "src/ImagesGUI/normal.jpg"; //à changer par intermédiaire
		setIcon(buttonNormal, NormalPath);
		buttonNormal.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e){
				manitou.setSpeed(2);
				System.out.println("Vitesse intermédiaire selectionnee ");
				message=message+"Speed envoyée : 2(NORMAL)\n";

			};
		});
		//		
		panel1.add(buttonNormal, BorderLayout.CENTER);
		//panel1.add(buttonNormal);

		JButton buttonDifficile = new JButton();
		String difficilePath = "src/ImagesGUI/difficile.jpg";
		setIcon(buttonDifficile, difficilePath);

		buttonDifficile.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e){
				manitou.setSpeed(3);
				System.out.println("Vitesse difficile selectionnee ");
				message=message+"Speed envoyée : 1(DIFFICILE)\n";

			};
		});
		panel1.add(buttonDifficile, BorderLayout.CENTER);
		//panel1.add(buttonDifficile);

		JButton buttonExpert = new JButton();
		String expertPath = "src/ImagesGUI/expert.jpg";
		setIcon(buttonExpert, expertPath);

		buttonExpert.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e){
				manitou.setSpeed(4);
				System.out.println("Vitesse expert selectionnee ");
				message=message+"Speed envoyée : 4(EXPERT)\n";

			};
		});
		panel1.add(buttonExpert, BorderLayout.CENTER);
		//panel1.add(buttonExpert);

		// go to step decor
		JButton buttonGoToStep2 = new JButton();
		String step2Path = "src/ImagesGUI/step2.jpg";
		setIcon(buttonGoToStep2, step2Path);

		buttonGoToStep2.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e){
				//panneau.removeAll();
				//fenetre.setTitle("Raquette");

				//JComponent panel2 = makeTextPanel();
		
				//fenetre.repaint();
				//fenetre.pack();
				
				
			}
		});
		panel1.add(buttonGoToStep2, BorderLayout.CENTER);
		//panel1.add(buttonGoToStep2);

		tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
	//}

	/////////////////////////////////////////////////////////////////

		JComponent panel2 = makeTextPanel();
		tabbedPane.addTab("Décor", icon, panel2,
				"Choisis ton décor  ");

		//DECOR1
		JButton buttonFirst = new JButton();
		String iconPath1 = "src/ImagesGUI/pelouse.jpg";
		setIcon(buttonFirst, iconPath1);

		buttonFirst.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e){

				//ce n'est pas au controleur qu'il faut donner la deco mais ï¿½ affichage
				//manitou.setDeco(1);

				System.out.println("Deco pelouse choisie ");
				message=message+"Deco envoyée: 1 \n";

			}
		});
		panel2.add(buttonFirst);

		//DECOR2
		JButton buttonSecond = new JButton();

		String iconPath2 = "src/ImagesGUI/ocean.jpg";
		setIcon(buttonSecond, iconPath2);

		buttonSecond.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e){
				//manitou.setDeco(2);
				System.out.println("Deco ocean choisie ");
				message=message+"Deco envoyée: 2 \n";

			}
		});
		panel2.add(buttonSecond);


		//DECOR3
		JButton buttonThird = new JButton();
		String iconPath3 = "src/ImagesGUI/jungle.jpg";
		setIcon(buttonThird, iconPath3);

		buttonThird.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e){
				//manitou.setDeco(3);
				System.out.println("Deco jungle choisie ");
				message=message+"Deco envoyée: 3 \n";
			}
		});
		panel2.add(buttonThird);


		//DECOR4
		JButton buttonFourth = new JButton();
		String iconPath4 = "src/ImagesGUI/newYork.jpg";
		setIcon(buttonFourth, iconPath4);

		buttonFourth.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e){
				//manitou.setDeco(4);
				System.out.println("Deco New York choisie ");
				message=message+"Deco envoyée: 4 \n";

			}
		});

		// go to step Raquette
		JButton buttonGoToStep3 = new JButton();
		String step3Path = "src/ImagesGUI/step3.jpg";
		setIcon(buttonGoToStep3, step3Path);

		buttonGoToStep3.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e){
				//panneau.removeAll();
				//fenetre.setTitle("Raquette");

				//fenetre.repaint();
				//fenetre.pack();
			}
		});
		panel2.add(buttonGoToStep3);

		tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
	

	/////////////////////////////////////////////////////////////////

		JComponent panel3 = makeTextPanel();
		tabbedPane.addTab("Raquette", icon, panel3,
				"Choisis la forme de ta raquette ");

		//raquette 1
		JButton buttonFirst1 = new JButton();
		String iconPath11 = "src/ImagesGUI/raquetteSport.jpg";
		setIcon(buttonFirst1, iconPath11);

		buttonFirst1.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e){
				//manitou.setRaquette(1);
				System.out.println("Raquette ping pong choisie ");
				message=message+"Raquette envoyée: 1 \n";
				ReproduireExec.ecrire(chemin, message);

			}
		});
		panel3.add(buttonFirst1, BorderLayout.PAGE_START);

		//Make the center component big, since that's the
		//typical usage of BorderLayout.

		//raquette 2
		JButton buttonSecond1 = new JButton();
		String iconPath21 = "src/ImagesGUI/requin.jpg";
		setIcon(buttonSecond1, iconPath21);

		buttonSecond1.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e){
				//manitou.setRaquette(2);
				System.out.println("Raquette requin choisie ");
				message=message+"Raquette envoyée: 2 \n";
				ReproduireExec.ecrire(chemin, message);

			}
		});
		panel3.add(buttonSecond1, BorderLayout.CENTER);

		//raquette 3
		JButton buttonThird1 = new JButton();
		String iconPath31 = "src/ImagesGUI/banane.jpg";
		setIcon(buttonThird1, iconPath31);

		buttonThird1.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e){
				//manitou.setRaquette(3);
				System.out.println("Raquette banane choisie ");
				message=message+"Raquette envoyée: 3 \n";
				ReproduireExec.ecrire(chemin, message);

			}
		});
		panel3.add(buttonThird1, BorderLayout.LINE_START);
		//RAQUETTE 4
		JButton buttonFourth1 = new JButton();
		String iconPath41 = "src/ImagesGUI/stars.jpg";
		setIcon(buttonFourth1, iconPath41);

		buttonFourth1.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e){
				//manitou.setRaquette(4);
				System.out.println("Raquette stars choisie ");
				message=message+"Raquette envoyée: 4 \n";
				ReproduireExec.ecrire(chemin, message);

			}
		});
		panel3.add(buttonFourth1, BorderLayout.LINE_END);


		tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);

		//Add the tabbed pane to this panel.
		add(tabbedPane);

		//The following line enables to use scrolling tabs.
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);

	}
}