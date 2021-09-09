package day02.code;

public class HelloDoc {
  // 메소드 선언
  public static int sum(int i, int j) {
    return i + j;
  }

  public static void main(String[] args) {
    int i;
    int j;
    char a;
    String b;
    final int TEN = 10; // 변화지 않는 값

    i = 1;
    j = sum(i, TEN); // sum함수호출해서 결과값을 j영역에 할당
    a = '?';
    b = "Hello";

    java.lang.System.out.println(a); // ? 출력 , java.lang패키지는 자동 import됨
    System.out.println(b); // Hello 출력
    System.out.println(TEN); // 10 출력
    System.out.println(j); // 11 출력
  }
}