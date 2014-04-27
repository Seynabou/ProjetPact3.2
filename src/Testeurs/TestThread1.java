package Testeurs;

import Jeu.Manitou;

public class TestThread1 extends Thread {

	private DirectionGiver testeur ;
	public TestThread1(Manitou manitou){
		super();
		
		testeur = new DirectionGiver(manitou);
	}
	public void run(){
		testeur.testManitou();
	}

}
