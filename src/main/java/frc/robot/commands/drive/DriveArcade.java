package frc.robot.commands.drive;

import edu.wpi.first.hal.simulation.RoboRioDataJNI;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSystem;
import frc.robot.subsystems.IntakeSystem;
import frc.robot.Robot;

public class DriveArcade extends CommandBase{

    private DriveSystem m_drive;

    public DriveArcade(DriveSystem drive){
        super();
        m_drive = drive;
        addRequirements(drive);
    }

    @Override
    public void initialize() {
        // TODO Auto-generated method stub
    }
    
    @Override
    public void execute() {
        // TODO Auto-generated method stub
        m_drive.OperateArcade(Robot.D_CONTROL().getLeftY(), Robot.D_CONTROL().getRightX());
        
    }

    @Override
    public boolean isFinished() {
        // TODO Auto-generated method stub
        return false;

        
    }
}
