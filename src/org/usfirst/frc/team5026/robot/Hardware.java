package org.usfirst.frc.team5026.robot;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.Talon;

public class Hardware {
	
	public Talon left = new Talon(0);
	public Talon right = new Talon(1);
	
	public TalonSRX cannon;
	
	public PowerDistributionPanel pdp;
	
	public DoubleSolenoid sol;
	
	public Hardware() {
		cannon = new TalonSRX(RobotMap.CANNON);
		pdp = new PowerDistributionPanel();
		sol = new DoubleSolenoid(0,1);
	}
}
