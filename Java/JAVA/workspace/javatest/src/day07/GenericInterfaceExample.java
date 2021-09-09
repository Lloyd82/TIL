package day07;

interface GenericInterface<T> {
  public void setValue(T x);

  public String getValueType(); //추상 매서드이기애 퍼블릭 생략가능
}

class GenericClass<T> implements GenericInterface<T> {
  private T value;     //ㄴ반드시 부모의 메서드를 오버라이딩해야함

  public void setValue(T x) {
    value = x; //부모의 메서드 재정의 = 오버라이딩
  }

  public String getValueType() {
    return value.getClass().toString(); //
  }
}

public class GenericInterfaceExample {
  public static void main(String[] args) {
    GenericClass<Integer> gInteger = new GenericClass<Integer>();
    GenericClass<String> gString = new GenericClass<String>();
    gInteger.setValue(10);
    gString.setValue("Text");
    System.out.println(gInteger.getValueType());
    System.out.println(gString.getValueType()); 
  }
}