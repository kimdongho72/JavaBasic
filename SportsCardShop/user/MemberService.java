package SportsCardShop.user;

import java.util.List;

public interface MemberService {

	List<MemberVO> getAllMembers();

	boolean register(String id, String password, String username);

	MemberVO login(String id, String password);

	List<MemberVO> getMemberList();

	MemberVO getMemberByNo(int memberNo);

	boolean isIdDuplicate(String id);

	boolean updatePassword(int memberNo, String oldPw, String newPw);

	boolean remove(int memberNo);

}
