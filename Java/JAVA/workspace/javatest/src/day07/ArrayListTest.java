package day07;
import java.util.ArrayList; 

class Jumsu{ 
    //멤버 변수 
  String name = "";
  int kuk;
  int eng;
  int tot;
  int avg;
    //생성자 자동생성법 > 메뉴창 source 제네레이트 컨스트럭터 유징필드 
  public Jumsu() {}
  public Jumsu(String name, int kuk, int eng) {
    //super(); //있건 없건 상관없기애 삭제 가능 
    this.name = name;
    this.kuk = kuk;
    this.eng = eng;
    this.tot = (kuk+eng);
    this.avg = (kuk+eng) / 2;
  }
  
}

public class ArrayListTest { 
  
  public static void main(String args[]){ 
  
    int i=0; 
    
    Jumsu s = null; 
    Jumsu s1 = new Jumsu("왕눈이",100, 80); 
    Jumsu s2 = new Jumsu("아로미", 80, 90); 
    Jumsu s3 = new Jumsu("투투", 90, 80); 
     
    ArrayList v = new ArrayList(); 
    v.add(s1); 
    v.add(s2); 
    v.add(s3);         

    for(i=0; i<v.size(); i++){ 
        s = (Jumsu)v.get(i); 
        System.out.print(s.name + "\t"); 
        System.out.print(s.kuk + "\t"); 
        System.out.print(s.eng + "\t"); 
        System.out.print(s.tot + "\t"); 
        System.out.print(s.avg + "\t\n");            
    } 
  } 
} 
    
  //생성자