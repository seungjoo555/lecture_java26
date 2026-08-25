package abstractclass;

public class Test {

	public static void main(String[] args) {
		String a = solution("abc1abc1abc");
		System.out.println(a);
	}
	
    public static String solution(String code) {
        String answer = "";
        StringBuilder sb = new StringBuilder("");
        int mode = 0;
        for (int i = 0; i < code.length(); i++) {
            char ch = code.charAt(i);
            System.out.println("mode : " + mode);
            System.out.println("i : " + i);
            System.out.println("ch : " + ch);
            if (ch == '1') {
                mode ^= 1;
            } else {
                if (mode == 0) {
                    if ((i & 1) != 1) {
                        sb.append(ch);
                        }
                } else {
                    if ((i & 1) == 1) {
                        sb.append(ch);
                    }
                }
            }
            System.out.println("sb : " + sb);
        }
        answer = sb.toString();
        return answer;
    }
	
}
