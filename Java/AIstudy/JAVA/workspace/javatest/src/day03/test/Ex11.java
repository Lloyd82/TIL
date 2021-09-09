package day03.test;

import java.util.Calendar;
import java.util.Scanner;

public class Ex11 {

  public static void main(String[] args) {
    
    Scanner sc =new Scanner(System.in);
    Calendar now= Calendar.getInstance();
    
    System.out.println("이름, 주소, 생일");
    
    String name = sc.next();
    String address = sc.next();
    String birth =sc.next();
    
    int age=now.get(Calendar.YEAR)
          -Integer.parseInt(birth.substring(0, 4));
   
    System.out.println(" 이름 : "+ name + "\n"
                      + " 주소 : "+ address + "\n"
                      + " 나이 : "+ age);
  }

}

