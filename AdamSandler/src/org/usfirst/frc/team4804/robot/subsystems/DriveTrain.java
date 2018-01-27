/*package org.usfirst.frc.team4804.robot.subsystems;

import org.usfirst.frc.team4804.robot.CimMotor;
import org.usfirst.frc.team4804.robot.OI;
import org.usfirst.frc.team4804.robot.RobotMap;
import org.usfirst.frc.team4804.robot.commands.Drive;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Subsystem;



public class DriveTrain extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	
	private CimMotor leftMotor;
	private CimMotor rightMotor;
	//private Encoder leftEncoder;
	//private Encoder rightEncoder;
	//currently no encoders on motors, but there might be later
	
	public DriveTrain(){
		leftMotor = new CimMotor(RobotMap.leftDriveId);
		rightMotor = new CimMotor(RobotMap.rightDriveId);
		//leftEncoder = new Encoder(RobotMap.leftDriveEncoderId);
		//rightEncoder = new Encoder(RobotMap.rightDriveEncoderId);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new Drive());
    }
    
    public void tankDrive() {
    	double leftY = -OI.driverController.getY(Hand.kLeft);
    	double rightY = OI.driverController.getY(Hand.kRight);
    	
    	double leftSpeed = leftY * RobotMap.driveSpeedMultiplier;
    	double rightSpeed = rightY * RobotMap.driveSpeedMultiplier;
    	
    	leftMotor.setSpeed(leftSpeed);
    	rightMotor.setSpeed(rightSpeed);
    	
    	
    	
    	
    }
}


*/