package app;

import java.util.List;

import account.FileDB;
import member.Member;
import member.MemberDao;
import member.MemberMapDao;
import member.MemberObjFileMapDao;
import member.MemberService;

public class MemberTest {

	public static void main(String[] args) {
		testFileOperation();
		
	}
	static void testFileOperation() {
//		String dbFilename = "memberDB.txt";
//		String dbFilename = "memberDB.dat";
		String dbFilename = "memberDB.obj";
		
//		MemberDao dao = new MemberFileMapDao(dbFilename);
//		MemberDao dao = new MemberDataFileMapDao(dbFilename);
		MemberDao dao = new MemberObjFileMapDao(dbFilename);
		FileDB fdb = (FileDB)dao;
		
		//insert
		dao.insertMember(new Member("aaa", "aaa", "1234"));
		dao.insertMember(new Member("ccc", "ccc", "1234"));
		
//		fdb.saveDB();
		fdb.loadDB();
		printMemberList(dao.selectAll());
		
	}
	
	
	static void testService() {
		MemberService ms = new MemberService(new MemberMapDao());
		
		ms.registerMember("aaa", "1234", "aaa");
		ms.registerMember("ccc", "1234", "ccc");
		printMemberList(ms.getMembers());
		
		ms.login("aaa", "1234");
		System.out.println(ms.getLoginMember());
	}

	static void testDao() {
		MemberDao mdao = new MemberMapDao();

		// insert
		mdao.insertMember(new Member("aaa", "1234", "aaa"));
		mdao.insertMember(new Member("ccc", "1234", "ccc"));
		
		// selectAll
		List<Member> mlist = mdao.selectAll();
		for (Member m : mlist)
			System.out.println(m);
		
		// select by id
		System.out.println(mdao.selectbyId("aaa"));
		
		// update
		Member m = new Member("aaa", "bbb", "1111");
//		mdao.updateMember(m);
		System.out.println(mdao.selectbyId("aaa"));
		
		//delete
//		mdao.deleteMember("aaa");
		mlist = mdao.selectAll();
		for (Member m2 : mlist)
			System.out.println(m2);
	}
	
	static void printMemberList(List<Member> mlist) {
		for (Member m2 : mlist) {
			System.out.println(m2);
		}
	}
}
