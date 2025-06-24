package SportsCardShop.cart;

import SportsCardShop.card.CardVO;

public class CartItemVO {
	private CardVO card;
	private int quantity;

	public CartItemVO(CardVO card, int quantity) {
		this.card = card;
		this.quantity = quantity;
	}

	public CardVO getCard() {
		return card;
	}

	public void setCard(CardVO card) {
		this.card = card;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "[" + card.getName() + " | 수량: " + quantity + "]";
	}
}