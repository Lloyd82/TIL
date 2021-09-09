package day02;

public class SwitchTest2 {

  public static void main(String[] args) {
    char c = 'C';
    String str = "Cdef";
    
    switch(str.charAt(0)) { //해쉬코드로도 가능
      case 'A': //65
        System.out.println("입력된 코드는 A 입니다.");
        break;
      case 'B': //66
        System.out.println("입력된 코드는 B 입니다.");
        break;
      case 'C': //67
        System.out.println("입력된 코드는 C 입니다.");
        break;
      case 'D': //68
        System.out.println("입력된 코드는 D 입니다."); 
        break; 
      default: 
        System.out.println("코드는 A부터 D까지 입력해야 합니다."); 
        break; 
    }

  }

}
