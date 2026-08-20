package start;

import java.util.Scanner;

public class Star06 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.print("별찍기 num : ");
		int num = sc.nextInt();
		for(int i = 0; i < num; i++) {
			for(int j = 0; j < i; j++)
				System.out.print(" ");
			for(int k = 0; k < (num-i); k++)
				System.out.print("*");
			for(int l = 1; l < (num-i); l++)
				System.out.print("*");
			System.out.println();
		}
		
		sc.close();
	}

}
