package day02.code;

import java.util.Scanner;

public class ScannerExam {
  public static void main(String args[]) {
    Scanner a = new Scanner(System.in); // 키보드로 입력한 값
    System.out.println("나이, 체중, 신장을 빈칸으로 분리하여 순서대로 입력하세요");
// 첫 번째 입력 아이템은 int
    System.out.println("당신의 나이는 " + a.nextInt() + "살 입니다.");
// 두 번째 입력 아이템은 double
    System.out.println("당신의 체중은 " + a.nextDouble() + "kg 입니다.");
// 세 번째 입력 아이템은 double
    System.out.println("당신의 신장은  " + a.nextDouble() + "cm 입니다.");
  }
}