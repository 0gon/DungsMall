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
			Member member = dao.selectById(conn, "dudrhs");
			System.out.println(member);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}