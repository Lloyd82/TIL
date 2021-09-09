package day05;
class Overc{
  int i,j;
  Overc(){} // 기본생성자 (생성자가 있을시 무조건 생성
  Overc(int i, int j){
    this.i = i;
    this.j = j;
  }
  void show() {
    System.out.println("상위 클래스의 메소드 show()실행");
  }
}
class SubOverC extends Overc{
  int k;
  public SubOverC(int i, int j, int k) {
    super(i,j); //부모의 매개 변수
    this.k= k;
  }
  void show() {
    System.out.println("하위 클래스의 메소드 show()수행");
    System.out.println("====super를 이용한 상위 클래스 메소드를 호출====");
    super.show(); //부모의 show() 호출 - 매소드 오버 라이딩 리워드  
  }
}  
public class SuperExam {

  public static void main(String[] args) {
    SubOverC over1 = new SubOverC(10, 20, 30);// 10과 20은 부모  30은 상속(자기자신
    System.out.println("i,j,k,의 값 "+over1.i + " "+over1.j+" "+over1.k);
    over1.show();
    
  }
}
