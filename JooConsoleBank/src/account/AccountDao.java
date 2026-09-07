package account;

import java.util.List;

public interface AccountDao {
	// C : 계좌 추가
	boolean insertAccount(Account ac);
	
	// R : 계좌 읽기 - 계좌번호, 전체, 계좌주
	List<Account> selectAll();
	Account selectByNo(int accountNo);
	List<Account> selectByMember(String memberId);
	
	// U : 계좌, 비밀번호 수정
	boolean updateAccount(Account ac);
	
	// D : 삭제
	boolean deleteAccount(int accountNo);
}
