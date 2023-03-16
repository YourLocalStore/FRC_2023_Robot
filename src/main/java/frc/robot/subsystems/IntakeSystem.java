package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;


public class IntakeSystem extends SubsystemBase{

    private final WPI_VictorSPX m_leftMotor;

    public IntakeSystem(){
        m_leftMotor = new WPI_VictorSPX(6);
    }

    void OperateIntake(double speed){
        m_leftMotor.set(speed);
    }
}
