package day02.test;

public class Ex03 {

  public static void main(String[] args) {
    // SwitchTest2.java -> if 문으로 변환
    char c = 'C';
    String str = "C";
    
//    switch(str.charAt(0)) { //해쉬코드로도 가능
//      case 'A': //65
//        System.out.println("입력된 코드는 A 입니다.");
//        break;
//      case 'B': //66
//        System.out.println("입력된 코드는 B 입니다.");
//        break;
//      case 'C': //67
//        System.out.println("입력된 코드는 C 입니다.");
//        break;
//      case 'D': //68
//        System.out.println("입력된 코드는 D 입니다."); 
//        break; 
//      default: 
//        System.out.println("코드는 A부터 D까지 입력해야 합니다."); 
//        break; 
      if (c== 'C') {
        System.out.println("입력된 코드는 C 입니다.");
      }else if (c=='A') {
        System.out.println("입력된 코드는 A 입니다.");
      }else if (c=='B') {
        System.out.println("입력된 코드는 B 입니다.");
      }else if (c=='C') {
        System.out.println("입력된 코드는 C 입니다.");
      }else if (c=='D') {
        System.out.println("입력된 코드는 D 입니다.");  
      }else  {
        System.out.println("코드는 A부터 D까지 입력해야 합니다.");  
    }
    
  }

}
