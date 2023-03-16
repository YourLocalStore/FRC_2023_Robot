package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;


public class IntakeSystem extends SubsystemBase{

    private final WPI_TalonSRX m_leftMotor;    
    private final DoubleSolenoid pistons;
    private final DigitalInput limitSwitch;

    public IntakeSystem() {
        m_leftMotor = new WPI_TalonSRX(6);
        pistons = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 0, 0);
        limitSwitch = new DigitalInput(0);

    }

    public boolean hasCube() {
        return limitSwitch.get();
    }

    public void openClaw() {
        pistons.set(Value.kForward);
    }

    public void closeClaw() {
        pistons.set(Value.kReverse);
    }

    public void OperateIntake(double speed){
        m_leftMotor.set(speed);

    }
}
