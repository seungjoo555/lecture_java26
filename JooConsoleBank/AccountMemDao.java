package account;

public class AccountMemDao {
	public static int noSeq = 111111;
	private Account[] accountDB = new Account[100];
	private int numAccount;
	
	// 계좌등록
	public boolean insertAccount(String owner, String password, int balance) {
		int no = noSeq++;
		accountDB[numAccount++] = new Account(no, owner, password, balance);
		return true;
	}
	
	// 계좌조회
	public Account[] selectAll() {
		Account[] accountList = new Account[numAccount];
		for (int i = 0; i < numAccount; i++) {
			accountList[i] = accountDB[i];
		}
		return accountList;
	}
	
	// 입금
	public boolean deposit(int accountNo, int amount) {
		for (int i = 0; i < numAccount; i++) {
			if (accountNo == accountDB[i].getNo()) {
				// 입금처리
				accountDB[i].setBalance(accountDB[i].getBalance()+Math.abs(amount));
				return true;
			}
		}
		return false;
	}
	
	// 출금
	public boolean withdraw(int accountNo, String password, int amount) {
		for (int i = 0; i < numAccount; i++) {
			if (accountNo == accountDB[i].getNo() && password.equals(accountDB[i].getPassword())) {
				// 출금
				if ( amount <= accountDB[i].getBalance()) {
					accountDB[i].setBalance(accountDB[i].getBalance()-Math.abs(amount));
					return true;
				} else {
					return false;
				}
			}
		}
		return false;
	}
	
}
