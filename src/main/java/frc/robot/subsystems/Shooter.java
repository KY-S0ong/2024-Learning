// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Shooter extends SubsystemBase {
  private double ShooterSpeed1;
  private double ShooterAcel1;

  private double ShooterSpeed2;
  private double ShooterAcel2;

  private final TalonFX ShooterMotor1 = new TalonFX(Constants.ShooterMotor1);
  private final TalonFX ShooterMotor2 = new TalonFX(Constants.ShooterMotor2);

  private final PIDController controller1 = new PIDController(Constants.kP1, Constants.kI1, Constants.kD1);
  private final PIDController controller2 = new PIDController(Constants.kP2, Constants.kI2, Constants.kD2);

  public Shooter() {
    TalonFXConfiguration t = new TalonFXConfiguration();
    ShooterMotor1.getConfigurator().apply(t);
    ShooterMotor2.getConfigurator().apply(t);
    t.Voltage.PeakForwardVoltage = 12.3;    

    ShooterMotor1.setInverted(false);
    ShooterMotor2.setInverted(true);
  }

  @Override
  public void periodic() {
    ShooterSpeed1 = ShooterMotor1.getVelocity().getValueAsDouble();
    ShooterAcel1 = ShooterMotor1.getAcceleration().getValueAsDouble();
    ShooterSpeed2 = ShooterMotor2.getVelocity().getValueAsDouble();
    ShooterAcel2 = ShooterMotor2.getAcceleration().getValueAsDouble();

    SmartDashboard.putNumber("Speed M1", ShooterSpeed1);
    SmartDashboard.putNumber("Aceleration M1", ShooterAcel1);
    SmartDashboard.putNumber("Speed M2", ShooterSpeed2);
    SmartDashboard.putNumber("Aceleration M2", ShooterAcel2);

    SmartDashboard.putNumber("P1", Constants.kP1);
    SmartDashboard.putNumber("I2;", Constants.kI1);
    SmartDashboard.putNumber("D1", Constants.kD1);

    SmartDashboard.putNumber("P1", Constants.kP2);
    SmartDashboard.putNumber("I2;", Constants.kI2);
    SmartDashboard.putNumber("D1", Constants.kD2);
    

  }

  public void ShooterController(double input){
    input = (Math.abs(input)<0.13) ? 0:input;
    ShooterMotor1.setVoltage(controller1.calculate(ShooterMotor1.getVelocity().getValueAsDouble(), input));
    ShooterMotor2.setVoltage(controller2.calculate(ShooterMotor2.getVelocity().getValueAsDouble(), input));

    //ShooterMotor1.set(ShooterSpeed1);



  }

public void shooterZero() {
    ShooterMotor1.set(0);
    ShooterMotor2.set(0);
}
  

  
  

  

}
