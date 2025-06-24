//package SportsCardShop.user.file;
//
//import SportsCardShop.user.HashMapMemberDAO;
//import SportsCardShop.user.MemberVO;
//
//import java.io.*;
//
//
//public class TextFileHashMapMemberDAO extends HashMapMemberDAO implements FileMemberDB {
//
//    private final String dataFilename = DATA_FILE + ".txt";
//   
//
//    @Override
//    public void saveMembers() {
//        try (
//            FileWriter fw = new FileWriter(dataFilename);
//            PrintWriter pw = new PrintWriter(fw);
//        ) {
//            for (MemberVO member : memberMap.values()) {
//                pw.println(member.getMemberNo());
//                pw.println(member.getId());
//                pw.println(member.getPassword());
//                pw.println(member.getUsername());
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public void loadMembers() {
//        try (
//            FileReader fr = new FileReader(dataFilename);
//            BufferedReader br = new BufferedReader(fr);
//        ) {
//            while (br.ready()) {
//                int memberNo = Integer.parseInt(br.readLine());
//                String id = br.readLine();
//                String pw = br.readLine();
//                String username = br.readLine();
//
//                MemberVO member = new MemberVO(memberNo, id, pw, username);
//                memberMap.put(id, member);
//                memberNoMap.put(memberNo, member);
//
//                if (memberSeq <= memberNo) memberSeq = memberNo + 1;
//            }
//        } catch (FileNotFoundException e) {
//            System.out.println("[로딩] " + dataFilename + " 이 없습니다.");
//        } catch (IOException | NumberFormatException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public void insert(MemberVO member) {
//        super.insert(member);
//        saveMembers();
//    }
//
//    @Override
//    public void updatePassword(int memberNo, String newPassword) {
//        super.updatePassword(memberNo, newPassword);
//        saveMembers();
//    }
//
//    @Override
//    public void delete(int memberNo) {
//        super.delete(memberNo);
//        saveMembers();
//    }
//
//    @Override
//    public void remove(int memberNo) {
//        super.remove(memberNo);
//        saveMembers();
//    }
//}  
