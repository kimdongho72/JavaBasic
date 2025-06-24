package SportsCardShop.user.file;

public interface FileMemberDB {
	String DATA_FILE = "./data/memberDB";

	void saveMembers();

	void loadMembers();
}
