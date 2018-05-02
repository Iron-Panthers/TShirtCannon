package org.usfirst.frc.team5026.robot.commands;

import org.usfirst.frc.team5026.robot.Robot;
import org.usfirst.frc.team5026.util.Constants;

import edu.wpi.first.wpilibj.command.Command;

public class ShootFromCannon extends Command {

	/**
	 * Allows to shoot t-shirts from a cannon. 
	 */
	public ShootFromCannon() {
		requires(Robot.cannon);
	}
	
    // Called just before this Command runs the first time
	protected void initialize() {
		Robot.cannon.stop();
	}
	
    // Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.cannon.shoot(Constants.CANNON_VOLTAGE); 
	}
	
	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return true;
	}
	
	// Called once after isFinished returns true
	protected void end() {
		Robot.cannon.stop();
	}
	
    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
	protected void interrupted() {
		end();
	}

}
