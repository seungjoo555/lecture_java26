package start;

import java.util.Scanner;

public class Coin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("금액(100원 단위) : ");
		int money = sc.nextInt();
		int coin500 = money / 500;
		money = money % 500;
		int coin100 = money / 100;
		System.out.println();
		System.out.println("동전의 수 >");
		System.out.printf("500원짜리 = %d개\n", coin500);
		System.out.printf("100원짜리 = %d개", coin100);
		sc.close();
	}

}
