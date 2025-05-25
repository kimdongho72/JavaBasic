package SportsCardShop.card;

import java.util.ArrayList;

public class DHCardService implements CardService {

    private CardDAO cardDAO;

    public DHCardService(CardDAO cardDAO) {
        this.cardDAO = cardDAO;
    }

    @Override
    public ArrayList<CardVO> searchCards(String keyword) {
        return new ArrayList<>(cardDAO.search(keyword));
    }

    @Override
    public ArrayList<CardVO> getPopularCards() {
        return new ArrayList<>(cardDAO.selectPopular());
    }

    @Override
    public ArrayList<CardVO> filterCards(String keyword, int minPrice, int maxPrice,
                                         String grade, int year, String brand, boolean inStockOnly) {
        return new ArrayList<>(cardDAO.filter(keyword, minPrice, maxPrice, grade, year, brand, inStockOnly));
    }
}
