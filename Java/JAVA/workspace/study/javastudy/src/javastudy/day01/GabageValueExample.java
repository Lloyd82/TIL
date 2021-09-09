package javastudy.day01;

public class GabageValueExample {
  public static void main(String[] args) {
    byte var1 = 125;
    int var2 = 125;
    for(int i = 0; i<5; i++) { //중괄호{}블록을 5회 반복 
      var1++;
      var2++;                         //↓'\t'는 tab 만큼 띔
      System.out.println("var1: "+var1+"\t"+"var2"+var2);
    }
      
  }

}
