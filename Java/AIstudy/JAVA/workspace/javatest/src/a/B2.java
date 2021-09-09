package a;
public class B2 extends A2 {
         void set() {
    i = 1;
    pro = 2;
 //   pri = 3;  // private 멤버 접근 불가, 컴파일 오류 발생
    pub = 4;
      }
      public static void main(String[] args) {
    B2 b = new B2();
    b.set();
     }
}