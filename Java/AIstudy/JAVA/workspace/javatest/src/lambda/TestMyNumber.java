package lambda;

public class TestMyNumber { // MyNumber.java를 람다식으로 변경

  public static void main(String[] args) {
    MyNumber max = (x, y) -> (x >= y) ? x : y; // 람다식을 인터페이스 자료형 max 변수에 대입
    // ㄴ 인터페이스
    System.out.println(max.getMax(10, 20));// 인터페이스 자료형 변수로 함수 호출

  }
}