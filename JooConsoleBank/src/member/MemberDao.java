package member;

import java.util.List;

public interface MemberDao {
	boolean insertMember(Member m);
	List<Member> selectAll();
	Member selectbyId(String id);
	boolean updateMember(Member m, String password);
	boolean deleteMember(Member m, String password);
}
