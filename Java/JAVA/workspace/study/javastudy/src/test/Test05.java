package test;

public class Test05 {

  public static void main(String[] args) {
    int i1 = Integer.parseInt(args[0]); //1번째 수 
    int i2 = Integer.parseInt(args[1]); //2번째 수 
    int max, min;
    if(i1 > i2) {
      max = i1; min = i2;
        System.out.println(max);    
        System.out.println(min);   
    }else if(i1 < i2) {
      max = i2; 
      min = i1;
        System.out.println(max);    
        System.out.println(min); 
    }
  }
}
