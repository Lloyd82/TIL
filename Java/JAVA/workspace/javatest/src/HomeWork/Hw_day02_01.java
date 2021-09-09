package HomeWork;

public class Hw_day02_01 {
  public class OverrideParent {
    public void call() {
      System.out.println("부모 매서드");
    }

    public class OverrideChild extends OverrideParent {
      public void call() {
        System.out.println("자식 매서드");
      }
    }

    public void main(String[] args) {
      OverrideChild ot = new OverrideChild();
      ot.call();
    }
  }
}
