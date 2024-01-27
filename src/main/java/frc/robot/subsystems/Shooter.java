// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.StatusSignal;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj.RobotController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Shooter extends SubsystemBase {
  private double speed1;
  private double acel1;

  private double speed2;
  private double acel2;

  private final TalonFX Motor1 = new TalonFX(Constants.Motor1);
  private final TalonFX Motor2 = new TalonFX(Constants.Motor2);

  public Shooter() {


  }

  @Override
  public void periodic() {
    speed1 = Motor1.getVelocity().getValueAsDouble();
    acel1 = Motor1.getAcceleration().getValueAsDouble();
    speed2 = Motor2.getVelocity().getValueAsDouble();
    acel2 = Motor2.getAcceleration().getValueAsDouble();

    SmartDashboard.putNumber("Speed M1", speed1);
    SmartDashboard.putNumber("Aceleration M1", acel1);

    SmartDashboard.putNumber("Speed M2", speed2);
    SmartDashboard.putNumber("Aceleration M2", acel2);

  }

  public void ShooterController(double input){
    Motor1.set(input);
    Motor2.set(input);

    //Motor1.set(speed1);



  }
  

  
  

  

}