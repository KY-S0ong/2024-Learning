// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.StatusSignal;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.RobotController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Shooter extends SubsystemBase {
  private double ShooterSpeed1;
  private double ShooterAcel1;

  private double ShooterSpeed2;
  private double ShooterAcel2;

  private final TalonFX Motor1 = new TalonFX(Constants.Motor1);
  private final TalonFX Motor2 = new TalonFX(Constants.Motor2);

  private final PIDController controller1 = new PIDController(0.1, 0.000005, 0.000025);
  private final PIDController controller2 = new PIDController(0.1, 0.000005, 0.000025);

  public Shooter() {
    Motor1.setInverted(false);
    Motor2.setInverted(false);
  }

  @Override
  public void periodic() {
    ShooterSpeed1 = Motor1.getVelocity().getValueAsDouble();
    ShooterAcel1 = Motor1.getAcceleration().getValueAsDouble();
    ShooterSpeed2 = Motor2.getVelocity().getValueAsDouble();
    ShooterAcel2 = Motor2.getAcceleration().getValueAsDouble();

    SmartDashboard.putNumber("Speed M1", ShooterSpeed1);
    SmartDashboard.putNumber("Aceleration M1", ShooterAcel1);

    SmartDashboard.putNumber("Speed M2", ShooterSpeed2);
    SmartDashboard.putNumber("Aceleration M2", ShooterAcel2);

  }

  public void ShooterController(double input){
    input = (Math.abs(input)<0.13) ? 0:input;
    Motor1.setVoltage(controller1.calculate(Motor1.getVelocity().getValueAsDouble(), input));
    Motor2.setVoltage(controller2.calculate(Motor2.getVelocity().getValueAsDouble(), input));

    //Motor1.set(ShooterSpeed1);



  }
  

  
  

  

}
