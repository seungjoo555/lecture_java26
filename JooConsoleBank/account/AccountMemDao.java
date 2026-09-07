//package account;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class AccountMemDao implements AccountDao{
//	public static int noSeq = 111111;
//	private List<Account> accountDB = new ArrayList<Account>();
//	
//	// 계좌등록
//	public boolean insertAccount(String memberId, String password, int balance) {
//		int no = noSeq++;
//		accountDB.add(new Account(no, memberId, password, balance));
//		return true;
//	}
//	
//	// 계좌조회
//	public List<Account> selectAll() {
//		List<Account> accountList = new ArrayList<Account>();
//		for (int i = 0; i < accountDB.size(); i++) {
//			accountList.add(accountDB.get(i));
//		}
//		return accountList;
//	}
//	
//	// 입금
//	public boolean deposit(int accountNo, int amount) throws NoAccountException {
//		for (int i = 0; i < accountDB.size(); i++) {
//			if (accountNo == accountDB[i].getNo()) {
//				// 입금처리
//				accountDB[i].setBalance(accountDB[i].getBalance()+Math.abs(amount));
//				return true;
//			}
//		}
//		
//		//없는 계좌번호면 -> 예외 객체 생성하여 던짐
//		throw new NoAccountException(accountNo);
//		//return false;
//	}
//	
//	// 출금
//	public boolean withdraw(int accountNo, String password, int amount) throws NoAccountException {
//		for (int i = 0; i < numAccount; i++) {
//			if (accountNo == accountDB[i].getNo() && password.equals(accountDB[i].getPassword())) {
//				// 출금
//				if ( amount <= accountDB[i].getBalance()) {
//					accountDB[i].setBalance(accountDB[i].getBalance()-Math.abs(amount));
//					return true;
//				} else {
//					return false;
//				}
//			}
//		}
//		throw new NoAccountException(accountNo);
//	}
//
//	@Override
//	public Account selectByNo(int accountNo) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List<Account> selectByMember(String memberId) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	
//}
