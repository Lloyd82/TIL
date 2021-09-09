package lambda;

@FunctionalInterface // 함수형 인터페이스 증거
public interface MyNumber {

  int getMax(int num1, int num2);

//  int getAdd(int num1, int num2); //함수형 인터페이스는 하나의 메서드만 사용
}