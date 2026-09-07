package exception;

public class TryCatchTest {

	public static void main(String[] args) {
		System.out.println("====프로그램 시작 ====");
		
		String[] array = {"100", "2OO", "300"};
		
		for (int i = 0; i <array.length; i++) {
			try {
				int value = Integer.parseInt(array[i]);
				System.out.printf("array[%d]의 값은 %d입니다.\n", i, value);
			} catch (Exception e) {
				System.out.println("숫자 바꿀 수 없는 문자열입니다.");
			}
		}						
		
		System.out.println("====프로그램 종료 ====");
	}

}
