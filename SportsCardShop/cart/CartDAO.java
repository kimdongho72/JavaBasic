package SportsCardShop.cart;

import java.util.List;

public interface CartDAO {
	boolean insertCartItem(CartItemVO item);

	CartItemVO selectCartItem(int cardId);

	List<CartItemVO> selectAllCartItem();

	boolean deleteCartItem(int cardId);

	boolean clear();
	

}
