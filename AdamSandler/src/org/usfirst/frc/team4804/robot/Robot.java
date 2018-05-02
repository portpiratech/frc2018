
package org.usfirst.frc.team4804.robot;

import org.usfirst.frc.team4804.robot.commands.Autonomous;
import org.usfirst.frc.team4804.robot.subsystems.Conveyor;
import org.usfirst.frc.team4804.robot.subsystems.DriveTrainV2;
import org.usfirst.frc.team4804.robot.subsystems.Grabber;
import org.usfirst.frc.team4804.robot.subsystems.Lifter;
import org.usfirst.frc.team4804.robot.subsystems.SparkSubsystem;
//import org.usfirst.frc.team4804.robot.subsystems.Grabber;
import org.usfirst.frc.team4804.robot.subsystems.ToggleDriveModeSubsystem;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	
	public static DriveMode driveMode;
	
	public static enum DriveMode {
		TankDrive,
		ArcadeDrive
	}

	public static final DriveTrainV2 driveTrain = new DriveTrainV2();
	public static ToggleDriveModeSubsystem toggleDriveMode = new ToggleDriveModeSubsystem();
	public static Conveyor conveyor = new Conveyor();
	public static Grabber grabber = new Grabber();
	public static Lifter lifter = new Lifter();
	public static SparkSubsystem sparkSubsystem = new SparkSubsystem();
	public static OI oi;
	
	private Command autonomousCommand;
	private SendableChooser<Command> chooser = new SendableChooser<>();
	
	public static DigitalInput switch1, switch2, switch3;
	
	
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		oi = new OI();
		Robot.driveMode = Robot.DriveMode.TankDrive;
		// chooser.addDefault("Default Auto", new ExampleCommand());
		// chooser.addObject("My Auto", new MyAutoCommand());
		//SmartDashboard.putData("Auto mode", chooser);
		
		switch1 = new DigitalInput(RobotMap.posSwitch1);
    	switch2 = new DigitalInput(RobotMap.posSwitch2);
    	switch3 = new DigitalInput(RobotMap.posSwitch3);
    	
    	initializeSmartDashboard();
	}
	
	private void initializeSmartDashboard()
	{
		SmartDashboard.putBoolean("Auto switch 1", switch1.get());
    	SmartDashboard.putBoolean("Auto switch 2", switch2.get());
    	SmartDashboard.putBoolean("Auto switch 3", switch3.get());
    	SmartDashboard.putNumber("Load speed", RobotMap.loadSpeed);
    	SmartDashboard.putNumber("Unload speed", RobotMap.unloadSpeed);
    	SmartDashboard.putNumber("Grab speed", RobotMap.grabSpeed);
    	SmartDashboard.putNumber("Hold speed", RobotMap.holdSpeed);
    	SmartDashboard.putNumber("Ungrab speed", RobotMap.ungrabSpeed);
    	SmartDashboard.putNumber("Auto delay", RobotMap.autonomousDelaySeconds);
	}
	
	private void readFromSmartDashboard()
	{
		RobotMap.loadSpeed = SmartDashboard.getNumber("Load speed", RobotMap.loadSpeed);
    	RobotMap.unloadSpeed = SmartDashboard.getNumber("Unload speed", RobotMap.unloadSpeed);
    	RobotMap.grabSpeed = SmartDashboard.getNumber("Grab speed", RobotMap.grabSpeed);
    	RobotMap.holdSpeed = SmartDashboard.getNumber("Hold speed", RobotMap.holdSpeed);
    	RobotMap.ungrabSpeed = SmartDashboard.getNumber("Ungrab speed", RobotMap.ungrabSpeed);
    	RobotMap.autonomousDelaySeconds = SmartDashboard.getNumber("Auto delay", RobotMap.autonomousDelaySeconds);
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
		SmartDashboard.putBoolean("Auto switch 1", switch1.get());
    	SmartDashboard.putBoolean("Auto switch 2", switch2.get());
    	SmartDashboard.putBoolean("Auto switch 3", switch3.get());
    	readFromSmartDashboard();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		//gameData is a string relative to the alliance color; "ABC" where A = closest switch, B = scale, C = furthest switch
		//A, B, C are either L (left) or R (right)
		
		
		//************Commented out to test if this was causing the robot to not move
		/*
		String gameData = DriverStation.getInstance().getGameSpecificMessage();
		boolean gameDataPresent = gameData.length() > 0;
		boolean leftSide = true;
		
		if(gameDataPresent && gameData.charAt(0) == 'L')
		{
			//Put left auto code here
			leftSide = true;
		} else if(gameDataPresent && gameData.charAt(0) == 'R') {
			//Put right auto code here
			leftSide = false;
		}
		
		autonomousCommand = new Autonomous(gameDataPresent, leftSide);
		*/
		//************Commented out to test if this was causing the robot to not move
		
		autonomousCommand = new Autonomous(true, false);
		
		//autonomousCommand = chooser.getSelected();
		//autonomousCommand = new Autonomous(true);
		
		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		SmartDashboard.putBoolean("Auto switch 1", switch1.get());
    	SmartDashboard.putBoolean("Auto switch 2", switch2.get());
    	SmartDashboard.putBoolean("Auto switch 3", switch3.get());
    	readFromSmartDashboard();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		SmartDashboard.putBoolean("Auto switch 1", switch1.get());
    	SmartDashboard.putBoolean("Auto switch 2", switch2.get());
    	SmartDashboard.putBoolean("Auto switch 3", switch3.get());
    	readFromSmartDashboard();
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		//LiveWindow.run();
	}
}
