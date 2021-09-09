package day05;
class OverB { 
    void show() { 
        System.out.println("부모클래스의 메소드 show()"); 
    } 

    void parent() { 
        System.out.println("부모클래스에만 있는 메소드 parent()"); 
    } 
} 

class SubOverB extends OverB { 
    //Overriding 
    void show() { 
        System.out.println("자식클래스의 메소드 show()"); 
    } 
} 
       
public class OverrideExam2 { 
    public static void main(String args[]) { 
        //부모 클래스 객체 생성 
        OverB ob = new OverB(); 
        ob.show();  //부모클래스의 메소드 show()  
        ob.parent(); 
         
        //자식 클래스 객체 생성 
        //상속이 무시되면서 자식 클래스의 메소드가 수행됩니다. 
        SubOverB over = new SubOverB(); 
        over.show();  //자식클래스의 메소드 show() 
        over.parent(); 

    } 
} 