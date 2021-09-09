package day09;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InsertPrepDB {
  public static void main(String args[]) {
    String url = "jdbc:mysql://localhost:3306/javadb?useUnicode=true&characterEncoding=utf8";
    String driver = "org.gjt.mm.mysql.Driver";
    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try {
      Class.forName(driver);
      con = DriverManager.getConnection(url, "javauser", "1234");

      String sql = "INSERT INTO address(name, handphone, address) ";
      sql += " VALUES('설계자,010-3333-9999,'한국')";

      pstmt = con.prepareStatement(sql);
      pstmt.setString(1, "김길동");
      pstmt.setString(2, "010-7777-7777");
      pstmt.setString(1, "서울시 강남구 역삼동");

      int cnt = pstmt.executeUpdate();

      System.out.println("레코드 " + cnt + "개가 추가 되었습니다.");

    } catch (java.lang.ClassNotFoundException | SQLException e) {
      System.out.println("SQLException: " + e.getMessage());
    } finally {
      try {
        if (pstmt != null) {
          pstmt.close();
        }
      } catch (Exception e) {
      }
      try {
        if (con != null) {
          con.close();
        }
      } catch (Exception e) {
      }

    }
  }

}