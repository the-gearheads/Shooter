/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.subsystems.ShooterAngle;

public class TurnToAnglePID extends PIDCommand {
  /**
   * Creates a new TurnToAnglePID.
   */
  public TurnToAnglePID(ShooterAngle subsystem, double angle) {
    super(
        // The controller that the command will use
        new PIDController(0.2, 0, 0.2),
        // This should return the measurement
        subsystem::getPosition,
        // This should return the setpoint (can also be a constant)
        angle,
        // This uses the output
        output -> {
        });

    // Use addRequirements() here to declare subsystem dependencies.
    // Configure additional PID options by calling `getController` here.
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return getController().atSetpoint();
  }
}
