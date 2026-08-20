package start;

import java.util.Scanner;

public class Sign {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자를 입력하세요 : ");
		int n = sc.nextInt();
		String res;
		if (n > 0)
			res = "양수";
		else if (n == 0)
			res = "0";
		else
			res = "음수";
		
		System.out.printf(">> %s입니다", res);
		sc.close();
	}

}
