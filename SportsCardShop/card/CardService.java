package SportsCardShop.card;

import java.util.List;

public interface CardService {
    List<CardVO> getAllCards();

    CardVO getCardById(int cardId);

    List<CardVO> getPopularCards();

    List<CardVO> searchCards(String keyword);

    List<CardVO> filterCards(CardSearchCondition cond);

    boolean registerCard(CardVO card);

    boolean removeCard(int cardId);

    

    boolean updateCardStock(int cardId, int newStock);
}
