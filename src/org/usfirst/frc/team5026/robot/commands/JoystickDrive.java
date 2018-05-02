package org.usfirst.frc.team5026.robot.commands;

import org.usfirst.frc.team5026.robot.Robot;
import org.usfirst.frc.team5026.util.Vector;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class JoystickDrive extends Command {
	
	/** Speed of the left side of the robot */
	private double leftSpeed;
	/** Speed of the right side of the robot */
	private double rightSpeed;
	
	/**
	 * Allows for driving with a joystick.
	 */
	 public JoystickDrive() {
    	requires(Robot.drive);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.oi.driveStick.seeAxis(); // See the raw joystick values
    	Vector v = Robot.oi.driveStick.findXY(); // Get x and y position of joystick
    	leftSpeed = Robot.oi.driveStick.findLeftPower(v.getX(), v.getY()); // Calculate left speed
    	SmartDashboard.putNumber("left spd", leftSpeed); // Display left speed
    	rightSpeed = Robot.oi.driveStick.findRightPower(v.getX(), v.getY()); // Calculate right speed
    	SmartDashboard.putNumber("right spd", rightSpeed); // Display right speed
    	Robot.drive.setLeftSide(leftSpeed); // Set power to the left side
    	Robot.drive.setRightSide(rightSpeed); // Set power to the right side
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drive.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }

}
