package org.usfirst.frc.team5026.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// JOYSTICKS
	public static final int DRIVE_STICK = 0;
	public static final int SHOOT_STICK = 1;
	// BUTTONS
	public static final int SHOOT_BUTTON = 1;
	// PORTS
	public static final int DRIVE_LEFT_PORT = 0;
	public static final int DRIVE_RIGHT_PORT = 1;
	public static final int TURRET_TURN_PORT = 2;
	public static final int CANNON_FIRE_PORT = 1;
	// SOLENOID
	public static final int SOLENOID_FORWARD = 0;
	public static final int SOLENOID_REVERSE = 1;
}
