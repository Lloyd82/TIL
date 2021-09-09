package lambda;
 
interface PrintString{
    
    void showString(String str);
}
 
public class TestLambda {
 
    public static void main(String[] args) {
        //↓인터 페이스
        PrintString lambdaStr = s->System.out.println(s); //람다식을 변수에 대입
        lambdaStr.showString("hello lambda_1");
        //↑PrintString lambdaStr = new PrintString(){
        //                         String show String(s) {
        //                         System.out.println(s)
        //                         } >객채지향 일반형
        // labdaStr.showString("hello lambde_1");
        showMyString(lambdaStr); //메서드를 매개변수를 전달
        
        PrintString reStr = returnString();
        reStr.showString("hello ");
    }
    public static void showMyString(PrintString p) {
      p.showString("hello lambda_2");} //매개변수로 전달하는 람다식
      //- 람다식을 변수에 대입하면 이를 매개변수로 전달할 수 있다.이 때 전달되는 매개변수의 자료형은 인터페이스형이다.
    
    public static PrintString returnString() {         //반환 값으로 사용
        return s->System.out.println(s + "world");
        //↑ 메서드의 반환형을 람다식의 인터페이스형으로 선언하면 구현한 람다식을 반환할 수 있다.
        //  반환 값으로 쓰이는 람다식
        
  }
}