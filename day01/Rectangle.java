package start;

import java.util.Scanner;

public class Rectangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("직사각형의 가로 길이 : ");
		double width = sc.nextDouble();
		System.out.print("직사각형의 세로 길이 : ");
		double height = sc.nextDouble();
		double res = width * height;
		System.out.printf("직사각형의 넓이는 %.1fcm입니다.", res);		
		sc.close();
	}

}
