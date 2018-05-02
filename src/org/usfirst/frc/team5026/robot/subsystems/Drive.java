package org.usfirst.frc.team5026.robot.subsystems;

import org.usfirst.frc.team5026.util.MotorGroup;
import org.usfirst.frc.team5026.util.MotorType;

import com.ctre.phoenix.motorcontrol.NeutralMode;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Drive extends Subsystem {
	
	/** Left talon */
	private Talon leftTalon;
	/** Right talon */
	private Talon rightTalon;
	
	/** Left motor group. Uses TalonSRXs. */
	private MotorGroup left;
	/** Right motor group. Uses TalonSRXs. */
	private MotorGroup right;
	
	/** Type indicating if using Talons or TalonSRXs */
	private MotorType type;
	
	/**
	 * Constructs the drive subsystem.
	 * 
	 * @param left - speed controllers for the left side of the robot
	 * @param right - speed controllers for the right side of the robot
	 * @param type - Talon or TalonSRX
	 */
	public Drive(SpeedController left, SpeedController right, MotorType type) {
		switch (type) {
			case TALON:
				leftTalon = (Talon) left;
				rightTalon = (Talon) right;
				break;
			case TALONSRX:
				this.left = (MotorGroup) left;
				this.right = (MotorGroup) right;
				break;
			default:
				throw new IllegalArgumentException("No.");
		}
		this.type = type;
	}
	
	/**
	 * Set to brake mode.
	 */
	public void setupBrakeMode() {
		left.setupBrakeMode(NeutralMode.Brake);
		right.setupBrakeMode(NeutralMode.Brake);
	}
	
	/**
	 * Set to coast mode.
	 */
	public void setupCoastMode() {
		left.setupBrakeMode(NeutralMode.Coast);
		right.setupBrakeMode(NeutralMode.Coast);
	}
	
	/**
	 * Sets power to the left side of the robot.
	 * 
	 * @param power
	 */
	public void setLeftSide(double power){
		double speed = power > 1 ? 1 : power < -1 ? -1 : power;
		if (type == MotorType.TALON) leftTalon.set(speed);
		else if (type == MotorType.TALONSRX) left.set(speed);
	}
	
	/**
	 * Sets power to the right side of the robot.
	 * 
	 * @param power
	 */
	public void setRightSide(double power){
		double speed = power > 1 ? 1 : power < -1 ? -1 : power;
		if (type == MotorType.TALON) rightTalon.set(speed);
		else if (type == MotorType.TALONSRX) right.set(speed);
	}
	
	/**
	 * Drives with a target if using TalonSRXs.
	 * 
	 * @param target - target in ticks
	 */
	public void driveWithTarget(double target) {
		if (type == MotorType.TALON) return;
		left.driveWithTarget(target);
		right.driveWithTarget(target);
	}
	
	/**
	 * 
	 * Returns encoder ticks on the left side.
	 * 
	 * @return encoder ticks on the left side if using TalonSRXs, 0 if using talons
	 */
	public double getLeftEncoderPosition() {
		return type == MotorType.TALONSRX ? left.getEncoderTicks() : 0;
	}
	
	/**
	 * Returns encoder ticks on the right side.
	 * 
	 * @return encoder ticks on the right side if using TalonSRXs, 0 if using talons
	 */
	public double getRightEncoderPosition() {
		return type == MotorType.TALONSRX ? right.getEncoderTicks() : 0;
	}
	
	/**
	 * Stops the motors.
	 */
	public void stop() {
		if (type == MotorType.TALONSRX) {
			left.stopMotor();
			right.stopMotor();
		}
		else if (type == MotorType.TALON) {
			leftTalon.set(0);
			rightTalon.set(0);
		}
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
