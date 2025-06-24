package SportsCardShop.cart;

import java.util.*;

public class HashMapCartDAO implements CartDAO {

	private Map<Integer, CartItemVO> cartMap = new HashMap<>();

	@Override
	public boolean insertCartItem(CartItemVO item) {
		int cardId = item.getCard().getCardId();
		if (cartMap.containsKey(cardId)) {
			// 수량 누적
			CartItemVO existing = cartMap.get(cardId);
			existing.setQuantity(existing.getQuantity() + item.getQuantity());
		} else {
			cartMap.put(cardId, item);
		}
		return true;
	}

	@Override
	public CartItemVO selectCartItem(int cardId) {
		return cartMap.get(cardId);
	}

	@Override
	public List<CartItemVO> selectAllCartItem() {
		return new ArrayList<>(cartMap.values());
	}

	@Override
	public boolean deleteCartItem(int cardId) {
		return cartMap.remove(cardId) != null;
	}

	@Override
	public boolean clear() {
		cartMap.clear();
		return true;
	}
}
