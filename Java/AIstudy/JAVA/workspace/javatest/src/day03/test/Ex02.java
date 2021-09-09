package day03.test;

public class Ex02 {

  public static void main(String[] args) {
    int array[] = {89,88,75,100,92};
    
    int max = array[0]; //최대값
    int min = array[0]; //최소값
        
    for(int i=0;i<array.length;i++) {
        if(max<array[i]) {
          max = array[i];
        }
        if(min>array[i]) {
          min = array[i];
        }
        
    }
        
    System.out.println("최대값 : "+max);
    System.out.println("최소값 : "+min);
  }
}
