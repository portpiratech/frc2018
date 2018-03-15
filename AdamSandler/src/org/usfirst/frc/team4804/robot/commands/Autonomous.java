package org.usfirst.frc.team4804.robot.commands;

import org.usfirst.frc.team4804.robot.Robot;
import org.usfirst.frc.team4804.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Autonomous extends CommandGroup {

	DigitalInput switch1, switch2, switch3;
	
    public Autonomous(boolean gameDataPresent, boolean switchOnLeftSide) {
    	switch1 = Robot.switch1;
    	switch2 = Robot.switch2;
    	switch3 = Robot.switch3;
    	
    	SmartDashboard.putBooleanArray("Auto switches", new boolean[]{switch1.get(), switch2.get(), switch3.get()});
    	
    	if(gameDataPresent && (switch1.get() || switch3.get()) )
    	{
    		if(switchOnLeftSide)
    		{
    			if(switch1.get()) {
    				addSequential(new Drive(3.0, -0.6, -0.6)); //drive forward for 3 seconds
    				Timer.delay(3.0);
    				addSequential(new LoadUnload(false, 1.0)); //unload cube
    			}
    			else
    			{
    				addSequential(new Drive(3.0, -0.6, -0.6)); //drive forward for 3 seconds
    			}
    		}
    		else
    		{
    			if(switch3.get())
    			{
    				addSequential(new Drive(3.0, -0.6, -0.6)); //drive forward for 3 seconds
    				Timer.delay(3.0);
    				addSequential(new LoadUnload(false, 1.0)); //unload cube
    			}
    			else
    			{
    				addSequential(new Drive(3.0, -0.6, -0.6)); //drive forward for 3 seconds
    			}
    		}
    	}
    	else
    	{
    		addSequential(new Drive(3.0, -0.6, -0.6)); //drive forward for 3 seconds
    	}
    	
    	//Timer.delay(3.0);
    	//addSequential(new LoadUnload(false, 1.0)); //unload cube
    	/*
    	if(switch1.get())
    	{
    		//starting on left side
    		if(leftSide)
    		{
    			//switch on left
    			
        		addSequential(new Drive(1.500, 0.5, 0.5)); //drive forward
            	addSequential(new Drive(true, -90)); //rotate 90 degrees
            	addSequential(new Drive(0.500, -0.5, -0.5)); //drive backward
            	addSequential(new LoadUnload(false)); //unload power cube
    		}
    		else
    		{
    			//switch on right
    			addSequential(new Drive(2.500, 0.5, 0.5)); //drive forward
    		}
    	}
    	else if(switch2.get())
    	{
    		//starting in middle
    		if(leftSide)
    		{
    			//switch on left
    		}
    		else
    		{
    			//switch on right
    		}
    	}
    	else if(switch3.get())
    	{
    		//starting on right side
    		if(leftSide)
    		{
    			//switch on left
    			addSequential(new Drive(2.500, 0.5, 0.5)); //drive forward
    		}
    		else
    		{
    			//switch on right
    			addSequential(new Drive(1.500, 0.5, 0.5)); //drive forward
            	addSequential(new Drive(true, 90)); //rotate 90 degrees
            	addSequential(new Drive(0.500, -0.5, -0.5)); //drive backward
            	addSequential(new LoadUnload(false)); //unload power cube
    		}
    	}
    	*/
    	
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
