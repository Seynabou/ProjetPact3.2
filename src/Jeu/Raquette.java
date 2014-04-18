package Jeu;

import Affichage.TexturedVBO;

public class Raquette extends Tools implements RaquetteInterface {
	
	 // The VBO of this object
    public TexturedVBO vbo;

	private int width;
	public Raquette(TexturedVBO vbo,double x, double y, double z, int v, int width) {
		super(x, y, z, 0,0, v);
		//this.width=width;
		
		// Appliquer une texture à l'objet
		
		 this.vbo = vbo;
	     width = vbo.texture.width;
		
	}

	 public void render()
	    {
	        vbo.render(v,width);
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

