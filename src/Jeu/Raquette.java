package Jeu;

public class Raquette extends Tools {
	

	private int width;
	public Raquette(float x, float y, float z, double dy, float raquette_width) {
		super(x, y, z, 0,dy, 0);
		//this.width=width;
		
	     width = (int) raquette_width;
		
	}

	
	public void Rebond(Balle b) {
		// TODO Auto-generated method stub
		//a modifier
//		System.out.println("Il y a des rebonds");
		double dx = b.getDx();
		b.setDx(-dx);
	}
	
	
	public boolean isAtLimitsY(TableDePingPong d){
		return ((this.getY()+this.width/2>d.getY()/2)||(this.getY()-this.width/2<d.getY()/2));
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

}

