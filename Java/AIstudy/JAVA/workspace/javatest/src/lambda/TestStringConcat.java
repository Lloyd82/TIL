package lambda;

public class TestStringConcat {

  public static void main(String[] args) {

    String s1 = "Hello";
    String s2 = "World";
    
    StringConcatImpl concat1 = new StringConcatImpl();
    concat1.makeString(s1, s2);
    
    StringConcat concat2 = (s,v)
                 ->{System.out.println(s+","+v);
    //i=30; 오류남 외부에서 지역 매게 변수변경X
        };
  }
}