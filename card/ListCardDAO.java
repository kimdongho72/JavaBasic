package SportsCardShop.card;

import java.util.ArrayList;
import java.util.List;

public class ListCardDAO implements CardDAO {

    private List<CardVO> cardList = new ArrayList<>();
    private int cardSeq = 1;

    public ListCardDAO() {
        cardList.add(new CardVO(cardSeq++, "손흥민", "토트넘", "FW", 100000, 5, true, "PSA10", 2022, "Panini"));
        cardList.add(new CardVO(cardSeq++, "이강인", "파리", "MF", 80000, 3, true, "레어", 2023, "Topps"));
        cardList.add(new CardVO(cardSeq++, "메시", "인터마이애미", "FW", 120000, 2, false, "일반", 2021, "Panini"));
        cardList.add(new CardVO(cardSeq++, "호날두", "알나스르", "FW", 95000, 0, false, "레어", 2020, "Topps"));
        cardList.add(new CardVO(cardSeq++, "김민재", "뮌헨", "DF", 70000, 4, true, "PSA10", 2022, "Topps"));
    }

    @Override
    public List<CardVO> selectAll() {
        return cardList;
    }

    @Override
    public List<CardVO> selectPopular() {
        List<CardVO> result = new ArrayList<>();
        for (CardVO card : cardList) {
            if (card.isPopular()) {
                result.add(card);
            }
        }
        return result;
    }

    @Override
    public List<CardVO> search(String keyword) {
        List<CardVO> result = new ArrayList<>();
        for (CardVO card : cardList) {
            if (card.getName().contains(keyword) ||
                card.getTeam().contains(keyword) ||
                card.getCategory().contains(keyword)) {
                result.add(card);
            }
        }
        return result;
    }

    @Override
    public List<CardVO> filter(String keyword, int minPrice, int maxPrice,
                               String grade, int year, String brand, boolean inStockOnly) {
        List<CardVO> result = new ArrayList<>();

        for (CardVO card : cardList) {
            if (!card.getName().contains(keyword) &&
                !card.getTeam().contains(keyword) &&
                !card.getCategory().contains(keyword)) continue;

            if (card.getPrice() < minPrice || card.getPrice() > maxPrice) continue;

            if (grade != null && !grade.isBlank() && !card.getGrade().equals(grade)) continue;
            if (year != 0 && card.getYear() != year) continue;
            if (brand != null && !brand.isBlank() && !card.getBrand().equals(brand)) continue;

            if (inStockOnly && card.getStock() <= 0) continue;

            result.add(card);
        }

        return result;
    }

    @Override
    public void insert(CardVO card) {
        cardList.add(card);
    }
}
