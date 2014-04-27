package Jeu;

public interface MovingObject {
public double getX();
public double getY();
public double getZ();
public double getAngleTheta();
public double getAnglePhi();
public int getSpeed();
public void setX(double x);
public void setY(double y);
public void setZ(double z);
public void setAngleTheta(double theta);
public void setAnglePhi(double phi);
public void setSpeed(int v);
public boolean isAtLimitsX(TableDePingPong d);
public boolean isAtLimitsY(TableDePingPong d);
public boolean isAtLimitsZ(TableDePingPong d);
public void reInitialize();

}

