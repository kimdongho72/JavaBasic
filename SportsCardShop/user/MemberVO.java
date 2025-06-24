package SportsCardShop.user;

import java.io.Serializable;

public class MemberVO implements Serializable {
	private static final long serialVersionUID = 1L;
	private int memberNo;
	private String id;
	private String password;
	private String username;

	public MemberVO(int memberNo, String id, String password, String username) {
		this.memberNo = memberNo;
		this.id = id;
		this.password = password;
		this.username = username;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public String getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}

	public String getUsername() {
		return username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUsername(String username) {
		this.username = username;
	} // 닉네임 변경 대응용

	@Override
	public String toString() {
		return "[회원번호: " + memberNo + "] " + id + " / " + username;
	}
}
