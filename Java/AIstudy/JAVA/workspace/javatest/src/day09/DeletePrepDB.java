package day09;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeletePrepDB {

  public static void main(String[] args) {
    String url = "jdbc:mysql://localhost:3306/javadb?useUnicode=true&characterEncoding=utf8";
    String driver = "org.gjt.mm.mysql.Driver";

    Connection con = null;
    PreparedStatement pstmt = null;

    try {
      Class.forName(driver);

      con = DriverManager.getConnection(url, "javauser", "1234");

      String sql = "delete from address ";
      sql = sql + " WHERE addressnum = ?";

      pstmt = con.prepareStatement(sql);
      pstmt.setInt(1, 7);

      int cnt = pstmt.executeUpdate();
      System.out.println("레코드 " + cnt + "개가 삭제되었습니다.");

    } catch (ClassNotFoundException |SQLException e) {
      System.out.println("SQLException: " + e.getMessage());
     
      e.printStackTrace();
    } finally {
      try {
        if (pstmt != null)
          pstmt.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
      try {
        if (con != null)
          con.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
  }
}
