package day05.test;
class TV{
 
  }


class Movie extends TV{ 
    String part="한국 영화"; 
    Movie(){
      super();
    }
} 

class Action extends Movie{ 
    String name=" "; 
    
    Action(){
      super();//부모의 기본생성자 호출
    }
} 

public class MovieTest { 
    public static void main(String[] args) { 
        //기본 생성자는 자동으로 생성되어 사용됩니다.  
        Action act = new Action(); 
        act.name="마파도"; //이문식 
        System.out.println(act.name); 
    } 
} 
