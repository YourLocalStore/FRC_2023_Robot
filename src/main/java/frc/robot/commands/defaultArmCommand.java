package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ArmSystem;

public class defaultArmCommand extends CommandBase{

    public defaultArmCommand(ArmSystem arm){
        addRequirements(arm);
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