package day09;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException; 

public class InsertDB {

  public static void main(String[] args) {
    String url = "jdbc:mysql://127.0.0.1:3306/javadb?useUnicode=true&characterEncoding=utf8";
    String driver = "org.gjt.mm.mysql.Driver";
    Connection con = null;
    Statement stmt = null;
    
      try {
        Class.forName(driver);
        
        con = DriverManager.getConnection(url, "javauser","1234");
        
        String sql = "insert into address(name, handphone, address)";
        sql += "values('설계자','010-3333-9999,'한국')";
        stmt = con.createStatement(); 
        
        int cnt = stmt.executeUpdate(sql);
        
        String sql1 = "INSERT INTO address(name,handphone,address) ";
     
      } catch(Exception e) { 
        System.out.println("Exception: " + e.getMessage()); 
      } finally{ 
        try{ 
            if ( stmt != null) stmt.close(); 
        }catch(Exception e){} 
        try{ 
            if ( con != null){ con.close(); } 
        }catch(Exception e){} 
        try {
          con.close();
        } catch (SQLException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
        
      }

  }

}
