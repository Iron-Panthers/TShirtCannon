package org.usfirst.frc.team5026.robot;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.Talon;

public class Hardware {
	
	public static final Talon left = new Talon(0);
	public static final Talon right = new Talon(1);
	
	public static final TalonSRX cannon = new TalonSRX(RobotMap.CANNON);
	
	public static final PowerDistributionPanel pdp = new PowerDistributionPanel();
	
	public static final DoubleSolenoid sol = new DoubleSolenoid(0,1);
}
