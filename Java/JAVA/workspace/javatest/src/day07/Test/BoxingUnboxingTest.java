package day07.Test;
import java.util.*;

public class BoxingUnboxingTest {
  public static void main(String[] args) {
    Vector<Double> d = new Vector<Double>(); // Generics
    d.add(2.0);// boxing 
    d.add(3.2);
    d.add(7.7);
    d.add(9.5);
    d.add(1.3);
    prints(d);
  }

  public static void prints(Vector<Double> di) {
    double num = di.size(); //unb
    double sum = 0;
    for (int j = 0; j < num; j++) {
      sum += di.get(j);
    } 
    System.out.println("합   : " + sum);
    System.out.println(di);
  }
}