package moduleIG;

import moduleOPENGL.Jouer.Pong;
import Jeu.Manitou;

public class MainTestIG {

	public MainTestIG() {
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Manitou manitou= new Manitou();
		
		//Pong pong = new Pong();
		FenetreZac window = new FenetreZac(manitou);
		window.show();
//		Interface2 menu = new Interface2(manitou); 
//		menu.show();
	}
}
