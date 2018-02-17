package org.usfirst.frc.team4804.robot.commands;

import org.usfirst.frc.team4804.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */

public class Drive extends Command {
	
	boolean auto;
	double sec, leftSpeed, rightSpeed;
	
    public Drive() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	auto = false;
    	requires(Robot.driveTrain);
    }
    
    public Drive(double sec, double leftSpeed, double rightSpeed) {
    	requires(Robot.driveTrain);
    	auto = true;
    	this.sec = sec;
    	this.leftSpeed = leftSpeed;
    	this.rightSpeed = rightSpeed;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(auto) {
    		Robot.driveTrain.drive(leftSpeed, rightSpeed);
    		Timer.delay(sec);
    	}
    	else {
    		Robot.driveTrain.tankArcadeDrive();
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return auto;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}

