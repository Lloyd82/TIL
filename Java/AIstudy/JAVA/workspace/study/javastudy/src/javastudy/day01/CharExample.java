package javastudy.day01;

public class CharExample {

  public static void main(String[] args) {
    char c1 = 'A'; // 문자를 직접 저장
    char c2 = 65; // 10진수로 저장
    char c3 = '\u0041'; // 16진수로 저장

    char c4 = '가'; 
    char c5 = 44032;
    char c6 = '\uac00';
   
    
    int uniCode = c1; //유니코드 얻기
    
    System.out.println(c1);
    System.out.println(c2);
    System.out.println(c3);
    System.out.println(c4);
    System.out.println(c5);
    System.out.println(c6);
    System.out.println(uniCode);
    
  }

}
/*char var1 = 'A'; //유니코드 0x0041 > 2진수 :00000000 01000001
/*char var1 = 'B'; //유니코드 0x0042 > 2진수 :00000000 01000010
/*char var1 = '가'; //유니코드 0xAC00 > 2진수 :10101100 01000001
/*char var1 = '각'; //유니코드 0xAC01 > 2진수 :10101100 01000010 
 * 총범위 0~65535, 0~127 askii 44032~55203까지 한글*/

