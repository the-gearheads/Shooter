/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.TurnToAngle;
import frc.robot.subsystems.ShooterAngle;
import frc.robot.commands.TurnToAnglePID;

public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ShooterAngle shooterAngle = new ShooterAngle(0, 31, true);
  private final XboxController controller;

  public RobotContainer() {
    controller = new XboxController(0);
    // Configure the button bindings
    configureButtonBindings();
  }

  private void configureButtonBindings() {
    new JoystickButton(controller, XboxController.Button.kA.value)
    .whenActive(new TurnToAngle(shooterAngle, 35));

    new JoystickButton(controller, XboxController.Button.kB.value)
    .whenActive(new TurnToAngle(shooterAngle, 45));

    new JoystickButton(controller, XboxController.Button.kY.value)
    .whenActive(new TurnToAngle(shooterAngle, 135));
  }
}
