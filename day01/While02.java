package start;

import java.util.Scanner;

public class While02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n;
		int check = 1;
		while(check == 1) {
			System.out.print("숫자를 입력하세요 : ");
			n = sc.nextInt();
			if ((n&1) == 1)
				System.out.println("홀수입니다.");
			else
				System.out.println("짝수입니다.");
			System.out.print("계속 하시겠습니까? (0-멈춤/1-계속) : ");
			check = sc.nextInt();
			System.out.println();
		}
		
		sc.close();
	}

}
