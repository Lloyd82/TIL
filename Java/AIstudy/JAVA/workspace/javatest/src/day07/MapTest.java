package day07;

import java.util.*;

public class MapTest {

  public static void main(String[] args) {
    HashMap map = new HashMap(); 
    map.put("0","lee"); 
    map.clear();//모두 제거 
    map.put("1","cho"); 
    map.put("2","kim"); 
    map.put("3","chung");
    map.put("4","min"); 
    map.put("3","jung");
    
    System.out.println(map);
    
    System.out.println(map.size());//size() 
    System.out.println(map.containsKey("3"));
    System.out.println("chung");
    map.remove("2"); 
    System.out.println(map); 
    System.out.println(map.size()); 
    
    print(map);
  }

  public static void print(HashMap map) {
    Set set = map.keySet();// key값을 Set으로
    Iterator iter = set.iterator();
    while (iter.hasNext()) {
      String key = (String) iter.next();
      System.out.println(key + "  " + map.get(key));// value
    }
  }
}
