package day05.test;

class Person {
  String name;
  String phone;
  static int ID;

  public void setName(String s) {
    name = s;
  }

  public String getPhone() {
    return phone;
  }

  public int getID() { // static은 오버라이딩 불가
    return ID;
  }
}

class Professor extends Person {

  public void setName(String s) { // 좁아질수 없으므로 protected -> public 
  }

  public String getPhone() {  
    return phone;
  }

  public void getPhoneint(int id) { // 선언 오류
  }

  public int getID() {
    return 0; // 리턴값이 존재하지 않아 수정
  }
}