package day01;

public class Hello2 {
	
	public static int sum(int n, int m) {
		return n+m;
	}

	public static void main(String[] args) {
		int i= 20; 
		int s;
		char a; //''
		
		s = sum(i, 10);//메소드 sum호출 메소드에 저장
		a = '?'; // '=' 할당의 한다는 의미, '같다' x
		
		System.out.println(a);
		System.out.println("Hello2");
		System.out.println(s);

	}

}
