package detail.command;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import detail.service.DetailService;
import item.model.Item;
import mvc.command.CommandHandler;

public class DetailHandler implements CommandHandler {
	private static final String FORM_VIEW = "/view/main/detail.jsp";
	DetailService ds = new DetailService();

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if (req.getMethod().equalsIgnoreCase("GET")) {
			System.out.println("디테일핸들러 두겟 지나침!");
			return processForm(req, res);
		} else if (req.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(req, res);
		} else {
			res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}

	private String processForm(HttpServletRequest req, HttpServletResponse res) {
		return FORM_VIEW;
	}
	
	private String processSubmit(HttpServletRequest req, HttpServletResponse res) throws IOException {
		setItem(req, res);
		String name = req.getParameter("name");
		String count = req.getParameter("count");
		if (count != null) {
			if (req.getAttribute("login") == null) {
				res.sendRedirect(req.getContextPath() + "/login.do");
				return null;
			} else if ((boolean) req.getAttribute("login")) { 
						// id 가져오기
				ds.insert("dudrhs", name, Integer.valueOf(count));
				if (req.getParameter("submit").equals("buy")) {
					res.sendRedirect(req.getContextPath() + "/cart.do");
					return null;
				}
			}
		}
		return FORM_VIEW;
	}

	private void setItem(HttpServletRequest req, HttpServletResponse res) throws UnsupportedEncodingException {
		req.setCharacterEncoding("UTF-8");
		String name = req.getParameter("name");
		Item item = ds.initPage(name);
		req.setAttribute("item", item);
	}
	
}
