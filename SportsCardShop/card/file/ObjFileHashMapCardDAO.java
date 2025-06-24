package SportsCardShop.card.file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;

import SportsCardShop.card.CardDAO;
import SportsCardShop.card.CardVO;
import SportsCardShop.card.HashMapCardDAO;

public class ObjFileHashMapCardDAO extends HashMapCardDAO implements CardDAO {

    private final String DATA_FILE = "./data/cardDB";
    private final String dataFileName = DATA_FILE + ".obj";

    public ObjFileHashMapCardDAO() {
        loadCards();
    }

    private void saveCards() {
        try (
            FileOutputStream fos = new FileOutputStream(dataFileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos)
        ) {
            oos.writeObject(cardMap);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadCards() {
        try (
            FileInputStream fis = new FileInputStream(dataFileName);
            ObjectInputStream ois = new ObjectInputStream(fis)
        ) {
            cardMap = (Map<Integer, CardVO>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("[DB 로딩 실패] " + dataFileName + " 파일이 존재하지 않습니다.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean insert(CardVO card) {
        boolean result = super.insert(card);
        if (result) saveCards();
        return result;
    }

    
    
    @Override
    public boolean remove(int cardId) {
        boolean result = super.remove(cardId);
        if (result) saveCards();  
        return result;
    }

    @Override
    public boolean updateStock(int cardId, int newStock) {
        boolean result = super.updateStock(cardId, newStock);
        if (result) saveCards();
        return result;
    }
}
