package javastudy.day02;

public class Pay {

  public static void main(String[] args) {
    int year = 5;
    int child = 0;
    int pay = 1500000;

//    if (year == 0) {
//      System.out.println("신입사원입니다");
//    }else if(year == 1) {
//      pay = pay + 200000;
//      System.out.println("경력 1년 입니다");
//    }else if(year == 1) {
//      pay = pay + 400000;
//      System.out.println("경력 2년 입니다");
//    }else if(year == 1) {
//      pay = pay + 600000;
//      System.out.println("경력 3년 입니다");
//    }else if(year == 1) {
//      pay = pay + 800000;
//      System.out.println("경력 4년 입니다");
//    }else {
//      pay = pay + 1500000;

    switch (year) {
    case 0:
      System.out.println("신입사원입니다");
      pay = pay;
      break;
    case 1:
      System.out.println("경력 1년 입니다");
      pay = pay + 200000;
      break;
    case 2:
      System.out.println("경력 2년 입니다");
      pay = pay + 400000;
      break;
    case 3:
      System.out.println("경력 3년 입니다");
      pay = pay + 600000;
      break;
    case 4:
      System.out.println("경력 4년 입니다");
      pay = pay + 800000;
      break;
    case 5:
      System.out.println("경력 5년 입니다");
      pay = pay + 1500000;
      break;

    }
    if (year >= 1) {
      if (child > 1) {
        pay = pay + (child + 200000);
      }
    }
    System.out.println("기본급: " + pay);
    System.out.println("연봉: " + (pay * 13));
    System.out.println("월급여: " + (pay * 13) / 12);
  }

}
