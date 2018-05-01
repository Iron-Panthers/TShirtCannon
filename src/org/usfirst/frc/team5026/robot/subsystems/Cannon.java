package org.usfirst.frc.team5026.robot.subsystems;

import org.usfirst.frc.team5026.robot.Hardware;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Cannon extends Subsystem {
	
	private TalonSRX cannon;
	
	public Cannon() {
		cannon = Hardware.cannon;
	}
	
	public void shoot(double voltage) {
		cannon.set(ControlMode.PercentOutput, voltage);
	}
	
	public void stop() {
		shoot(0);
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

}
