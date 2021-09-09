package stream;

public class TravelCustomer {

  private String name; // 이름
  private int age; // 나이
  private int price; // 가격

  public TravelCustomer(String name, int age, int price) {
    this.name = name;
    this.age = age;
    this.price = price;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  public int getPrice() {
    return price;
  }

  public String toString() {
    return "name: " + name + "age: " + age + "price: " + price;
  }
}
//- 세명의 고객을 ArrayList에 추가하고 이에 대한 스트림을 생성하여 다음 연산을 수행한다.
//- 스트림의 메서드로 코드를 간결하게 작성할 수 있다.

//1. 고객명단을 출력한다.
//2. 여행의 총 비용을 계산한다.
//3. 고객 중 20세 이상인 사람을 정렬하여 출력한다.

