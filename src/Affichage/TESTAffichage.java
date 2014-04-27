package Affichage;

import Jeu.Manitou;
import Testeurs.TestThread1;
import Testeurs.TestThread2;

public class TESTAffichage {
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Manitou manitou = new Manitou();
		TestThread1 t1 = new TestThread1(manitou);
		TestThread2 t2 = new TestThread2(manitou);
		t1.run();
		t2.run();
		

	}
}
