package test;

public class Test03 {

  public static void main(String[] args) {
    int num[] = { -99, 53, 27, -51, -2 };

    for (int i = 0; i < num.length; i++) {
      if (num[i] < 0) {
        num[i] *= -1;
        System.out.println(num[i]);
      } else {
        System.out.println(num[i]);
      }
    }
  }
}