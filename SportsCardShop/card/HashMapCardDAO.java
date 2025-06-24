package SportsCardShop.card;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashMapCardDAO implements CardDAO {

    protected Map<Integer, CardVO> cardMap = new HashMap<>();
    protected int cardSeq = 1;

    @Override
    public boolean insert(CardVO card) {
        if (card == null) return false;

        if (card.getCardId() == 0) {
            card.setCardId(cardSeq++);
        } else if (card.getCardId() >= cardSeq) {
            cardSeq = card.getCardId() + 1;
        }
        cardMap.put(card.getCardId(), card);
        return true;
    }

    
    
    @Override
    public boolean remove(int cardId) {
        return cardMap.remove(cardId) != null;
    }

    @Override
    public boolean updateStock(int cardId, int newStock) {
        CardVO card = cardMap.get(cardId);
        if (card != null) {
            card.setStock(newStock);
            return true;
        }
        return false;
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
    public List<CardVO> filter(CardSearchCondition cond) {
        List<CardVO> result = new ArrayList<>();
        for (CardVO card : cardMap.values()) {
            if (cond.getKeyword() != null && !cond.getKeyword().isBlank()) {
                if (!card.getName().contains(cond.getKeyword()) &&
                    !card.getTeam().contains(cond.getKeyword()) &&
                    !card.getCategory().contains(cond.getKeyword())) continue;
            }
            if (cond.getMinPrice() != null && card.getPrice() < cond.getMinPrice()) continue;
            if (cond.getMaxPrice() != null && card.getPrice() > cond.getMaxPrice()) continue;
            if (cond.getGrade() != null && !cond.getGrade().isBlank() &&
                !card.getGrade().equals(cond.getGrade())) continue;
            if (cond.getYear() != null && !cond.getYear().equals(card.getYear())) continue;

            if (cond.getBrand() != null && !cond.getBrand().isBlank() &&
                !card.getBrand().equals(cond.getBrand())) continue;
            if (cond.getInStockOnly() != null && cond.getInStockOnly() && card.getStock() <= 0) continue;

            result.add(card);
        }
        return result;
    }

    @Override
    public CardVO getCardById(int cardId) {
        return cardMap.get(cardId);
    }
}
