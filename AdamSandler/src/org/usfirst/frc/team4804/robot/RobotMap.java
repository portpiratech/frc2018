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
	 * 11-14: TalonSRX
	 */
	public static int leftDriveId = 11;
	public static int rightDriveId = 14;
}
