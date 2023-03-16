package frc.robot.commands.drive;

import edu.wpi.first.hal.simulation.RoboRioDataJNI;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSystem;
import frc.robot.subsystems.IntakeSystem;
import frc.robot.Robot;

public class Rotate90Degrees extends CommandBase{

    private DriveSystem m_drive;

    private double[] direction;
    

    public Rotate90Degrees(DriveSystem drive){
        super();
        m_drive = drive;
        addRequirements(drive);
    }

    @Override
    public void initialize() {
        // TODO Auto-generated method stub
        // Timeout tbd for 90 deg alignment

        if(Robot.D_CONTROL().getLeftBumperPressed()){
            direction = new double[]{-1, 1};
        }
        else if (Robot.D_CONTROL().getRightBumperPressed()){
            direction = new double[]{1, -1};
        }

        


        super.initialize();
    }
    
    @Override
    public void execute() {
        // TODO Auto-generated method stub
        m_drive.OperateTank(direction[0], direction[1]);
    }

    @Override
    public boolean isFinished() {
        // TODO Auto-generated method stub
        return super.isFinished();
    }
}
