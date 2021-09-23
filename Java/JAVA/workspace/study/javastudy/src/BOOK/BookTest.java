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

	// 조회
	public List<BookDTO>  printAllBooks() {
		List<BookDTO> list = new ArrayList<BookDTO>();
		Connection con = Open.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuffer sql = new StringBuffer();

		sql.append(" SELECT * FROM BOOKLIST ");
		sql.append(" ORDER BY ISBN DESC");
		System.out.println("|**************************도서목록**************************|");
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

	
////컬럼으로 추가
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
//			pstmt.setString(1, "강백호");
//    		pstmt.setString(2, "서태웅");
//    		pstmt.setString(3, "정대만");			
//    		pstmt.setString(4, "송태섭");			
//    		pstmt.setString(5, "채치수");			
//
//			
//			int cnt = pstmt.executeUpdate();
//			System.out.println("추가 되었습니다 ");
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			DBClose.close(pstmt, con);
//		}
//		return flag;
//		}
//	}
//	
//레코드로 추가?
//	public boolean insertStudent(BookDTO book) {
//	    boolean flag = false;
//	    Connection con = Open.getConnection(); // 연결
//	    PreparedStatement pstmt = null;
//	    StringBuffer sql = new StringBuffer();
//
//	    sql.append(" INSERT INTO STUDENT ");
//	    sql.append(" VALUES(?,?,?,?,?,?,?) ");
//	    try {
//	      pstmt = con.prepareStatement(sql.toString());
//	      pstmt.setString(1, "강백호");
//		  pstmt.setString(2, "서태웅");
//		  pstmt.setString(3, "정대만");			
// 		  pstmt.setString(4, "송태섭");			
//		  pstmt.setString(5, "채치수");	
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
	
	


