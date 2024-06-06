/**Classe DriveSubsystem - Essa classe que faz o Rôbo andar 
 * @author Não sei ao certo, admito que peguei da Net mas tive que arruma-lá! - Marlon Andrei (O Mito)
 * @version 2.00 (Como eu mechi, considero a minha versão a 2) * 
 */
package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;
import com.ctre.phoenix6.hardware.Pigeon2;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.utils.Dashboard;

public class TankSubsystem extends SubsystemBase {

  // Declara SmartDashBoard
  private final Dashboard dash = new Dashboard();

  private final CANSparkMax leftFront;
  private final CANSparkMax leftBack;

  private final CANSparkMax rightFront;
  private final CANSparkMax rightBack;

  private final Pigeon2 gyro = new Pigeon2(50);
  
  private PIDController pidDrive = new PIDController(0.01, 0, 0);  
  private double angleAt = 0;
  private double flagFront = 1;

  public TankSubsystem() {

    leftFront = new CANSparkMax(8, MotorType.kBrushed);
    leftBack = new CANSparkMax(9, MotorType.kBrushed);

    rightFront = new CANSparkMax(6, MotorType.kBrushed);
    rightBack = new CANSparkMax(7, MotorType.kBrushed);

    resetAngle();

  }

  @Override
  public void periodic() {

    dash.PV("Angle", gyro.getAngle());

  }


  public void drive(double x, double y) {
    double angleAdjust = 0;
    double pidValue;

    //dash.PV("TESTE",123);

    y = y * flagFront;

    if (y > 0.8) {
      y = 0.8;
    } else if (y < -0.8) {
      y = -0.8;
    }

    if (x > 0.5) {
      x = 0.5;
    } else if (x < -0.5) {
      x = -0.5;
    }


    dash.PV("Rotation2D", gyro.getRotation2d().getDegrees());

 
    if ((y < -0.01) || (y > 0.01)) {

      //angleAdjust = pidDrive.calculate(gyro.getAngle(), angleAt);
      //x += angleAdjust;

    }


    /* MAC - Código abaixo deixava mais lento a virada
    if (x > 0.2) {
      x = 0.2;
    } else if (x < -0.2) {
      x = -0.2;
    }
    */
    
    leftFront.set(y - x);
    leftBack.set(y - x);
    rightFront.set(-y - x);
    rightBack.set(-y - x);    

    if (((x < -0.01) || (x > 0.01)) && (angleAdjust == 0)) {
      angleAt = gyro.getAngle();
      dash.PV("AngleAt",angleAt);
    }


  }

  public void inverseFront() {
    flagFront = flagFront * -1;
  }


  public void zeroDrive() {
    leftFront.set(0);
    leftBack.set(0);

    rightFront.set(0);
    rightBack.set(0);
  }

  public void resetAngle() {
    gyro.reset();
  }

}
