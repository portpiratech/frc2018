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
	
	private static final int MAX_COUNT = 175;
	
    public Grab(boolean open) {
    	
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.grabber);
    	this.open = open;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	isTurning = true;
    	Robot.grabber.resetCount();
    	double speed = 0.75;
    	if(open) {
    		Robot.grabber.close(-1*speed);
    	} else {
    		Robot.grabber.close(speed);
    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
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
    

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        //return !isTurning || Robot.grabber.getCount() > MAX_COUNT || Robot.grabber.getCount() < 0;
    	return !(OI.operatorController.getAButton() || OI.operatorController.getBButton());
    			
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
    }
} 