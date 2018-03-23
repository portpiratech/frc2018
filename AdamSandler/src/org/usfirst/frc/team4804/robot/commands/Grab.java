package org.usfirst.frc.team4804.robot.commands;
import org.usfirst.frc.team4804.robot.OI;
import org.usfirst.frc.team4804.robot.Robot;
import org.usfirst.frc.team4804.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Grab extends Command {

	private boolean isTurning;
	private boolean open;
	private boolean auto;
	private boolean aLastPressed;
	
	private static final int MAX_COUNT = 175;
	
    public Grab(boolean open, boolean auto) {
    	
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.grabber);
    	this.open = open;
    	this.auto = auto;
    }
    
    public Grab() {
    	requires(Robot.grabber);
    	this.auto = false;
    	this.aLastPressed = true;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	if(auto)
    	{
	    	isTurning = true;
	    	Robot.grabber.resetCount();
	    	double speed = 0.75;
	    	if(open) {
	    		Robot.grabber.close(-1*speed);
	    	} else {
	    		Robot.grabber.close(speed);
	    	}
    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(auto)
    	{
    		Robot.grabber.count();
	    	System.out.println(Robot.grabber.getMotorCurrent());
	    	SmartDashboard.putNumber("Grabber count", Robot.grabber.getCount());
	    	SmartDashboard.putNumber("Grabber current", Robot.grabber.getMotorCurrent());
	    	/*if(Robot.grabber.getMotorCurrent() >= RobotMap.grabberMaxCurrent){
	    		isTurning = false;    	
	    	} else {
	    		isTurning = true;
	    	}*/
	    	
	    	SmartDashboard.putBoolean("Is turning", isTurning);
	    	SmartDashboard.putNumber("Grabber speed", Robot.grabber.getMotorOutputPercent());
    	}
    	else
    	{
    		if(OI.operatorController.getAButton())
    		{
    			//ungrab
    	    	Robot.grabber.close(-RobotMap.ungrabSpeed);
    	    	aLastPressed = true;
    		}
    		else if(OI.operatorController.getBButton())
    		{
    			//grab
    			Robot.grabber.close(RobotMap.grabSpeed);
    			aLastPressed = false;
    		}
    		else
    		{
    			if(!aLastPressed && !OI.operatorController.getAButton())
    			{
    				//keep trying to grab
    				Robot.grabber.close(RobotMap.holdSpeed);
    			}
    			else if(aLastPressed && !OI.operatorController.getBButton())
    			{
    				Robot.grabber.close(0);
    			}
    		}
    	}
    }
    

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        //return !isTurning || Robot.grabber.getCount() > MAX_COUNT || Robot.grabber.getCount() < 0;
    	return (auto && !(OI.operatorController.getAButton() || OI.operatorController.getBButton()));
    			
    }

    // Called once after isFinished returns true
    protected void end() {
    	isTurning = false;
    	SmartDashboard.putBoolean("Is turning", isTurning);
    	if(open) {
    		Robot.grabber.close(0);
    	}
    	else{
    		Robot.grabber.close(0.45);
    	}
    	SmartDashboard.putNumber("Grabber speed", Robot.grabber.getMotorOutputPercent());
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	//Robot.grabber.close(0);
    }
} 