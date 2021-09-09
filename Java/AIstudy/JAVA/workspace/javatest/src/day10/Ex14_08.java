package day10;

public class Ex14_08 {
  public static void main(String[] args) {

    class Car extends Thread {
      String carName;

      Car(String carName) {
        this.carName = carName;
      }
//                 ↓ 실행메소드
      public void run() {
        for (int i = 0; i < 3; i++) {
          try {
            Thread.sleep(10); //준비 상태일때 상태값 까지 가져감
            System.out.println(carName + "~~ 달립니다.");

          } catch (Exception e) {
          }
        }
      }
    }

    Car car1 = new Car("$자동차1");
    car1.start();

    Car car2 = new Car("@자동차2");
    car2.start();

    Car car3 = new Car("*자동차3");
    car3.start();
  }
}
