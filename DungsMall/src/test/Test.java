package test;

import java.sql.Connection;
import java.sql.SQLException;

import login.member.dao.MemberDao;
import login.member.model.Member;
import util.dbutil.DBUtil;

public class Test{
	public static void main(String[] args) {
		MemberDao dao = new MemberDao();
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			Member member = new Member("dudrhs", "dudrhs", "영곤", "dudrhs@naver.com");
			dao.insert(conn, member);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}