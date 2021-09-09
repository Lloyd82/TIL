package day05.test;

import java.text.DecimalFormat;

class Circle {

  Circle() {
  }

  Circle(int r) {
    this.r = r;
  }

  private int r; // 반지름

  public void setR(int r) {
    this.r = r;
  }

  public int getR() {
    return r;
  }

  public double getCircleRound() {
    return (2 * Math.PI * r);
  }

  public double getCircleArea() {
    return (Math.PI * r * r);
  }

  public void printCircle() {
    DecimalFormat df = new DecimalFormat("#####.##");
    System.out.println("원의 반지름 : " + r + "\n원의 둘레 : "
                       + df.format(getCircleRound()) +"\n원의 넓이 : "
                       + df.format(getCircleArea()));
  }
}

class Rect {

  Rect() {
  }

  Rect(double x, double y) {
    this.x = x;
    this.y = y;
  }

  private double x, y;

  public void setX(int x) {
    this.x = x;
  }

  public double getX() {
    return x;
  }

  public void setY(int y) {
    this.y = y;
  }

  public double getY() {
    return y;
  }

  public double getRectRound() {
    return (2 * (x + y));
  }

  public double getRectArea() {
    return (x * y);
  }

  public void printRect() {
    DecimalFormat df = new DecimalFormat("#####.##");
    System.out.println("밑변 : " + x + "\n높이 : " + y + "\n사각형의 둘레 : " 
                        + df.format(getRectRound()) + "\n사격형의 넓이 : "
                        + df.format(getRectArea()));
  }
}

class Tri {
  Tri() {
  }

  Tri(double x, double y, double z) {
    this.x = x;
    this.y = y;
    this.z = z;
  }

  private double x, y, z; // 세변의 길이

  public void setX(double x) {
    this.x = x;
  }

  public double getX() {
    return x;
  }

  public void setY(double y) {
    this.y = y;
  }

  public double getY() {
    return y;
  }

  public void setZ(double z) {
    this.z = z;
  }

  public double getZ() {
    return z;
  }

  public double getTriRound() {
    if ((x >= y + z) || (y >= x + z) || (z >= x + y)) {
      System.out.println("잘못된값입니다.");
      return 0;
    } else {
      return (x + y + z);
    }
  }

  public double getTriArea() {
    double s = getTriRound() / 2;
    return Math.sqrt(s * (s - x) * (s - y) * (s - z));
  }

  public void printTri() {
    DecimalFormat df = new DecimalFormat("#####.##");
    System.out.println("세 변의 길이 : " + x + 
                        " " + y + " " + z +
                        "\n삼각형의 둘레 : " + df.format(getTriRound()) 
                        + "\n삼각형의 넓이 : " + df.format(getTriArea()));
  }
}

public class ShapesTest {

  public static void main(String[] args) {
    Circle c = new Circle(10);
    c.printCircle();

    Rect r = new Rect(10, 20);
    r.printRect();

    Tri t = new Tri(10, 15, 10);
    t.printTri();
  }

}
