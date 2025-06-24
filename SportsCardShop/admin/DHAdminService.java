package SportsCardShop.admin;

import SportsCardShop.card.CardService;
import SportsCardShop.card.CardVO;
import SportsCardShop.order.OrderDAO;
import SportsCardShop.order.OrderVO;
import SportsCardShop.user.MemberService;
import SportsCardShop.user.MemberVO;

import java.util.List;

public class DHAdminService implements AdminService {

    private CardService cardService;
    private MemberService memberService;
    private OrderDAO orderDAO;

    public DHAdminService(CardService cardService, MemberService memberService, OrderDAO orderDAO) {
        this.cardService = cardService;
        this.memberService = memberService;
        this.orderDAO = orderDAO;
    }

    @Override
    public void registerCard(CardVO card) {
        cardService.registerCard(card);  
    }

  

    @Override
    public boolean updateCardStock(int cardId, int newStock) {
        CardVO card = cardService.getCardById(cardId);
        if (card == null) return false;
        card.setStock(newStock);
        return true;
    }

    @Override
    public boolean removeCard(int cardId) {
        CardVO card = cardService.getCardById(cardId);
        if (card == null) return false;
        return cardService.removeCard(cardId);
    }

    @Override
    public List<CardVO> getAllCards() {
        return cardService.searchCards("");  
    }

    @Override
    public List<OrderVO> getAllOrders() {
        return orderDAO.selectAll();
    }

    @Override
    public List<MemberVO> getAllMembers() {
        return memberService.getAllMembers(); 
    }
    @Override
    public boolean removeMember(int memberNo) {
        MemberVO member = memberService.getMemberByNo(memberNo);
        if (member == null) return false;
        return memberService.remove(memberNo);
    }

}
