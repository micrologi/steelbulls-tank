package frc.robot;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.Joystick;
import frc.robot.Constants.OIConstants;
import edu.wpi.first.wpilibj2.command.RunCommand;
import frc.robot.subsystems.TankSubsystem;

public class RobotContainer {

  // Os subsistemas do robô
  private final TankSubsystem robotTank = new TankSubsystem();

  // O Joystick do robô
  Joystick joystickDrive = new Joystick(OIConstants.kDriverControllerPort);

  /**
   * O contêiner para o robô. Contém subsistemas, dispositivos de entrada/saida e comandos.
   */
  public RobotContainer() {
      
    // Configura os botão padrão
    configureButtonBindings();

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

    //Zera a posição de frente     
    //JoystickButton setZeroHeading = new JoystickButton(m_driverController, 3);
    //setZeroHeading.onTrue(new InstantCommand(
    //        () -> robotTank.zeroHeading()
    //    )
    //);

  }

}
