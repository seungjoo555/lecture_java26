package start;

import java.util.Scanner;

public class For01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int sum = 0;
		System.out.print("숫자를 입력하세요 : ");
		int n = sc.nextInt();
		for (int i = 1; i <= n ; i++)
			sum += i;
		
		System.out.printf("1부터 %d까지의 합은 %d입니다.", n, sum);
		sc.close();
	}

}
