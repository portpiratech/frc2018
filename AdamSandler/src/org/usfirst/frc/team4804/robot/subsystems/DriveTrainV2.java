package org.usfirst.frc.team4804.robot.subsystems;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team4804.robot.CimMotor;
import org.usfirst.frc.team4804.robot.OI;
import org.usfirst.frc.team4804.robot.Robot;
import org.usfirst.frc.team4804.robot.RobotMap;
import org.usfirst.frc.team4804.robot.commands.Drive;

/**
 *
 */
public class DriveTrainV2 extends Subsystem {

	private CimMotor leftMotor;
	private CimMotor rightMotor;
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public DriveTrainV2(){
		leftMotor = new CimMotor(RobotMap.leftDriveId);
		rightMotor = new CimMotor(RobotMap.rightDriveId);
		
	}


    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new Drive());
    }
    
    public void tankArcadeDrive() {

    	if(Robot.driveMode == Robot.DriveMode.ArcadeDrive)
    	{
    		double turnValue = OI.driverController.getX(Hand.kLeft);
        	double throttleValue = OI.driverController.getY(Hand.kLeft);
        	
        	double leftValue = -(turnValue+throttleValue)*RobotMap.driveSpeedMultiplier;
        	double rightValue = -(turnValue-throttleValue)*RobotMap.driveSpeedMultiplier;
        	
        	boolean halfSpeed  = OI.driverController.getBumper(Hand.kRight);
        	
        	if(halfSpeed)
        	{	
        		leftMotor.setSpeed(leftValue/2);
        		rightMotor.setSpeed(rightValue/2);
        	}
        	else
        	{
        		leftMotor.setSpeed(leftValue);
            	rightMotor.setSpeed(rightValue); 
        	}
        	
    	}
    	else
    	{
    		double leftY = -OI.driverController.getY(Hand.kLeft);
        	double rightY = OI.driverController.getY(Hand.kRight);
        	
        	double leftSpeed = leftY * RobotMap.driveSpeedMultiplier;
        	double rightSpeed = rightY * RobotMap.driveSpeedMultiplier;
        	
        	boolean halfSpeed = OI.driverController.getBumper(Hand.kRight);
        	
        	if(halfSpeed)
        	{
        		leftMotor.setSpeed(leftSpeed/2);
            	rightMotor.setSpeed(rightSpeed/2);
        	}
        	else
        	{
        		leftMotor.setSpeed(leftSpeed);
            	rightMotor.setSpeed(rightSpeed);
        	}
        	
    	}
    }
}

