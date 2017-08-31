package org.usfirst.frc.team5026.robot.commands;

import org.usfirst.frc.team5026.robot.Constants;
import org.usfirst.frc.team5026.robot.Robot;
import org.usfirst.frc.team5026.robot.RobotMap;
import org.usfirst.frc.team5026.robot.subsystems.Cannon;
import org.usfirst.frc.team5026.robot.subsystems.PantherJoystick;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class MoveAndFireTurret extends Command {
	Cannon cannon;
	PantherJoystick joystick;

    public MoveAndFireTurret() {
        requires(Robot.cannon);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	cannon = Robot.cannon;
    	cannon.stopMotors();
    	joystick = Robot.oi.shootStick;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	cannon.setTurretMotor(joystick.getScaledDeadzoneX() * Constants.SPEED_TURRET_SCALING);
    	// HOLD JOYSTICK DOWN TO FIRE SHIRT (RELEASE AFTERWARDS TO GIVE REPRESSURE TIME)
    	if (joystick.getRawButton(RobotMap.SHOOT_BUTTON)) {
        	Robot.cannon.pulseCannonMotor(Constants.CANNON_OUTPUT_VOLTAGE);
    	} else {
    		Robot.cannon.pulseCannonMotor(0);
    	}
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
