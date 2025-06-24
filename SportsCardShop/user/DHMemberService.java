package SportsCardShop.user;

import java.util.List;

public class DHMemberService implements MemberService {

	private MemberDAO memberDAO;

	public DHMemberService(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}

	@Override
	public boolean register(String id, String password, String username) {
		if (isIdDuplicate(id))
			return false;

		int memberNo = memberDAO.getNextMemberNo();
		MemberVO newMember = new MemberVO(memberNo, id, password, username);
		memberDAO.insert(newMember);
		return true;
	}

	@Override
	public MemberVO login(String id, String password) {
		return memberDAO.selectByIdAndPassword(id, password);
	}

	@Override
	public List<MemberVO> getMemberList() {
		return memberDAO.selectAll();
	}

	@Override
	public List<MemberVO> getAllMembers() {
		return memberDAO.selectAll();
	}

	@Override
	public MemberVO getMemberByNo(int memberNo) {
		return memberDAO.selectByMemberNo(memberNo);
	}

	@Override
	public boolean isIdDuplicate(String id) {
		return memberDAO.selectById(id) != null;
	}

	@Override
	public boolean updatePassword(int memberNo, String oldPw, String newPw) {
		MemberVO member = memberDAO.selectByMemberNo(memberNo);
		if (member == null)
			return false;
		if (!member.getPassword().equals(oldPw))
			return false;

		memberDAO.updatePassword(memberNo, newPw);
		return true;
	}

	@Override
	public boolean remove(int memberNo) {
	    MemberVO member = memberDAO.selectByMemberNo(memberNo);
	    if (member == null) return false;
	    return memberDAO.delete(memberNo);
	}

}