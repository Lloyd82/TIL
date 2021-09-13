package test;

class Score {
  // 이름, 국어, 영어, 수학, 총점, 평균
  String name;
  int kor;
  int eng;
  int meth;

  public int sumCalc() {
    return kor + eng + meth;
  }

  public int avgCalc() {
    return sumCalc() / 3;
  }

  public void printCalc() {
    System.out.println("-------------");
    System.out.println("     성적");
    System.out.println("-------------");
    System.out.println("성명 : " + name);
    System.out.println("국어 : " + kor);
    System.out.println("영어 : " + eng);
    System.out.println("수학 : " + meth);
    System.out.println("총점 : " + sumCalc());
    System.out.println("평균 : " + avgCalc());
  }

}

public class ScoreCalc2 {

  public static void main(String[] args) {
    // score 객체 3개 생성
    // 각 개체의 이름, 점수들 할당, 총점/평? 계산하기
    // 이름, 점수들, 총점, 평균 출력
    Score s1 = new Score();
    Score s2 = new Score();
    Score s3 = new Score();

    s1.name = "qwe";
    s1.kor = 90;
    s1.eng = 88;
    s1.meth = 92;
    s1.printCalc();

    s2.name = "asd";
    s2.kor = 68;
    s2.eng = 55;
    s2.meth = 99;
    s2.printCalc();

    s3.name = "zxc";
    s3.kor = 90;
    s3.eng = 99;
    s3.meth = 22;
    s3.printCalc();

  }
}