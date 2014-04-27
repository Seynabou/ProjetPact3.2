package Jeu;


public class Balle extends Tools {


    
	public Balle(double x, double y, double z, double theta,double phi, int v,int radius) {
		super(x, y, z, theta,phi, v);
		this.radius=radius;
		
	  
		// TODO Auto-generated constructor stub
	}

	
	private int radius;
	
	public boolean staysInTheField(Raquette r) {
		// TODO Auto-generated method stub
		
		return (Math.abs(r.getY()-this.getY())<r.getWidth()/2);
	}

	
	public int getRadius() {
		// TODO Auto-generated method stub
		return radius;
	}
	
	@Override
	public boolean isAtLimitsX(TableDePingPong d) {
		// TODO Auto-generated method stub
		return (Math.abs(this.getX())<d.getX()-this.getRadius());
	}

	@Override
	public boolean isAtLimitsY(TableDePingPong d) {
		// TODO Auto-generated method stub
		return (Math.abs(this.getY())<d.getY()-this.getRadius());
	}

	@Override
	public boolean isAtLimitsZ(TableDePingPong d) {
		// TODO Auto-generated method stub
		return (Math.abs(this.getZ())<d.getZ()-this.getRadius());
	}

	
}
