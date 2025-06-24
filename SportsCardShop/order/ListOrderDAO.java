package SportsCardShop.order;

import java.util.ArrayList;
import java.util.List;

public class ListOrderDAO implements OrderDAO {

    private List<OrderVO> orderList = new ArrayList<>();
   

    @Override
    public void insert(OrderVO order) {
        orderList.add(order);
    }

    @Override
    public List<OrderVO> selectAll() {
        return orderList;
    }

    @Override
    public List<OrderVO> selectByMemberNo(int memberNo) {
        List<OrderVO> result = new ArrayList<>();
        for (OrderVO order : orderList) {
            if (order.getMemberNo() == memberNo) {
                result.add(order);
            }
        }
        return result;
    }
}