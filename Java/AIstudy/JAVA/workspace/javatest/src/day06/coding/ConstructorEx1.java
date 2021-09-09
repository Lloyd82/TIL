package day06.coding;

class A1 {
  //public A1() {} //오류 없애는 방법 1 기본생성자 생성
  public A1(int x) {
    System.out.println("생성자A");
  }
}

class B1 extends A1 {
  public B1() {
    super(10); //오류 없애는 방법 2 생성자 값 입력
    System.out.println("생성자B");
  }
}

public class ConstructorEx1 {
  public static void main(String[] args) {
    B1 b;
    b = new B1();
  }
}