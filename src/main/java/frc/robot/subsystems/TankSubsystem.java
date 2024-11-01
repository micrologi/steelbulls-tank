/**Classe DriveSubsystem - Essa classe que faz o Rôbo andar 
 * @author Não sei ao certo, admito que peguei da Net mas tive que arruma-lá! - Marlon Andrei (O Mito)
 * @version 2.00 (Como eu mechi, considero a minha versão a 2) * 
 */
package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.Pigeon2;
import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkMax;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.utils.Dashboard;
import frc.utils.Macro;

public class TankSubsystem extends SubsystemBase {

  // Declara SmartDashBoard
  private final Dashboard dash = new Dashboard();

  private final CANSparkMax leftFront;
  private final CANSparkMax leftBack;

  private final CANSparkMax rightFront;
  private final CANSparkMax rightBack;

  private Macro macro;

  private final Pigeon2 gyro = new Pigeon2(50);
  
  private PIDController pidDrive = new PIDController(0.01, 0, 0);  
  private double angleAt = 0;
  private double flagFront = 1;

  public boolean flagAngleFront = true;

  public TankSubsystem(Macro macro) {

    this.macro = macro;

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

  public void drive(double x, double y, boolean sourceControl) {
    double angleAdjust = 0;

    if ((x != 0) || (y != 0)) {      

      if (sourceControl)
        flagAngleFront = false;
      
      macro.flagPlayMacro = false;
      macro.macroKeyAct = 0;  
    }

    // Play Macro
    if (macro.flagPlayMacro) {
      x = macro.getX(macro.macroKeyAct);
      y = macro.getY(macro.macroKeyAct);
      
      if (macro.macroKeyAct >= macro.getLastKey()) {
        macro.flagPlayMacro = false;
        macro.macroKeyAct = 0;  
      } else {
        macro.macroKeyAct++;
      }

    }

    
    // Record Macro
    if (macro.flagRecordMacro) {
      macro.Add(x, y);
    }


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

  public void setAngleFront(double anglePoint) {
    double angleActual = gyro.getAngle();

    double degree = anglePoint + angleActual;
    double direction = -1;
    double kp = 0.05;
    double velocity = 0.4;
    double qRotation = 50;
    double error;
    double proportional;

    double startTime = System.currentTimeMillis();

    int cont = 0;

    while (flagAngleFront && (cont < qRotation) && ((System.currentTimeMillis() - startTime) < 50)) {
      error = gyro.getAngle() - degree;
      proportional = kp * error * direction; 

      if (Math.round(error) == 0) {
        cont++;
      } else {
        cont = 0;
      }

      if (Math.abs(proportional) > velocity) {
        proportional = velocity * (proportional / Math.abs(proportional));
      }

      drive(proportional,0,false);

    }
    
  }  

  public void moveFrontBack(double distanceMeters) {
  }
  
  public void setAdvance(double ty) {
    double startTime = System.currentTimeMillis();
    while(ty > -15.00 && (System.currentTimeMillis() - startTime) < 200) {
        drive(0, -0.3, false);
    }
    zeroDrive();
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
