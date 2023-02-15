// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

/** Add your docs here. */
public class SparkMaxFactory {
    public static CANSparkMax createDefaultSparkMax(int deviceId, MotorType type) {
        CANSparkMax sparkMax = new CANSparkMax(deviceId, type);
        sparkMax.enableVoltageCompensation(10);
        sparkMax.setIdleMode(IdleMode.kBrake);
        sparkMax.setSmartCurrentLimit(40);
        sparkMax.burnFlash();
        return sparkMax;
    }

    public static CANSparkMax createSparkMax(int deviceId, MotorType type, IdleMode idleMode, int currentLimit) {
        CANSparkMax sparkMax = new CANSparkMax(deviceId, type);
        sparkMax.enableVoltageCompensation(10);
        sparkMax.setIdleMode(idleMode);
        sparkMax.setSmartCurrentLimit(currentLimit);
        sparkMax.burnFlash();
        return sparkMax;
    }
}
