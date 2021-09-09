package day07;

public class GenericMethodExample {
  public static <E> void printArgInfo(E arg) { //'<E>' 선언 위치 유의
    System.out.print("Argument Type is " + arg.getClass());
    System.out.println(" / Value is " + arg);
  }

  public static void main(String[] args) {
    Integer i = new Integer(10);
    char c = 'A';
    float f = 3.14f;
    printArgInfo(i); // <Integer> void printArgInfo(Integer)
    printArgInfo(c); // <Character> void printArgInfo(Character)
    printArgInfo(f); // <Float> void printArgInfo(Float)
  }
}