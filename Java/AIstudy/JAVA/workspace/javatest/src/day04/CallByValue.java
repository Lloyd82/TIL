package day04;

class Person{
  String name;    //필드
  int age;        //필드
  
  Person(String s){ // 생성자 < 필드 초기화 역할
    name= s;
  }
  public void setAge(int n) {
    age = n; //객체의 age영역에 33을 할당 >멤버변수 할당
    n++; // 34 > 지역변수이기에 괄호 안에서 출력하지 않는 한 사라짐
  }
  
}

public class CallByValue {

  public static void main(String[] args) {
    
    Person p = new Person("홍길동");
    int a =33; 
    
    p.setAge(a);
    
    System.out.println(a);
    //System.out.println(p.hashcode());
    //System.out.println("홍길동".hashcode());

  }

}
