package SportsCardShop.user;

import java.util.List;

public interface MemberDAO {

    void insert(MemberVO member);

    List<MemberVO> selectAll();

    MemberVO selectByMemberNo(int memberNo);

    MemberVO selectById(String id);

    MemberVO selectByIdAndPassword(String id, String password);

    void updatePassword(int memberNo, String newPassword);

  
    int getNextMemberNo();
    boolean delete(int memberNo);
}
