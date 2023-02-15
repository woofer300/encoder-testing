// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.LeftSide;

public class RunLeftSide extends CommandBase {
  private final LeftSide mLeftSide;
  private final DoubleSupplier mLeftJoystickY;

  /** Creates a new RunLeftSide. */
  public RunLeftSide(LeftSide leftSide, DoubleSupplier leftJoystickY) {
    mLeftSide = leftSide;
    mLeftJoystickY = leftJoystickY;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(mLeftSide);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double leftJoystickY = mLeftJoystickY.getAsDouble();
    mLeftSide.setPercent(leftJoystickY);
    SmartDashboard.putNumber("Left Joystick Y", leftJoystickY);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
