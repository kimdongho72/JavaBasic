package SportsCardShop.user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashMapMemberDAO implements MemberDAO {

    protected Map<String, MemberVO> memberMap = new HashMap<>();
    protected Map<Integer, MemberVO> memberNoMap = new HashMap<>();
    protected int memberSeq = 1;

    @Override
    public void insert(MemberVO member) {
        memberMap.put(member.getId(), member);
        memberNoMap.put(member.getMemberNo(), member);
    }

    @Override
    public List<MemberVO> selectAll() {
        return new ArrayList<>(memberMap.values());
    }

    @Override
    public MemberVO selectByMemberNo(int memberNo) {
        return memberNoMap.get(memberNo);
    }

    @Override
    public MemberVO selectById(String id) {
        return memberMap.get(id);
    }

    @Override
    public MemberVO selectByIdAndPassword(String id, String password) {
        MemberVO member = memberMap.get(id);
        if (member != null && member.getPassword().equals(password)) {
            return member;
        }
        return null;
    }

    @Override
    public void updatePassword(int memberNo, String newPassword) {
        MemberVO member = memberNoMap.get(memberNo);
        if (member != null) {
            member.setPassword(newPassword);
        }
    }

    @Override
    public boolean delete(int memberNo) {
        MemberVO removed = memberNoMap.remove(memberNo);
        if (removed != null) {
            memberMap.remove(removed.getId());
            return true;
        }
        return false;
    }


    @Override
    public int getNextMemberNo() {
        return memberSeq++;
    }


}

