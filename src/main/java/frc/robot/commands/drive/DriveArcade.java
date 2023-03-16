package frc.robot.commands.drive;


import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSystem;
import frc.robot.constants;

public class DriveArcade extends CommandBase{

    private DriveSystem m_drive;

    public DriveArcade(DriveSystem drive){
        super();
        m_drive = drive;
        addRequirements(drive);
    }

    @Override
    public void initialize() {
    }
    
    @Override
    public void execute() {
        m_drive.OperateArcade(constants.D_CONTROL.getLeftY(), constants.D_CONTROL.getRightX());
        
    }

    @Override
    public boolean isFinished() {
        return false;

        
    }
}
