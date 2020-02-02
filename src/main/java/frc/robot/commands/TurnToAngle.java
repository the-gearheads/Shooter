/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ShooterAngle;

public class TurnToAngle extends CommandBase {
  ShooterAngle shooterAngle;
  double target;
  boolean isAtAngle;

  public TurnToAngle(ShooterAngle subsystem, double angle) {
    shooterAngle = subsystem;
    target = angle;
    addRequirements(shooterAngle);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    isAtAngle = false;
    if (target > shooterAngle.getPosition()) {
      shooterAngle.setDirection(1);
    }
    else {
      shooterAngle.setDirection(-1);
    }
    shooterAngle.turn(0.2);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double offset = target - shooterAngle.getPosition();
    SmartDashboard.putNumber("OFFSET", offset);
    if (offset > -0.5 && offset < 0.5) {
      isAtAngle = true;
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    shooterAngle.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return isAtAngle;
  }
}
