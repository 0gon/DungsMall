package order.command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.RequestWrapper;

import org.apache.taglibs.standard.lang.jstl.parser.Token;

import com.google.gson.Gson;
import com.mysql.cj.protocol.a.LocalDateTimeValueEncoder;
import com.mysql.cj.protocol.a.LocalDateValueEncoder;

import basket.model.BasketList;
import detail.service.DetailService;
import mvc.command.CommandHandler;
import order.service.OrderService;

public class OrderHandler implements CommandHandler {
	private static final String FORM_VIEW = "view/purchase/order/order.jsp";
	private OrderService os = new OrderService();
	private List<BasketList> list = new ArrayList<>();

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if (req.getMethod().equalsIgnoreCase("GET")) {
			System.out.println("Order 핸들러 Get 지나침!");
			return processForm(req, res);
		} else if (req.getMethod().equalsIgnoreCase("POST")) {
			System.out.println("Order 핸들러 Post 지나침!");
			processOrder(req,res);
			
			
			return processSubmit(req, res);
		} else {
			res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}

	private String processForm(HttpServletRequest req, HttpServletResponse res) {
		return FORM_VIEW;
	}

	private String processSubmit(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
//		req.setCharacterEncoding("UTF-8");
//		LocalDate date = LocalDate.now();
//		String dateS = String.valueOf(date);
//		DetailService ds = new DetailService();
//		String sessionId = (String) req.getAttribute("sessionId");
//		BufferedReader reader = req.getReader();
//		StringBuilder requestBody = new StringBuilder();
//		String line;
//
//		while ((line = reader.readLine()) != null) {
//			requestBody.append(line);
//		}
//
//		// JSON 데이터를 Gson을 이용하여 객체로 변환
//		Gson gson = new Gson();
//		BasketList[] basketItems = gson.fromJson(requestBody.toString(), BasketList[].class);
//
//		// 체크된 리스트 생성하기
//		for (BasketList item : basketItems) {
//			list.add(new BasketList(item.getName(), item.getCount(), item.getPrice()));
//		}
//		System.out.println("추가가 끝난 리스트" + list);
//		req.setAttribute("basketCheckList", list);
//		RequestDispatcher dispatcher = req.getRequestDispatcher(FORM_VIEW);
//		dispatcher.forward(req, res);
//		// 영수증 리스트에 한줄 추가
//		System.out.println("영수증 리스트 추가");
//		os.insertReceipt(ds.getId(sessionId), date);
//
//		for (BasketList item : basketItems) {
//			System.out.println("영수증 디테일 추가");
//			os.insertReceiptDetail(item.getName(), item.getCount(), item.getPrice());
//			System.out.println("장바구니에서 구매한 항목 삭제");
//			os.deleteBasket(ds.getId(sessionId), item.getName());
//		}
		return FORM_VIEW;
	}

	private String processOrder(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		req.setCharacterEncoding("UTF-8");
		LocalDate date = LocalDate.now();
		String dateS = String.valueOf(date);
		DetailService ds = new DetailService();
		String sessionId = (String) req.getAttribute("sessionId");
		BufferedReader reader = req.getReader();
		StringBuilder requestBody = new StringBuilder();
		String line;

		while ((line = reader.readLine()) != null) {
			requestBody.append(line);
		}

		// JSON 데이터를 Gson을 이용하여 객체로 변환
		Gson gson = new Gson();
		BasketList[] basketItems = gson.fromJson(requestBody.toString(), BasketList[].class);

		// 체크된 리스트 생성하기
		for (BasketList item : basketItems) {
			list.add(new BasketList(item.getName(), item.getCount(), item.getPrice()));
		}
		System.out.println("추가가 끝난 리스트" + list);
		req.setAttribute("basketCheckList", list);
		return FORM_VIEW;
	}
}
