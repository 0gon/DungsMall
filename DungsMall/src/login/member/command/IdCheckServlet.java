package login.member.command;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login.member.dao.MemberDao;
import login.member.model.Member;
import util.dbutil.DBUtil;

@WebServlet("/IdCheckServlet")
public class IdCheckServlet extends HttpServlet {
	MemberDao dao = new MemberDao();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username"); // Get the username from the request parameter

		// Simulate database check, replace with actual logic
		boolean isUsernameTaken = checkIfUsernameExists(username);

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");

		// Create JSON response
		String jsonResponse = "{\"isTaken\":" + isUsernameTaken + "}";
		response.getWriter().write(jsonResponse);
	}

	private boolean checkIfUsernameExists(String username) {
		try (Connection conn = DBUtil.getConnection();) {
			Member member = dao.selectById(conn, username);
			if (member == null) {
				return false;
			} else
				return true;
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}
}
