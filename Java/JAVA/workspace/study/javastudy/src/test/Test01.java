package test;

public class Test01 {

  public static void main(String[] args) {
    int a[] = {99, 89, 92, 88, 76};
    int sum = a[0]+a[1]+a[2]+a[3]+a[4];
    double avg = sum/a.length; 
    
    System.out.println(sum);
    System.out.println(avg);
    System.out.println((double)sum/5);

  }

}
