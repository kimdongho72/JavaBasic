package SportsCardShop.card;

public class CardVO {

    private int cardId;
    private String name;
    private String team;
    private String category;
    private int price;
    private int stock;
    private boolean isPopular;

    // 필터용 필드
    private String grade;   // 일반, 레어, PSA10
    private int year;       // 발행연도
    private String brand;   // 제조사

    public CardVO(int cardId, String name, String team, String category, int price, int stock,
                  boolean isPopular, String grade, int year, String brand) {
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
    }

    public int getCardId() { return cardId; }
    public String getName() { return name; }
    public String getTeam() { return team; }
    public String getCategory() { return category; }
    public int getPrice() { return price; }
    public int getStock() { return stock; }
    public boolean isPopular() { return isPopular; }
    public String getGrade() { return grade; }
    public int getYear() { return year; }
    public String getBrand() { return brand; }

    public void setStock(int stock) { this.stock = stock; }
    public void setPopular(boolean isPopular) { this.isPopular = isPopular; }

    @Override
    public String toString() {
        return "[" + cardId + "] " + name + " | " + team + " | " + category + " | " +
                grade + " | " + year + " | " + brand + " | " +
                price + "원 | 재고: " + stock + " | 인기: " + (isPopular ? "★" : "-");
    }
}
