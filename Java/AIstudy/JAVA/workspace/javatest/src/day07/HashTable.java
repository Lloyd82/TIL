package day07;

import java.util.Hashtable;
import java.util.Iterator;
 

public class HashTable {

  public static void main(String[] args) {
    Hashtable ht = new Hashtable(); 
    
    ht.put("AREA01", "대한민국"); 
    ht.put("AREA02", "러시아"); 
    ht.put("AREA03", "중국"); 
    ht.put("AREA04", "일본"); 
     
    String area = (String)ht.get("AREA01"); 
    //String area = (String)ht.get("AREA05"); 
     
    if ( area != null){ 
        System.out.println(area); 
    }else{ 
        System.out.println("검색 지역이 없습니다."); 
    } 
 
    System.out.println(ht);
    
    Iterator iter = ht.keySet().iterator();
    while(iter.hasNext()) {
      String key = (String) iter.next();
      System.out.println(key + "=" + ht.get(key));
      
    }
  }
}

