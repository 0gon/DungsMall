package detail.service;

import java.sql.Connection;
import java.sql.SQLException;

import item.dao.ItemDao;
import item.model.Item;
import util.dbutil.DBUtil;

public class DetailService {
	ItemDao dao = new ItemDao();
	
	public Item initPage(String text) {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			return dao.getByName(conn, text);
		} catch (SQLException e) {
			throw new RuntimeException();
		} finally {
			DBUtil.close(conn);
		}
	}
}
