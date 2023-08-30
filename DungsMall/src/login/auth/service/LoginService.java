package login.auth.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import login.auth.model.User;
import login.member.dao.MemberDao;
import login.member.model.Member;
import login.member.service.LoginFailException;
import util.dbutil.DBUtil;

public class LoginService {

	private MemberDao memberDao = new MemberDao();

	public void login(HttpServletRequest req, String id, String password) {
		try (Connection conn = DBUtil.getConnection();) {
			User user = getUser(conn, id, password);
			updateSessionId(conn, req, user);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	public User getUser(Connection conn, String id, String password) throws SQLException {
		Member member = memberDao.selectById(conn, id);
		if (member == null) {
			throw new LoginFailException();
		}
		if (!member.matchPassword(password)) {
			throw new LoginFailException();
		}
		User user = new User(member.getId());
		return user;
	}

	public void updateSessionId(Connection conn, HttpServletRequest req, User user) throws SQLException {
		String sessionId = req.getRequestedSessionId();
		String id = user.getId();
		memberDao.updateSessionId(conn, sessionId, id);
	}

	public void deleteSessionId(String cookieValue) {
		try (Connection conn = DBUtil.getConnection();) {
			memberDao.deletBySessionId(conn, cookieValue);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
}
