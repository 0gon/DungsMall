package test;

import java.sql.Connection;
import java.sql.SQLException;

import item.dao.ItemDao;
import item.model.Item;
import util.dbutil.DBUtil;

public class Test {
	public static void main(String[] args) {
		ItemDao dao = new ItemDao();
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			Item item = dao.selectLikeName(conn, "감");
			System.out.println(item);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
