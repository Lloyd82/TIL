package day05;
class School{ 
    int year=0; 
    public School(){ 
        this.year = 0; 
    } 
} 

class MiddleSchool extends School{ 
    int year=0; 
    public MiddleSchool(){ 
        this.year = 3; 
    } 
     
    public void prn(){ 
        System.out.println("year: " + year); 
        System.out.println("this.year: " + this.year); 
        System.out.println("super.year: " + super.year); //부모클래스 
    } 
     
} 

public class SuperTest { 

    public static void main(String[] args) { 
        MiddleSchool middleSchool = new MiddleSchool(); 
        middleSchool.prn(); 
    } 

} //이름 이 같을시 부모의 것은 숨겨짐 따라서 부모의 것을 접근할시 super를 통해서 접근