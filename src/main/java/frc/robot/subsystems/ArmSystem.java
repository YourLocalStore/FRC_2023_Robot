package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;


public class ArmSystem extends SubsystemBase{

    private final CANSparkMax m_topMotor1; // Elbow Motor
    private final CANSparkMax m_bottomMotor1; // Arm Motor
    private final Encoder shoulder_encoder, elbow_encoder; // Encoders

    private int shoulder_position = 0 // 
    private int elbow_position = 0 // 

    public ArmSystem(){
        m_topMotor1 = new CANSparkMax (6); 
        m_bottomMotor1 = new Spark(6)
        m_motor = new MotorControllerGroup(m_topMotor1, m_bottomMotor1);

    }

    // Arm Pos
    public void getArmPosition;

    // Arm Speed
    public void OperateArm(double speed){
        m_topMotor1.set(speed);
        m_bottomMotor1.set(speed);
    }
}
