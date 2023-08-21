package payment.command;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import order.service.OrderService;

public class PaymentHandler {
	private static final String FORM_VIEW = "view/purchase/order/payment.jsp";
	private OrderService os = new OrderService();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if (req.getMethod().equalsIgnoreCase("GET")) {
			System.out.println("cart 핸들러 get 지나침!");
			return processSubmit(req, res);
		} else if (req.getMethod().equalsIgnoreCase("POST")) {
			System.out.println("cart 핸들러  post 지나침!");
			
			return processSubmit(req, res);
		} else {
			res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}
	private String processForm(HttpServletRequest req, HttpServletResponse res) {
		return FORM_VIEW;
	}

	private String processSubmit(HttpServletRequest req, HttpServletResponse res) throws UnsupportedEncodingException {
		
		return FORM_VIEW;
	}
	
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