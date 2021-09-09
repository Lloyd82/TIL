package day02;

public class DoWhile {

  public static void main(String[] args) {

     int j = 1;
     
     do {
       System.out.println("번호:" +j);
       j++;
       if(j==5)break; 
     }while(j<0);
     
     System.out.println("--------- END ---------"); 
     System.out.println("do-while문 종료후의 j의 값:" + j); 

  }

}
