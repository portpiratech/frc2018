package org.usfirst.frc.team4804.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	//Trying to fix merge conflicts
	// public static int rangefinderModule = 1;
	
	//XBox controller IDs
	public static int driverControllerId = 0;
	public static int operatorControllerId = 1;
	public static int leftStickXId = 0;
	public static int leftStickYId = 1;
	public static int rightStickXId = 4;
	public static int rightStickYId = 5;
	
	//CANbus device IDs
	/* 0: PDP
	 * 1: PCM
	 * 2-6: TalonSRX
	 */
	public static int lifterDriveId = 5;//unsure
	public static int leftDriveId = 12;
	public static int rightDriveId = 13;
	public static int leftDriveEncoderId = 7;//7 and 8 aren't determined yet
	public static int rightDriveEncoderId = 8;
	public static int grabberId = 2;//should be 3
	public static int conveyorId = 3;//should be 2
	
	//PWM
	public static int sparkId = 0;
	
	//DIO
	public static int conveyorLimitId = 11;//still not determined
	public static int posSwitch1 = 0;
	public static int posSwitch2 = 1;
	public static int posSwitch3 = 2;
	
	//DriveTrain
	public static double driveSpeedMultiplier = 1.0;
	
	//Conveyor
	public static double loadSpeed = .3;
	public static double unloadSpeed = .75;
	
	//Grabber
	public static int grabberMaxCurrent = 5;
	public static int grabberEncoderId = 1;
	
}
