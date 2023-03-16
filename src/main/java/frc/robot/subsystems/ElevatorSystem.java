package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;

import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants;
import frc.robot.commands.elevator.defaultElevatorCommand;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;


public class ElevatorSystem extends SubsystemBase {

    private final WPI_VictorSPX l_motor, r_motor;
    private final DigitalInput toplimitSwitch, bottomlimitSwitch;
    private final Encoder encoder;

    private final MotorControllerGroup m_motor;


    private int last_position = 0;

    private double speed = 0.5;

    private int setting = 0;

    public ElevatorSystem(){
        r_motor = new WPI_VictorSPX(6);
        l_motor = new WPI_VictorSPX(6);
        m_motor = new MotorControllerGroup(l_motor, r_motor);

        //r_motor.setInverted(true);
        toplimitSwitch = new DigitalInput(0);
        bottomlimitSwitch = new DigitalInput(1);

        encoder = new Encoder(
            constants.ELEVATOR_ENCODER_PORTS[0],
            constants.ELEVATOR_ENCODER_PORTS[1]
            );
            
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new defaultElevatorCommand(this));
    }

    void PositionCheck(){
        if(bottomlimitSwitch.get())
            last_position = 0;
        else if(toplimitSwitch.get())
            last_position = 2;
        else if(encoder.getDistance() > 0.45 && encoder.getDistance() < 0.55)
            last_position = 1;
    }

    public int GetPosition(){
        PositionCheck();
        return last_position;
    }

    public boolean SwitchSetting(int setting){

        PositionCheck();

        switch (setting){

            //Mesurment = 26
            case 0:

                if(!bottomlimitSwitch.get()) { m_motor.set(-speed);}

                else{
                    last_position = 0;
                    m_motor.set(0);
                    return true;
                }

                break;

            case 1:

                if(encoder.getDistance() < 0.45 && encoder.getDistance() > 0.55) { 
                    if(last_position == 2){
                        m_motor.set(-speed); 
                    }
                    else{
                        m_motor.set(speed);
                    }


                }

                else{
                    last_position = 1;
                    m_motor.set(0);
                    return true;
                }

                break;

            case 2:
        
                if(!toplimitSwitch.get()) { m_motor.set(speed);}

                else{ 
                    last_position = 2;
                    m_motor.set(0);
                    return true;
                }

                break;
        }

        return false;
    }
}
