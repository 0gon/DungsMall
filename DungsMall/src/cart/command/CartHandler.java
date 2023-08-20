package cart.command;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import basket.dao.BasketDao;
import basket.model.BasketSub;
import cart.service.CartService;
import detail.service.DetailService;
import item.model.Item;
import mvc.command.CommandHandler;

public class CartHandler implements CommandHandler {
	private static final String FORM_VIEW = "view/purchase/cart/cart.jsp";
	CartService cartService = new CartService();
	List<BasketSub> list = new ArrayList<>();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if (req.getMethod().equalsIgnoreCase("GET")) {
			System.out.println("cart 핸들러 get 지나침!");
			return processForm(req, res);
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

	private String processSubmit(HttpServletRequest req, HttpServletResponse res) {
		
		setItem(req, res);
		return FORM_VIEW;
	}

	private void setItem(HttpServletRequest req, HttpServletResponse res) {
		String name = "dudrhs";
		 list = cartService.itemCall(name);
		 req.setAttribute("basketList", list);
	}
}



