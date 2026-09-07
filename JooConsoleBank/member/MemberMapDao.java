package member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberMapDao implements MemberDao {

	Map<String, Member> memberDB = new HashMap<>();
	
	@Override
	public boolean insertMember(Member m) {
		memberDB.put(m.getId(), m);
		return false;
	}

	@Override
	public List<Member> selectAll() {
		return new ArrayList<>(memberDB.values());
	}

	@Override
	public Member selectbyId(String id) {
		return memberDB.get(id);
	}

	@Override
	public boolean updateMember(Member m, String password) {
		Member member = selectbyId(m.getId());
		if (member != null || member.getPassword().equals(password)) {
			memberDB.put(m.getId(), m);
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteMember(Member m, String password) {
		Member member = selectbyId(m.getId());
		if (member != null || member.getPassword().equals(password)) {
			memberDB.remove(m.getId());
			return true;
		}
		return false;
	}

}
