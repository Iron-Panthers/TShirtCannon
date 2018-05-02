package org.usfirst.frc.team5026.util;

public class Constants {
	
	/** Joystick deadzone */
	public static final double CIRCLE_DEADZONE = 0.1;
	
	/** Voltage for the cannon */
	public static final double CANNON_VOLTAGE = 9.0;
	
	public static final int kTimeoutMs = 0; // Do not change
	public static final int kSlotIdx = 0; // Do not change
	public static final int kPIDLoopIdx = 0; // Do not change
	
	
	// Drive constants
	/** P constant for driving */
	public static final double DRIVE_P = 0;
	/** I constant for driving */
	public static final double DRIVE_I = 0;
	/** D constant for driving */
	public static final double DRIVE_D = 0;
	/** F constant for driving */
	public static final double DRIVE_F = 0.3069; // Calculated as per the Talon SRX Software Refrence Manual, Section: 12.4.2. Math is: 0.75 * 1023 / 2500
	/** Encoder ticks in a full wheel revolution */
	public static final int DRIVE_TICKS_PER_REVOLUTION = 5526;
	/** Radius of the robot wheels */
	private static final double WHEEL_RADIUS = 3; // Inches
	/** Circumference of the robot wheels */
	private static final double WHEEL_CIRCUMFERENCE = WHEEL_RADIUS*2*Math.PI;	
	/** Desired velocity */
	private static final double DRIVE_WANTED_INCHES_PER_SECOND = 48;
	/** Desired acceleration */
	private static final double DRIVE_WANTED_ACCELERATION_INCHES_PER_SECOND_SQUARED = 80;
	/**
	 * Converts in/s to encoder ticks per 100 ms
	 * 
	 * @param inchesPerSecond
	 * @return velocity in encoder ticks per 100 ms
	 */
	private static int MOTION_MAGIC_VELOCITY(double inchesPerSecond) {
		return (int)( DRIVE_TICKS_PER_REVOLUTION * inchesPerSecond / WHEEL_CIRCUMFERENCE / 10 );
	}
	/**
	 * Converts in/s^2 to encoder ticks per 100 ms per second
	 * 
	 * @param inchesPerSecondPerSecond
	 * @return acceleration in encoder ticks per 100 ms per second
	 */
	private static int MOTION_MAGIC_ACCELERATION(double inchesPerSecondPerSecond) {
		return (int) (DRIVE_TICKS_PER_REVOLUTION * inchesPerSecondPerSecond / (WHEEL_CIRCUMFERENCE) / 10);
	}
	/** Drive velocity */
	public static final int DRIVE_VELOCITY = MOTION_MAGIC_VELOCITY(DRIVE_WANTED_INCHES_PER_SECOND); // Units of encoder ticks per 100 ms 
	/** Drive acceleration */
	public static final int DRIVE_ACCELERATION = MOTION_MAGIC_ACCELERATION(DRIVE_WANTED_ACCELERATION_INCHES_PER_SECOND_SQUARED); // Units of encoder ticks per 100 ms per second

}