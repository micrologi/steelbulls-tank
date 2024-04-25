package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

public class Robot extends TimedRobot { 

  // Declara SmartDashBoard
  private RobotContainer m_robotContainer;

  @Override
  public void robotInit() {
    m_robotContainer = new RobotContainer();
  }

  @Override
  public void robotPeriodic() {
    CommandScheduler.getInstance().run();
  }

  @Override
  public void autonomousInit() {

  }

  @Override
  public void autonomousPeriodic() {
         
  }

  /** Esta função é chamada uma vez quando o Teleop é ativado. */
  @Override
  public void teleopInit() {
    
  }

  /** Esta função é chamada periodicamente durante o controle do operador. */
  @Override
  public void teleopPeriodic() {

  }

  /** Esta função é chamada uma vez quando o robô é desativado. */
  @Override
  public void disabledInit() {

  }

  /** Esta função é chamada periodicamente quando desativada. */
  @Override
  public void disabledPeriodic() {

  }

  /** Esta função é chamada uma vez quando o modo de teste é ativado. */
  @Override
  public void testInit() {
    CommandScheduler.getInstance().cancelAll();
  }

  /** Esta função é chamada periodicamente durante o modo de teste. */
  @Override
  public void testPeriodic() {

  }

  
}
