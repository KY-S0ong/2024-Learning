// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.configs.Slot0Configs;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Falcon extends SubsystemBase {
  private static final TalonFX ShooterFalcon1 = null;
  /** Creates a new Falcon. */

  private final TalonFX shooterFalcon1 = new TalonFX(Constants.ShooterFalcon1);
  private final TalonFX shooterFalcon2 = new TalonFX(Constants.ShooterFalcon2);

  private TalonFXConfiguration TalonFXConfig = new TalonFXConfiguration();
  private PIDController PIDController = new PIDController(Constants.kP, Constants.kI, Constants.kD);
  public double ShooterSpeed1;
  public double ShooterSpeed2;
  private double ShotoerVel1;
  private double ShotoerVel2;
  private double ShotoerVolts1;
  private double ShotoerVolts2;
  private double ShotoerAcel1;
  private double ShotoerAcel2;

  public Falcon() {
    TalonFXConfig.Voltage.PeakForwardVoltage = 10;
    TalonFXConfig.Voltage.PeakReverseVoltage = 10;
    var slot0Conigs = new Slot0Configs();
    shooterFalcon1.getConfigurator().apply(TalonFXConfig);
    shooterFalcon2.getConfigurator().apply(TalonFXConfig);
    updatePID();
  }

  private void updatePID(){
    var slot0Conigs = new Slot0Configs();
    slot0Conigs.kV = Constants.kV;
    slot0Conigs.kP = Constants.kP;
    slot0Conigs.kI = Constants.kI;
    slot0Conigs.kD = Constants.kD;
    
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    ShotoerVel1 = shooterFalcon1.getVelocity().getValueAsDouble();
    ShotoerVel2 = shooterFalcon2.getVelocity().getValueAsDouble();
    ShotoerAcel1 = shooterFalcon1.getAcceleration().getValueAsDouble();
    ShotoerAcel2 = shooterFalcon2.getAcceleration().getValueAsDouble();
    ShotoerVolts1 = shooterFalcon1.getMotorVoltage().getValueAsDouble();
    ShotoerVolts2 = shooterFalcon2.getMotorVoltage().getValueAsDouble();

    SmartDashboard.putNumber("Shooter Velocity1", ShotoerVel1);
    SmartDashboard.putNumber("Shooter Acceleration1", ShotoerAcel1);
    SmartDashboard.putNumber("Shooter ShotoerVolts1", ShotoerVolts1);
    SmartDashboard.putNumber("Shooter Velocity2", ShotoerVel2);
    SmartDashboard.putNumber("Shooter Acceleration2", ShotoerAcel2);
    SmartDashboard.putNumber("Shooter ShotoerVolts2", ShotoerVolts2);

    //SmartDashboard.putNumber("Proportional", Constants.kP);
    //SmartDashboard.putNumber("Integral", Constants.kI);
    //SmartDashboard.putNumber("Derivitive", Constants.kV);
    //SmartDashboard.putNumber("Volts", Constants.kV);
    //Constants.kP = SmartDashboard.getNumber("Get New P", Constants.kP);
    //Constants.kI = SmartDashboard.getNumber("Get New I", Constants.kI);
    
  }

  public void runMotor(double speed1){
    ShotoerVolts1 = PIDController.calculate(ShotoerVel1, ShooterSpeed1);
    ShotoerVolts2 = PIDController.calculate(ShotoerVel2, ShooterSpeed2);
    ShooterFalcon1.setVoltage(ShotoerVolts1);
    shooterFalcon2.setVoltage(ShotoerVolts2);
  }

}
