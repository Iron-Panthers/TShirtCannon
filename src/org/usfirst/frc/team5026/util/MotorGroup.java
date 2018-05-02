package org.usfirst.frc.team5026.util;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.StatusFrameEnhanced;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class MotorGroup implements SpeedController {
	
	/** First motor */
	private TalonSRX motor1; 
	/** Second motor */
	private TalonSRX motor2;
	/** Third motor */
	private TalonSRX motor3;
	/** Motors in an array */
	private TalonSRX[] motors;

	/**
	 * Constructs a motor group consisting of three TalonSRXs.
	 * 
	 * @param motor1
	 * @param motor2
	 * @param motor3
	 */
	public MotorGroup(TalonSRX motor1, TalonSRX motor2, TalonSRX motor3) {
		this.motor1 = motor1;
		this.motor2 = motor2;
		this.motor3 = motor3;
		motors = new TalonSRX[3];
		motors[0] = this.motor1;
		motors[1] = this.motor2;
		motors[2] = this.motor3;
		this.motor2.follow(motor1);
		this.motor3.follow(motor1);
		setUp(motor1, motor2, motor3);
	}
	
	/**
	 * Sets up the motors.
	 * 
	 * @param masterMotor - the master motor
	 * @param motors - slave motors
	 */
	private void setUp(TalonSRX masterMotor, TalonSRX... motors) {
		masterMotor.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, Constants.kPIDLoopIdx, Constants.kTimeoutMs);
		masterMotor.setSensorPhase(true);
		masterMotor.setInverted(false);
		
		masterMotor.setStatusFramePeriod(StatusFrameEnhanced.Status_13_Base_PIDF0, 10, Constants.kTimeoutMs);
		masterMotor.setStatusFramePeriod(StatusFrameEnhanced.Status_10_MotionMagic, 10, Constants.kTimeoutMs);
		
		masterMotor.configNominalOutputForward(0, Constants.kTimeoutMs);
		masterMotor.configNominalOutputReverse(0, Constants.kTimeoutMs);
		masterMotor.configPeakOutputForward(1, Constants.kTimeoutMs);
		masterMotor.configPeakOutputReverse(-1, Constants.kTimeoutMs);
		
		masterMotor.selectProfileSlot(Constants.kSlotIdx, Constants.kTimeoutMs);
		masterMotor.config_kF(0, Constants.DRIVE_F, Constants.kTimeoutMs);
		masterMotor.config_kP(0, Constants.DRIVE_P, Constants.kTimeoutMs);
		masterMotor.config_kI(0, Constants.DRIVE_I, Constants.kTimeoutMs);
		masterMotor.config_kD(0, Constants.DRIVE_D, Constants.kTimeoutMs);
		
		masterMotor.configMotionCruiseVelocity(Constants.DRIVE_VELOCITY, Constants.kTimeoutMs);
		masterMotor.configMotionAcceleration(Constants.DRIVE_ACCELERATION, Constants.kTimeoutMs);

		for (int i = 0; i < motors.length; i++) motors[i].follow(masterMotor);
		motor1 = masterMotor;
		this.motors = motors;
	}
	
	/**
	 * Sets to brake or coast mode.
	 * 
	 * @param mode - brake or coast
	 */
	public void setupBrakeMode(NeutralMode mode) {
		motor1.setNeutralMode(mode);
		for (TalonSRX s : motors) {
			s.setNeutralMode(mode);
		}
	}
	
	/**
	 * Drives with a target.
	 * 
	 * @param target - target in ticks
	 */
	public void driveWithTarget(double target) {
		motor1.set(ControlMode.MotionMagic, target);
		SmartDashboard.putNumber("Motor "+motor1.getDeviceID(), motor1.getMotorOutputPercent());
		for (TalonSRX t : motors) {
			SmartDashboard.putNumber("Motor "+t.getDeviceID(), t.getMotorOutputPercent());
		}
	}
	
	/**
	 * Returns the encoder reading.
	 * 
	 * @return encoder ticks
	 */
	public int getEncoderTicks() {
		return this.motor1.getSelectedSensorPosition(Constants.kSlotIdx);
	}

	@Override
	public void pidWrite(double output) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void set(double speed) {
		motor1.set(ControlMode.PercentOutput, speed);
		for (TalonSRX t : motors) {
			SmartDashboard.putNumber("Motor "+t.getDeviceID(), t.getMotorOutputPercent());
		}
		
	}

	@Override
	public double get() {
		return motor1.getMotorOutputPercent();
	}

	@Override
	public void setInverted(boolean isInverted) {
		motor1.setSensorPhase(!isInverted);
	}

	@Override
	public boolean getInverted() {
		return motor1.getInverted();
	}

	@Override
	public void disable() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stopMotor() {
		set(0);
	}

}
