/**Classe VisionSubsystem - Classe para cuidar da Luz Limão (LimeLight) 
 * @author Marlon Andrei a Lenda
 * @co-author Lucas Miyazaki o faz tudo
 * @version 0.01 * 
 */

package frc.robot.subsystems;

import edu.wpi.first.net.PortForwarder;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.utils.Dashboard;

public class VisionSubsystem extends SubsystemBase {
  private NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
  private Dashboard dash = new Dashboard();
  private double tx;
  private double ty;
  private TankSubsystem robot; 

  public VisionSubsystem(TankSubsystem robotTank) {
    this.robot = robotTank;

    for (int port = 5800; port <= 5807; port++) {
        PortForwarder.add(port, "limelight.local", port);
    }
  }  

  @Override
  public void periodic() {
    NetworkTableEntry tableTx = table.getEntry("tx");
    NetworkTableEntry tableTy = table.getEntry("ty");
    this.tx = tableTx.getDouble(0);
    this.ty = tableTy.getDouble(0);
    
    if (this.ty != 0.0) {
      this.robot.setAdvance(ty);
    }
    if (this.tx != 0.0) {
      this.robot.flagAngleFront = true;
      this.robot.setAngleFront(tx);
    }

  }
  


}