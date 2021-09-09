package day04;
class Score{
  //이름, 국어, 영어, 수학, 총점, 평균
 private String name;
 private int kor;
 private int eng;
 private int meth;
 
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
  public int geteng() {
    return eng;
  }
  public void setMeth(int meth) {
    this.meth = meth; 
  }
  public int getMeth() {
    return meth;
  }
  
  
  public int sumCalc() {
    return kor+eng+meth; 
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
  public class ScoreCalc {

  public static void main(String[] args) {
    //score 객체 3개 생성
    //각 개체의 이름, 점수들 할당, 총점/평슌 계산하기
    //이름, 점수들, 총점, 평균 출력
    Score s1 = new Score();
    Score s2 = new Score();
    Score s3 = new Score();
    
    s1.setName("qwe");
    s1.setKor(90);
    s1.setEng(88);
    s1.setMeth(92);
    s1.printCalc();
    
    s2.setName("asd");
    s2.setKor(68);
    s2.setEng(55);
    s2.setMeth(99);
    s2.printCalc();
    
    s3.setName("zxc");
    s3.setKor(90);
    s3.setEng(99);
    s3.setMeth(22);
    s3.printCalc();
  
  }
}
