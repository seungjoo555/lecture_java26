package start;

import java.util.Scanner;

public class ArrayCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("기준 숫자 입력 : ");
		int n = sc.nextInt();
		int[] intA = {10, 20, 30, 40, 50};
		int count= getCount(intA, n);
		System.out.println("배열에 기준숫자보다 큰 수의 개수 : " + count);
		
		sc.close();
	}
	
	static int getCount(int[] intArray, int n) {
		int c = 0;
		for(int i = 0; i < intArray.length; i++) {
			c += intArray[i] > n ? 1 : 0;
		}
		return c;
	}

}
