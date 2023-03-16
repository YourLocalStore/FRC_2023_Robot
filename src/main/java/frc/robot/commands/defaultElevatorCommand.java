package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ElevatorSystem;

public class defaultElevatorCommand extends CommandBase{

    public defaultElevatorCommand(ElevatorSystem elevator){
        addRequirements(elevator);
    }

    @Override
    public void initialize() {
        // TODO Auto-generated method stub
        super.initialize();
    }
    
    @Override
    public void execute() {
        // TODO Auto-generated method stub
        super.execute();
    }

    @Override
    public boolean isFinished() {
        // TODO Auto-generated method stub
        return super.isFinished();
    }
}