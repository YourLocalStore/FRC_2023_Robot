package frc.robot.commands.elevator;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ElevatorSystem;

public class MoveElevatorCommand extends CommandBase{

    private boolean finish_command = false, direction;
    private int setting = 0;

    private ElevatorSystem m_elevator;

    public MoveElevatorCommand(ElevatorSystem elevator, boolean dir){
        addRequirements(m_elevator);
        direction = dir;
        m_elevator = elevator;
    }

    @Override
    public void initialize() {

        setting = m_elevator.GetPosition();

        if(direction){
            if(setting == 2){
                setting = 0;
            }
            else{
                setting++;
            }
        }
        else{
            if(setting == 0){
                setting = 2;
            }
            else{
                setting--;
            }
        }


        super.initialize();
    }
    
    @Override
    public void execute() {

        finish_command = m_elevator.SwitchSetting(setting);

        super.execute();
    }

    @Override
    public boolean isFinished() {

        return finish_command;
    }
}
