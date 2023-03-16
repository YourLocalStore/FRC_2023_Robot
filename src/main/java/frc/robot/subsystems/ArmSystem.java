package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;


public class ArmSystem extends SubsystemBase{

    private final CANSparkMax m_topMotor1; // Elbow Motor
    private final CANSparkMax m_bottomMotor1; // Arm Motor
    private final Encoder shoulder_encoder, elbow_encoder; // Encoders

    // I DON'T KNOW WHAT I'M DOING HERE YET L;OL
    private int shoulder_position = 0 
    private int elbow_position = 0  

    public ArmSystem(){
        m_topMotor1 = new CANSparkMax (6); 
        m_bottomMotor1 = new Spark(6)
        m_motor = new MotorControllerGroup(m_topMotor1, m_bottomMotor1);

    }
}

    // Arm Pos
    public void getArmPosition;

    // Arm Speed
    public void OperateArm(double speed){
        m_topMotor1.set(speed);
        m_bottomMotor1.set(speed);
        
        // Check for speed on elbow, stop when tripped, or keep speed if not passed threshold
        if (speed > 1) {
            if (elbow_encoder.get()) {
                m_topMotor1.set(0);
            } else {
                m_topMotor1.set(speed)
            }
        // Check for speed on shoulder, stop when tripped, or keep speed if not passed threshold
        } else {
           if (shoulder_encoder.get()) {
            m_bottomMotor1.set(0);
           } else {
            m_bottomMotor1.set(speed)
         }    
    }
}  
