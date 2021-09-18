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
		StringBuffer sql = new StringBuffer();

		BookTest bookTest = new BookTest();
		bookTest. printAllBooks();

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

	

	public boolean insertStudent(BookDTO book) {
		Boolean flag = false;
		Connection con = Open.getConnection();
		PreparedStatement pstmt = null;
		StringBuffer sql = new StringBuffer();

		sql.append(" ARTER TABLE BOOKLIST");
		sql.append(" ADD STUDUNT VARCHAR(10) NOT NULL");
		

		try {
			pstmt = con.prepareStatement(sql.toString());
//			pstmt.setInt(1, book.getIsbn());
//			pstmt.setString(2, book.getTitle());
//			pstmt.setString(3, book.getAuthor());
//			pstmt.setString(4, book.getPublisher());
//			pstmt.setString(5, book.getAuthor());
//			pstmt.setInt(6, book.getPrice());

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(pstmt, con);
		}
//		private void p(BookDTO book) {
//			System.out.println(book);
		return flag;
		}
	}


