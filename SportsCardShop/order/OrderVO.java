package SportsCardShop.order;


import java.time.LocalDate;

public class OrderVO  {

    private int orderId;
    private int memberNo;
    private String memberName;
    private int cardId;
    private String cardName;
    private int quantity;
    private int totalPrice;
    private LocalDate orderDate;

    public OrderVO(int orderId, int memberNo, String memberName, int cardId,
                   String cardName, int quantity, int totalPrice, LocalDate orderDate) {
        this.orderId = orderId;
        this.memberNo = memberNo;
        this.memberName = memberName;
        this.cardId = cardId;
        this.cardName = cardName;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.orderDate = orderDate;
    }

    public int getOrderId() { return orderId; }
    public int getMemberNo() { return memberNo; }
    public String getMemberName() { return memberName; }
    public int getCardId() { return cardId; }
    public String getCardName() { return cardName; }
    public int getQuantity() { return quantity; }
    public int getTotalPrice() { return totalPrice; }
    public LocalDate getOrderDate() { return orderDate; }

    @Override
    public String toString() {
        return "[주문번호: " + orderId + "] " +
               "회원: " + memberName + " (No." + memberNo + ") | " +
               "카드: " + cardName + " (ID: " + cardId + ") | " +
               "수량: " + quantity + "개 | 총액: " + totalPrice + "원 | " +
               "주문일: " + orderDate;
    }
}