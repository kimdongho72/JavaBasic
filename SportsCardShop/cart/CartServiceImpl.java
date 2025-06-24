package SportsCardShop.cart;

import java.util.List;

public class CartServiceImpl implements CartService {

	private CartDAO cartDAO;

	public CartServiceImpl(CartDAO cartDAO) {
		this.cartDAO = cartDAO;
	}

	@Override
	public boolean addItemToCart(CartItemVO item) {
		return cartDAO.insertCartItem(item);
	}

	@Override
	public CartItemVO getCartItemInfo(int cardId) {
		return cartDAO.selectCartItem(cardId);
	}

	@Override
	public List<CartItemVO> listCartItems() {
		return cartDAO.selectAllCartItem();
	}

	@Override
	public boolean isCartEmpty() {
		return cartDAO.selectAllCartItem().isEmpty();
	}

	@Override
	public boolean removeCartItem(int cardId) {
		return cartDAO.deleteCartItem(cardId);
	}

	@Override
	public boolean clearCart() {
		return cartDAO.clear();
	}
}
