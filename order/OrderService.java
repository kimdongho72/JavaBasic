package SportsCardShop.order;

import SportsCardShop.card.CardVO;

import java.util.ArrayList;

public interface OrderService {

    boolean orderCard(int memberNo, String memberName, CardVO card, int quantity);

    ArrayList<OrderVO> getOrderList();

    ArrayList<OrderVO> getOrderListByMember(int memberNo);
}
