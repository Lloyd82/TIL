package day02.code;
public class DosInput2 { 

    public static void main(String[] args) { 
        int i1 = Integer.parseInt(args[0]); //"100" -> 100, "a" -> 오류
        int i2 = Integer.parseInt(args[1]); //2번째 수 parse'I'nt 대문자 주의
         
        System.out.println("args.length:" + args.length); 
        System.out.println("i1:" + i1); 
        System.out.println("i2:" + i2);  
        System.out.println("i1+i2:" + (i1+i2)); 
    } 

} 