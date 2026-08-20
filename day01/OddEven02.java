package start;

import java.util.Scanner;

public class OddEven02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자를 입력하세요 : ");
		int n = sc.nextInt();
		if (n >= 0) {
			if ((n & 1) == 1)
				System.out.println("홀수입니다.");
			else
				System.out.println("짝수입니다.");
		}
		else
			System.out.println("양수가 아닙니다.");
		sc.close();
	}

}
