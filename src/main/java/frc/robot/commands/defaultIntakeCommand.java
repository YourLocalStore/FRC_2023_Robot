package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeSystem;

public class defaultIntakeCommand extends CommandBase{

    public defaultIntakeCommand(IntakeSystem intake){
        addRequirements(intake);
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
