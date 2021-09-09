package memo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import utility.DBClose;
import utility.Open;

public class MemoDAO {

  public List list() {
    List list = new ArrayList();

    Connection con = Open.getConnection();
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    StringBuffer sql = new StringBuffer();

    sql.append(" SELECT * FROM memo ");
    sql.append(" ORDER BY name ASC ");

    try {
      pstmt = con.prepareStatement(sql.toString());

      rs = pstmt.executeQuery();

      while (rs.next()) {
        MemoDTO dto = new MemoDTO();
        dto.setMemonum(rs.getInt("memonum"));
        dto.setName(rs.getString("name"));
        dto.setContent(rs.getString("content"));
        dto.setPass(rs.getString("pass"));

        list.add(dto);
      }

    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      DBClose.close(rs, pstmt, con);
    }
    return list;
  }

  public boolean delete(int memonum) {

    boolean flag = false;
    Connection con = Open.getConnection();
    PreparedStatement pstmt = null;
    StringBuffer sql = new StringBuffer();

    sql.append(" DELETE from memo ");
    sql.append(" WHERE memonum = ? ");

    try {
      pstmt = con.prepareStatement(sql.toString());
      pstmt.setInt(1, memonum);

      int cnt = pstmt.executeUpdate();

      if (cnt > 0)
        flag = true;

    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      DBClose.close(pstmt, con);
    }
    return flag;
  }

  public boolean update(MemoDTO dto) {
    boolean flag = false;
    Connection con = Open.getConnection();
    PreparedStatement pstmt = null;
    StringBuffer sql = new StringBuffer();

    sql.append(" UPDATE memo  ");
    sql.append("    SET content = ?, ");
    sql.append("        pass = ?   ");
    sql.append("  WHERE memonum = ? ");

    try {
      pstmt = con.prepareStatement(sql.toString());
      pstmt.setString(1, dto.getContent());
      pstmt.setString(2, dto.getPass());
      pstmt.setInt(3, dto.getMemonum());

      int cnt = pstmt.executeUpdate();
      if (cnt > 0)
        flag = true;

    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      DBClose.close(pstmt, con);
    }

    return flag;
  }

  public MemoDTO read(int memonum) {
    MemoDTO dto = null;
    Connection con = Open.getConnection();

    PreparedStatement pstmt = null;
    ResultSet rs = null;
    StringBuffer sql = new StringBuffer();

    sql.append(" SELECT memonum, name, content, pass FROM memo ");
    sql.append(" WHERE memonum = ? ");

    try {
      pstmt = con.prepareStatement(sql.toString());
      pstmt.setInt(1, memonum);

      rs = pstmt.executeQuery();

      if (rs.next()) {
        dto = new MemoDTO();
        dto.setMemonum(rs.getInt("memonum")); // rs 에서 꺼내와서 DTO에 저장.
        dto.setName(rs.getString("name"));
        dto.setContent(rs.getString("content"));
        dto.setPass(rs.getString("pass"));
      }

    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      DBClose.close(rs, pstmt, con);
    }

    return dto;
  }

  public boolean create(MemoDTO dto) {
    boolean flag = false;
    Connection con = Open.getConnection(); // db 연결 부분
    PreparedStatement pstmt = null;
    StringBuffer sql = new StringBuffer();

    sql.append(" INSERT INTO memo(name, content, pass) ");
    sql.append(" VALUES(?,?,?) ");
    try {
      pstmt = con.prepareStatement(sql.toString());
      pstmt.setString(1, dto.getName());
      pstmt.setString(2, dto.getContent());
      pstmt.setString(3, dto.getPass());

      int cnt = pstmt.executeUpdate();

      if (cnt > 0)
        flag = true;

    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      DBClose.close(pstmt, con);
    }

    return flag;
  }
}