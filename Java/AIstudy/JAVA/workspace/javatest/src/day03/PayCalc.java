package day03;
class Pay { 
  //멤버 변수, 인스턴스 변수, 필드 
  private String name; 
  private int    bonbong; 
   
  public Pay() {}
  public Pay(String name, int bonbong) {
    this.name = name;
    this.bonbong = bonbong;
  }

  public void setName(String name) {
    this.name = name;
  }
  
  public String getName() {
    return name;
  }
  
  public void setBonbong(int bonbong) {
    this.bonbong = bonbong;
  }
  
  public int getBonbong() {
    return bonbong;
  }
  
  public int taxCalc() {
    return (int)(bonbong * 0.05 + 0.5);
  }
  
  public int silsuCalc() {
    return bonbong - taxCalc();
  }
  
  public void printPay() {
    System.out.println("성명: " + name); 
    System.out.println("본봉: " + bonbong); 
    System.out.println("세금: " + taxCalc()); 
    System.out.println("실수령액: " + silsuCalc()); 
  }
} 

class ExtraPay extends Pay{
  private int year ;         //근무(경력) 년수 
  private int child ;        //자녀수 

  ExtraPay(){}
  ExtraPay(String name, int bonbong, int year, int child){
    super(name,bonbong);
    this.year = year;
    this.child = child;
  }
  public int getYear() {
    return year;
  }
  public void setYear(int year) {
    this.year = year;
  }
  public int getChild() {
    return child;
  }
  public void setChild(int child) {
    this.child = child;
  }
  
  public int getExtraPay() {
    int pay = 0;
    
    if (year == 0){ 
        System.out.println("신입사원입니다.");     
    }else if (year == 1) { 
        pay = 200000; 
        System.out.println("경력 1년 입니다."); 
    }else if(year == 2) { 
        pay = 400000; 
    }else if(year == 3) { 
        pay = 600000; 
    }else if(year == 4) { 
        pay =  800000; 
    }else{ 
        pay =  1500000; 
    } 
     
    //자녀수당을 계산합니다. 
    if ( year >=1){ 
        if (child > 1){ 
            pay = pay + (child * 200000); 
        } 
    }
    
    return pay;
  }
  @Override
  public void printPay() {
    System.out.println("성명: " + getName()); 
    System.out.println("본봉: " + getBonbong()); 
    System.out.println("세금: " + taxCalc()); 
    System.out.println("수당: " + getExtraPay());
    System.out.println("실수령액: " + (silsuCalc()+getExtraPay())); 
  }
   
}


public class PayCalc { 

    public static void main(String[] args) { 
 
        Pay p1 = new Pay(); 
        Pay p2 = new Pay();
        Pay p3 = new Pay("홍길동",4000000);
        p3.printPay();
        
        p1.setBonbong(2000000); 
        p1.setName("왕눈이"); 
        p1.printPay();
         
        p2.setBonbong(2500000); 
        p2.setName("아로미");  
        p2.printPay();
        
        ExtraPay ep = new ExtraPay();
        ep.setName("김길동");
        ep.setBonbong(3000000);
        ep.setYear(3);
        ep.setChild(2);
        ep.printPay();
        
        ExtraPay ep2 = new ExtraPay("이길동",4000000,4,1);
        ep2.printPay();
         
      } 

} 