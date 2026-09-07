package account;

import java.util.List;

public class AccountService {
	
	public static int noSeq = 111111;
	private AccountDao accountDao;
	
	public AccountService(AccountDao accountDao) {
		this.accountDao = accountDao;
	}
	
	public boolean createAccount(String owner, String password, int amount) {
		Account ac = new Account(noSeq++, owner, password, amount);
		return accountDao.insertAccount(ac);
	}
	
	public List<Account> getAllAccounts(){
		return accountDao.selectAll();
	}
	
	public List<Account> getMembersAccounts(String memberId) {
		return accountDao.selectByMember(memberId);
	}
	
	public Account getAccount(int accountNo) {
		return accountDao.selectByNo(accountNo);
	}
	
	public boolean deposit(int accountNo, int amount) throws NoAccountException {
		Account ac = accountDao.selectByNo(accountNo);
		if (ac != null) {
			ac.setBalance(ac.getBalance() + Math.abs(amount));
			accountDao.updateAccount(ac);
			return true;
		}
		
		//없는 계좌번호면 -> 예외 객체 생성하여 던짐
		throw new NoAccountException(accountNo);
	}
	
	public boolean withdraw(int accountNo, int amount, String password) throws NoAccountException {
		Account ac = accountDao.selectByNo(accountNo);
		if (ac != null) {
			if (password.equals(ac.getPassword())) {
				// 출금
				if ( amount <= ac.getBalance()) {
					ac.setBalance(ac.getBalance()-Math.abs(amount));
					accountDao.updateAccount(ac);
					return true;
				} else {
					System.out.println("비밀번호가 틀렸습니다.");
					return false;
				}
			}
		}
		throw new NoAccountException(accountNo);
	}
	
	public boolean deleteAccount(int accountNo, String password) {
		return true;
	}
}
