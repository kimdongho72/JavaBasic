package SportsCardShop.card;

import java.util.ArrayList;

public interface CardService {

    ArrayList<CardVO> searchCards(String keyword);

    ArrayList<CardVO> getPopularCards();

    ArrayList<CardVO> filterCards(String keyword, int minPrice, int maxPrice,
                                  String grade, int year, String brand, boolean inStockOnly);
}
