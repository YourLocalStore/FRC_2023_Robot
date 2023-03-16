package frc.robot.subsystems;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;


public class DriveSystem extends SubsystemBase {

    private final WPI_VictorSPX m_leftMotor1;
    private final WPI_VictorSPX m_rightMotor1;
  
    private final WPI_VictorSPX m_leftMotor2;
    private final WPI_VictorSPX m_rightMotor2;
  
    private final MotorControllerGroup m_leftDrive;
    private final MotorControllerGroup m_rightDrive;
    private final DifferentialDrive m_robotDrive;
    private final XboxController m_drive_controller;

    public DriveSystem(){

        m_leftMotor1 = new WPI_VictorSPX(6);
        m_rightMotor1 = new WPI_VictorSPX(4);
        m_leftMotor2 = new WPI_VictorSPX(5);
        m_rightMotor2 = new WPI_VictorSPX(3);
        m_leftDrive = new MotorControllerGroup(m_leftMotor1, m_leftMotor2);
        m_rightDrive = new MotorControllerGroup(m_rightMotor1, m_rightMotor2);
        m_robotDrive = new DifferentialDrive(m_leftDrive, m_rightDrive);
        m_drive_controller = new XboxController(0); 

        m_rightDrive.setInverted(true);
    }


    public void OperateArcade(double input_x, double input_y){
        m_robotDrive.arcadeDrive(input_x, input_y);
    }

    public void OperateTank(double speed1, double speed2){
        m_robotDrive.tankDrive(m_drive_controller.getLeftY(), m_drive_controller.getRightX());
    }
}
