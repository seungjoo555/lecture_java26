package start;

import java.util.Scanner;

public class GugudanMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("구구단 출력할 단 : ");
		int n = sc.nextInt();
		gugudan(n);
		for(int i = 2; i < 10; i++) {
			gugudan(i);
		}
		sc.close();
	}
	
	static void gugudan(int num) {
		System.out.printf("[ 구구단 %d단 ]\n", num);
		for(int i = 1; i < 10; i++) {
			System.out.printf("%d x %d = %d", num, i, (num*i));
			System.out.println();
		}
	}
	
}