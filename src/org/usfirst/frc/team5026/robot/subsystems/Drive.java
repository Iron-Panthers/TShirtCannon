package org.usfirst.frc.team5026.robot.subsystems;

import org.usfirst.frc.team5026.robot.Robot;
import org.usfirst.frc.team5026.robot.commands.JoystickDrive;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Drive extends Subsystem {
	
	RobotDrive drive;
	
	public Drive() {
		drive = new RobotDrive(Robot.hardware.left, Robot.hardware.right);
		drive.setSafetyEnabled(false);
	}
	
	public void drive(double left, double right) {
		drive.setLeftRightMotorOutputs(left, right);
	}
	public void useArcadeDrive(double yAxis, double xAxis) {
		drive.arcadeDrive(yAxis, xAxis);
	}

	public void stopMotors() {
		drive.setLeftRightMotorOutputs(0, 0);
	}
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		setDefaultCommand(new JoystickDrive());
	}
	
	
}
