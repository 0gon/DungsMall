package receipt.command;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import item.model.Item;
import login.member.dao.MemberDao;
import mvc.command.CommandHandler;
import receipt.dao.ReceiptDao;
import receipt.model.ReceiptList;
import util.dbutil.DBUtil;

public class ReceiptHandler implements CommandHandler {
	private static final String FORM_VIEW = "/view/purchase/receipt/receiptList.jsp";
	ReceiptDao dao = new ReceiptDao();
	MemberDao mDao = new MemberDao();

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if (req.getMethod().equalsIgnoreCase("GET")) {
			System.out.println("영수증핸들러 두겟 지나침!");
			return processForm(req, res);
		} else if (req.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(req, res);
		} else {
			res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}

	private String processForm(HttpServletRequest req, HttpServletResponse res) {
		//setItem(req, res);
		return FORM_VIEW;
	}
	
	private String processSubmit(HttpServletRequest req, HttpServletResponse res) throws IOException {
		return FORM_VIEW;
	}
	
	private void setItem(HttpServletRequest req, HttpServletResponse res) {
		List<ReceiptList> list = null;
		List<String> foods = null;
		try (Connection conn = DBUtil.getConnection()) {
			String id = mDao.selectIdBySessionId(conn, (String)req.getAttribute("sessionId"));
			list = dao.getAll(conn, id);
			foods = dao.getFirst(conn, id);
		} catch (SQLException e) {
			throw new RuntimeException();
		}
		req.setAttribute("list", list);
		req.setAttribute("foods", foods);
	}
}