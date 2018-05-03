package org.usfirst.frc.team5026.robot.subsystems;

import org.usfirst.frc.team5026.robot.Robot;
import org.usfirst.frc.team5026.robot.commands.ShootFromCannon;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Cannon extends Subsystem {
	
	/** Motor controller for the cannon */
	private TalonSRX cannon;
	
	/**
	 * Constructs a cannon.
	 */
	public Cannon() {
		cannon = Robot.hardware.cannon;
	}
	
	/**
	 * Shoots T-shirt from cannon with a certain voltage.
	 * 
	 * @param voltage
	 */
	public void shoot(double voltage) {
		cannon.set(ControlMode.PercentOutput, voltage/12.0);
	}
	
	/**
	 * Stops the cannon motor by setting its power to 0.
	 */
	public void stop() {
		shoot(0);
	}
	
	@Override
	protected void initDefaultCommand() {
//		setDefaultCommand(new ShootFromCannon());
	}

}
