package Affichage;

import Jeu.Manitou;

public class TESTAffichage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Manitou manitou = new Manitou();
		Affichage afficheur = new Affichage(manitou);
		afficheur.play();
	}
}
