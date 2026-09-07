package account;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountMapDao implements AccountDao{
	
	Map<Integer, Account> accountDB = new HashMap<>();

	@Override
	public boolean insertAccount(Account ac) {
		accountDB.put(ac.getNo(), ac);
		return false;
	}

	@Override
	public List<Account> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account selectByNo(int accountNo) {
		return accountDB.get(accountNo);
	}

	@Override
	public List<Account> selectByMember(String memberId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateAccount(Account ac) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteAccount(int accountNo) {
		// TODO Auto-generated method stub
		return false;
	}

}
