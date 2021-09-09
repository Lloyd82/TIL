package day06;
abstract class Sum{
  public abstract String toSting();//함수는 항상 괄호가 붙음
  public String sum (int i, int j) {
    int sum = i+j;
    return " "+ sum;
  }
}

class Sum_s1 extends Sum{ 
  
  @Override
  public String toSting() {
    
    return null;
  }

  public String toString(){ 
      return "class Sum_s1 extends Sum"; 
  } 
} 

class Sum_s2 extends Sum{ 
  @Override
  public String toSting() {
    
    return null;
  }

  //추상 메소드 Overriding(구현)     
  public String toString(){ 
      return "class Sum_s2 extends Sum"; 
  } 
} 
 
  
public class SumMain {

  public static void main(String[] args) {

    Sum_s1 s1 = new Sum_s1(); 
    System.out.println(s1.sum(10, 20)); 
    System.out.println(s1.toString()); 

    Sum_s2 s2 = new Sum_s2(); 
    System.out.println(s2.sum(100, 200)); 
    System.out.println(s2.toString()); 

  }

}
