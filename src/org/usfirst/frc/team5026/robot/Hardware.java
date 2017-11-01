package org.usfirst.frc.team5026.robot;

import org.usfirst.frc.team5026.robot.util.LEDDisplay;
import org.usfirst.frc.team5026.robot.util.MotorGroup;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Talon;

public class Hardware {
	
	public Talon left1;
	public Talon left2;
	public Talon right1;
	public Talon right2;
	
	public MotorGroup leftMotorGroup;
	public MotorGroup rightMotorGroup;
	
	public CANTalon turret;
	public CANTalon cannon;
	
	public Compressor compressor;
	public DoubleSolenoid sol;
	
	public LEDDisplay led;
	
	public Hardware () {
		// Construct the things here
		left1 = new Talon(RobotMap.DRIVE_LEFT_PORT_1);
		left2 = new Talon(RobotMap.DRIVE_LEFT_PORT_2);
		right1 = new Talon(RobotMap.DRIVE_RIGHT_PORT_1);
		right2 = new Talon(RobotMap.DRIVE_RIGHT_PORT_2);
		
		leftMotorGroup = new MotorGroup(left1, left2);
		rightMotorGroup = new MotorGroup(right1, right2);
		
		turret = new CANTalon(RobotMap.TURRET_TURN_PORT);
		cannon = new CANTalon(RobotMap.CANNON_FIRE_PORT);
		
		// Possible issues that could cause Compressor not starting could be D-link position
		compressor = new Compressor(1);
		compressor.start();
		sol = new DoubleSolenoid(RobotMap.SOLENOID_FORWARD, RobotMap.SOLENOID_REVERSE);
		
		led = new LEDDisplay(RobotMap.LED);
	}
}
