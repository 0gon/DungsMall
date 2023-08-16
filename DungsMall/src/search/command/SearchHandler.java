package search.command;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import item.dao.ItemDao;
import item.model.Item;
import mvc.command.CommandHandler;

public class SearchHandler implements CommandHandler{
	private static final String FORM_VIEW = "/view/main/main.html";
	ItemDao dao = new ItemDao();

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if (req.getMethod().equalsIgnoreCase("GET")) {
			System.out.println("서치핸들러 두겟 지나침!");
			setItem(req, res);
			return processForm(req, res);
		} else if (req.getMethod().equalsIgnoreCase("POST")) {
//			return processSubmit(req, res);
		} else {
			res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
		return null;
	}
	
	private void setItem(HttpServletRequest req, HttpServletResponse res) {
		Connection conn = null;
		
		try {
			List<Item> itemList = dao.getAll(conn);
			req.setAttribute("itemList", itemList);
			System.out.println(req.getAttribute("itemList"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private String processForm(HttpServletRequest req, HttpServletResponse res) {
		return FORM_VIEW;
	}

}
