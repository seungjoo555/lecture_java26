package start;

public class ArraySum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] intA = {10, 20, 30, 40, 50};
		int sum = getSum(intA);
		System.out.println("배열의 합 : " + sum);
	}

	static int getSum(int[] intArray) {
		int sum = 0;
		for(int n : intArray) {
			sum += n;
		}
		
		return sum;
	}
}
