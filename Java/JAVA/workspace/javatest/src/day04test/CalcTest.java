package day04test;

import java.util.Scanner;

import day04test.Calc;

class Calc {
//멤버 변수 int -> 수1, 수2, 연산자 opertion
// private, setter, getter
// input(), calc(), print()
  Scanner s = new Scanner(System.in);

  // instance variable(인스턴스 변수)
  private int num1;
  private int num2;
  private int oper; //연산자

  public Calc() {
  }

  public void setNum1(int num1) {
    this.num1 = num1;
  }

  public int getNum1() {
    return num1;
  }

  public void setNum2(int num2) {
    this.num2 = num2;
  }

  public int getNum2() {
    return num2;
  }

  public void setoper(int oper) {
    this.oper = oper;
  }

  public int getoper() {
    return oper;
  }

  public void input() {

    num1 = s.nextInt();
    num2 = s.nextInt();
    oper = s.nextInt();
  }
    int oper() {
    int oper = 0;
    if(oper == 1) {
      oper = num1+num2;
    }
    else if(oper == 2) {
      oper = num1-num2;
    }
    else if(oper == 3) {
      oper = num1*num2;
    }
    else if(oper == 4) {
      oper = num1/num2;
    }
    else if(oper == 5) {
      oper = num1%num2;
    }
    else { 
      System.out.println("1부터 5까지만");
    }
    return oper;
    }
  public int calc(int num1, int num2, int oper) {

    // lv(loal variable 지역변수)
    int a = 0;

    switch (a) {
    case 1:
      a = num1 + num2;
      break;
    case 2:
      a = num1 - num2;
      break;
    case 3:
      oper = num1 / num2;
      break;
    case 4:
      oper = num1 * num2;
      break;
    case 5:
      oper = num1 % num2;
      break;
    }
    return a;

  }

  public void print() {
    System.out.println(calc(num1, num2, oper));
  }
}

public class CalcTest {

  public static void main(String[] args) {

    Calc c = new Calc();
    c.input();
    c.print();
  }
}