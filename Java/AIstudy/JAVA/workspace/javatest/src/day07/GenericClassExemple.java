package day07;

class SimpleGeneric<E>{
  private E[] values;
  private int index;
  
  SimpleGeneric(int len){
    values = (E[])new Object[len];
    index = 0;
  }
  public void add(E...args) { //'...'= 가변인자. 여러개가 올수있음
    for (E e : args) {  //data 마지막까지 접근
      values[index++]=e;
    }
  }
  public void print() {
    for (E e:values) {
      System.out.println(e+" ");
    }
    System.out.println();
  }
}

public class GenericClassExemple {

  public static void main(String[] args) {
    SimpleGeneric<Integer> gint = new SimpleGeneric<Integer>(10);
    gint.add(1,2);
    gint.add(1,2,3,4,5,6,7);
    gint.add(0);
    gint.print();
    
    SimpleGeneric<Double> gdou = new SimpleGeneric<Double>(10);
    gdou.add(10.0,20.0,30.0);
    gdou.print();

  }
}