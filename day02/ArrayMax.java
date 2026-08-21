package start;

public class ArrayMax {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] intA = {10, 20, 30, 40, 50};
		int max = getMax(intA);
		System.out.println("배열에서 가장 큰 값 : " + max);
	}
	
	static int getMax(int[] intArray) {
		int max = intArray[0];
		for(int i = 1; i < intArray.length; i++) {
			max = max > intArray[i] ? max : intArray[i];
		}
		
		return max;
	}

}
