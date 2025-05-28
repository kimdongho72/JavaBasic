package member.file;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import member.HashMapMemberDAO;
import member.MemberVO;

public class TextFileHashMapMemberDAO extends HashMapMemberDAO implements FileMemberDB {

	private String dataFilename = DATA_FILE + ".txt";
	private final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

	@Override
	public void saveMembers() {
		try (FileWriter fw = new FileWriter(dataFilename); PrintWriter pw = new PrintWriter(fw);) {
			SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);

			for (MemberVO member : memberDB.values()) {
				pw.println(member.getMemberNo());
				pw.println(member.getId());
				pw.println(member.getPassword());
				pw.println(member.getUsername());
				pw.println(member.getMobile() != null ? member.getMobile() : "null");
				pw.println(member.getEmail() != null ? member.getEmail() : "null");
				pw.println(member.getAddress() != null ? member.getAddress() : "null");
				pw.println(sdf.format(member.getRegDate()));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void loadMembers() {
		try (FileReader fr = new FileReader(dataFilename); BufferedReader br = new BufferedReader(fr);) {
			SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);

			while (br.ready()) {
				int memberNo = Integer.parseInt(br.readLine());
				String id = br.readLine().strip();
				String password = br.readLine().strip();
				String username = br.readLine().strip();
				String mobile = br.readLine().strip();
				String email = br.readLine().strip();
				String address = br.readLine().strip();
				Date regDate = sdf.parse(br.readLine());

				// "null" 문자열 처리
				mobile = "null".equals(mobile) ? null : mobile;
				email = "null".equals(email) ? null : email;
				address = "null".equals(address) ? null : address;

				MemberVO member = new MemberVO(memberNo, id, password, username, mobile, email, address, regDate);
				memberDB.put(id, member);

				if (memberSeq <= memberNo)
					memberSeq = memberNo + 1;
			}
		} catch (FileNotFoundException e) {
			System.out.println("[로딩 실패] 파일이 존재하지 않습니다: " + dataFilename);
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
	}
}