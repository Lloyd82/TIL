package day09;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectDBOne {
  public static void main(String args[]) throws ClassNotFoundException {
    String url = "jdbc:mysql://localhost:3306/javadb?useUnicode=true&characterEncoding=utf8";
    String driver = "org.gjt.mm.mysql.Driver";
    Connection con = null; // 디비 연결 객체
    Statement stmt = null; // sql문 전송객체
    ResultSet rs = null; // select 문을 전송한후 실행된 결과 갑을 받는 자바 클래스

    // 1. 드라이버 메모리 올림(객체생성-> new : 정확한 type이 있어야함
    // 2. 연결 객체 생성
    // 3.서버의 전송할 sql 전송
    // 4.전송객체 생성후 sql문 전송
    // 5.전송후 받은 결과값 확인
    try {
      Class.forName(driver);

      con = DriverManager.getConnection(url, "javauer", "1234");

      String sql =  " select addressnum, name, handphone, address";
      sql +=        "?.?.?";

      stmt = con.createStatement();
      rs = stmt.executeQuery(sql);

      if (rs.next()) {
        int addressnum = rs.getInt("addressnum");
        String name = rs.getString(2);
        String phone = rs.getString(3);
        String address = rs.getString("address");

        System.out.println("번호:" + addressnum);
        System.out.println("이름:" + name);
        System.out.println("전화번호:" + phone);
        System.out.println("주소:" + address);
      }
    } catch (ClassNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      try {
        if (stmt != null)
          stmt.close();
      } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      try {
        if (con != null)
          con.close();
      } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
  }
}


