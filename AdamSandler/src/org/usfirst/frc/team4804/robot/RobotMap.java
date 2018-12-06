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
	
	/*** DEVICE IDENTIFICATION NUMBERS/CHANNELS ***/
	//XBox controller IDs & axis IDs
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
	 * Else: Encoders?
	 */
	public static int lifterDriveId = 5;
	public static int leftDriveId = 4;
	public static int rightDriveId = 6;
	public static int grabberId = 2;
	public static int conveyorId = 3;
	public static int leftDriveEncoderId = 7;//7 and 8 aren't determined yet
	public static int rightDriveEncoderId = 8;
	
	//PWM (pulse width modulation) channels
	public static int sparkId = 0;
	
	//DIO (digital input/output) channels
	public static int posSwitch1 = 0;
	public static int posSwitch2 = 1;
	public static int posSwitch3 = 2;
	public static int conveyorLimitId = 11;//still not determined
	
	//Analog input devices
	public static int grabberEncoderId = 1;
	
	/*** VARIABLE VALUES FOR SUBSYSTEMS/COMMANDS ***/
	//Autonomous
	public static double autonomousDelaySeconds = 2.0;
	public static double autonomousLengthSeconds = 2.0;
	
	//DriveTrain
	public static double driveSpeedMultiplier = .5;
	public static double driveSpeedDeadband = 0.1; //won't drive unless speed >= this value
	
	//Conveyor
	public static double loadSpeed = .6;
	public static double unloadSpeed = .75;
	
	//Grabber
	public static int grabberMaxCurrent = 5;
	public static double grabSpeed = 0.9;
	public static double holdSpeed = 0.6;
	public static double ungrabSpeed = 0.9;
	
	//Lifter
	public static double lifterSpeedMultiplier = 1.0;
	public static double lifterSpeedDeadband = 0.15; //won't drive unless speed >= this value
}
