/**Classe DriveSubsystem - Essa classe que faz o Rôbo andar 
 * @author Não sei ao certo, admito que peguei da Net mas tive que arruma-lá! - Marlon Andrei (O Mito)
 * @version 2.00 (Como eu mechi, considero a minha versão a 2) * 
 */
package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;


import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.utils.Dashboard;

public class TankSubsystem extends SubsystemBase {

  // Declara SmartDashBoard
  private final Dashboard dash = new Dashboard();

  private final CANSparkMax leftFront;
  private final CANSparkMax leftBack;

  private final CANSparkMax rightFront;
  private final CANSparkMax rightBack;

  // O sensor giroscópio
  //private final Pigeon2 m_gyro = new Pigeon2(PigeonConstants.Pigeon2ID);

  public TankSubsystem() {

    leftFront = new CANSparkMax(8, MotorType.kBrushed);
    leftBack = new CANSparkMax(9, MotorType.kBrushed);

    rightFront = new CANSparkMax(6, MotorType.kBrushed);
    rightBack = new CANSparkMax(7, MotorType.kBrushed);

  }

  @Override
  public void periodic() {

  }


  public void drive(double x, double y) {

    //dash.PV("TESTE",123);

    if (y > 0.8) {
      y = 0.8;
    } else if (y < -0.8) {
      y = -0.8;
    }

    if (x > 0.2) {
      x = 0.2;
    } else if (x < -0.2) {
      x = -0.2;
    }
    
    leftFront.set(y - x);
    leftBack.set(y - x);
    rightFront.set(-y - x);
    rightBack.set(-y - x);    

  }


  public void zeroDrive() {
    leftFront.set(0);
    leftBack.set(0);

    rightFront.set(0);
    rightBack.set(0);
  }

}
