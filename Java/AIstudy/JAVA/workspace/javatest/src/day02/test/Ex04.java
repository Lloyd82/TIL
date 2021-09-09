package day02.test;

public class Ex04 {

  public static void main(String[] args) {
       
    String grade="학점";
    int score = 100;
            
    if(score >= 90) {
      grade = "A";
    }else if(score >= 80 && score < 90) {
      grade = "B";
    }else if(score >= 70 && score < 80) {
      grade = "C";
    }else if(score >= 60 && score < 70) {
      grade = "D";
    }else {
      grade = "F";
    }

    System.out.println("학점 : " + grade);
  }

}
