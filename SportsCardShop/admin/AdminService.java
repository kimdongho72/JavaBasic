package SportsCardShop.admin;

import SportsCardShop.card.CardVO;
import SportsCardShop.order.OrderVO;
import SportsCardShop.user.MemberVO;

import java.util.List;

public interface AdminService {

    void registerCard(CardVO card);

    boolean removeCard(int cardId);

    
    boolean updateCardStock(int cardId, int newStock);  
    boolean removeMember(int memberNo);  
 
    

    List<CardVO> getAllCards();

    List<OrderVO> getAllOrders();

    List<MemberVO> getAllMembers();

                 




}