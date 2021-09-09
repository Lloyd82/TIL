package day05;

class  Person {
  String name;
  String id;

  public Person(String name) {
  this.name = name;
   }
}
class  Student extends Person {
  String grade;
  String department;

  public Student(String name) {
  super(name);//부모의 매개변수 호출
   }
}

public class UpcastingEx {
  public static void main(String[] args) {
    Person p;
    Student s= new Student("홍길동");
    p= s;//업 캐스팅시 부모 타입만 접근 가능
    System.out.println(p.name);
    
//    p.grade ="a"; 컴파일 오류
//    p.department ="com"; 컴파일오류
    
    Student s2 = (Student)p; // 다운 캐스팅 재식, 부모 탑입에 모두 접근 가능
    s2.department = "name";
    s2.grade = "a";
    System.out.println(s2.name);
    
    System.out.println("+++++해쉬코드+++++");
    System.out.println("자식타입 : "+s.hashCode());
    System.out.println("부모타입 : "+p.hashCode());
    System.out.println("자식타입 : "+s2.hashCode());
    
//    Student s3 = (Student) new Person("길동2세");
//    System.out.println(s3);
  }
}
