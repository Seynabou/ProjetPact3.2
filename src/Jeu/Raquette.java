package Jeu;

public class Raquette extends Tools {
	

	private double width;
	public Raquette(double x, double y, double z, double dy, double raquette_width) {
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
		return ((y+width/2>d.getY()/2)||(y-width/2<-d.getY()/2));
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

}

