package BOOK;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import utility.DBClose;
import utility.Open;

public class BookTest {
	

	public static void main(String[] args) {
//		StringBuffer sql = new StringBuffer();
		BookTest bookTest = new BookTest();
		bookTest.printAllBooks();
		

	}

	// ��ȸ
	public List<BookDTO>  printAllBooks() {
		List<BookDTO> list = new ArrayList<BookDTO>();
		Connection con = Open.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuffer sql = new StringBuffer();

		sql.append(" SELECT * FROM BOOKLIST ");
		sql.append(" ORDER BY ISBN DESC");
		System.out.println("|**************************�������**************************|");
		try {
			pstmt = con.prepareStatement(sql.toString());

			rs = pstmt.executeQuery();
			while (rs.next()) {
				BookDTO dto = new BookDTO();

				dto.setIsbn(rs.getInt("isbn"));
				dto.setTitle(rs.getString("title"));
				dto.setAuthor(rs.getString("author"));
				dto.setPublisher(rs.getString("publisher"));
				dto.setPrice(rs.getInt("price"));
				dto.setDetail(rs.getString("detail"));
				dto.setPublish_date(rs.getString("publish_date"));

				list.add(null);

				System.out.printf(dto.getIsbn() + " | " + dto.getTitle() + "\t" + " | " + dto.getAuthor() + " | "
						+ dto.getPublisher() + " | " + dto.getPrice() + " | " + dto.getDetail() + "\n");

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(pstmt, con);
		}
		return list;

	}

	
////�÷����� �߰�
//	public boolean insertStudent(BookDTO book) {
//		Boolean flag = false;
//		Connection con = Open.getConnection();
//		PreparedStatement pstmt = null;
//		StringBuffer sql = new StringBuffer();
//
//		sql.append(" ARTER TABLE BOOKLIST");
//		sql.append(" ADD STUDUNT VARCHAR(10) NOT NULL");
//		
//
//		try {
//			pstmt = con.prepareStatement(sql.toString());
//			pstmt.setString(1, "����ȣ");
//    		pstmt.setString(2, "���¿�");
//    		pstmt.setString(3, "���븸");			
//    		pstmt.setString(4, "���¼�");			
//    		pstmt.setString(5, "äġ��");			
//
//			
//			int cnt = pstmt.executeUpdate();
//			System.out.println("�߰� �Ǿ����ϴ� ");
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			DBClose.close(pstmt, con);
//		}
//		return flag;
//		}
//	}
//	
//���ڵ�� �߰�?
//	public boolean insertStudent(BookDTO book) {
//	    boolean flag = false;
//	    Connection con = Open.getConnection(); // ����
//	    PreparedStatement pstmt = null;
//	    StringBuffer sql = new StringBuffer();
//
//	    sql.append(" INSERT INTO STUDENT ");
//	    sql.append(" VALUES(?,?,?,?,?,?,?) ");
//	    try {
//	      pstmt = con.prepareStatement(sql.toString());
//	      pstmt.setString(1, "����ȣ");
//		  pstmt.setString(2, "���¿�");
//		  pstmt.setString(3, "���븸");			
// 		  pstmt.setString(4, "���¼�");			
//		  pstmt.setString(5, "äġ��");	
//
//	      int cnt = pstmt.executeUpdate();
//
//	      if (cnt > 0)
//	        flag = true;
//
//	    } catch (SQLException e) {
//	      // TODO Auto-generated catch block
//	      e.printStackTrace();
//	    } finally {
//	      DBClose.close(pstmt, con);
//	    }
//
//	    return flag;
//	  }
	}
	
	


