package payment.command;

import order.service.OrderService;

public class PaymentHandler {
	private static final String FORM_VIEW = "view/purchase/order/order.jsp";
	private OrderService os = new OrderService();
}


// 영수증 리스트에 한줄 추가
//System.out.println("영수증 리스트 추가");
//os.insertReceipt(ds.getId(sessionId), date);
//
//for (BasketList item : basketItems) {
//	System.out.println("영수증 디테일 추가");
//	os.insertReceiptDetail(item.getName(), item.getCount(), item.getPrice());
//	System.out.println("장바구니에서 구매한 항목 삭제");
//	os.deleteBasket(ds.getId(sessionId), item.getName());
//}