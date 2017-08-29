package org.usfirst.frc.team5026.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Victor;

public class Hardware {
	
	public static final Talon left = new Talon(0);
	public static final Talon right = new Talon(1);
	
	public static final Victor turret = new Victor(2);
	public static final Victor cannon = new Victor(3);
	
	public static final DoubleSolenoid sol = new DoubleSolenoid(0,1);
}
