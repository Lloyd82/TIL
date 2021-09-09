package day10;

class OutClass {
  // inClass = new InClass(); // 내부 클래스 생성 2

  private int num = 10;
  private static int sNum = 20;
  private InClass inClass;

  public OutClass() {
    inClass = new InClass(); // 내부 클래스 생성
  }

  class InClass {

    int inNum = 100;
    // static int sInNum = 200; //에러 남 static 사용불가

    void inTest() {
      System.out.println("OutClass num = " + num + "(외부 클래스의 인스턴스 변수)");
      System.out.println("OutClass sNum = " + sNum + "(외부 클래스의 스태틱 변수)");
    }
    // static void sTest(){ //에러 남 static method 사용불가
    // }
  }

  static class InStaticClass { // -정적 내부 클래스

    int inNum = 100;
    static int sInNum = 200;
    // 정적 내부 클래스- 내부클래스가 외부클래스 생성과 무관하게 사용할 수 있어야 하고 정적변수도
    // 사용할 수 있어야 한다면, 정적 내부 클래스(static, inner class)를 만들면 된다.
    // - 클래스에 static 함께 사용한다.

    void inTest() { // 정적 클래스의 일반 메서드
      // num += 10; // 외부 클래스의 인스턴스 변수는 사용할 수 없음.
      System.out.println("InStaticClass inNum = " + inNum + "(내부 클래스의 인스턴스 변수 사용)");
      System.out.println("InStaticClass sInNum = " + sInNum + "(내부 클래스의 스태틱 변수 사용)");
      System.out.println("OutClass sNum = " + sNum + "(외부 클래스의 스태틱 변수 사용)");
    }

    static void sTest() { // 정적 클래스의 static 메서드
      // num += 10; // 외부 클래스의 인스턴스 변수는 사용할 수 없음.
      // inNum += 10; // 내부 클래스의 인스턴스 변수는 사용할 수 없음

      System.out.println("OutClass sNum = " + sNum + "(외부 클래스의 스태틱 변수 사용)");
      System.out.println("InStaticClass sInNum = " + sInNum + "(내부 클래스의 스태틱 변수 사용)");

    }
  }

  public void usingClass() {
    inClass.inTest(); // 내부 클래스 변수를 사용하여 메서드 호출하기
  }

}

public class InnerTest {

  public static void main(String[] args) {

//    OutClass outClass = new OutClass();
//    System.out.println("외부 클래스 이용하여 내부 클래스 기능 호출");
//    outClass.usingClass(); // 내부 클래스 기능 호출
//    System.out.println();

//    outClass.usingClass();    // 직접내부 클래스 기능 호출
    System.out.println("======================================");

    OutClass outClass2 = new OutClass();
    System.out.println("외부 클래스 객체 생성후 내부 클래스 객체생성후 기능 호출");
    OutClass.InClass inClass = outClass2.new InClass();
    inClass.inTest();

    System.out.println("=======================================");

    // 외부 클래스 생성하지 않고 바로 정적 내부 클래스 생성
    OutClass.InStaticClass sInClass = new OutClass.InStaticClass();
    System.out.println("정적 내부 클래스 일반 메서드 호출");
    sInClass.inTest();

    System.out.println("정적 내부 클래스의 스태틱 메소드 호출");
    OutClass.InStaticClass.sTest();

  }
}