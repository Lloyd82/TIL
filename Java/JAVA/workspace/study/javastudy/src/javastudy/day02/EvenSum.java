package javastudy.day02;

public class EvenSum {
  public static void main(String[] args) {
//    int sum = 0;
//
//    for (int i = 1; i <= 100; i++) {
//      if (i % 2 == 0) {
//        sum += i;
//        if (i == 10) {
//          System.out.print("=");
//          System.out.print(i);
//        } else
//          System.out.print("+");
//        }
//        System.out.println("+" + i);
//        System.out.println("1~100까지 짝수의 합:" + sum);
//
//      }
//
//    }
    int sum = 0;

    for (int i = 1; i <= 100; i++) {
      if (i % 2 == 1) {
        sum += i;
      }
    }
    
    System.out.println("1~100까지 홀수의 합:" + sum);
  }
}
