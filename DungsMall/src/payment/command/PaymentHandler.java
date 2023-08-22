package payment.command;

import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import basket.model.BasketList;
import detail.service.DetailService;
import mvc.command.CommandHandler;
import order.service.OrderService;

public class PaymentHandler implements CommandHandler {
	private static final String FORM_VIEW = "view/purchase/order/payment.jsp";
	private OrderService os = new OrderService();
	

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if (req.getMethod().equalsIgnoreCase("GET")) {
			System.out.println("payment 핸들러 get 지나침!");
			return processSubmit(req, res);
		} else if (req.getMethod().equalsIgnoreCase("POST")) {
			System.out.println("payment 핸들러  post 지나침!");

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
		req.setCharacterEncoding("UTF-8");
		LocalDate date = LocalDate.now();
		String dateS = String.valueOf(date);
		DetailService ds = new DetailService();
		String sessionId = (String) req.getAttribute("sessionId");
		String line;
		List<BasketList> list = new ArrayList<>();
		// JSON 데이터를 Gson을 이용하여 객체로 변환
		Gson gson = new Gson();
		BasketList[] basketItems = gson.fromJson(req.getParameter("postData"), BasketList[].class);

		// 체크된 리스트 생성하기
		if (basketItems != null) {
			for (BasketList item : basketItems) {
				list.add(new BasketList(item.getName(), item.getPrice(), item.getCount()));
			}

			// 영수증 리스트에 한줄 추가
			System.out.println("영수증 리스트 추가");
			os.insertReceipt(ds.getId(sessionId), date);

			for (BasketList item : basketItems) {
				 System.out.println("영수증 디테일 추가");
				os.insertReceiptDetail(item.getName(), item.getCount(), item.getPrice());
				 System.out.println("장바구니에서 구매한 항목 삭제");
				os.deleteBasket(ds.getId(sessionId), item.getName());
			}
		}
		return FORM_VIEW;

	}
}
