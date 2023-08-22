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

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if (req.getMethod().equalsIgnoreCase("GET")) {
			System.out.println("Order 핸들러 Get 지나침!");
			return processForm(req, res);
		} else if (req.getMethod().equalsIgnoreCase("POST")) {
			System.out.println("Order 핸들러 Post 지나침!");
			
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
		if(basketItems != null) {
		for (BasketList item : basketItems) {
			list.add(new BasketList(item.getName(), item.getPrice(), item.getCount()));
		}
		
		System.out.println("추가가 끝난 리스트" + list);
		req.setAttribute("basketCheckList", list);
		return FORM_VIEW;
		} else {
			System.out.println("OrderHandler : 아직 아이템이 담기지 않았습니다.");
		}
		return FORM_VIEW;
	}
}
