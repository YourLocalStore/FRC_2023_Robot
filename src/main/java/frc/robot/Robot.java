// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;


import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
/*
 * 
 */


import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;

import frc.robot.commands.drive.DriveArcade;
import frc.robot.commands.drive.Rotate90Degrees;

import frc.robot.subsystems.DriveSystem;
import frc.robot.subsystems.ElevatorSystem;
import frc.robot.subsystems.IntakeSystem;

import edu.wpi.first.wpilibj2.command.CommandScheduler;

/**
 * This is a demo program showing the use of the DifferentialDrive class. Runs the motors with
 * arcade steering.
 */
public class Robot extends TimedRobot {
  private final WPI_VictorSPX m_leftMotor1 = new WPI_VictorSPX(6);
  private final WPI_VictorSPX m_rightMotor1 = new WPI_VictorSPX(4);


  private final WPI_VictorSPX m_leftMotor2 = new WPI_VictorSPX(5);
  private final WPI_VictorSPX m_rightMotor2 = new WPI_VictorSPX(3);

  private final MotorControllerGroup m_leftDrive = new MotorControllerGroup(m_leftMotor1, m_leftMotor2);
  private final MotorControllerGroup m_rightDrive = new MotorControllerGroup(m_rightMotor1, m_rightMotor2);
  private final DifferentialDrive m_robotDrive = new DifferentialDrive(m_leftDrive, m_rightDrive);

  private IntakeSystem intake = new IntakeSystem();
  private ElevatorSystem elevator = new ElevatorSystem();
  private DriveSystem drive = new DriveSystem();

  private SendableChooser chooser = new SendableChooser<String>(); 

  private static final XboxController DRIVE_CONTROLLER = new XboxController(0); 
  private static final XboxController OP_CONTROLLER = new XboxController(1); 

  public static XboxController D_CONTROL() {
      return DRIVE_CONTROLLER;
  }
  public static XboxController O_CONTROL() {
      return OP_CONTROLLER;
  }

  private double[] 
    speeds = {0, 0};

  private double 
    speed, 
    input,

    deadzone = 0.2f;

  private double[][] directions = {
    {0, 0}, //still
    {1, -1}, //right
    {-1, 1}, //left
    {1, 1}, //forward
    {-1, -1}, //back
  };
  
  @Override
  public void robotInit() {
    // We need to invert one side of the drivetrain so that positive voltages
    // result in both sides moving forward. Depending on how your robot's
    // gearbox is constructed, you might have to invert the left side instead.

    

    m_rightDrive.setInverted(true);

    chooser.setDefaultOption("Arcade", "Arcade");
    chooser.addOption("Forza", "Forza");

  }

@Override
  public void teleopPeriodic() {

    CommandScheduler.getInstance().schedule(new DriveArcade(drive));
    //switch((String)chooser.getSelected()){
//
    //  speed = DRIVE_CONTROLLER.getRightTriggerAxis() - DRIVE_CONTROLLER.getLeftTriggerAxis();
//
//
    //  case "Arcade":
    //break;

      //case "Forza":
//
      //  
      //  m_robotDrive.arcadeDrive(speed, DRIVE_CONTROLLER.getRightX());
      //  break;

        //If the right trigger is held, set the speed relative to the right triggers value
        //Otherwise, set the value negative to the left trigger value (to account for backwards movement)

        //SetWheelDirections();

        // Drive with arcade drive.
        // That means that the Y axis drives forward
        // and backward, and the X turns left and right.
        //m_robotDrive.tankDrive(speeds[0], speeds[1]);
    //}
    
  }

  void SetWheelDirections(){
    //g = input[0]
    //h = speed

    if(speed != 0){
      speeds[0] = Math.abs(speed) * (Lerp(input, speed, -Math.abs(input) + 1)); 
      speeds[1] = Math.abs(speed) * (Lerp(-input, speed, -Math.abs(input) + 1));
    }
    else{

      speeds[0] = input; 
      speeds[1] = -input;

    }
    /*
    if(inputs[0] <= 0.1 && inputs[0] >= -0.1){
      speeds[0] = Lerp(-1, 1, RecenterFactor(inputs[0])); 
      speeds[1] = Lerp(1, -1, RecenterFactor(inputs[0]));
    }
    else{
      speeds[0] = speed; 
      speeds[1] = speed;
    }
    */
  }

  public double Lerp(double value1, double value2, double factor){
    
    double difference;
    difference = value2 - value1;
    return value1 + difference * factor;    
  } 

  public double RecenterFactor(double value){
    return value + 1 / 2;  
  } 
}
