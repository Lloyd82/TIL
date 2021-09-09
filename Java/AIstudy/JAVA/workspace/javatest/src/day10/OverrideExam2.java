package day10;

class OverB {
  void show() {
    System.out.println("부모 클래스의 메서드 show");
  }

  void parent() {
    System.out.println("부모 클레스에만 있는 메서드 parent()");
  }
}

class SubOverB extends OverB {

  @Override
  void show() {
    // TODO Auto-generated method stub
    super.show();
    System.out.println("자식 클래스의 메서드 show(");

  }

}

public class OverrideExam2 {

  public static void main(String[] args) {
    SubOverB sub = new SubOverB();
    // sub로 호출할수있는 메서드, show (오버라이딩 메서드), parent(부모 메서드)
    sub.parent();
    sub.show();

    OverB over = new OverB();
    sub.show();
    sub.parent();
    // over 를 호출 할수 있는 메서드, 자신의 show, parent

    OverB B = new SubOverB();
    // o 를 호출 할수 있는 메서드, OverB타입의 모든 메서드 단 오버라이드된 자식의 메서드가 호출
    sub.parent();
    sub.show();// 동적 바인딩

  }

}
