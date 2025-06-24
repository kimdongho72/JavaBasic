package SportsCardShop.card;

import java.io.Serializable;
import java.util.Date;

public class CardVO implements Serializable {
	private static final long serialVersionUID = 1L;
	private int cardId;
	private String name;
	private String team;
	private String category;
	private int price;
	private int stock;
	private boolean isPopular;
	private Date regDate;

	private String grade;
	private int year;
	private String brand;

	private int totalOrderQuantity = 0;

	public CardVO(int cardId, String name, String team, String category, int price, int stock, boolean isPopular,
			String grade, int year, String brand, Date regDate) {
		this.cardId = cardId;
		this.name = name;
		this.team = team;
		this.category = category;
		this.price = price;
		this.stock = stock;
		this.isPopular = isPopular;
		this.grade = grade;
		this.year = year;
		this.brand = brand;
		this.regDate = regDate;
	}

	public CardVO(int cardId, String name, String team, String category, int price, int stock, boolean isPopular,
			String grade, int year, String brand) {
		this(cardId, name, team, category, price, stock, isPopular, grade, year, brand, new Date());
	}

	public int getCardId() {
		return cardId;
	}

	public String getName() {
		return name;
	}

	public String getTeam() {
		return team;
	}

	public String getCategory() {
		return category;
	}

	public int getPrice() {
		return price;
	}

	public int getStock() {
		return stock;
	}

	public boolean isPopular() {
		return isPopular;
	}

	public String getGrade() {
		return grade;
	}

	public int getYear() {
		return year;
	}

	public String getBrand() {
		return brand;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public void setPopular(boolean isPopular) {
		this.isPopular = isPopular;
	}

	public Date getRegDate() {
		return regDate;

	}

	public void setRegdate(Date regDate) {
		this.regDate = regDate;
	}

	public void setCardId(int cardId) {
		this.cardId = cardId;
	}

//	public int getTotalOrderQuantity() {
//		return totalOrderQuantity;
//	}
//
//	public void addToTotalOrderQuantity(int quantity) {
//		this.totalOrderQuantity += quantity;
//	}

	@Override
	public String toString() {
		return "[" + cardId + "] " + name + " | " + team + " | " + category + " | " + grade + " | " + year + " | "
				+ brand + " | " + price + "원 | 재고: " + stock + " | 인기: " + (isPopular ? "★" : "-");
	}
}
