package org.usfirst.frc.team5026.robot;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PowerDistributionPanel;

public class Hardware {
	
	// TODO: Make motors for driving
	
	/** Cannon motor */
	public TalonSRX cannon;
	/** Power distribution panel */
	public PowerDistributionPanel pdp;
	/** Solenoid */
	public DoubleSolenoid sol;
	
	/**
	 * Constructs the hardware used.
	 */
	public Hardware() {
		cannon = new TalonSRX(RobotMap.CANNON);
		pdp = new PowerDistributionPanel();
		sol = new DoubleSolenoid(0,1);
	}
}
