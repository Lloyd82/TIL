package bbs;

public class BbsTest {

	public static void main(String[] args) {
		BbsDAO dao = new BbsDAO();
		
		//create(dao);
		read(dao);

	}

	private static void read(BbsDAO dao) {
		// TODO Auto-generated method stub
		
	}

	private static void create(BbsDAO dao) {
		BbsDTO dto = new BbsDTO();
		dto.setWname("홍길동");
		dto.setTitle("제목");
		dto.setContent("내용");
		dto.setPasswd("1234");
		if(dao.create(dto )) {
			p("성공");
		}else {
			p("실패");
		}
		
	}

	private static void p(String string) {
		System.out.println(string);
		
	}

}
