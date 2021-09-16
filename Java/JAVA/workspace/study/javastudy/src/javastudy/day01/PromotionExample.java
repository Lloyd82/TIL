package javastudy.day01;

public class PromotionExample {

  public static void main(String[] args) {
    byte bytevalue = 10;
    int intvalue = bytevalue; //int < byte
    System.out.println(intvalue);
    
    char charvalue = 'a';
    intvalue = charvalue; //int < char
    System.out.println(" = " +intvalue);
    
    intvalue = 500;
    long longvalue = intvalue; //long < int
    System.out.println(longvalue);
    
    intvalue = 200;
    double doublevalue = intvalue; // double < int
    System.out.println(doublevalue);
  }
}
