package day02.code;

public class ArithmeticOperator {
  public static void main(String[] args) {
    final int TIME = 500; // 상수 선언
    int second;
    int minute;
    int hour;

    second = TIME % 60; // 500초를 60으로 나눈 나머지는 초를 의미
    minute = (TIME / 60) % 60; // 500초를 60으로 나눈 몫을 다시 60으로 나눈 나머지
    hour = (TIME / 60) / 60; // 500초를 60으로 나눈 몫을 다시 60으로 나눈 몫
    System.out.print(TIME + "초는 ");
    System.out.print(hour + "시간, ");
    System.out.print(minute + "분, ");
    System.out.println(second + "초입니다.");
  }
}