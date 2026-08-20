package start;

import java.util.Scanner;

public class Star03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.print("별찍기 num : ");
		int num = sc.nextInt();
		for(int i = 0; i < num; i++) {
			for(int j = 1; j < (num-i); j++)
				System.out.print(" ");
			for(int k = 0; k <= i; k++)
				System.out.print("*");
			System.out.println();
		}
		
		sc.close();
	}

}
