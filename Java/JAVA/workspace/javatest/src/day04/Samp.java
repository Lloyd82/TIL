package day04;

public class Samp {
  
    
    int id;
    
    public Samp() {
      //this.id=0;
    }
    public Samp(int x) {
      this.id=x;
    }
    public void set(int x) {
      this.id=x;
    }
    public int get() {
      return this.id;
    }

    public static void main(String[] args) {
      Samp ob1 = new Samp(); //기본생성자 -> set 객체초기화 ->사용
      ob1.set(100);
      System.out.println(ob1.get());
      
      Samp ob2 = new Samp(300); // 매개변수 생성자 -> 사용
      System.out.println(ob2.get());

  }

}
