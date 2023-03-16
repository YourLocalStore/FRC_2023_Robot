package frc.robot.commands.elevator;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ElevatorSystem;

public class defaultElevatorCommand extends CommandBase{

    public defaultElevatorCommand(ElevatorSystem elevator){
        addRequirements(elevator);
    }

    @Override
    public void initialize() {
        super.initialize();
    }
    
    @Override
    public void execute() {
        super.execute();
    }

    @Override
    public boolean isFinished() {
        return super.isFinished();
    }
}