package start;

import java.util.Scanner;

public class For04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.print("숫자를 입력하세요 : ");
		int n = sc.nextInt();
		int res = n;
		for(int i = n-1; i > 0; i--)
			res *= i;
		
		System.out.printf("%d! = %d", n, res);
		sc.close();
	}

}
