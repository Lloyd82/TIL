package javastudy.day01;

public class VariableScopeExemple {

  public static void main(String[] args) {
    int v1 = 15;
    if(v1>10) {
      int v2 = v1 - 10;
    }
    int v2= v1 +  + 5; //v2 변수를 사용할수 없기 때문애 컴파일에러가 생김
    System.out.println(v2);
  }
  
}