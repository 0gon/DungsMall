package login.member.service;

import java.sql.Connection;
import java.sql.SQLException;

import login.member.dao.MemberDao;
import login.member.model.JoinRequest;
import login.member.model.Member;
import util.dbutil.DBUtil;

public class JoinService {

	private MemberDao memberDao = new MemberDao();

	public void join(JoinRequest joinReq) {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			conn.setAutoCommit(false);
			
			Member member = memberDao.selectById(conn, joinReq.getId());
			if (member != null) {
				DBUtil.rollback(conn);
				throw new DuplicateIdException();
			}
			
			memberDao.insert(conn, 
					new Member(
							joinReq.getId(), 
							joinReq.getPassword(), 
							joinReq.getName(), 
							joinReq.getEmail()
							));
			conn.commit();
		} catch (SQLException e) {
			DBUtil.rollback(conn);
			throw new RuntimeException(e);
		} finally {
			DBUtil.close(conn);
		}
	}
}
