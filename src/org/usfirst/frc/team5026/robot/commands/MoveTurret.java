package org.usfirst.frc.team5026.robot.commands;

import org.usfirst.frc.team5026.robot.Robot;
import org.usfirst.frc.team5026.robot.subsystems.PantherJoystick;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class MoveTurret extends Command {

	private PantherJoystick joystick;
	
    public MoveTurret() {
    	requires(Robot.cannon);
    	
    	
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.cannon.stopMotors();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.cannon.setTurretMotor(joystick.getScaledDeadzoneX() * 0.5);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.cannon.stopMotors();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.cannon.stopMotors();
    }
}
