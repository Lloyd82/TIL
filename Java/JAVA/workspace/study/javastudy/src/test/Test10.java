package test;

import java.util.Scanner;

public class Test10 {

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    boolean run = true;
    int balance = 0;
    while(run) {
      System.out.println("--------------------------");
      System.out.println("1.입금 | 2.출금| 3.잔고| 4.종료");
      System.out.println("--------------------------");
      
      //작성위치
      
      String input;
      input = s.next();
      
      switch(input){
      
      case "1":
        while(true) {
          System.out.println("입금금 액을 입력하세요")
          m.deposit = s.nextint();
          if(m.deposit > 0){
             System.out.println(m.deposit + "원이 입금되었습니다");
             
          }}
      
    }

  }

}
