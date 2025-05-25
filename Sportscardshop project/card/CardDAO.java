package SportsCardShop.card;

import java.util.List;

public interface CardDAO {

    List<CardVO> selectAll();

    List<CardVO> selectPopular();

    List<CardVO> search(String keyword);

    List<CardVO> filter(String keyword, int minPrice, int maxPrice, String grade, int year, String brand, boolean inStockOnly);

    void insert(CardVO card);
}
