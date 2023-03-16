package frc.robot.subsystems;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;


public class ArmSystem extends SubsystemBase{

    private final WPI_VictorSPX m_leftMotor;

    public ArmSystem(){
        m_leftMotor = new WPI_VictorSPX(6);
    }

    void OperateArm(double speed){
        m_leftMotor.set(speed);
    }
}
