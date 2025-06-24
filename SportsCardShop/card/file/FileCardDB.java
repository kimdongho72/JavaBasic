package SportsCardShop.card.file;

public interface FileCardDB {
    String DATA_FILE = "./data/cardDB";
    void saveCards();
    void loadCards();
}