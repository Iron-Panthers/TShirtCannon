package org.usfirst.frc.team5026.robot.commands;

import org.usfirst.frc.team5026.robot.Robot;
import org.usfirst.frc.team5026.robot.util.CannonState;
import org.usfirst.frc.team5026.robot.util.LEDDisplay;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class LEDController extends Command {

	LEDDisplay led;
	private boolean cycling = false; // Are the leds currently cycling, or are they force set?
	
    public LEDController() {
        // Should require nothing!
    	// Runs all the time
    	led = Robot.hardware.led;
    }

    protected void initialize() {
    	cycling = false;
    }

    protected void execute() {
    	// This will only do it for the cannon!
    	if (!cycling) {
        	led.cycleAll(); // Cycles the leds when not doing anything
    		cycling = true; // Makes sure to only reset the cycle once per shot
    		// TODO: Pick up where it left off (fancy irrelevance)
    	}
    	if (Robot.cannon.state == CannonState.FIRING) {
    		led.setColor(CannonState.FIRING.color);
    		cycling = false;
    	}
    	
//    	led.setColor(Robot.cannon.state.color);
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
