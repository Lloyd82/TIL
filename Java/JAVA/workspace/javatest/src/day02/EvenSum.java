package day02;
  public class EvenSum { 
    public static void main(String[] args) { 
      int sum = 0; 

      for(int i=1;i<=100;i++){ 
        if(i % 2 == 1){ 
          sum += i; 
        } 
      } 

      System.out.println("1~100까지 홀수의 합:"+sum); 

    } 

} 