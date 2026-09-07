package member;

import java.util.List;

public class MemberService {

	final String ADMIN_ID = "admin";
	final String ADMIN_PASSWORD = "1234";
	
	private MemberDao dao;
	private Member loginMember;
	
	public MemberService(MemberDao dao) {
		this.dao = dao;
	}
	
	public boolean registerMember(String id, String password, String nickname) {
		if (dao.selectbyId(id) == null) {
			Member member = new Member(id, nickname, password);
			dao.insertMember(member);
			return true;
		}
		return false;
	}
	
	public boolean login(String id, String password) {
		if (id.equals(ADMIN_ID)) {
			if (password.equals(ADMIN_PASSWORD)) {
				// 관리자로 로그인
				loginMember = new Member(ADMIN_ID, null, ADMIN_PASSWORD);
				return true;
			}
			return false;
		}
		Member member = dao.selectbyId(id);
		if (member != null && member.getPassword().equals(password)) {
			// 일반 회원 로그인
			loginMember = member;
			return true;
		}
		return false;
	}
	
	public boolean logout() {
		loginMember = null;
		return true;
	}
	
	public List<Member> getMembers() {
		return dao.selectAll();
	}

	public Member getLoginMember() {
		return loginMember;
	}

	public String getAdminId() {
		return ADMIN_ID;
	}
	
	public Member getMemberById(String id) {
		return dao.selectbyId(id);
	}

	public void insertMember(Member member) {
		dao.insertMember(member);
	}

	public boolean updatePassword(String oldPassword, String newPassword) {
		if (!loginMember.getPassword().equals(oldPassword))
			return false;

		loginMember.setPassword(newPassword);
		return dao.updateMember(loginMember, newPassword);
	}

	public boolean deleteMember(String password) {
		if (dao.deleteMember(loginMember, password)) {
			logout();
			return true;
		}
		return false;
	}

	public boolean deleteMemberByAdmin(String id) {
		Member target = dao.selectbyId(id);
		if (target == null)
			return false;
		return dao.deleteMember(target, target.getPassword());
	}
	
	
}
