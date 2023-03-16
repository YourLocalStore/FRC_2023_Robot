package frc.robot.subsystems;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;


public class ElevatorSystem extends SubsystemBase {

    private final WPI_VictorSPX m_motor;
    private final DigitalInput toplimitSwitch, bottomlimitSwitch, middlelimitswitch;

    private double speed = 0.5;

    private int setting = 0;

    public ElevatorSystem(){
        m_motor = new WPI_VictorSPX(6);
        m_motor.setInverted(true);
        toplimitSwitch = new DigitalInput(0);
        bottomlimitSwitch = new DigitalInput(1);
        middlelimitswitch = new DigitalInput(2);
    }

    public void SwitchSetting(boolean direction){
        
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

        switch (setting){
            case 0:

                while(!bottomlimitSwitch.get()) { m_motor.set(-speed); }
                break;

            case 1:
        
                while(!middlelimitswitch.get()) { m_motor.set(speed); }
                break;

            case 2:
        
                while(!toplimitSwitch.get()) { m_motor.set(speed); }
                break;
        }


        if(direction && !toplimitSwitch.get()){
            while(!toplimitSwitch.get()){
                m_motor.set(speed);
            }
        }
    }
}
