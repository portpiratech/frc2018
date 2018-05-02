package org.usfirst.frc.team4804.robot.subsystems;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

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
	private ADXRS450_Gyro gyro;
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public DriveTrainV2(){
		leftMotor = new CimMotor(RobotMap.leftDriveId);
		rightMotor = new CimMotor(RobotMap.rightDriveId);
		gyro = new ADXRS450_Gyro();
	}


    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new Drive());
    }
    
    public void resetGyro() {
    	gyro.reset();
    }
    
    public double getGyroAngle() {
    	return gyro.getAngle();
    }
    
    public double getGyroRate() {
    	return gyro.getRate();
    }
    
    public void drive(double leftSpeed, double rightSpeed) {
    	leftMotor.setSpeed(-leftSpeed);
    	rightMotor.setSpeed(rightSpeed);
    }
    
    public void tankArcadeDrive() {
    	double leftSpeed, rightSpeed;
    	
    	if(Robot.driveMode == Robot.DriveMode.ArcadeDrive)
    	{
    		double turnValue = -OI.driverController.getX(Hand.kLeft);
        	double throttleValue = OI.driverController.getY(Hand.kLeft);
        	
        	leftSpeed = (turnValue-throttleValue)*RobotMap.driveSpeedMultiplier;
        	rightSpeed = (turnValue+throttleValue)*RobotMap.driveSpeedMultiplier;
    	}
    	else
    	{
    		RobotMap.driveSpeedMultiplier = SmartDashboard.getNumber("Drive speed", RobotMap.driveSpeedMultiplier);
    		double leftY = -OI.driverController.getY(Hand.kLeft);
        	double rightY = OI.driverController.getY(Hand.kRight);
        	
        	leftSpeed = leftY * RobotMap.driveSpeedMultiplier;
        	rightSpeed = rightY * RobotMap.driveSpeedMultiplier;
    	}
    	
    	//press right bumper for halfspeed
    	boolean halfSpeed  = OI.driverController.getBumper(Hand.kRight);
    	if(halfSpeed)
    	{	
    		leftSpeed /= 2;
    		rightSpeed /= 2;
    	}
    	
    	leftMotor.setSpeed(leftSpeed, RobotMap.driveSpeedDeadband);
    	rightMotor.setSpeed(rightSpeed, RobotMap.driveSpeedDeadband);
    	
    	displayCurrent();
    }
    
    public void displayCurrent() {
    	SmartDashboard.putNumber("Left drive current", leftMotor.getMotor().getOutputCurrent());
    	SmartDashboard.putNumber("Right drive current", rightMotor.getMotor().getOutputCurrent());
    }
}

