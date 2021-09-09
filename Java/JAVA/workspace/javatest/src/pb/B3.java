package pb;

import pa.A3;

public class B3 extends A3 {
  void set() {
 //   i = 1; // i는 default 멤버, 컴파일 오류
    pro = 2;
  //  pri = 3; // private 멤버 접근 불가, 컴파일 오류 발생
    pub = 4;
  }

  public static void main(String[] args) {
    B3 b = new B3();
    b.set();
  }
}