package day04;

public class Ex09_09 {
  public static void main(String[] args) {
    String str1 = "Java Programming";
    String str2 = "Java Programming"; //동일한 문자열의 경우 같은 해시코드를 공유
    
    String str3 = new String("Java Programming");
    String str4 = new String("Java Programming");
    
    Object obj = new Object();
    Object obj2 = new Object(); //new Object(); 사용시엔 다른 헤시코드 사용

    System.out.println("원 문자열1 ==> [" + str1.hashCode() + "]");
    System.out.println("원 문자열2 ==> [" + str2.hashCode() + "]");
    System.out.println("원 문자열3 ==> [" + str3.hashCode() + "]\n");
    System.out.println("원 문자열4 ==> [" + str4.hashCode() + "]\n");

    System.out.println("문자열1==문자열2 결과 :\t " + (str1 == str2)); //'=='값비교
    System.out.println("문자열1.equals(문자열2) 결과 : " + str1.equals(str2));
    //결과상 다름 따라서 문자열 비교시엔 ==가 아닌 equals를 사용
    System.out.println("문자열1==문자열3 결과 :\t " + (str1 == str3));
    System.out.println("문자열1.equals(문자열3) 결과 : " + str1.equals(str3));
    
    System.out.println("문자열4==문자열3 결과 :\t " + (str4 == str3));
    System.out.println("obj==obj2 결과 :\t " + (obj == obj2));
  }
}