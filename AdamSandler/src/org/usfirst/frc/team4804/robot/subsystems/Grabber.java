package org.usfirst.frc.team4804.robot.subsystems;

import org.usfirst.frc.team4804.robot.OI;
import org.usfirst.frc.team4804.robot.RobotMap;
import org.usfirst.frc.team4804.robot.SeatMotor;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Grabber extends Subsystem {
	//This is a very basic version of grabber's program
	
	private SeatMotor grabberMotor;
	private Encoder grabVoltage;
	
	/*public Grabber(){
		public grabberMotor = new SeatMotor(RobotMap.grabberId);
		
	}*/
	
	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
    }
	
	public void close() {
    	double clamp = OI.operatorController.getY(Hand.kLeft);
	}
	
	
	

}

