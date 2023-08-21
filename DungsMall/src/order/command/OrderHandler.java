package order.command;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.RequestWrapper;

import org.apache.taglibs.standard.lang.jstl.parser.Token;

import com.google.gson.Gson;

import basket.model.BasketList;
import mvc.command.CommandHandler;

public class OrderHandler implements CommandHandler {
	private static final String FORM_VIEW = "view/purchase/order/order.jsp";
	private List<BasketList> basketList = new ArrayList<>();

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if (req.getMethod().equalsIgnoreCase("GET")) {
			System.out.println("Order 핸들러 Get 지나침!");
			return processForm(req, res);
		} else if (req.getMethod().equalsIgnoreCase("POST")) {
			System.out.println("Order 핸들러 Post 지나침!");
			req.setCharacterEncoding("UTF-8");
			BufferedReader reader = req.getReader();
	        StringBuilder requestBody = new StringBuilder();
	        String line;
	        while ((line = reader.readLine()) != null) {
	            requestBody.append(line);
	        }

	        // JSON 데이터를 Gson을 이용하여 객체로 변환
	        Gson gson = new Gson();
	        BasketList[] basketItems = gson.fromJson(requestBody.toString(), BasketList[].class);

	        // 변환된 객체들을 처리하거나 출력
	        for (BasketList item : basketItems) {
	            System.out.println("Item: " + item.getName() +
	                               ", Price: " + item.getPrice() +
	                               ", Count: " + item.getCount());
	        }
			
			
			return processSubmit(req, res);
		} else {
			res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}

	private String processForm(HttpServletRequest req, HttpServletResponse res) {
		return FORM_VIEW;
	}

	private String processSubmit(HttpServletRequest req, HttpServletResponse res) {
		return FORM_VIEW;
	}
}
