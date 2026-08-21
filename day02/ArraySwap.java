package start;

import java.util.Arrays;

public class ArraySwap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] intA = {10, 20, 30, 40, 50};
		swapArray(intA);
		System.out.println("스왑한 배열 : " + Arrays.toString(intA));
	}

	
	static void swapArray(int[] intArray) {
		int temp = 0;
		for(int i = 0; i < (intArray.length/2); i++) {
			temp = intArray[i];
			intArray[i] = intArray[intArray.length-1-i];
			intArray[intArray.length-1-i] = temp;
		}
	}
}
