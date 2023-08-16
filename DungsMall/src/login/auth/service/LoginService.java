package login.auth.service;

import java.sql.Connection;
import java.sql.SQLException;

import login.auth.model.User;
import login.member.dao.MemberDao;
import login.member.model.Member;
import login.member.service.LoginFailException;
import util.dbutil.DBUtil;

public class LoginService {

	private MemberDao memberDao = new MemberDao();

	public User login(String id, String password) {
		try (Connection conn = DBUtil.getConnection()) {
			Member member = memberDao.selectById(conn, id);
			if (member == null) {
				throw new LoginFailException();
			}
			if (!member.matchPassword(password)) {
				throw new LoginFailException();
			}
			User user = new User(member.getId());
			return user;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}