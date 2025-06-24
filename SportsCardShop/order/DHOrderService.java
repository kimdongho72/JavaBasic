package SportsCardShop.order;

import SportsCardShop.card.CardVO;

import java.time.LocalDate;
import java.util.ArrayList;


public class DHOrderService implements OrderService {

    private OrderDAO orderDAO;
    private int orderSeq = 1;

    public DHOrderService(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    @Override
    public boolean orderCard(int memberNo, String memberName, CardVO card, int quantity) {
        if (card.getStock() < quantity) {
            return false; 
        }

        card.setStock(card.getStock() - quantity);

        int totalPrice = card.getPrice() * quantity;
        OrderVO order = new OrderVO(orderSeq++, memberNo, memberName,
                card.getCardId(), card.getName(), quantity, totalPrice, LocalDate.now());

        orderDAO.insert(order);
        return true;
    }

    @Override
    public ArrayList<OrderVO> getOrderList() {
        return new ArrayList<>(orderDAO.selectAll());
    }

    @Override
    public ArrayList<OrderVO> getOrderListByMember(int memberNo) {
        return new ArrayList<>(orderDAO.selectByMemberNo(memberNo));
    }
}