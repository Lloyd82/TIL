package day07;

import java.util.*;

public class ListTest1 {
  public static void main(String[] args) {
    ArrayList list = new ArrayList();
    list.add("lee"); //0
    list.clear(); // .clear 전부삭제
    list.add("cho"); //0
    list.add("kim"); //1
    list.add("chung");//2
    list.add("min"); //3
    list.add("chung"); //4 List 는 순서를 기억하기에 중복가능
    System.out.println("ArrayList 사이즈:" + list.size());// size()
    System.out.println(list.contains("chung"));
    list.remove("kim"); // '.remove'1개체 삭제
    list.remove(3);
    System.out.println("ArrayList 사이즈:" + list.size());
    System.out.println("min이 있는 위치값:" + list.indexOf("min"));

    System.out.println("Iterator를 이용해서 출력");
    print(list);
    System.out.println("배열를 이용해서 출력");
    print(list.toArray());
    // ArrayList 에서 0에서 1까지의 데이타 추출
    List sublist = list.subList(0, 2);// 0~2-1까지
    System.out.println("추출된 데이타만 출력");
    print(sublist);
    System.out.println("for문을 이용해서 출력");
    printGet(list);
  }

  public static void print(List list) {
    Iterator iter = list.iterator(); // 'Iterator' 컬랙션 프래임워크에서 저장된 요소들을 표준화한것
    while (iter.hasNext()) {         //컬랙션 프래임 워크란 데이터를 저장하는 클래스들을 표준화한 설계
      String str = (String) iter.next();
      System.out.println(str);
    }
  }//

  public static void print(Object[] obj) {
    int count = obj.length;
    for (int i = 0; i < count; i++) {
      System.out.println(obj[i]);
    }
  }//

  public static void printGet(List set) {
    int count = set.size();
    for (int i = 0; i < count; i++) {
      System.out.println(set.get(i));
      // String str=(String)set.get(i)
    }
  }//
}