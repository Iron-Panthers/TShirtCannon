package org.usfirst.frc.team5026.robot.commands;

import org.usfirst.frc.team5026.robot.Hardware;
import org.usfirst.frc.team5026.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ShootFromCannon extends Command {

	public ShootFromCannon() {
		requires(Robot.cannon);
	}
	
	
	protected void initialize() {
		
	}
	
	protected void execute() {
		Robot.cannon.shoot(9.0 / Hardware.pdp.getVoltage()); // Constant to be added later
	}
	
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return true;
	}
	
	protected void end() {
		Robot.cannon.stop();
	}
	
	protected void interrupted() {
		end();
	}

}