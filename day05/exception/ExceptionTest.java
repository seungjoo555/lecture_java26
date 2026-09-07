package exception;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ExceptionTest {

	public static void main(String[] args) {
		ExceptionTest t = new ExceptionTest();
		t.nullPointerException();
	}

	public void arithmeticException() {
		int a = 10, b= 0;
		int c = a/b;
	}

	public void indexException() {
		int[] array = { 0, 1, 2 };
		System.out.println(array[3]);
	}

	public void nullPointerException() {
		String str = null;
		str.charAt(1);
	}

	public void numberFormatException() {
		String str = "123AA";
		int num = Integer.parseInt(str);
	}

	public void classException() {
		//Class.forName("java.lang.String");
		System.out.println("클래스가 있습니다.");
	}
	
	public void ioException() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//String str = br.readLine();
	}
}
