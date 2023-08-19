package search.command;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import item.model.Item;
import mvc.command.CommandHandler;
import search.service.SearchService;

public class SearchHandler implements CommandHandler {
	private static final String FORM_VIEW = "/view/main/search.jsp";
	SearchService ss = new SearchService();

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if (req.getMethod().equalsIgnoreCase("GET")) {
			System.out.println("서치핸들러 두겟 지나침!");
			return processForm(req, res);
		} else if (req.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(req, res);
		} else {
			res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}


	private String processForm(HttpServletRequest req, HttpServletResponse res) {
		setItem(req, res);
		return FORM_VIEW;
	}
	
	private String processSubmit(HttpServletRequest req, HttpServletResponse res) {
		return FORM_VIEW;
		
	}

	private void setItem(HttpServletRequest req, HttpServletResponse res) {
		String text = (String) req.getParameter("search");
		System.out.println(text);
//		String text = "감";
		List<Item> list = ss.search(text);
		req.setAttribute("list", list);
	}
}
