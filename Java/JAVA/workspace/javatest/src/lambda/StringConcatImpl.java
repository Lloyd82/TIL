package lambda;

public class StringConcatImpl implements StringConcat {

  @Override
  public void makeString(String s1, String s2) {
    System.out.println(s1 + "," + s2);
  } //익명의 내부 클래스 AnonymousInnerClass
}
