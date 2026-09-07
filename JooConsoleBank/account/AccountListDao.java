package account;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AccountListDao implements AccountDao{
	private List<Account> accountDB = new ArrayList<Account>();
	
	@Override
	public boolean insertAccount(Account ac) {
		accountDB.add(ac);
		return true;
	}

	@Override
	public List<Account> selectAll() {
		List<Account> accountList = new ArrayList<Account>();
//		for (int i = 0; i < accountDB.size(); i++) {
//			accountList.add(accountDB.get(i));
//		}	인덱스로 계좌를 전부 가져오기
		
//		Iterator<Account> iter = accountDB.iterator();
//		while (iter.hasNext()) {
//			accountList.add(iter.next());
//		}	이터레이터를 생성해 계좌 가져오기
		
		for (Account ac : accountDB) {
			accountList.add(ac);
		}	// 향상된 for문으로 계좌 가져오기
		
		return accountList;
	}

	@Override
	public Account selectByNo(int accountNo) {
		for (Account ac : accountDB) {
			if (ac.getNo() == accountNo) return ac;
		}
		return null;
	}

	@Override
	public List<Account> selectByMember(String memberId) {
		List<Account> accountList = new ArrayList<Account>();
		for (Account ac : accountDB) {
			if (memberId.equals(ac.getMemberId())) accountList.add(ac);
		}
		return accountList;
	}

	@Override
	public boolean updateAccount(Account ac) {
		Account orgAccount = selectByNo(ac.getNo());
		accountDB.set(accountDB.indexOf(orgAccount), ac);
		return true;
	}

	@Override
	public boolean deleteAccount(int accountNo) {
		// TODO Auto-generated method stub
		return false;
	}

}
