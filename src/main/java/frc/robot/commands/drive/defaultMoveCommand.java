package frc.robot.commands.drive;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSystem;
import frc.robot.Robot;

public class defaultMoveCommand extends CommandBase{

    private DriveSystem m_drive;

    public defaultMoveCommand(DriveSystem drive){
        super();
        m_drive = drive;
        addRequirements(drive);
    }

    @Override
    public void initialize() {
    }
    
    @Override
    public void execute() {
        m_drive.OperateArcade(Robot.D_CONTROL().getLeftY(), Robot.D_CONTROL().getRightX());
        
    }

    @Override
    public boolean isFinished() {
        return false;

        
    }
}
