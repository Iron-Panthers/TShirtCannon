package org.usfirst.frc.team5026.robot.subsystems;

import org.usfirst.frc.team5026.robot.Robot;
import org.usfirst.frc.team5026.robot.commands.MoveAndFireTurret;

import com.ctre.CANTalon;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Cannon extends Subsystem {
	CANTalon turret;
	CANTalon cannon;

	public Cannon() {
		cannon = Robot.hardware.cannon;
		turret = Robot.hardware.turret;
		
		cannon.changeControlMode(TalonControlMode.Voltage);
	}
	
	public void pulseCannonMotor(double voltage) {
		cannon.set(voltage);
	}
	
	public void setTurretMotor(double target) {
		turret.set(target);
	}
	
	public void stopMotors() {
		turret.set(0);
		cannon.set(0);
	}
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new MoveAndFireTurret());
	}
}
