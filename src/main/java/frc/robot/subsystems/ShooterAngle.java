/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.AnalogInput;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class ShooterAngle extends SubsystemBase {
  private AnalogInput pot;
  private int direction;
  private WPI_TalonSRX seatMotor;

  public ShooterAngle(int potPort, int motorId, boolean invertDirection) {
    pot = new AnalogInput(potPort);
    direction = 0;
    seatMotor = new WPI_TalonSRX(motorId);
    seatMotor.setInverted(invertDirection);
    seatMotor.set(ControlMode.PercentOutput, 0);
    seatMotor.set(0);
  }

  public void setDirection(int direction) {
    this.direction = direction;
  }

  public void turn(double speed) {
    seatMotor.set(speed * direction);
  }

  public double getPosition() {
    return (360 / 0.4907) * (pot.getVoltage() - 0.00488);
  }

  public void stop() {
    seatMotor.set(0);
  }
}
