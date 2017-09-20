package org.usfirst.frc.team5026.robot.subsystems; 
 
import edu.wpi.first.wpilibj.Joystick; 
 
/*  
 * @param magnitude is the magnitude of the vector of the joystick from the center.  
 * @param xy is a X or Y value usually obtained from getX() or getY() 
 *  
 * The math for the radial deadzone is found at this website:  
 * http://www.third-helix.com/2013/04/12/doing-thumbstick-dead-zones-right.html 
 *  
 * One thing to take notice is the (xy / magnitude) or normalized vector also known as the unit vector. 
 *  
 * */ 
 
public class PantherJoystick extends Joystick { 
   
  int joystickThrottleValue; 
  public boolean goingForward; 

   
  public PantherJoystick(int port) { 
    super(port); 
    goingForward = true; 
     
  } 
   
  public double getScaledDeadzoneX() { 
	double val = this.getDeadzoneJoystickValue(this.getMagnitude(), this.getX() * 0.5f, 0.0563f); 
	if (Math.abs(val) < 0.0563f) {
		return 0;
	}
    return val;
  } 
   
  public double getScaledDeadzoneY() {     
    double val = this.getDeadzoneJoystickValue(this.getMagnitude(), this.getY() * 0.6f, 0.0512f); 
    if (Math.abs(this.getY()) == 1.0) {
    	if (goingForward) return this.getY();
    	return -this.getY();
    }
    else { 
      if (goingForward) return val; 
      return -val; 
    }   
  } 
   
  public double getMagnitude() { 
    double xVal = this.getX(); 
    double yVal = this.getY(); 
    double magnitude = Math.sqrt(xVal * xVal + yVal * yVal); 
 
    return magnitude; 
  } 
   
  public double getDeadzoneJoystickValue(double magnitude, double xy, float deadzone) { 
	// Need to fix so that the x doesnt change when we move drastically in the y
    if (magnitude < deadzone) { 
      return 0; 
    } 
    else{ 
      return (xy / magnitude) * ((magnitude - deadzone) / (1 - deadzone)); 
    } 
  } 
   
  /* 
  public throttleMode() { 
    joystickThrottlevalue = this.getThrottle(); 
  } 
  */ 
 
} 