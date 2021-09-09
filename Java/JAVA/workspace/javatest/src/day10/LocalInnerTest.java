package day10;

class Outer {

  int outNum = 100; //
  static int sNum = 200; // data area

  public Runnable getRunnable(int i) {       //method area , public 생략됨

    int num = 100; //지역변수, 

    class MyRunnable implements Runnable {

      int localNum = 10;

      @Override
      public void run() {
        // num = 200; //에러 남. 지역변수는 상수로 바뀜, 외부지역변수에 변경은 상수로 바뀌기기에 메서드 안에서 사용불가
        // i = 100; //에러 남. 매개 변수 역시 지역변수처럼 상수로 바뀜
        /*지역 내부 클래스에서 지역변수의 유효성
          - 지역변수는 메소드가 호출될 때 스택 메모리에 생성되고 메서드의 수행이 끝나면
            메모리에서 사라진다.
          - 지역 내부 클래스에서 사용하는 지역 변수는 상수로 처리된다.
          - 컴파일시 final이 자동으로 추가된다.
          - getRunable()의 지역변수 i와 num은 다른값으로 바꾸려고 하면 오류가 발생한다.
          - 지역 내부 클래스에서 사용하는 메서드의 지역변수는 모두 상수로 바뀐다. */
        
        System.out.println("i =" + i);
        System.out.println("num = " + num);
        System.out.println("localNum = " + localNum);

        System.out.println("outNum = " + outNum + "(외부 클래스 인스턴스 변수)");
        System.out.println("Outter.sNum = " + Outer.sNum + "(외부 클래스 정적 변수)");
      }
    }
    return new MyRunnable();
  }
}

public class LocalInnerTest {

  public static void main(String[] args) {

    Outer out = new Outer();
    Runnable runner = out.getRunnable(10);
    runner.run();
  }
}