package start;

import java.util.Scanner;

public class For03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.print("숫자를 입력하세요 : ");
		int n = sc.nextInt();

		for(int i = 1; i < 10; i++)
			System.out.printf("%d x %d = %d\n", n, i, n * i);
		
		sc.close();
	}

}
