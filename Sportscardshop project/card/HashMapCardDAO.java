package SportsCardShop.card;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashMapCardDAO implements CardDAO {

    private Map<Integer, CardVO> cardMap = new HashMap<>();

    public HashMapCardDAO() {
        insert(new CardVO(1, "손흥민", "토트넘", "FW", 100000, 5, true, "PSA10", 2022, "Panini"));
        insert(new CardVO(2, "이강인", "파리", "MF", 80000, 3, true, "레어", 2023, "Topps"));
        insert(new CardVO(3, "메시", "인터마이애미", "FW", 120000, 2, false, "일반", 2021, "Panini"));
    }

    @Override
    public List<CardVO> selectAll() {
        return new ArrayList<>(cardMap.values());
    }

    @Override
    public List<CardVO> selectPopular() {
        List<CardVO> result = new ArrayList<>();
        for (CardVO card : cardMap.values()) {
            if (card.isPopular()) {
                result.add(card);
            }
        }
        return result;
    }

    @Override
    public List<CardVO> search(String keyword) {
        List<CardVO> result = new ArrayList<>();
        for (CardVO card : cardMap.values()) {
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
        for (CardVO card : cardMap.values()) {
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
        cardMap.put(card.getCardId(), card);
    }
}
