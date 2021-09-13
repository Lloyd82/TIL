package test;

import java.util.Calendar;
import java.util.Scanner;

public class Test11 {

  public static void main(String[] args) {
    Scanner s =new Scanner(System.in);
    Calendar now= Calendar.getInstance();
    
    System.out.println("이름, 주소, 생일");
    
    String name = s.next();
    String address = s.next();
    String birth =s.next();
    
   int age=now.get(Calendar.YEAR)+1
          -Integer.parseInt(birth.substring(0, 4));
   
    System.out.println(" 이름 : "+ name + "\n"
                      + " 주소 : "+address + "\n"
                      + " 나이 : "+age);

  }

}
