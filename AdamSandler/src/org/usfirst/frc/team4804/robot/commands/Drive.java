package org.usfirst.frc.team4804.robot.commands;

import org.usfirst.frc.team4804.robot.Robot;
import org.usfirst.frc.team4804.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */

public class Drive extends Command {
	
	boolean auto, turn;
	double sec, leftSpeed, rightSpeed, degrees;
	DigitalInput switch1, switch2, switch3;
	
    public Drive() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	this.auto = false;
    	this.turn = false;
    	requires(Robot.driveTrain);
    }
    
    public Drive(double sec, double leftSpeed, double rightSpeed) {
    	requires(Robot.driveTrain);
    	this.auto = true;
    	this.turn = false;
    	this.sec = sec;
    	this.leftSpeed = leftSpeed;
    	this.rightSpeed = rightSpeed;
    }
    
    public Drive(boolean turn, double degrees)
    {
    	requires(Robot.driveTrain);
    	this.auto = true;
    	this.turn = true;
    	this.degrees = degrees;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	switch1 = Robot.switch1;
    	switch2 = Robot.switch2;
    	switch3 = Robot.switch3;
    	
    	SmartDashboard.putBooleanArray("Auto switches", new boolean[]{switch1.get(), switch2.get(), switch3.get()});
    	
    	if(auto) {
    		//auto drive mode
    		if(turn) {
    			//auto turn to input degrees
    			double initAngle = Robot.driveTrain.getGyroAngle();
    			
    			//turn right if degrees > 0, turn left if degrees <= 0
    			if(Math.signum(degrees) == 1.0){
    				Robot.driveTrain.drive(0.5, -0.5);
    			}
    			else {
    				Robot.driveTrain.drive(-0.5, 0.5);
    			}
    			
    			//keep turning until angle reached or command times out
    			double initTime = System.currentTimeMillis();
    			double timeoutMillis = 3000;
    			while(Math.abs(Robot.driveTrain.getGyroAngle() - initAngle) < degrees)
    			{
    				//do nothing
    				if(System.currentTimeMillis() - initTime > timeoutMillis)
    				{
    					break;
    				}
    			}
    		}
    		else {
    			//move at set speeds for specified time
    			Robot.driveTrain.drive(leftSpeed, rightSpeed);
    			Timer.delay(sec);
    		}

			//stop driving
			Robot.driveTrain.drive(0, 0);
    	}
    	else {
    		//manual control
    		Robot.driveTrain.tankArcadeDrive();
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return auto;
    }

    // Called once after isFinished returns true
    protected void end() {
		Robot.driveTrain.drive(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}

