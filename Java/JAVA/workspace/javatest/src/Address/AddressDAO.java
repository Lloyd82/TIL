package Address;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import utility.DBClose;
import utility.Open;

public class AddressDAO {
  //조회
  public List<AddressDTO> list(){
    List<AddressDTO> list = new ArrayList<AddressDTO>();
    Connection con = Open.getConnection();
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    StringBuffer sql = new StringBuffer();
    
    sql = append(" SELECT * FROM ADDRESS "); 
    sql = append(" ODER BY NAME DESC "); 

    try {
      pstmt = con.prepareStatement(sql.toString());
      
      rs= pstmt.executeQuery();
      while(rs.next()){
        AddressDTO dto = new AddressDTO();
        dto.setAddressnum(rs.getInt("addressnum"));
        dto.setName(rs.getString("name"));
        dto.setHandphone(rs.getString("handphone"));
        dto.setAddress(rs.getString("Address"));
        
        list.add(dto);
        
      }
    
    }catch(SQLException e) {
      e.printStackTrace();
    }finally {
      DBClose.close(pstmt, con);
    }
    return list;
  }

  private StringBuffer append(String string) {
    // TODO Auto-generated method stub
    return null;
  }
  
  //삭제
  public boolean delete(int addressnum) {
    boolean flag = false;
    Connection con = Open.getConnection();
    PreparedStatement pstmt = null;
    StringBuffer sql = new StringBuffer();

    sql.append("delete from address ");
    sql.append("where addressnum = ? ");

    try {
      pstmt = con.prepareStatement(sql.toString());
      pstmt.setInt(1, addressnum);

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

  //수정
  public boolean update(AddressDTO dto) {
    Boolean flag = false;
    Connection con = Open.getConnection();
    PreparedStatement pstmt = null;
    StringBuffer sql = new StringBuffer();

    sql.append(" UPDATE address");
    sql.append("	  SET handphone = ?, ");
    sql.append("			  address =  ?   ");
    sql.append("	WHERE addressnum = ? ");

    try {
      pstmt = con.prepareStatement(sql.toString());
      pstmt.setString(1, dto.getHandphone());
      pstmt.setString(2, dto.getHandphone());
      pstmt.setString(3, dto.getAddress());

      int cnt = pstmt.executeUpdate();
      if (cnt > 0)
        flag = true;

    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      DBClose.close(pstmt, con);
    }

    return flag;

  }

  //읽기
  public AddressDTO read(int addressnum) {
    AddressDTO dto = null;
    Connection con = Open.getConnection();
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    StringBuffer sql = new StringBuffer();

    sql.append("SELECT addressnum, NAME, handphone, address FROM address ");
    sql.append("	WHERE addressnum = ? ");

    try {
      pstmt = con.prepareStatement(sql.toString());
      pstmt.setInt(1, addressnum);

      rs = pstmt.executeQuery();

      if (rs.next()) {
        dto = new AddressDTO();
        dto.setAddress(rs.getInt("addressnum")); // rs�뿉�꽌 爰쇰궡���꽌 DTO�뿉 ���옣
        dto.setName(rs.getString("name"));
        dto.setHandphone(rs.getString("handphone"));
        dto.setAddress(rs.getString("address"));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      DBClose.close(rs, pstmt, con);
    }

    return dto;
  }

  //등록
  public boolean create(AddressDTO dto) {
    boolean flag = false;
    Connection con = Open.getConnection();
    PreparedStatement pstmt = null;
    StringBuffer sql = new StringBuffer();

    sql.append("	INSERT INTO address(NAME, handphone, address) ");
    sql.append("	VALUES(?,?,?) ");

    try {
      pstmt = con.prepareStatement(sql.toString());
      pstmt.setString(1, dto.getName());
      pstmt.setString(2, dto.getHandphone());
      pstmt.setString(3, dto.getAddress());

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
