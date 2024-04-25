package frc.utils;

import edu.wpi.first.util.sendable.Sendable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/*
 * Classe criada porque é um saco ficar chamando toda hora um método diferente 
 * dependendo o tipo do dado que queremos na Dashboard
 * 
 * @author  Marlon Andrei
 * 
 */
public class Dashboard {
   
  public void PV(String Key, String Value) {
    SmartDashboard.putString(Key, Value);
  }

  public void PV(String Key, Double Value) {
    SmartDashboard.putNumber(Key, Value);
  }

  public void PV(String Key, int Value) {
    SmartDashboard.putNumber(Key, Value);
  }

  public void PV(String Key, boolean Value) {
    SmartDashboard.putBoolean(Key, Value);
  }

  public void PV(String Key, Sendable Value) {
    SmartDashboard.putData(Key, Value);
  }

  public double GV(String key, double value) {
    return SmartDashboard.getNumber(key, value);
  }

  public String GV(String key, String value) {
    return SmartDashboard.getString(key, value);
  }

  public int GV(String key, int value) {
    return (int)SmartDashboard.getNumber(key, value);
  }

  public boolean GV(String key, boolean value) {
    return SmartDashboard.getBoolean(key, value);
  }

}
