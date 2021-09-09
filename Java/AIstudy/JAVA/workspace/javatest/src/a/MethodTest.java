package a;
class	Method {
	public int add(int a, int b) {
		return a + b;
	}
	public double add(double a, double b) {
		return a + b;
	}
}

class Method2 extends Method {
	@Override
	public int add(int a, int b) {
		// TODO Auto-generated method stub
		return super.add(a, b) + 100;
	}

	@Override
	public double add(double a, double b) {
		// TODO Auto-generated method stub
		return super.add(a, b) + 100;
	}
}

public class MethodTest {
	public static void main(String[] args) {
		Method[] tests = {new Method(), new Method2()};
		
		for (int i = 0; i < tests.length; i++)
		{
			System.out.println(tests[i].add(1, 1));
			System.out.println(tests[i].add(6.1, 4.1));
		}
	}
}