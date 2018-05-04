package org.usfirst.frc.team5026.robot;

import org.usfirst.frc.team5026.util.MotorGroup;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PowerDistributionPanel;

public class Hardware {
	
	// TODO: Make motors for driving
	public TalonSRX leftM1;
	public TalonSRX leftM2;
	public TalonSRX rightM1;
	public TalonSRX rightM2;
	
	public MotorGroup left;
	public MotorGroup right;
	
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
		leftM1 = new TalonSRX(RobotMap.LEFTM1_PORT);
		leftM2 = new TalonSRX(RobotMap.LEFTM2_PORT);
		rightM1 = new TalonSRX(RobotMap.RIGHTM1_PORT);
		rightM2 = new TalonSRX(RobotMap.RIGHTM2_PORT);
		
		left = new MotorGroup(leftM1, leftM2);
		right = new MotorGroup(rightM1, rightM2);
		right.setInverted(!true);
		left.setInverted(!false);
		
		cannon = new TalonSRX(RobotMap.CANNON);
		pdp = new PowerDistributionPanel();
		sol = new DoubleSolenoid(0,1);
	}
}
