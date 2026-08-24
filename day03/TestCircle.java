package start;

import java.util.Scanner;

public class TestCircle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("원의 반지름 : ");
		double r = sc.nextDouble();
		Circle c = new Circle(r);
		double area = c.getExtent();
		System.out.println("반지름이 " + r + "인 원의 넓이는 " + area + "입니다.");
		sc.close();
	}

}
