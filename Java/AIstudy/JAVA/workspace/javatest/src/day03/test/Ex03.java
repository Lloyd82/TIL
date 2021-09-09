package day03.test;

public class Ex03 {

  public static void main(String[] args) {
    int score[] = {-11, 15,-5, 1 ,-9};
    
    for(int i = 0;i < score.length;i++) {
      
      int a = score[i];
      
      if(a < 0) {score[i] = a * -1;}
      
      System.out.println(score[i]);
      
      //math
      //score[i] = Math.abs(a);
      //if
      
    }
  }
}

      
      
      
    
    
    
 
    
    
 