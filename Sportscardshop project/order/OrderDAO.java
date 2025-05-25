package SportsCardShop.order;

import java.util.List;

public interface OrderDAO {

    void insert(OrderVO order);

    List<OrderVO> selectAll();

    List<OrderVO> selectByMemberNo(int memberNo);
}