package org.usfirst.frc.team5026.robot.commands;

import org.usfirst.frc.team5026.robot.Robot;
import org.usfirst.frc.team5026.util.Constants;

import edu.wpi.first.wpilibj.command.TimedCommand;

public class ShootFromCannon extends TimedCommand {

	/**
	 * Allows to shoot t-shirts from a cannon. 
	 */
	public ShootFromCannon() {
		super(Constants.CANNON_LAUNCH_TIME);
		requires(Robot.cannon);
	}
	
    // Called just before this Command runs the first time
	protected void initialize() {
		Robot.cannon.stop();
	}
	
    // Called repeatedly when this Command is scheduled to run
	protected void execute() {
		System.out.println("Launched!");
		Robot.cannon.shoot(Constants.CANNON_VOLTAGE); 
	}
	
	// Called once after isFinished returns true
	protected void end() {
		System.out.println("STOPPED!");
		Robot.cannon.stop();
	}
	
    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
	protected void interrupted() {
		end();
	}

}
