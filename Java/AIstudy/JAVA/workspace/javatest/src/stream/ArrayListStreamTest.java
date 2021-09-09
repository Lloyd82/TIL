package stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ArrayListStreamTest {

  public static void main(String[] args) {
    
    List<String> sList = new ArrayList<String>();
    sList.add("tomas");
    sList.add("Edward");
    sList.add("jack");
    
    Stream<String> stream = sList.stream();
    stream.forEach(s -> System.out.println(s+" "));
    System.out.println();
    
    sList.stream().sorted().forEach(s->System.out.println(s+" "));
  // 스트림 새로 생성하여 정렬하여 출력한다.

  }

}
