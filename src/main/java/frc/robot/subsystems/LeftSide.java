// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxAlternateEncoder;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.SparkMaxFactory;

public class LeftSide extends SubsystemBase {
  private final CANSparkMax mLeftFrontSpark = SparkMaxFactory.createSparkMax(Constants.kLeftFrontSparkPort, MotorType.kBrushless, IdleMode.kBrake, 42);
  private final CANSparkMax mLeftBackSpark = SparkMaxFactory.createSparkMax(Constants.kLeftBackSparkPort, MotorType.kBrushless, IdleMode.kBrake, 42);

  private final RelativeEncoder mLeftThroughBore = mLeftBackSpark.getAlternateEncoder(SparkMaxAlternateEncoder.Type.kQuadrature, 8192);

  /** Creates a new LeftSide. */
  public LeftSide() {
    mLeftBackSpark.follow(mLeftFrontSpark);
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("Encoder Velocity", mLeftThroughBore.getVelocity());
  }

  public void setPercent(double percent) {
    mLeftFrontSpark.set(percent);
  }
}
