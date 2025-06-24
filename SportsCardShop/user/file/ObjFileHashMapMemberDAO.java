package SportsCardShop.user.file;

import SportsCardShop.user.*;

import java.io.*;
import java.util.Collections;
import java.util.Map;

public class ObjFileHashMapMemberDAO extends HashMapMemberDAO implements FileMemberDB {

	private String dataFileName = DATA_FILE + ".obj";

	public ObjFileHashMapMemberDAO() {
		loadMembers();
	}

	@Override
	public void saveMembers() {
		try (FileOutputStream fos = new FileOutputStream(dataFileName);
				ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			oos.writeObject(memberMap);
			oos.writeObject(memberNoMap);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void loadMembers() {
		try (FileInputStream fis = new FileInputStream(dataFileName);
				ObjectInputStream ois = new ObjectInputStream(fis)) {
			memberMap = (Map<String, MemberVO>) ois.readObject();
			memberNoMap = (Map<Integer, MemberVO>) ois.readObject();

			if (!memberNoMap.isEmpty()) {
				memberSeq = Collections.max(memberNoMap.keySet()) + 1;
			}
		} catch (FileNotFoundException e) {
			System.out.println("[DB 로딩] " + dataFileName + " 이 없습니다.");
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void insert(MemberVO member) {
		super.insert(member);
		saveMembers();
	}

	@Override
	public void updatePassword(int memberNo, String newPassword) {
		super.updatePassword(memberNo, newPassword);
		saveMembers();
	}

	@Override
	public boolean delete(int memberNo) {
		boolean result = super.delete(memberNo);
		if (result) {
			saveMembers(); // 변경사항 저장
		}
		return result;
	}
}
