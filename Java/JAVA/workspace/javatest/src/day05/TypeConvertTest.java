package day05;

class TypeConvert {
  String url = "http://www.kma.go.kr";
  public void setUrl(String url) {
    this.url = url;
  }
  public String getUrl() {
    return url;
  }
  @Override
  public String toString() {
    return"자식클래스에서 메소드 오버 라이딩";
  }
}


public class TypeConvertTest {

  public static void main(String[] args) {
    TypeConvert tc = new TypeConvert();
    Object obj = tc;// 업캐스팅 - object만 접근
    // System.out.println(obj.getUrl());
    System.out.println(tc.getUrl());

    System.out.println(obj.hashCode());
    System.out.println(tc.hashCode());

    TypeConvert tc2 = (TypeConvert) obj;// 다운캐스팅 부모 자식 타입 다 접근
    System.out.println(tc2.getUrl());
    System.out.println(tc2.hashCode());

    System.out.println(tc.toString());
    System.out.println(obj); //동적바인딩
    System.out.println(tc2);

  }

}
