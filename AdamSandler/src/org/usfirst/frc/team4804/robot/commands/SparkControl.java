package org.usfirst.frc.team4804.robot.commands;

import org.usfirst.frc.team4804.robot.OI;
import org.usfirst.frc.team4804.robot.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SparkControl extends Command {
	
	private double speed;
	
	public SparkControl() {
		requires(Robot.sparkSubsystem);
		this.speed = 0;
	}
	
    /*public SparkControl(double speed) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.sparkSubsystem);
    	this.speed = speed;
    }*/

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//negative value to spark only when both triggers pressed & match time < 30 sec
    	if(DriverStation.getInstance().getMatchTime() < 30.0)
    	{
    		double left = OI.operatorController.getTriggerAxis(Hand.kLeft);
    		double right = OI.operatorController.getTriggerAxis(Hand.kRight);
    		if(left > 0.9 && right > 0.9)
    		{
    			Robot.sparkSubsystem.setSpark(-1.0);
    		}
    	}
    	else
    	{
    		Robot.sparkSubsystem.setSpark(1.0);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
