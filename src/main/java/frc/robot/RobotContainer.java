package frc.robot;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.Constants.OIConstants;
import frc.robot.subsystems.TankSubsystem;
import frc.robot.subsystems.VisionSubsystem;
import frc.utils.Macro;

public class RobotContainer {

  // Sistema de macros
  private final Macro macro = new Macro();

  // Os subsistemas do robô
  private final TankSubsystem robotTank = new TankSubsystem(macro);

  // Subsistema da câmera
  private final VisionSubsystem vision = new VisionSubsystem(robotTank);

  // O Joystick do robô
  Joystick joystickDrive = new Joystick(OIConstants.kDriverControllerPort);

  /**
   * O contêiner para o robô. Contém subsistemas, dispositivos de entrada/saida e comandos.
   */
  public RobotContainer() {
      

    //Reseta frente
    //robotTank.inverseFront();

    // Configura os botão padrão
    configureButtonBindings();

    // Configure comandos padrão do Driving
    robotTank.setDefaultCommand(      

      new RunCommand(
        () -> robotTank.drive(
          MathUtil.applyDeadband(joystickDrive.getRawAxis(4), 0.1), 
          MathUtil.applyDeadband(joystickDrive.getRawAxis(1), 0.1),
          true 
        ),
        robotTank)
        
    );

  }

  private void configureButtonBindings() {

    // JoystickButton setZeroHeading = new JoystickButton(joystickDrive,3);
    // setZeroHeading.onTrue(new InstantCommand(
    //         () -> robotTank.resetAngle()
    //     )
    // );

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
    // JoystickButton setFrontAdvance = new JoystickButton(joystickDrive,2);
    // setFrontAdvance.onTrue(new InstantCommand(
    //         () -> robotTank.setAdvance(0, 0.5)
    //     )
    // );
    
    JoystickButton recordMacro = new JoystickButton(joystickDrive,7);
    recordMacro.onTrue(new InstantCommand(
            () -> macro.recordMacro()
        )
    );

    JoystickButton playMacro = new JoystickButton(joystickDrive,8);
    playMacro.onTrue(new InstantCommand(
            () -> macro.playMacro()
        )
    );

    // Verde
    JoystickButton setFlagVisionActive = new JoystickButton(joystickDrive,1);
    setFlagVisionActive.onTrue(new InstantCommand(
            () -> vision.setFlagVisionActive()
        )
    );


  }

}
