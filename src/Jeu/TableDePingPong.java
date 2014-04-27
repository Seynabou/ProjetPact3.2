package Jeu;

public class TableDePingPong {

	private final double x;
	private final double y;
	private final double z;
	private boolean balleStaysInTheField=true;
	
	public TableDePingPong(double x, double y, double z) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
	}

	
	public void Rebond(Balle b) {
		// TODO Auto-generated method stub
		if (b.isAtLimitsY(this))
		{
			if (b.getY()<0)
			{
				double theta = b.getAngleTheta();
				b.setAngleTheta(theta-Math.PI/2);
				
			}
			
			else
			{
				double theta = b.getAngleTheta();
				b.setAngleTheta(theta+Math.PI/2);
			}
			
		}
		if (b.isAtLimitsZ(this))
		{
			
			
		}
		
	}

	
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

	
	public boolean getBalleStaysInTheField() {
		// TODO Auto-generated method stub
		return this.balleStaysInTheField;
	}

	
	public void setBalleStaysInTheField(boolean position) {
		// TODO Auto-generated method stub
		this.balleStaysInTheField=position;
	}

}
