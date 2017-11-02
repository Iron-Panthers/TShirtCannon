package org.usfirst.frc.team5026.robot.util;

import org.usfirst.frc.team5026.robot.Constants;

public enum CannonState {
	FIRING(Constants.LED_FIRING_COLOR),
	MOVING(Constants.LED_MOVING_COLOR),
	STOPPED(Constants.LED_STOPPED_COLOR);
	
	public Color color;
	private CannonState(Color c) {
		this.color = c;
	}
}
