// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.Autos;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.MovePiston;
import frc.robot.commands.RunShooterForwards;
import frc.robot.commands.RunShooterReverse;
import frc.robot.commands.ShooterCMD;
import frc.robot.commands.StopPiston;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.Pneumatics;
import frc.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final Pneumatics piston = new Pneumatics();
  private final XboxController xboxController = new XboxController(Constants.XboxPort);
  private final Shooter m_Shooter = new Shooter();
  //private final ShooterCMD m_drivCmd = new ShooterCMD(m_Shooter, xboxController);
  private final RunShooterForwards runShooterForwards = new RunShooterForwards(m_Shooter);
  private final RunShooterReverse runShooterReverse = new RunShooterReverse(m_Shooter);
  private final MovePiston m_MovePiston = new MovePiston(piston);
  private final StopPiston m_StopPiston = new StopPiston(piston);


  // Replace with CommandPS4Controller or CommandJoystick if needed
  private final CommandXboxController m_driverController =
      new CommandXboxController(OperatorConstants.kDriverControllerPort);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
    //m_Shooter.setDefaultCommand(m_drivCmd);
   

  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    // Schedule `ExampleCommand` when `exampleCondition` changes to `true`
    //new JoystickButton(xboxController, 1);

    // Schedule `exampleMethodCommand` when the Xbox controller's B button is pressed,
    // cancelling on release.
    //m_driverController.b().whileTrue(m_exampleSubsystem.exampleMethodCommand());
    new JoystickButton(xboxController, 6).whileTrue(runShooterForwards);
    new JoystickButton(xboxController, 5).whileTrue(runShooterReverse);
    
    new JoystickButton(xboxController, 1).whileTrue(m_MovePiston);
    new JoystickButton(xboxController, 2).whileTrue(m_StopPiston);
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
      return null;
  }
}
