package org.usfirst.frc.team4804.robot.commands;

import org.usfirst.frc.team4804.robot.OI;
import org.usfirst.frc.team4804.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class LoadUnload extends Command {
	
	private boolean isLoad, auto, finished;
	private double sec;
	
    public LoadUnload(boolean isLoad) {
        // Use requires() here to declare subsystem dependencies
        this.isLoad = isLoad;   
        auto = false;
    	requires(Robot.conveyor);
    }
    
    public LoadUnload(boolean isLoad, double timeSec)
    {
    	this.isLoad = isLoad;
    	sec = timeSec;
    	auto = true;
    	requires(Robot.conveyor);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(isLoad == true){
    		Robot.conveyor.load();//tweak later
    	}
    	else{
    		Robot.conveyor.unload();//tweak later
    	}
    	
    	if(auto){
    		Timer.delay(sec);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (!auto && !(OI.operatorController.getXButton() || OI.operatorController.getYButton()))
        		|| (auto);
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.conveyor.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
