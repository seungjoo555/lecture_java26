package start;

import java.util.Scanner;

public class Circle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final double PI = 3.14;
		Scanner sc = new Scanner(System.in);
		System.out.print("원의 반지름을 입력하세요(cm) : ");
		double r = sc.nextDouble();
		System.out.printf("원의 넓이는 %.2fcm입니다.", (r * r * PI));
		sc.close();
	}

}
