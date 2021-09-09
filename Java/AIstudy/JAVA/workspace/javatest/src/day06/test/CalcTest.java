package day06.test;

abstract class Calculator {
  public abstract int add(int a, int b);

  public abstract int subtract(int a, int b);

  public abstract double average(int[] a);
}

class GoodCalc extends Calculator {

  @Override
  public int add(int a, int b) {
    return a + b;
  }

  @Override
  public int subtract(int a, int b) {
    return a - b;
  }

  @Override
  public double average(int[] a) {
    double sum = 0.0;
    for (int i = 0; i< a.length; i++)
      sum += i;
    return sum / a.length;
  }

}

public class CalcTest {

  public static void main(String[] args) {
    GoodCalc g = new GoodCalc();
    int[] c = {1, 2};
    
    System.out.println(g.add(1, 2));
    System.out.println(g.subtract(2, 1));
    System.out.println(g.average(c));
  }
}