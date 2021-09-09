package day02.code;

public class EndlessLoop {
  public static void main(String[] args) {
    int i = 1;
    int sum = 0;
    while (i <= 100) {
      i++; // 올바른 위치 , 앞에 주석을 제거해야 무한반복 안됨
      if (i % 2 == 1)
        continue; // i 값을 증가시키지 않고 반복 조건을 검사하므로
      // 무한 반복에 빠지게 됨
      else
        sum = sum + i;
      //i++; // 잘못된 위치. 무한루프에 빠짐
    }
    System.out.println("1부터 100까지 짝수의 합은 " + sum);
  }
}