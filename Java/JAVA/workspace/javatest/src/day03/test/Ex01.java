package day03.test;

public class Ex01 {

  public static void main(String[] args) {
    int arr[] = {15, 86, 22, 65, 77};
     
    int sum = 0;
        
    for(int i = 0; i<arr.length; i++) {
        sum += arr[i];}
    
    System.out.println(sum);
    System.out.println(sum/arr.length);
  }
}
