package org.usfirst.frc.team5026.robot.subsystems;

import org.usfirst.frc.team5026.robot.Robot;
import org.usfirst.frc.team5026.robot.commands.MoveAndFireTurret;

import com.ctre.CANTalon;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Cannon extends Subsystem {
	Victor turret;
	public CANTalon cannon;
	DoubleSolenoid sol;

	public Cannon() {
		cannon = Robot.hardware.cannon;
		turret = Robot.hardware.turret;
		sol = Robot.hardware.sol;
		
		cannon.changeControlMode(TalonControlMode.Voltage);
	}
	
	public void pulseCannonMotor(double voltage) {
		cannon.set(voltage);
	}
	
	public void setTurretMotor(double target) {
		turret.set(target);
	}
	public void fireCannon() {
		sol.set(Value.kForward);
	}
	public void stopCannon() {
		sol.set(Value.kReverse);
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
