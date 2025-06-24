//package SportsCardShop.card.file;
//
//import SportsCardShop.card.CardVO;
//import SportsCardShop.card.HashMapCardDAO;
//
//import java.io.*;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//
//public class TextFileHashMapCardDAO extends HashMapCardDAO implements FileCardDB {
//
//    private String dataFileName = DATA_FILE + ".txt";
//    private final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
//
//    @Override
//    public void saveCards() {
//        try (FileWriter fw = new FileWriter(dataFileName);
//             PrintWriter pw = new PrintWriter(fw)) {
//
//            for (CardVO card : cardMap.values()) {
//                pw.println(card.getCardId());
//                pw.println(card.getName());
//                pw.println(card.getTeam());
//                pw.println(card.getCategory());
//                pw.println(card.getPrice());
//                pw.println(card.getStock());
//                pw.println(card.isPopular());
//                pw.println(card.getGrade());
//                pw.println(card.getYear());
//                pw.println(card.getBrand());
//
//                SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
//                pw.println(sdf.format(card.getRegDate()));
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public void loadCards() {
//        try (FileReader fr = new FileReader(dataFileName);
//             BufferedReader br = new BufferedReader(fr)) {
//
//            while (br.ready()) {
//                int cardId = Integer.parseInt(br.readLine());
//                String name = br.readLine().strip();
//                String team = br.readLine().strip();
//                String category = br.readLine().strip();
//                int price = Integer.parseInt(br.readLine());
//                int stock = Integer.parseInt(br.readLine());
//                boolean isPopular = Boolean.parseBoolean(br.readLine());
//                String grade = br.readLine().strip();
//                int year = Integer.parseInt(br.readLine());
//                String brand = br.readLine().strip();
//
//                SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
//                Date regdate = sdf.parse(br.readLine());
//
//                cardMap.put(cardId, new CardVO(cardId, name, team, category, price, stock,
//                        isPopular, grade, year, brand, regdate));
//
//                if (cardSeq <= cardId)
//                    cardSeq = cardId + 1;
//            }
//
//        } catch (FileNotFoundException e) {
//            System.out.println("[\uB85C\uB529] " + dataFileName + "\uC774 \uC5C6\uC2B5\uB2C8\uB2E4.");
//        } catch (IOException | ParseException e) {
//            e.printStackTrace();
//        }
//    }
//}