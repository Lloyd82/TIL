package day03.test;

public class Ex06 {

  public static void main(String[] args) {
    int num = Integer.parseInt(args[0]);

    if(num>0) System.out.println("양수");
    if(num<0) System.out.println("음수");
    if(num==0) System.out.println("0");
  }
}
