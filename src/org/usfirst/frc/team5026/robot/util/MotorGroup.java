package org.usfirst.frc.team5026.robot.util;

import org.usfirst.frc.team5026.robot.Constants;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.SpeedController;

public class MotorGroup implements SpeedController {

	private SpeedController[] motors;
	
	public MotorGroup(SpeedController... motors) {
		this.motors = motors;
	}

	@Override
	public void set(double speed) {
		for(SpeedController sc : motors)
		{
			sc.set(speed);
		}
	}

	@Override
	public void pidWrite(double output) {	}

	@Override
	public double get() { return 0;	}

	@Override
	public void setInverted(boolean isInverted) {	}

	@Override
	public boolean getInverted() { return false; }

	@Override
	public void disable() {
		set(0);
	}

	@Override
	public void stopMotor() {
		set(0);
	}
}