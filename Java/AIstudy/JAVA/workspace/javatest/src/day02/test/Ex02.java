package day02.test;

public class Ex02 {

  public static void main(String[] args) {
    // SwitchTest.java -> if 문으로 변환
    int k = 4;
    
//    switch(k) {
//      case 1:
//        System.out.println("1입니다.");
//        break;
//      case 2:
//        System.out.println("2입니다.");
//      case 3:
//        System.out.println("3입니다.");
//      case 4:
//        System.out.println("4입니다.");
//      default:
//        System.out.println("1부터 4까지 입력해야 합니다.");
//        break;
     if(k==1) {
       System.out.println("1입니다.");
     }else if(k==2) {
       System.out.println("2입니다.");
     }else if(k==3) {
       System.out.println("3입니다.");
     }else if(k==4) {
       System.out.println("4입니다."); 
     }else {
       System.out.println("1부터 4까지 입력해야 합니다.");
     }
    
    }

}
