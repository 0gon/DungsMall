package receipt.command;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import item.dao.ItemDao;
import item.model.Item;
import login.member.dao.MemberDao;
import mvc.command.CommandHandler;
import receipt.dao.ReceiptDao;
import receipt.model.ReceiptDetail;
import receipt.model.ReceiptList;
import util.dbutil.DBUtil;

public class ReceiptHandler implements CommandHandler {
	private static final String FORM_VIEW = "/view/purchase/receipt/receiptList.jsp";
	ReceiptDao dao = new ReceiptDao();
	MemberDao mDao = new MemberDao();
	ItemDao iDao = new ItemDao();

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
		if (req.getAttribute("login") != null) {
			setItem(req, res);
			return FORM_VIEW;
		} else {
			try {
				res.sendRedirect("/DungsMall/login.do");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
	}

	private String processSubmit(HttpServletRequest req, HttpServletResponse res) throws IOException {
		return FORM_VIEW;
	}

	private void setItem(HttpServletRequest req, HttpServletResponse res) {
		List<ReceiptList> list = new ArrayList<>();
		List<ReceiptDetail> foods = null;
		try (Connection conn = DBUtil.getConnection()) {
			String id = mDao.selectIdBySessionId(conn, (String) req.getAttribute("sessionId"));
			list = dao.getList(conn, id);
			for (int i = 0; i < list.size(); i++) {
				foods = new ArrayList<>();
				ReceiptList receipt = list.get(i);
				foods = dao.getDetail(conn, receipt.getNo());
				setItemDetails(conn, foods);
				receipt.setDetail(foods);
			}
		} catch (SQLException e) {
			throw new RuntimeException();
		}
		req.setAttribute("total", getTotal(list));
		req.setAttribute("list", list);
	}

	private List<Integer> getTotal(List<ReceiptList> receipt) {
		List<Integer> totals = new ArrayList<>();
		for (ReceiptList list : receipt) {
			int total = 0;
			for (ReceiptDetail detail : list.getDetail()) {
				total += detail.getPrice();
			}
			totals.add(total);
		}
		return totals;
	}

	private void setItemDetails(Connection conn, List<ReceiptDetail> details) throws SQLException {
		for (int i = 0; i < details.size(); i++) {
			ReceiptDetail detail = details.get(i);
			detail.setItemDetail(iDao.getByName(conn, detail.getItem()));
		}
	}
}