package day04;
//하나의 java 파일안에 클래스가 2개이상 존재하는 경우 
//main()메소드가 있는 오직 하나의 클래스만 public을 선업합니다. 
//일반적으로 main()가 있으면 무조건 public을 선언하며 
//파일명은 public 클래스명과 일치해야 합니다. 

class SCWCD{ 
    int t1=0; 
    int t2=0; 
    int t3=0; 
    int t4=0; 
    static int BONUS=100;  
         
    public SCWCD(){ 
    } 
     
    public SCWCD(int t1, int t2, int t3, int t4){ 
        this.t1 = t1; 
        this.t2 = t2; 
        this.t3 = t3; 
        this.t4 = t4;         
    } 
     
    //클래스 메소드  
    public static void prLine(){ 
        System.out.println("****************"); 
        System.out.println("   SOLDESK       "); 
        System.out.println("         JAVA   "); 
        System.out.println("****************"); 
    } 
} 



public class SCWCDmain { 
    public static void main(String[] args) { 
        //클래스.static 메소드명 
        SCWCD.prLine();  
    } 
} 