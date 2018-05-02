package org.usfirst.frc.team5026.util;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

// Because a GoodJoystick is a Joystick, not a GoodJoystick has a Joystick
public class GoodJoystick extends Joystick {
	
	/**
	 * Constructs a good joystick.
	 * 
	 * @param port - port that joystick is plugged into
	 */
	public GoodJoystick(int port) {
		super(port);
	}
	
	/**
	 * Displays raw joystick values.
	 */
	public void seeAxis() {
		SmartDashboard.putNumber("Raw X", super.getX());
		SmartDashboard.putNumber("Raw Y", super.getY());
	}

	/**
	 * Creates and returns a vector with the x and y position of the joystick.
	 * 
	 * @return x and y position of the joystick
	 */
	public Vector findXY() {
		// Reverses drive when triggered
		Vector v = super.getRawButton(1) ? new Vector(super.getX(), super.getY()) : new Vector(super.getX(), -super.getY());
		double magnitude = v.getMagnitude();
		double scaledMagnitude = (magnitude-Constants.CIRCLE_DEADZONE)/(1-Constants.CIRCLE_DEADZONE);
		v.norm();
		v.mult(scaledMagnitude);
		
		//TODO
		v.mult(1.05);
					
		if ( magnitude < Constants.CIRCLE_DEADZONE ) {
			v.zero();
		}
		
		SmartDashboard.putNumber("deadzone corrected X", v.getX());
		SmartDashboard.putNumber("deadzone corrected Y", v.getY());
		return v;
	}
	
	/**
	 * Calculate left power.
	 * 
	 * @param x
	 * @param y
	 * @return left power
	 */
	public double findLeftPower(double x,double y) {
	        return y+x;
	}

	/**
	 * Calculate right power.
	 * 
	 * @param x
	 * @param y
	 * @return right power
	 */
	public double findRightPower(double x,double y) {
			return y-x;
	}
}


