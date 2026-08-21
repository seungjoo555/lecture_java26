package start;

public class SumPrint {
	
	public static void main(String[] args) {
		int result = sumPrint(165, 543);
	}
	
	public static int sumPrint(int a, int b) {
		int result;
		result = a + b;
		printResult(result);
		return result;
	}
	
	public static void printResult(int result) {
		System.out.println("결과는 " + result);
	}
	
}
