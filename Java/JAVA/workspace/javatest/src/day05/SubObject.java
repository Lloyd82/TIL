package day05;

class SuperObject {
  protected String name;

  public void paint() { //<요거
    draw();
  }

  public void draw() {
    System.out.println(name);
  }
}  
public class SubObject extends SuperObject{
  protected String name;
  public void draw() {
    name = "sub";
    super.name = "super"; 
    super.draw(); // draw 호출
    System.out.println(name);
  }

  public static void main(String[] args) {
    SuperObject b = new SubObject();
    b.paint(); // 부모의 paint()호출
  }
}
