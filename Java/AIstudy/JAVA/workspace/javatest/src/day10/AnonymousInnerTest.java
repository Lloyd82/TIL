package day10;

class Outter2 {

  Runnable getRunnable(int i) {

    int num = 100;

    return new Runnable() {

      /* 익명 내부 클래스 ↓ 
       * - 클래스의 이름을 사용하지 않는 클래스를 익명 클래스라한다. 
       * - 익명 내부 클래스는 단 하나의 인터페이스 또는 단 하나의 추상 클래스를 바로 생성 할 수 있다. 
       * - 인터페이스는 인스턴스로 생성할 수 없으므로 인터페이스 몸체를 포함하여 생성 할 수 있다.*/
       
      @Override
      public void run() {

        // num = 200; //에러 남
        // i = 10; //에러 남
        System.out.println(i);
        System.out.println(num);
      }// 익명의 클래스
    };
  } // 일반 메서드

  public Runnable runner = new Runnable() { // public 생략가능

    @Override
    public void run() {
      System.out.println("Runnable 이 구현된 익명 클래스 변수");

    }
  };
}

public class AnonymousInnerTest {

  public static void main(String[] args) {
    Outter2 out = new Outter2();

    Runnable runnerble = out.getRunnable(10);
    runnerble.run();

    out.runner.run(); //runner 멤버변수 run 이름없는.동적 객체
  }
}