package org.usfirst.frc.team4804.robot.subsystems;


import org.usfirst.frc.team4804.robot.CimMotor;
import org.usfirst.frc.team4804.robot.OI;
import org.usfirst.frc.team4804.robot.RobotMap;
import org.usfirst.frc.team4804.robot.commands.Lift;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Lifter extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	private CimMotor motor;
	//private Encoder leftEncoder;
	//private Encoder rightEncoder;
	//currently no encoders on motors, but there might be later
	
	public Lifter(){
		motor = new CimMotor(RobotMap.lifterDriveId);
		//leftEncoder = new Encoder(RobotMap.leftDriveEncoderId);
		//rightEncoder = new Encoder(RobotMap.rightDriveEncoderId);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new Lift());
    }
    
    public void liftDrive() {
    	
    	double liftSpeed = OI.operatorController.getY(Hand.kRight);
    	
    	if(Math.abs(liftSpeed) < 0.2)
    	{
    		liftSpeed = 0;
    	}
    	motor.setSpeed(liftSpeed);

    	
    }
}

