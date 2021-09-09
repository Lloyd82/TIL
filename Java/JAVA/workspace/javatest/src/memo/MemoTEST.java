package memo;

import java.util.List;

public class MemoTEST {

  public static void main(String[] args) {
    MemoDAO dao = new MemoDAO();
//    Create(dao);
//    read(dao);
//    update(dao);
//    delete(dao);
    list(dao);
    // TODO Auto-generated method stub

  }

  private static void list(MemoDAO dao) {
    List<MemoDTO> list = dao.list();

    for (MemoDTO dto : list) {
      p("======================");
      p(dto);
    }

  }

  private static void delete(MemoDAO dao) {
    // TODO Auto-generated method stub
    if (dao.delete(6)) {
      p("삭제성공");
    } else {
      p("삭제실패");
    }

  }

  private static void update(MemoDAO dao) {
    // TODO Auto-generated method stub
    MemoDTO dto = dao.read(1);
    dto.setContent("강녕하십니까");
    dto.setPass("4321");

    if (dao.update(dto)) {
      p("수정 성공");
    } else {
      p("수정 실패");
    }

  }

  private static void read(MemoDAO dao) {
    // TODO Auto-generated method stubMemoDTO
    MemoDTO dto = dao.read(1);
    p(dto);

  }

  private static void Create(MemoDAO dao) {
    MemoDTO dto = new MemoDTO(5, "이길동", "안녕하세요.", "1234");
    if (dao.create(dto)) {
      p("레코드 생성 성공");
    } else {
      p("레코드 생성 실패");
    }
  }

  private static void p(String str) {
    System.out.println(str);
  }

  private static void p(MemoDTO dto) {
    // TODO Auto-generated method stub
    System.out.println("번호:" + dto.getMemonum());
    System.out.println("이름:" + dto.getName());
    System.out.println("내용:" + dto.getContent());
    System.out.println("비번:" + dto.getPass());

  }

}
