package org.usfirst.frc.team5026.robot.commands;

import org.usfirst.frc.team5026.robot.Robot;
import org.usfirst.frc.team5026.robot.util.Color;
import org.usfirst.frc.team5026.robot.util.LEDDisplay;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class LEDController extends Command {

	LEDDisplay led;
	
    public LEDController() {
        // Should require nothing!
    	// Runs all the time
    	led = Robot.hardware.led;
    }

    protected void initialize() {
    	
    }

    protected void execute() {
    	// This will only do it for the cannon!
    	led.setColor(Robot.cannon.state.color);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	// Never ends, doesn't matter if it does
    }

    protected void interrupted() {
    	
    }
}
