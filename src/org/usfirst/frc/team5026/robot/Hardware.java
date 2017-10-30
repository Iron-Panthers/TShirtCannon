package org.usfirst.frc.team5026.robot;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Victor;

public class Hardware {
	
	public Talon left;
	public Talon right;
	
	public Victor turret;
	public CANTalon cannon;
	
	public Compressor compressor;
	public DoubleSolenoid sol;
	
	public Hardware () {
		// Construct the things here
		left = new Talon(RobotMap.DRIVE_LEFT_PORT);
		right = new Talon(RobotMap.DRIVE_RIGHT_PORT);
		
		turret = new Victor(RobotMap.TURRET_TURN_PORT);
		cannon = new CANTalon(RobotMap.CANNON_FIRE_PORT);
		
		// Possible issues that could cause Compressor not starting could be D-link position
		//compressor = new Compressor(1);
		//compressor.start();
		sol = new DoubleSolenoid(RobotMap.SOLENOID_FORWARD, RobotMap.SOLENOID_REVERSE);
	}
}
