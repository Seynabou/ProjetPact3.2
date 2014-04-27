package Jeu;
import moduleIG.ConfigData;
import moduleIntegration.*;


//Modif par rapport au vbo

public class Manitou implements SetDirectionInterfaceClassifCon, GetPositionOfRaquetteBalleAffichageCon,
IGControleurInterface{

	public Manitou() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void traiterDonnees(ConfigData donnees){
		this.speed=donnees.difficulte;
	}
	
	private TableDePingPong decor=new TableDePingPong(10,6,0);
	private int speed=1;
	private int directionP1;
	private int directionP2;
	private double alea=Math.random()*Math.PI*2;
	private Balle balle = new Balle(150,0,0,0,alea,speed,1);
	private Raquette raquetteP1=new Raquette( (float) (-decor.getX()/2-150),0,0,speed,5);
	private Raquette raquetteP2=new Raquette((float) (decor.getX()/2)+250,0,0,speed,5);
	private Score score=new Score(0,0);
	private MouvementBalle laBalle;
	private MouvementRaquettes lesRaquettes;
	private boolean pause;


	public void mettreEnPause_Reprendre(){
		this.pause= !pause;
		System.out.println("Je mets le jeu en pause");
	}
	

	@Override
	public void setDirectionP1(int direction) {
		// TODO Auto-generated method stub
		this.directionP1=direction;
	}
	@Override
	public void setDirectionP2(int direction) {
		// TODO Auto-generated method stub
		this.directionP2=direction;
	}


	@Override
	public Balle getBalle() {
		// TODO Auto-generated method stub
		return this.balle;
	}

	@Override
	public Raquette getRaquetteP1() {
		// TODO Auto-generated method stub
		return this.raquetteP1;
	}

	@Override
	public Raquette getRaquetteP2() {
		// TODO Auto-generated method stub
		return this.raquetteP2;
	}

	
	
	public void quitter(){
		
	}

	// Il faut rajouter des setters et getters concernant les 4 differents décors et les 4 différents types de raquette

}
