package day04;

class Pay {
  int ppp;

  public void payRefer(Pay a) { //해시
    a.ppp = a.ppp + 2000;
  }

  public int payValue(int j) { //값
    j = j + 2000;
    return j;
  
  }
}

public class PayTest {
  
  public static void main(String[] args) {
    Pay p = new Pay();
    p.ppp = 10;

    int i = 10; //메인 지역변수

    p.payRefer(p); // call by reference로 전달
    i=p.payValue(i); // call by value로 전달 i= >리턴 설정후 j를 활용 가능
    
    System.out.println(p.ppp); // 객체가 변경되서 2010
    System.out.println(i);// 10
  }

}