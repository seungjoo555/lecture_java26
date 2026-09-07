package account;

public class Account {
	private int no;
	private String memberId;
	private String password;
	private int balance;
	
	public Account(int no, String memberId, String password, int balance) {
		this.no = no;
		this.memberId = memberId;
		this.password = password;
		this.balance = balance;
	}

	public int getNo() {
		return no;
	}
	
	public String getMemberId() {
		return memberId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "[계좌번호 =" + no + ", 계좌주 =" + memberId + ", 비밀번호 = " + password + ", 잔액 =" + balance + "]";
	}

	
	
}
