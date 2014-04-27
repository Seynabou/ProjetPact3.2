package Jeu;



public class Tools  {

	
	protected double x;
	protected double y;
	
	 // The VBO of this object
    
	public Tools(double x, double y, double z, double theta,double phi, int v) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
		this.theta = theta;
		this.v = v;
		this.phi=phi;
	}
	

	protected double z;
	protected double theta;
	protected double phi;
	protected int v;
	
	public double getX() {
		// TODO Auto-generated method stub
		return this.x;
	}

	
	
	public double getY() {
		// TODO Auto-generated method stub
		return this.y;
	}

	
	public double getZ() {
		// TODO Auto-generated method stub
		return this.z;
	}

	
	public double getAngleTheta() {
		// TODO Auto-generated method stub
		return this.theta;
	}

	
	public int getSpeed() {
		// TODO Auto-generated method stub
		return this.v;
	}

	
	public void setX(double x) {
		// TODO Auto-generated method stub
		this.x=x;
	}

	
	public void setY(double y) {
		// TODO Auto-generated method stub
		this.y=y;
	}

	
	public void setZ(double z) {
		// TODO Auto-generated method stub
		this.z=z;
	}

	
	public void setAngleTheta(double theta) {
		// TODO Auto-generated method stub
		this.theta=theta;
	}

	
	public void setSpeed(int v) {
		// TODO Auto-generated method stub
		this.v=v;
	}

	
	public boolean isAtLimitsX(TableDePingPong d) {
		// TODO Auto-generated method stub
		return (Math.abs(this.x)<d.getX());
	}

	
	public boolean isAtLimitsY(TableDePingPong d) {
		// TODO Auto-generated method stub
		return (Math.abs(this.y)<d.getY());
	}

	
	public boolean isAtLimitsZ(TableDePingPong d) {
		// TODO Auto-generated method stub
		return (Math.abs(this.z)<d.getZ());
	}

	
	public double getAnglePhi() {
		// TODO Auto-generated method stub
		return this.phi;
	}

	
	public void setAnglePhi(double phi) {
		// TODO Auto-generated method stub
		this.phi=phi;
	}
	

	
	public void reInitialize() {
		// TODO Auto-generated method stub
		this.setX(0);
		this.setY(0);
		this.setZ(0);
		this.setAnglePhi(0);
		this.setAngleTheta(0);
	}

}
