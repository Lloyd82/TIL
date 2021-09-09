package day06.coding;

class SuperObject {
  protected String name;

  public void paint() {
    draw();
  }

  public void draw() {
    System.out.println(name); //up casting
  }
}

public class SubObject extends SuperObject {
  protected String name;

  public void draw() {
    name = "Sub";
    super.name = "Super"; //업캐스팅 발생
    super.draw();
    System.out.println(name);
  }

  public static void main(String[] args) {
    SuperObject b = new SubObject();
    b.paint();
  }
}