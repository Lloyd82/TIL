package test;

public class Test02 {

  public static void main(String[] args) {
    double[] arr = { 1.5, 1.6, 1.7, 1.8, 1.9 };

    double max = 10;
    double min = 0.0;

    for (int i = 0; i < arr.length; i++) {
        if (min < arr[i])
          min = arr[i];
        if (max > arr[i])
          max = arr[i];
      }

      System.out.println(max);
      System.out.println(min);
    }
  }

