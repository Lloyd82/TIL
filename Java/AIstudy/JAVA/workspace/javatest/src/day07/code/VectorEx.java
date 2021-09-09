package day07.code;

import java.util.Vector;

public class VectorEx {

  public static void main(String[] args) {
    Vector v = new Vector();
    v.add("Hello");
    v.add(new Integer(4));
    v.add(new Double(3.14));
    System.out.println("벡터내의 요소 객채수 : " +v.size());
    System.out.println("벡터내의 현재 용량 : " +v.capacity());
    
    for(int i = 0; i<v.size(); i++) {
      Object obj= v.get(i);
      if(obj instanceof String) { //String 객체의 경우
        String str = (String)obj;
        System.out.println(str); // 'instanceof' 연산자이며 참변이 참조하고있는 
      }                          // 실제 타입을알아보기 위한 명령어 주로 조건문에서 활용
      else if(obj instanceof Integer) {  // Integer 객체의 경우
        Integer x = (Integer)obj;
        int n = x.intValue();// .intValue() 선언되고 참조변수만 가져오기에 생략가능
        System.out.println(n);
      }
      else if(obj instanceof Double) {  // Double 객체의 경우
        Double y = (Double)obj;
        double d = y.doubleValue(); //.intValue() 선언되고 참조변수만 가져오기에 생략가능
        System.out.println(d);
      }
    }

  }

}
