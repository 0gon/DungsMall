package login.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import login.member.model.Member;
import util.dbutil.DBUtil;

public class MemberDao {

	public Member selectById(Connection conn, String id) throws SQLException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement(
					"select * from member where id = ?");
			stmt.setString(1, id);
			rs = stmt.executeQuery();
			Member member = null;
			if (rs.next()) {
				member = new Member(rs.getString("id"),
									rs.getString("password"), 
									rs.getString("name"), 
									rs.getString("email"));
			}
			return member;
		} finally {
			DBUtil.close(rs);
			DBUtil.close(stmt);
		}
	}
	
	public int insert(Connection conn, Member member) throws SQLException {
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(
					"INSERT INTO `dungsmall`.`member` (`id`, `password`, `name`, `email`) "
					+ "VALUES (?, ?, ?, ?);");
			stmt.setString(1, member.getId());
			stmt.setString(2, member.getPassword());
			stmt.setString(3, member.getName());
			stmt.setString(4, member.getEmail());
			return stmt.executeUpdate();
		} finally {
			DBUtil.close(stmt);
		}
	}

	public int updateSessionId(Connection conn, String sessionId, String id) throws SQLException {
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(
					"UPDATE `dungsmall`.`member` SET `sessionid` = ? WHERE (`id` = ?);");
			stmt.setString(1, sessionId);
			stmt.setString(2, id);
			return stmt.executeUpdate();
		} finally {
			DBUtil.close(stmt);
		}
	}
}
