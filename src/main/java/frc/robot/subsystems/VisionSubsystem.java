/**Classe VisionSubsystem - Classe para cuidar da Luz Limão (LimeLight) 
 * @author Marlon Andrei a Lenda
 * @version 0.01 * 
 */
package frc.robot.subsystems;

import frc.utils.Dashboard;
import edu.wpi.first.net.PortForwarder;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class VisionSubsystem extends SubsystemBase {

  private double tx, ty, tz; 
  private NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
  private NetworkTableEntry targetpose_robotspace = table.getEntry("targetpose_robotspace");
  private Dashboard dash = new Dashboard();

  public VisionSubsystem() {

    for (int port = 5800; port <= 5807; port++) {
        PortForwarder.add(port, "limelight.local", port);
    }
  }  

  @Override
  public void periodic() {

    double[] values = targetpose_robotspace.getDoubleArray(new double[] { 0, 0, 0 });

    this.tx = (values[0] * 100);
    this.ty = (values[1] * 100);
    this.tz = (values[2] * 100);

    dash.PV("TX",tx);
    dash.PV("TY",ty);
    dash.PV("TZ",tz);

  }
  
  public double getTx() {
    return this.tx;
  }

  public double getTy() {
    return this.ty;
  }

  public double getTz() {
    return this.tz;
  }


}