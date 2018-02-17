package org.usfirst.frc.team4804.robot.subsystems;


import org.usfirst.frc.team4804.robot.RobotMap;
import org.usfirst.frc.team4804.robot.SeatMotor;
import edu.wpi.first.wpilibj.AnalogTrigger;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Grabber extends Subsystem {
	//This is a very basic version of grabber's program
	
	private SeatMotor grabberMotor;
	private AnalogTrigger grabberAnalogTrigger;
	private int count;
	private boolean encState;
	
	
	//Encoder is 174.9:1 gear ratio (174.9 counts per revolution)
	//(50ish reads per second)/(174.9 counts) = 0.285 speed necessary for full encoder resolution
	
	
	public Grabber(){
		grabberMotor = new SeatMotor(RobotMap.grabberId);
		grabberAnalogTrigger = new AnalogTrigger(RobotMap.grabberEncoderId);
		grabberAnalogTrigger.setLimitsVoltage(3.0, 3.75);		
		count = 0;
		encState = getEncoderState();
		grabberMotor.getMotor().enableCurrentLimit(true);
		grabberMotor.getMotor().configPeakCurrentLimit(0, 0);
		grabberMotor.getMotor().configContinuousCurrentLimit(RobotMap.grabberMaxCurrent, 500);
		
	}
	
	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
		//setDefaultCommand(new Grab());
    }
	
	public void close(double setSpeed) {
		grabberMotor.setSpeed(setSpeed);
	}

	public void smartDashboardOutput() {
		SmartDashboard.putNumber("Seat motor encoder index", grabberAnalogTrigger.getIndex());
    	SmartDashboard.putBoolean("Seat motor encoder bool", getEncoderState());
    	SmartDashboard.putNumber("Seat motor encoder count test", count);
    
	}
	
	public double getMotorCurrent() {
		return grabberMotor.getMotor().getOutputCurrent();
	}
	
	public boolean getEncoderState(){
		 return grabberAnalogTrigger.getTriggerState();
	}
	
	public double getMotorOutputPercentSignum() {
		return Math.signum(grabberMotor.getMotor().getMotorOutputPercent());
	}
	
	public void count() {
		System.out.println(count);
		//Catches the rising edges
		if(encState != getEncoderState() && getEncoderState()) { 
			count += (int) getMotorOutputPercentSignum();
		}
		encState = getEncoderState();
		
		//if it is supposed to have 175 pulses(i'm not entirely sure) it worked at ~1/4 speed
	}

	public void resetCount() {
		count = 0;
	}

	public int getCount() {
		return count;
	}
	

}

