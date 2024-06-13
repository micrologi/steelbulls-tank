package frc.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import frc.utils.Dashboard;

public class Macro {

  private ArrayList<Double> x = new ArrayList<Double>();
  private ArrayList<Double> y = new ArrayList<Double>();

  private final Dashboard dash = new Dashboard();

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

    if (this.flagPlayMacro) 
      reverseXY();

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


  public void reverseXY() {
    int key = 0;

    ArrayList<Double> localx = new ArrayList<Double>();
    ArrayList<Double> localy = new ArrayList<Double>();
    
    for (int cont=this.x.size()-1;cont>=0;cont--) {
      localx.add(key,this.x.get(cont) * -1);
      localy.add(key,this.y.get(cont) * -1);
      key++;
    }

    this.x = localx;
    this.y = localy;
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
