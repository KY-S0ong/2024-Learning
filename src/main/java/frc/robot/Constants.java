// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static class OperatorConstants {
    public static final int kDriverControllerPort = 1;
  }


public static final int ShooterMotor1 = 5; //Learning
public static final int ShooterMotor2 = 6; //Learning

public static final int XboxPort = 1;
public static final int pcm = 0;

public static double kP1 = 0.1;
public static double kI1 = 0.000015;
public static double kD1 = 0.000025;
public static double kV1 = 0;

public static double kP2 = 0.1;
public static double kI2 = 0.000015;
public static double kD2 = 0.000025;
public static double kV2 = 0;

 
}
