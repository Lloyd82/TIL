package day09;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DriverTestMysql {

  public static void main(String[] args) {
    String url = "jdbc:mysql://127.0.0.1:3306/javadb?useUnicode=true&characterEncoding=utf8";
    Connection con = null;
    try {
      // JDBC드라이버를 로딩합니다.
      Class.forName("org.gjt.mm.mysql.Driver");
      // MySQL 서버를 설정합니다.
      con = DriverManager.getConnection(url, "javauser", "1234");

      System.out.println("데이터 베이스 접속이 성공했습니다.");
    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
    } finally {
      if (con != null)
        try {
          con.close(); // 데이터베이스 접속을 닫습니다.
        } catch (SQLException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }

    }

  }

}