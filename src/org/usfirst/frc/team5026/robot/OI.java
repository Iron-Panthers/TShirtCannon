package org.usfirst.frc.team5026.robot;

import org.usfirst.frc.team5026.robot.subsystems.PantherJoystick;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

// import org.usfirst.frc.team5026.robot.commands.ExampleCommand;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	public PantherJoystick driveStick;
	public PantherJoystick shootStick;
	
	public Button shootButton1;
	
	public OI() {
		driveStick = new PantherJoystick(RobotMap.DRIVE_STICK);
		shootStick = new PantherJoystick(RobotMap.SHOOT_STICK);
	}
	
	public void initButtons() {
		shootButton1 = new JoystickButton(shootStick, RobotMap.SHOOT_BUTTON);
	}
}
