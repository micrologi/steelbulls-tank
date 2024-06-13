package frc.utils;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class Macro {

  private ArrayList<Double> x = new ArrayList<Double>();
  private ArrayList<Double> y = new ArrayList<Double>();

  public boolean flagRecordMacro = false;
  public boolean flagPlayMacro = false;
  public int macroKeyAct = 0;

  public Macro() {    
  }

  
  public void recordMacro() {
    
    if (!this.flagRecordMacro) {
      Clear();
    }
    this.flagRecordMacro = !this.flagRecordMacro;
    
  }


  public void playMacro() {

    if (this.flagRecordMacro) {
      this.flagRecordMacro = false;
    } 

    if (getSize() > 0) {
      this.macroKeyAct = 0;
      this.flagPlayMacro = !this.flagPlayMacro;
    }

  }

/* 
  public void saveMacro() {
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("macro.dat")));

    for (int cont = 0; cont < this.x.size(); cont++)
    {
      out.println(x.get(cont) + ";" + y.get(cont));
    }
    out.close();
  }

  public void loadMacro() {
    Scanner scan = new Scanner(new File("macro.dat"));

    x.clear();
    y.clear();
    while(scan.hasNext())
    {
      x.add(1.0);
      y.add(1.0);
    }

  }
*/

  public void Clear() {
    this.x.clear();
    this.y.clear();
  }

  public void Add(double x, double y) {
    this.x.add(x);
    this.y.add(y);
  }

  public double getX(int key) {
    return this.x.get(key);
  }
  
  public double getY(int key) {
    return this.y.get(key);
  }

  public int getLastKey() {
    return x.size()-1;
  }

  public int getSize() {
    return x.size();
  } 

}
