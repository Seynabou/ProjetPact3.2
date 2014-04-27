package Jeu;



public class Tools  {

	
	protected double x;
	protected double y;
	
	 // The VBO of this object
    
	public Tools(double x, double y, double z, double dx,double dy, double dz) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
		this.dx = dx;
		this.dz = dz;
		this.dy=dy;
	}
	

	protected double z;
	protected double dx;
	protected double dy;
	protected double dz;
	
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

	
	public double getDx() {
		// TODO Auto-generated method stub
		return this.dx;
	}

	
	public double getDz() {
		// TODO Auto-generated method stub
		return this.dz;
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

	
	public void setDx(double dx) {
		// TODO Auto-generated method stub
		this.dx=dx;
	}

	
	public void setDz(double dz) {
		// TODO Auto-generated method stub
		this.dz=dz;
	}

	


	
	public double getDy() {
		// TODO Auto-generated method stub
		return this.dy;
	}

	
	public void setDy(double dy) {
		// TODO Auto-generated method stub
		this.dy=dy;
	}
	

	public void move(){
		x+=dx;
		y+=dy;
		z+=dz;
	}
	
	public void reInitialize() {
		// TODO Auto-generated method stub
		this.setX(0);
		this.setY(0);
		this.setZ(0);
		this.setDy(Math.random());
		this.setDx(Math.random());
		this.setDz(Math.random());
	}

}
