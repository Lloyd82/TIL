package day03.code;
class Score{
  //이름, 국어, 영어, 수학, 총점, 평균
  //수학점수, 총점, 평균 - 실수
 private String name;
 private int kor;
 private int eng;
 private int math;
 
 
 public Score() {}
 public Score(String name, int kor, int eng, int math) {
   this.name = name;
   this.kor = kor;
   this.eng = eng;
   this.math = math;
 }
 
 
 
 
 public void setName(String name) {
    this.name = name; 
  }
  public String getName() {
    return name;
  }
  public void setKor(int kor) {
    this.kor = kor; 
  }
  public int getKor() {
    return kor;
  }
  public void setEng(int eng) {
    this.eng = eng; 
  }
  public int getEng() {
    return eng;
  }
  public void setMath(int math) {
    this.math = math; 
  }
  public int getMath() {
    return math;
  }
  public int sumCalc() {
    return kor+eng+math; 
  }
  public double avgCalc() {
    return sumCalc() / 3;
  }
  public void printCalc() {
    System.out.println("-------------");
    System.out.println("     성적");
    System.out.println("-------------");
    System.out.println("성명 : " + name);
    System.out.println("국어 : " + kor);
    System.out.println("영어 : " + eng);
    System.out.println("수학 : " + math);
    System.out.println("총점 : " + sumCalc());
    System.out.println("평균 : " + avgCalc());
    
  }
    
}

class Grade extends Score{
  
  Grade(String name, int kor, int eng, int math) {
    super(name, kor, eng, math);
  }
  
    public String getGrade(double avg) {
      String grade = null;
      if (avg >= 90) {
        grade = "A";
      } else if (avg < 90 && avg >= 80) {
        grade = "B";
      } else if (avg < 80 && avg >= 70) {
        grade = "C";
      } else if (avg < 70 && avg >= 60) {
        grade = "D";
      } else {
        grade = "F";
      }
      return grade;
    }
    //오버라이드 printScore()
    @Override
    public void printCalc() {
      System.out.println("-----------------------");
      System.out.println("grade class");
      System.out.println("이름: " + getName());
      System.out.println("국어: " + getKor());
      System.out.println("영어: " + getEng());
      System.out.println("수학: " + getMath());
      System.out.println("total: " + sumCalc());
      System.out.println("avg: " + avgCalc());
      System.out.println("등급: " + getGrade(avgCalc()));  
  
  }
 
}
  public class ScoreCalc2 {

  public static void main(String[] args) {
    //score 객체 3개 생성
    //각 개체의 이름, 점수들 할당, 총점/평슌 계산하기
    //이름, 점수들, 총점, 평균 출력
    Score s1 = new Score("qwe", 90,88,92);
    Score s2 = new Score("asd", 68, 55,99);
    Score s3 = new Score("zxc", 90, 99, 22);
//  Score s4 = new Score("qaz", 77, 88, 95); 
    
    
//    s1.setName("qwe");
//    s1.setKor(90);
//    s1.setEng(88);
//    s1.setMeth(92);
    s1.printCalc();
    
//    s2.setName("asd");
//    s2.setKor(68);
//    s2.setEng(55);
//    s2.setMeth(99);
    s2.printCalc();
    
//    s3.setName("zxc");
//    s3.setKor(90);
//    s3.setEng(99);
//    s3.setMeth(22);
    s3.printCalc();
    
//    s4.setName("qaz");
//    s4.setKor(77);
//    s4.setEng(88);
//    s4.setMath(95);
//    s4.printCalc();
    
    
    Grade g1 = new Grade("qaz",77,88,95);
    g1.printCalc();
    
//    grade s4 = new Grade(77, 88, 95);
//    s4.setName("qaz");
//    s4.setKor(77);
//    s4.setEng(88);
//    s4.setMath(95);
//    s4.printCalc();   
     
  
  }
}
