package start;

import java.util.Scanner;

public class While01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.print("숫자를 입력하세요 : ");
		int n = sc.nextInt();
		int sum = n;
		while(n != 0) {
			System.out.print("숫자를 입력하세요 : ");
			n = sc.nextInt();
			sum += n;
		}
		
		System.out.printf("지금까지 입력한 숫자의 합은 %d입니다.", sum);
		
		sc.close();
	}

}
