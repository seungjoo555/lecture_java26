package start;

import java.util.Scanner;

public class OddEven {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("정수를 입력하세요 : ");
		int n = sc.nextInt();
		String res = (n & 1) == 1 ? "홀수":"짝수";
		System.out.println(res);
		sc.close();
	}

}
