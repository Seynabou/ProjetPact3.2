package Jeu;

import Affichage.TexturedVBO;

public class Raquette extends Tools implements RaquetteInterface {
	

	private int width;
	public Raquette(float x, float y, float z, int v, float raquette_width) {
		super(x, y, z, 0,0, v);
		//this.width=width;
		
	     width = (int) raquette_width;
		
	}

	@Override
	public void Rebond(BalleInterface b) {
		// TODO Auto-generated method stub
		//a modifier
//		System.out.println("Il y a des rebonds");
		b.setAnglePhi(b.getAnglePhi());
		b.setAngleTheta(b.getAngleTheta());
	}
	
	@Override
	public boolean isAtLimitsY(DecorInterface d){
		return ((this.getY()+this.width/2>d.getY()/2)||(this.getY()-this.width/2<d.getY()/2));
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

}

