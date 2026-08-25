package app;

import java.util.Scanner;

import account.Account;
import account.AccountMemDao;

public class JooConsoleBank01 {

	static String[] startMenu = {"0.종료", "1.계좌등록", "2.계좌조회", "3.입금", "4.출금"};
	static Scanner sc = new Scanner(System.in);
	static AccountMemDao amd = new AccountMemDao();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		welcomMessage();
		startBankMenu();
		sayGoodbye();
		sc.close();
	}

	private static void welcomMessage() {
		// TODO Auto-generated method stub
		System.out.println("===================================================");
		System.out.println("Joo Console Bank에 오신 것을 환영합니다.");
	}

	private static void startBankMenu() {
		// TODO Auto-generated method stub
		int menu;
		do {
			menu = getMenu(startMenu);
			switch (menu) {
			case 1: // 계좌등록
				menuAccountRegist();
				break;
			case 2: // 계좌조회
				menuAccountList();
				break;
			case 3: // 입금
				menuDeposit();
				break;
			case 4: // 출금
				System.out.println("4선택");
				menuWithdraw();
				break;
			case 0: // 종료
				return;
			default: // 없는메뉴를 선택
				System.out.println("없는 메뉴입니다. 다시 선택해주세요.");
			}
		}while(menu != 0);
	}

	private static void menuAccountRegist() {
		// 계좌 등록 : 계좌주 이름, 비밀번호, 초기입금액
		System.out.println("[계좌등록 시작]");
		System.out.print("계좌주 : ");
		String owner = sc.nextLine();
		System.out.print("비밀번호 : ");
		String password = sc.nextLine();
		System.out.print("초기입금액 : ");
		int amount = Integer.parseInt(sc.nextLine());
		if (amd.insertAccount(owner, password, amount)) {
			System.out.println("계좌를 등록했습니다.");
		} else {
			System.out.println("계좌를 등록할 수 없습니다.");			
		}
	}

	private static void menuAccountList() {
		// 계좌 조회
		System.out.println("[계좌 조회]");
		showAccountList();
	}

	private static void showAccountList() {
		Account[] accountList = amd.selectAll();
		for (Account a : accountList) {
			System.out.println(a);
		};
	}
	
	private static void menuDeposit() {
		System.out.println("[입금]");
		showAccountList();
		// 입금
		System.out.println("계좌번호 : ");
		int accountNo = sc.nextInt();
		sc.nextLine();
		System.out.println("입금액 : ");
		int amount = sc.nextInt();
		sc.nextLine();
		if(amd.deposit(accountNo, amount)) {
			System.out.println("입금에 성공했습니다");
		} else {
			System.out.println("입금에 실패했습니다.");
		}
	}

	private static void menuWithdraw() {
		// TODO Auto-generated method stub
		System.out.println("[출금]");
		showAccountList();
		// 출금
		System.out.println("계좌번호 : ");
		int accountNo = sc.nextInt();
		sc.nextLine();
		System.out.println("비밀번호 : ");
		String password = sc.nextLine();
		System.out.println("출금액 : ");
		int amount = sc.nextInt();
		sc.nextLine();
		if(amd.withdraw(accountNo, password, amount)) {
			System.out.println("출금에 성공했습니다");
		} else {
			System.out.println("출금에 실패했습니다.");
		}
	}

	private static int getMenu(String[] menuList) {
		//메뉴 출력
		System.out.println("===================================================");
		for (int i = 1; i < menuList.length; i++) {
			System.out.println(menuList[i]);
		}
		System.out.println(menuList[0]);
		System.out.println("===================================================");
		
		//메뉴 선택
		System.out.print(">> 메뉴 선택 : ");
		int menu = sc.nextInt();
		sc.nextLine();
		System.out.println("===================================================");
		
		return menu;
	}
	
	
	private static void sayGoodbye() {
		// TODO Auto-generated method stub
		System.out.println("Joo Console Bank를 이용해 주셔서 감사합니다.");
		System.out.println("안녕히 가십시오.");
		System.out.println("===================================================");
	}

}
