package moduleIG;

import Jeu.Manitou;

public class MainTestIG {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Manitou manitou= new Manitou();
		FenetreAffichage menu = new FenetreAffichage(manitou); 
		menu.show();
	}
}
