package SportsCardShop.card;

import java.util.List;

public interface CardDAO {

	List<CardVO> selectAll();

	List<CardVO> selectPopular();

	List<CardVO> search(String keyword);

	List<CardVO> filter(CardSearchCondition cond);

	CardVO getCardById(int cardId);

	boolean insert(CardVO card);

	

	boolean remove(int cardId);

	boolean updateStock(int cardId, int newStock);
}
