package org.usfirst.frc.team5026.robot.subsystems;

import org.usfirst.frc.team5026.robot.Robot;
import org.usfirst.frc.team5026.robot.commands.MoveAndFireTurret;
import org.usfirst.frc.team5026.robot.util.CannonState;

import com.ctre.CANTalon;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Cannon extends Subsystem {
	CANTalon turret;
	CANTalon cannon;
	
	public CannonState state;

	public Cannon() {
		cannon = Robot.hardware.cannon;
		turret = Robot.hardware.turret;
		
		cannon.changeControlMode(TalonControlMode.Voltage);
		state = CannonState.STOPPED;
	}
	
	public void pulseCannonMotor(double voltage) {
		cannon.set(voltage);
		state = CannonState.FIRING;
	}
	
	public void setTurretMotor(double target) {
		turret.set(target);
		state = CannonState.MOVING;
	}
	
	public void stopMotors() {
		turret.set(0);
		cannon.set(0);
		state = CannonState.STOPPED;
	}
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new MoveAndFireTurret());
	}
}
