package SportsCardShop.cart;

import java.util.List;

public interface CartService {
	boolean addItemToCart(CartItemVO item);

	CartItemVO getCartItemInfo(int cardId);

	List<CartItemVO> listCartItems();

	boolean isCartEmpty();

	boolean removeCartItem(int cardId);

	boolean clearCart();
}
