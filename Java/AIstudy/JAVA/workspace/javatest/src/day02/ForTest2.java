package day02;
public class ForTest2 { 
    public static void main(String[] args) { 

        outer: for (int i=0; i<=2; i++) { 
                    for (int j=2; j>=0; j--) { 
                        if (i==j) break outer; 
                        System.out.println("i==" + i + " j==" + j); 
                    } 
                } 
    } 
} 
 //거의 사용하지 않음 사유 하나만 사용하는 경우가 거의 없기에...