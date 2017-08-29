package org.usfirst.frc.team5026.robot.subsystems;

import org.usfirst.frc.team5026.robot.Robot;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Cannon extends Subsystem{

	public Cannon(Victor t, Victor c) {
		
		t = Robot.hardware.turret;
		c = Robot.hardware.cannon;
	}
	
	public void setCannonMotor(double cannon) {            
		Robot.hardware.cannon.set(cannon);
	}
	
	public void setTurretMotor(double turret) {
		Robot.hardware.turret.set(turret);
	}
	
	public void stopMotors() {
		Robot.hardware.turret.set(0);
		Robot.hardware.cannon.set(0);
	}
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
}
