package javastudy.day01;

public class CharExample {

  public static void main(String[] args) {
    char c1 = 'A'; // 臾몄옄瑜� 吏곸젒 ���옣
    char c2 = 65; // 10吏꾩닔濡� ���옣
    char c3 = '\u0041'; // 16吏꾩닔濡� ���옣

    char c4 = '가'; 
    char c5 = 44032;
    char c6 = '\uac00';
   
    
    int uniCode = c1; //�쑀�땲肄붾뱶 �뼸湲�
    
    System.out.println(c1);
    System.out.println(c2);
    System.out.println(c3);
    System.out.println(c4);
    System.out.println(c5);
    System.out.println(c6);
    System.out.println(uniCode);
    
  }

}
/*char var1 = 'A'; //�쑀�땲肄붾뱶 0x0041 > 2吏꾩닔 :00000000 01000001
/*char var1 = 'B'; //�쑀�땲肄붾뱶 0x0042 > 2吏꾩닔 :00000000 01000010
/*char var1 = '媛�'; //�쑀�땲肄붾뱶 0xAC00 > 2吏꾩닔 :10101100 01000001
/*char var1 = '媛�'; //�쑀�땲肄붾뱶 0xAC01 > 2吏꾩닔 :10101100 01000010 
 * 珥앸쾾�쐞 0~65535, 0~127 askii 44032~55203源뚯� �븳湲�*/

