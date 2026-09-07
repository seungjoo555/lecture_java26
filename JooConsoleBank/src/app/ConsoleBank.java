package app;

import java.util.List;
import java.util.Scanner;

import account.Account;
import account.AccountListDao;
import account.AccountService;
import account.NoAccountException;
import member.Member;
import member.MemberMapDao;
import member.MemberService;

public class ConsoleBank {
	
	Scanner sc = new Scanner(System.in);
	AccountService as;
	MemberService ms;
	
	String[] startMenu = {"종료", "로그인", "회원가입"};
	String[] adminMenu = {"로그아웃", "회원관리", "계좌관리"};
	String[] bankingMenu = {"로그아웃", "계좌목록", "입금", "출금", "계좌생성", "계좌해지", "내정보"};
	String[] myinfoMenu = {"돌아가기", "비밀번호수정", "회원탈퇴"};
	String[] adminMemberMenu = {"돌아가기", "회원목록", "회원강퇴"};
	String[] adminAccountMenu = {"돌아가기", "전체계좌목록", "회원별계좌목록"};

	public ConsoleBank(AccountService as, MemberService ms) {
		this.as = as;
		this.ms = ms;
	}
	
	public static void main(String[] args) {
		AccountService as = new AccountService(new AccountListDao());
		MemberService ms = new MemberService(new MemberMapDao());
		ConsoleBank consoleBank = new ConsoleBank(as, ms);
		
		consoleBank.welcomeMessage();
		consoleBank.runStartMenu();
		consoleBank.sayGoodbye();
		
	}
	
	private void welcomeMessage() {
		System.out.println("+------------------------------------+");
		System.out.println("  Welcome to Hyejeong's Console Bank ");
		System.out.println("+------------------------------------+");
		
	}

	private void sayGoodbye() {
		System.out.println(">> Hyejeong's Console Bank를 이용해 주셔서 감사합니다.");
		
	}
	
	private void runStartMenu() {
		
		while (true) {
			System.out.println("[[ 시작 메뉴 ]]");
			int menu = selectMenu(startMenu);
			switch (menu) {
			case 1:
				menuLogin(); break;
			case 2:
				menuJoin(); break;
			case 0:
				return;
			default:
				System.out.println("메뉴에 있는 번호를 입력하세요.");
			}
		}
		
	}
	
	private int selectMenu(String[] menuList) {
		System.out.println("==========================");
		for (int i = 1; i < menuList.length; i++)
			System.out.println(" " + i + ". " + menuList[i]);
		System.out.println(" 0. " + menuList[0]);
		System.out.println("==========================");
		System.out.print(">> 선택 : ");
		int menu = Integer.parseInt(sc.nextLine());
		return menu;
	}

	private void menuLogin() {
		System.out.println("[[ 로그인 ]]");
		System.out.print(">> 아이디 : ");
		String id = sc.nextLine();
		System.out.print(">> 비밀번호 : ");
		String password = sc.nextLine();
		
		// 로그인 처리 후 로그인한 멤버 유형에 맞는 메뉴 실행
		if (ms.login(id, password)) {
			Member m = ms.getLoginMember();
			if (m.getId().equals(ms.getAdminId()))
				runAdminMenu();
			else {
				runBankingMenu();
			}
		} else {
			System.out.println(">> 로그인 할 수 없습니다.");
		}
		
	}

	private void menuJoin() {
		List<Member> memberList = ms.getMembers();
		System.out.println("[[ 회원가입 ]]");
		String id;

		while (true) {
		    System.out.print(">> 아이디 : ");
		    id = sc.nextLine();
		    boolean isDuplicate = false;

		    for (Member member : memberList) {
		        if (member.getId().equals(id)) {
		            isDuplicate = true;
		            break;
		        }
		    }

		    if (isDuplicate) {
		        System.out.println("중복된 ID입니다. 다시 입력해주세요.");
		        continue;
		    }
		    break;
		}

		System.out.print(">> 비밀번호 : ");
		String password = sc.nextLine();
		String nickname;
		while (true) {
		    System.out.print(">> 닉네임 : ");
		    nickname = sc.nextLine();
		    boolean isDuplicate = false;
		    for (Member member : memberList) {
		        if (member.getNickname().equals(nickname)) {
		            isDuplicate = true;
		            break;
		        }
		    }
		    if (isDuplicate) {
		        System.out.println("중복된 닉네임입니다. 다시 입력해주세요.");
		        continue;
		    }
		    break;
		}

		ms.registerMember(id, password, nickname);
		System.out.println("회원가입이 완료되었습니다.");
	}

	private void runAdminMenu() {

		while (true) {
			System.out.println("[[ 관리자 메뉴 ]]");
			int menu = selectMenu(adminMenu);
			switch (menu) {
			case 1: // 회원관리
				runAdminMemberMenu(); break;
			case 2: // 계좌관리
				runAdminAccountMenu(); break;
			case 0:
				return;
			default:
				System.out.println("메뉴에 있는 번호를 입력하세요.");
			}
		}
		
	}

	private void runAdminMemberMenu() {
		while (true) {
			System.out.println("[[ 관리자용 회원관리 ]]");
			int menu = selectMenu(adminMemberMenu);
			switch (menu) {
			case 1: // 회원 목록
				menuAdminListMembers(); break;
			case 2: // 회원 강퇴
				menuAdminDeleteMember(); break;
			case 0:
				return;
			default:
				System.out.println("메뉴에 있는 번호를 입력하세요.");
			}
		}
		
	}

	private void menuAdminListMembers() {
		System.out.println("[[ 회원 목록 ]]");
		List<Member> memberList = ms.getMembers();

		if (memberList.isEmpty()) {
			System.out.println(">> 등록된 회원이 없습니다.");
			return;
		}

		for (Member m : memberList)
			System.out.println(" " + m);
	}

	private void menuAdminDeleteMember() {
		System.out.println("[[ 회원 강퇴 ]]");
		System.out.print(">> 강퇴할 회원 아이디 : ");
		String id = sc.nextLine();

		if (id.equals(ms.getAdminId())) {
			System.out.println(">> 관리자는 강퇴할 수 없습니다.");
			return;
		}

		if (ms.deleteMemberByAdmin(id))
			System.out.println(">> 강퇴되었습니다.");
		else
			System.out.println(">> 존재하지 않는 회원입니다.");
	}

	private void runAdminAccountMenu() {
		while (true) {
			System.out.println("[[ 관리자용 계좌관리 ]]");
			int menu = selectMenu(adminAccountMenu);
			switch (menu) {
			case 1: // 전체 계좌 목록
				menuAdminListAllAccounts(); break;
			case 2: // 회원 계좌 목록
				menuAdminListMemberAccounts(); break;
			case 0:
				return;
			default:
				System.out.println("메뉴에 있는 번호를 입력하세요.");
			}
		}
		
	}


	private void menuAdminListAllAccounts() {
		System.out.println("[[ 전체 계좌 목록 ]]");
		List<Account> accountList = as.getAllAccounts();

		if (accountList.isEmpty()) {
			System.out.println(">> 등록된 계좌가 없습니다.");
			return;
		}

		for (Account ac : accountList)
			System.out.println(" " + ac);
	}

	private void menuAdminListMemberAccounts() {
		System.out.println("[[ 회원별 계좌 목록 ]]");
		System.out.print(">> 조회할 회원 아이디 : ");
		String id = sc.nextLine();

		if (ms.getMemberById(id) == null) {
			System.out.println(">> 존재하지 않는 회원입니다.");
			return;
		}

		List<Account> accountList = as.getMembersAccounts(id);
		if (accountList.isEmpty()) {
			System.out.println(">> 보유한 계좌가 없습니다.");
			return;
		}

		for (Account ac : accountList)
			System.out.println(" " + ac);
	}

	private void runBankingMenu() {
		while (true) {
			System.out.println("[[ 은행 메뉴 ]]");
			int menu = selectMenu(bankingMenu);
			switch (menu) {
			case 1: // 내 계좌 목록
				menuListMyAccounts(); break;
			case 2: // 입금
				menuDeposit(); break;
			case 3: // 출금
				menuWithdraw(); break;
			case 4 : // 계좌생성
				menuCreateAccount(); break;
			case 5: // 계좌해지
				menuDeleteAccount(); break;
			case 6: // 내 정보
				runMyinfoMenu(); break;
			case 0:
				return;
			default:
				System.out.println("메뉴에 있는 번호를 입력하세요.");
			}
		}
		
	}

	private void menuListMyAccounts() {
		System.out.println("[[ 내 계좌 목록 ]]");
		List<Account> accountList = as.getMembersAccounts(ms.getLoginMember().getId());

		if (accountList.isEmpty()) {
			System.out.println(">> 보유한 계좌가 없습니다.");
			return;
		}

		for (Account ac : accountList)
			System.out.println(" " + ac);
	}

	private void menuDeposit() {
		System.out.println("[[ 입금 ]]");
		System.out.print(">> 계좌번호 : ");
		int accountNo = Integer.parseInt(sc.nextLine());
		System.out.print(">> 입금액 : ");
		int amount = Integer.parseInt(sc.nextLine());

		try {
			as.deposit(accountNo, amount);
			System.out.println(">> 입금 완료. 잔액 : " + as.getAccount(accountNo).getBalance());
		} catch (NoAccountException e) {
			System.out.println(">> " + e.getMessage());
		}
	}

	private void menuWithdraw() {
		System.out.println("[[ 출금 ]]");
		System.out.print(">> 계좌번호 : ");
		int accountNo = Integer.parseInt(sc.nextLine());
		System.out.print(">> 출금액 : ");
		int amount = Integer.parseInt(sc.nextLine());
		System.out.print(">> 계좌 비밀번호 : ");
		String password = sc.nextLine();

		try {
			if (as.withdraw(accountNo, amount, password))
				System.out.println(">> 출금 완료. 잔액 : " + as.getAccount(accountNo).getBalance());
			else
				System.out.println(">> 비밀번호가 틀렸거나 잔액이 부족합니다.");
		} catch (NoAccountException e) {
			System.out.println(">> " + e.getMessage());
		}
	}

	private void menuCreateAccount() {
		System.out.println("[[ 계좌 생성 ]]");
		System.out.print(">> 계좌 비밀번호 : ");
		String password = sc.nextLine();
		System.out.print(">> 최초 입금액 : ");
		int amount = Integer.parseInt(sc.nextLine());

		String owner = ms.getLoginMember().getId();
		if (as.createAccount(owner, password, amount))
			System.out.println(">> 계좌가 생성되었습니다. 계좌번호 : " + (AccountService.noSeq - 1));
		else
			System.out.println(">> 계좌 생성에 실패했습니다.");
	}

	private void menuDeleteAccount() {
		System.out.println("[[ 계좌 해지 ]]");
		System.out.print(">> 해지할 계좌번호 : ");
		int accountNo = Integer.parseInt(sc.nextLine());
		System.out.print(">> 계좌 비밀번호 : ");
		String password = sc.nextLine();

		if (as.deleteAccount(accountNo, password))
			System.out.println(">> 계좌가 해지되었습니다.");
		else
			System.out.println(">> 비밀번호가 틀렸거나 잔액이 남아있습니다.");
	}

	private void runMyinfoMenu() {
		while (true) {
			System.out.println("[[ 내 정보 메뉴 ]]");
			int menu = selectMenu(myinfoMenu);
			switch (menu) {
			case 1: // 비밀번호 수정
				menuUpdatePassword(); break;
			case 2: // 회원 탈퇴
				menuDeleteMembership(); break;
			case 0:
				return;
			default:
				System.out.println("메뉴에 있는 번호를 입력하세요.");
			}
		}
		
	}

	private void menuUpdatePassword() {
		System.out.println("[[ 비밀번호 수정 ]]");
		System.out.print(">> 현재 비밀번호 : ");
		String oldPassword = sc.nextLine();
		System.out.print(">> 새 비밀번호 : ");
		String newPassword = sc.nextLine();

		if (ms.updatePassword(oldPassword, newPassword))
			System.out.println(">> 비밀번호가 변경되었습니다.");
		else
			System.out.println(">> 현재 비밀번호가 올바르지 않습니다.");
	}

	private void menuDeleteMembership() {
		System.out.println("[[ 회원 탈퇴 ]]");
		System.out.print(">> 비밀번호 : ");
		String password = sc.nextLine();

		if (ms.deleteMember(password))
			System.out.println(">> 탈퇴가 완료되었습니다.");
		else
			System.out.println(">> 비밀번호가 올바르지 않습니다.");
	}
	


}
