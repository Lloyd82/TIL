package javastudy.day01;

public class ByteExample {

  public static void main(String[] args) {
    byte var1 = -128;
    byte var2 = -30;
    byte var3 = 0;
    byte var4 = 30;
    byte var5 = 127;
    //byte var6 = 128; 컴파일 에러 사유:기본 변수 byte의 최대값 초과
    
    System.out.println(var1);
    System.out.println(var2);
    System.out.println(var3);
    System.out.println(var4);
    System.out.println(var5);

  }

}
/* byte 타입은 색상정보및 파일 또는 이미지등의 이진(바이너리) 데이터를처리 할때 주로 사용 
 * 범위 -128 ~ 127  
 */