package moduleIG;

import Jeu.Manitou;

public class MainTestIG {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Manitou manitou= new Manitou();
		
		Interface1 menu = new Interface1(manitou); 
		menu.show();
		
//		Interface2 menu = new Interface2(manitou); 
//		menu.show();
	}
}
