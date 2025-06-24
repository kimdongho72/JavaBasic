package SportsCardShop.card;

import java.util.List;

public class DHCardService implements CardService {

  
	private final CardDAO cardDAO;

    public DHCardService(CardDAO cardDAO) {
        this.cardDAO = cardDAO;
   
    }

    @Override
    public List<CardVO> getAllCards() {
        return cardDAO.selectAll();
    }

    @Override
    public CardVO getCardById(int cardId) {
        return cardDAO.getCardById(cardId); 
    }

    @Override
    public List<CardVO> getPopularCards() {
        return cardDAO.selectPopular();
    }

    @Override
    public List<CardVO> searchCards(String keyword) {
        return cardDAO.search(keyword);
    }

    @Override
    public List<CardVO> filterCards(CardSearchCondition cond) {
        return cardDAO.filter(cond);
    }

    @Override
    public boolean registerCard(CardVO card) {
        return cardDAO.insert(card);
    }

    @Override
    public boolean removeCard(int cardId) {
        CardVO target = cardDAO.getCardById(cardId);
        if (target != null) {
            return cardDAO.remove(cardId); 
        }
        return false;
    }


    @Override
    public boolean updateCardStock(int cardId, int newStock) {
        return cardDAO.updateStock(cardId, newStock);
    }

}

