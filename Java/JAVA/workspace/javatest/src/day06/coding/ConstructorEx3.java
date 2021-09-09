package day06.coding;

class A3 {
  public A3() {
    System.out.println("생성자A");
  }

  public A3(int x) {
    System.out.println("매개변수생성자A" + x);
  }
}

class B3 extends A3 {
  public B3() {
    System.out.println("생성자B");
  }

  public B3(int x) {
    super(x);
    System.out.println("매개변수생성자B" + x);
  }
}

public class ConstructorEx3 {
  public static void main(String[] args) {
    B3 b;
    b = new B3(5);
  }
}