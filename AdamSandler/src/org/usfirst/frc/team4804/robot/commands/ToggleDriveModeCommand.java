package org.usfirst.frc.team4804.robot.commands;

import org.usfirst.frc.team4804.robot.Robot;
import org.usfirst.frc.team4804.robot.RobotMap;
import org.usfirst.frc.team4804.robot.subsystems.ToggleDriveModeSubsystem;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ToggleDriveModeCommand extends Command {
	
	
    public ToggleDriveModeCommand() {
        // Use requires() here to declare subsystem dependencies
    	requires(Robot.toggleDriveMode);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.toggleDriveMode.toggleDriveMode();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
