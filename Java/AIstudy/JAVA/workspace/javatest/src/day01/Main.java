package day01;

public class Main {

	public static void main(String[] args) {
		boolean b1 = true;
		boolean b2 = false;
		boolean b3 = (10 > 2) ? true : false; // 삼항 연산자
		int i = (!true) ? 100: 200;
		
		System.out.println("Value of boolean variable b1 is :" + b1);
		System.out.println("Value of boolean variable b1 is :" + b2);
		System.out.println("Value of boolean variable b1 is :" + b3);
		System.out.println(i);		
	}

}
