package moduleIG;

import Affichage.Affichage;
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
		
		Affichage pong = new Affichage(manitou);
		FenetreDemarrage window = new FenetreDemarrage(manitou,pong);
		window.show();

	}
}
