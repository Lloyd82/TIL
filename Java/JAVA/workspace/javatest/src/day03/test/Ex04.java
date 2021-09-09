package day03.test;

import java.util.Calendar;

public class Ex04 {

  public static void main(String[] args) {
    String name=args[0];
    String number=args[1];
    String addr=args[2];
    String jumin=args[3];
    
    Calendar calendar = Calendar.getInstance(); 
    int currYear= calendar.get(Calendar.YEAR); 
    int age = currYear - (Integer.parseInt(jumin.substring(0,2))+ 1900);
   
    System.out.println("이름: "+ name);
    System.out.println("전화번호: "+ number);
    System.out.println("주소: "+ addr);
    System.out.println("나이: "+ age);
    
    
  }
}