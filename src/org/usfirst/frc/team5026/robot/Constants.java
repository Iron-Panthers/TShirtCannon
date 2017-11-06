package org.usfirst.frc.team5026.robot;

import org.usfirst.frc.team5026.robot.util.Color;

public class Constants {
	//Cannon Constants
	public static final double CANNON_OUTPUT_VOLTAGE = 9.0;
	public static final double SPEED_TURRET_SCALING = 0.7;
	
	//LED Constants
	public static final double LED_TIME_DEFAULT = 1;
	public static final int LED_SHIFT_INDEX = 0;
	public static final int LED_DRIVE_INDEX = 1;
	public static final Color LED_FIRING_COLOR = Color.GREEN;
	public static final Color LED_MOVING_COLOR = Color.YELLOW;
	public static final Color LED_STOPPED_COLOR = Color.RED;
	public static final Color[] LED_CYCLE = {Color.RED, Color.GOLD, Color.YELLOW, Color.GREEN, Color.BLUE, Color.ELECTRIC_INDIGO};

}
