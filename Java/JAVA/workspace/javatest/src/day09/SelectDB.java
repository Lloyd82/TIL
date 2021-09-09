package day09;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectDB {

  public static void main(String[] args) {
    String url = "jdbc:mysql://localhost:3306/javadb?useUnicode=true&characterEncoding=utf8";
    String driver = "org.gjt.mm.mysql.Driver";
    Connection con = null; 
    Statement  stmt = null; 
    ResultSet rs = null; 
    
    try {
      Class.forName(driver);
      
      con = DriverManager.getConnection(url, "javauser", "1234");
    } catch (ClassNotFoundException | SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      try {
        if(rs != null)rs.close();
    } catch (SQLException e) {
      
      e.printStackTrace();
    }
      try {
        if(con != null)con.close();
    } catch (SQLException e) {
      
      e.printStackTrace();
    }
    
    }
  }

}
