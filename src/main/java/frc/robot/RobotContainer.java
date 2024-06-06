package frc.robot;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.Joystick;
import frc.robot.Constants.OIConstants;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.TankSubsystem;
import frc.robot.subsystems.VisionSubsystem;

public class RobotContainer {

  // Os subsistemas do robô
  private final TankSubsystem robotTank = new TankSubsystem();

  // Subsistema da câmera
  private final VisionSubsystem vision = new VisionSubsystem();

  // O Joystick do robô
  Joystick joystickDrive = new Joystick(OIConstants.kDriverControllerPort);

  /**
   * O contêiner para o robô. Contém subsistemas, dispositivos de entrada/saida e comandos.
   */
  public RobotContainer() {
      

    //Reseta frente
    robotTank.inverseFront();

    // Configura os botão padrão
    configureButtonBindings();

    vision.getTx();

    // Configure comandos padrão do Driving
    robotTank.setDefaultCommand(

      new RunCommand(
        () -> robotTank.drive(
          MathUtil.applyDeadband(joystickDrive.getRawAxis(4), 0.1), 
          MathUtil.applyDeadband(joystickDrive.getRawAxis(1), 0.1) 
        ),
        robotTank)
    );

  }

  private void configureButtonBindings() {

    JoystickButton setZeroHeading = new JoystickButton(joystickDrive,3);
    setZeroHeading.onTrue(new InstantCommand(
            () -> robotTank.resetAngle()
        )
    );

    JoystickButton setInverseFront = new JoystickButton(joystickDrive,4);
    setInverseFront.onTrue(new InstantCommand(
            () -> robotTank.inverseFront()
        )
    );

    JoystickButton setAngleFront = new JoystickButton(joystickDrive,6);
    setAngleFront.onTrue(new InstantCommand(
            () -> robotTank.setAngleFront(90)
        )
    );
    JoystickButton setAngleFrontInverted = new JoystickButton(joystickDrive,5);
    setAngleFrontInverted.onTrue(new InstantCommand(
            () -> robotTank.setAngleFront(-90)
        )
    );

  }

}
