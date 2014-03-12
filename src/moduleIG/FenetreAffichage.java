package moduleIG;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Jeu.Manitou;

import java.awt.Container;

import javax.swing.*;

import moduleIntegration.ReproduireExec;


import moduleOPENGL.Jouer.Pong;



import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class FenetreAffichage {

	private  JFrame fenetre;
	private  Manitou manitou;
	public  boolean RIGHT_TO_LEFT = false;
	private  JPanel panneau;
	public void show(){
		this.addComponentsToPane(panneau);
		this.fenetre.pack();
		this.fenetre.setLocationRelativeTo(null);
		this.fenetre.setVisible(true);
	}

	private Pong pong ;
	private String chemin = "data\\ReproductionEXEC.txt";
	private String message = "NOUVEAU JEU: \n";


	public FenetreAffichage(Manitou manitou){	
		this.fenetre= new JFrame("Menu principal");
		this.manitou= manitou;
		panneau = (JPanel) fenetre.getContentPane();

	}

	protected void setIcon(JButton button, String iconPath)
	{
		ImageIcon icon = new ImageIcon(iconPath) ;

		// Dimensionne le bouton selon la taille de l'icône.
		button.setPreferredSize(new Dimension(icon.getIconWidth(), icon
				.getIconHeight())) ;
		// Habille le bouton de l'icône.
		button.setIcon(icon) ;
	}

	//il faudra mettre à jour la premiere fenêtre du menu principal
	
//	public void addComponentsToPane5(Container pane) {
//		//certains boutons ont été changé entre temps pour une question de gout
//		// Il faudra prendre en compte ce M. gardoll avait dit le 11 Mars coté ergonomie...
//		if (!(pane.getLayout() instanceof BorderLayout)) {
//			pane.add(new JLabel("Container doesn't use BorderLayout!"));
//			return;
//		}
//
//		if (RIGHT_TO_LEFT) {
//			pane.setComponentOrientation(
//					java.awt.ComponentOrientation.RIGHT_TO_LEFT);
//		}
//
//		JButton buttonJouer = new JButton();
//		String jouerPath = "src/ImagesGUI/jouer.png";
//		setIcon(buttonJouer, jouerPath);
//		buttonJouer.addMouseListener(new MouseAdapter() {
//
//			public void mouseClicked(MouseEvent e){
//				panneau.removeAll();
//				fenetre.setTitle(" Level");
//				addComponentsToPane(panneau);
//				fenetre.repaint();
//				fenetre.pack();
//			}
//
//		});
//		pane.add(buttonJouer, BorderLayout.PAGE_START);
//
//		//Make the center component big, since that's the
//		//typical usage of BorderLayout.
//
//		
//		JButton buttonAide = new JButton();
//		String AidePath = "src/ImagesGUI/aide.jpg";
//		setIcon(buttonAide, AidePath);
//		buttonAide.addMouseListener(new MouseAdapter() {
//
//			public void mouseClicked(MouseEvent e){
//				System.out.println("L'Aide va bientôt s'afficher");
//			};
//		});
//		pane.add(buttonAide, BorderLayout.CENTER);
//
//		JButton buttonCredits = new JButton();
//		String CreditsPath = "src/ImagesGUI/credit.jpg";
//		setIcon(buttonCredits, CreditsPath);
//
//		buttonCredits.addMouseListener(new MouseAdapter() {
//
//			public void mouseClicked(MouseEvent e){
//				System.out.println("Les Crédits vont bientôt s'afficher");
//			};
//		});
//		pane.add(buttonCredits, BorderLayout.LINE_START);
//
//		JButton buttonStats = new JButton();
//		String statsPath = "src/ImagesGUI/stats.jpg";
//		setIcon(buttonStats, statsPath);
//
//		buttonStats.addMouseListener(new MouseAdapter() {
//
//			public void mouseClicked(MouseEvent e){
//				System.out.println("Les Statistiques vont bientôt s'afficher");
//			};
//		});
//		pane.add(buttonStats, BorderLayout.LINE_END);
//
//		//go to STEP 2	
//		JButton buttonQuitter = new JButton();
//		String quitPath = "src/ImagesGUI/exit.jpg";
//		setIcon(buttonQuitter, quitPath);
//
//		buttonQuitter.addMouseListener(new MouseAdapter() {
//
//			public void mouseClicked(MouseEvent e) {
//				System.exit(0);
//			};
//		});
//		pane.add(buttonQuitter, BorderLayout.PAGE_END);
//	}

	public void addComponentsToPane(Container pane) {

		if (!(pane.getLayout() instanceof BorderLayout)) {
			pane.add(new JLabel("Container doesn't use BorderLayout!"));
			return;
		}

		if (RIGHT_TO_LEFT) {
			pane.setComponentOrientation(
					java.awt.ComponentOrientation.RIGHT_TO_LEFT);
		}

		JButton buttonFacile = new JButton();
		String facilePath = "src/ImagesGUI/facile.jpg";
		setIcon(buttonFacile, facilePath);
		buttonFacile.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e){
				manitou.setSpeed(1);
				System.out.println("Vitesse facile selectionnee ");
				message=message+"Speed envoyée : 1(FACILE)\n";

			}

		});
		pane.add(buttonFacile, BorderLayout.PAGE_START);

		//Make the center component big, since that's the
		//typical usage of BorderLayout.


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
		pane.add(buttonNormal, BorderLayout.CENTER);

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
		pane.add(buttonDifficile, BorderLayout.LINE_START);

		JButton buttonExpert = new JButton("Expert");
		String expertPath = "src/ImagesGUI/expert.jpg";
		setIcon(buttonExpert, expertPath);

		buttonExpert.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e){
				manitou.setSpeed(4);
				System.out.println("Vitesse expert selectionnee ");
				message=message+"Speed envoyée : 4(EXPERT)\n";

			};
		});
		pane.add(buttonExpert, BorderLayout.LINE_END);

		//go to STEP 2	
		JButton buttonValider = new JButton();
		String step2Path = "src/ImagesGUI/step2.jpg";
		setIcon(buttonValider, step2Path);

		buttonValider.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				panneau.removeAll();
				fenetre.setTitle("Mode de jeu");
				addComponentsToPane2(panneau);
				fenetre.repaint();
				fenetre.pack();
			};
		});
		pane.add(buttonValider, BorderLayout.PAGE_END);
	}

	public void addComponentsToPane2(Container pane) {

		if (!(pane.getLayout() instanceof BorderLayout)) {
			pane.add(new JLabel("Container doesn't use BorderLayout!"));
			return;
		}

		if (RIGHT_TO_LEFT) {
			pane.setComponentOrientation(
					java.awt.ComponentOrientation.RIGHT_TO_LEFT);
		}

		JButton buttonFacile = new JButton("J1vsJ2");


		buttonFacile.addMouseListener(new MouseAdapter() {

			// a voir ce qu'on rajoute pour differencier entre les differents modes de jeu.


			public void mouseClicked(MouseEvent e){
				manitou.setMode(1);
				System.out.println("mode J1 vs J2 choisi ");
				message=message+"Mode envoyé : 1(J1vsJ2)\n";

			}
		});
		pane.add(buttonFacile, BorderLayout.LINE_END);

		//Make the center component big, since that's the
		//typical usage of BorderLayout.

		JButton buttonNormal = new JButton("J1vsIA");
		buttonNormal.setPreferredSize(new Dimension(200, 100));
		buttonNormal.addMouseListener(new MouseAdapter() {

			// a voir ce qu'on rajoute pour differencier entre les differents modes de jeu.      

			public void mouseClicked(MouseEvent e){
				message=message+"Mode envoyé : 2(J1vsIA)\n";
				System.out.println("mode J1 vs IA choisi ");

			}
		});
		pane.add(buttonNormal, BorderLayout.CENTER);

		JButton buttonDifficile = new JButton("J1&J2vsIA");
		buttonDifficile.addMouseListener(new MouseAdapter() {

			// a voir ce qu'on rajoute pour differencier entre les differents modes de jeu.

			public void mouseClicked(MouseEvent e){
				System.out.println("mode J1&J2 vs J2 choisi ");
				message=message+"Mode envoyé : 3(J1&J2vsIA)\n";

			}
		});
		pane.add(buttonDifficile, BorderLayout.LINE_START);


		//go to STEP3
		JButton buttonJouer = new JButton();
		String step3Path = "src/ImagesGUI/step3.jpg";
		setIcon(buttonJouer, step3Path);

		buttonJouer.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e){
				panneau.removeAll();
				fenetre.setTitle("Decor");
				addComponentsToPane3(panneau);
				fenetre.repaint();
				fenetre.pack();
			}
		});
		pane.add(buttonJouer, BorderLayout.PAGE_END);



	}


	public void addComponentsToPane3(Container pane) {

		if (!(pane.getLayout() instanceof BorderLayout)) {
			pane.add(new JLabel("Container doesn't use BorderLayout!"));
			return;
		}

		if (RIGHT_TO_LEFT) {
			pane.setComponentOrientation(
					java.awt.ComponentOrientation.RIGHT_TO_LEFT);
		}
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
		pane.add(buttonFirst, BorderLayout.PAGE_START);

		//Make the center component big, since that's the
		//typical usage of BorderLayout.

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
		pane.add(buttonSecond, BorderLayout.CENTER);


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
		pane.add(buttonThird, BorderLayout.LINE_START);


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
		pane.add(buttonFourth, BorderLayout.LINE_END);

		//go to step4
		JButton buttonJouer = new JButton();
		String step4Path = "src/ImagesGUI/step4.jpg";
		setIcon(buttonJouer, step4Path);

		buttonJouer.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e){
				panneau.removeAll();
				fenetre.setTitle("Raquette");
				addComponentsToPane4(panneau);
				fenetre.repaint();
				fenetre.pack();
			}
		});
		pane.add(buttonJouer, BorderLayout.PAGE_END);
	}


	public void addComponentsToPane4(Container pane) {

		if (!(pane.getLayout() instanceof BorderLayout)) {
			pane.add(new JLabel("Container doesn't use BorderLayout!"));
			return;
		}

		if (RIGHT_TO_LEFT) {
			pane.setComponentOrientation(
					java.awt.ComponentOrientation.RIGHT_TO_LEFT);
		}

		//raquette 1
		JButton buttonFirst = new JButton();
		String iconPath1 = "src/ImagesGUI/raquetteSport.jpg";
		setIcon(buttonFirst, iconPath1);

		buttonFirst.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e){
				//manitou.setRaquette(1);
				System.out.println("Raquette ping pong choisie ");
				message=message+"Raquette envoyée: 1 \n";
				ReproduireExec.ecrire(chemin, message);

			}
		});
		pane.add(buttonFirst, BorderLayout.PAGE_START);

		//Make the center component big, since that's the
		//typical usage of BorderLayout.

		//raquette 2
		JButton buttonSecond = new JButton();
		String iconPath2 = "src/ImagesGUI/requin.jpg";
		setIcon(buttonSecond, iconPath2);

		buttonSecond.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e){
				//manitou.setRaquette(2);
				System.out.println("Raquette requin choisie ");
				message=message+"Raquette envoyée: 2 \n";
				ReproduireExec.ecrire(chemin, message);

			}
		});
		pane.add(buttonSecond, BorderLayout.CENTER);

		//raquette 3
		JButton buttonThird = new JButton();
		String iconPath3 = "src/ImagesGUI/banane.jpg";
		setIcon(buttonThird, iconPath3);

		buttonThird.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e){
				//manitou.setRaquette(3);
				System.out.println("Raquette banane choisie ");
				message=message+"Raquette envoyée: 3 \n";
				ReproduireExec.ecrire(chemin, message);

			}
		});
		pane.add(buttonThird, BorderLayout.LINE_START);
		//RAQUETTE 4
		JButton buttonFourth = new JButton();
		String iconPath4 = "src/ImagesGUI/stars.jpg";
		setIcon(buttonFourth, iconPath4);

		buttonFourth.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e){
				//manitou.setRaquette(4);
				System.out.println("Raquette stars choisie ");
				message=message+"Raquette envoyée: 4 \n";
				ReproduireExec.ecrire(chemin, message);

			}
		});
		pane.add(buttonFourth, BorderLayout.LINE_END);

		JButton buttonJouer = new JButton();
		String playPath = "src/ImagesGUI/jouer.jpg";
		setIcon(buttonJouer, playPath);

		buttonJouer.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				panneau.removeAll();
				panneau.repaint();
				fenetre.repaint();

				System.out.println("Le jeu va se lancer");
// il faut revoir avec M. gardoll la barre de progression
				
				ProgressBar frame = new ProgressBar();
				frame.pack();
				frame.setVisible(true);
				frame.loop();
				frame.setVisible(false);
				fenetre.setVisible(false);

				System.out.println("Le jeu va se lancer");
				fenetre.setVisible(false);
				
//				final ProgressMonitor pm = new ProgressMonitor(new
//						JFrame(), "Loading", "Loading, please wait ...",
//						0, 100) ;
//
//				SwingWorker sw = new SwingWorker<Void, Void>() {
//					@Override
//					public Void doInBackground() {
//						int position = 0;
//						while (position < 101) {
//							pm.setProgress(position);
//							System.out.println("position : " + position);
//							try {
//								Thread.sleep(500);
//							} catch (InterruptedException e) {
//							}
//							position += 20;
//						}
//						return null ;
//					}
//				} ;
//				sw.execute();
				
				//revoir l'apparition de la fenêtre de jeu, pas très jolie!! 
				pong = new Pong();
				pong.gameLoop();
			}
		});
		pane.add(buttonJouer, BorderLayout.PAGE_END);
	}
}

