package search.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import item.dao.ItemDao;
import item.model.Item;
import util.dbutil.DBUtil;

public class SearchService {
	ItemDao dao = new ItemDao();
	
	public void search(String text) {
		List<Item> list = new ArrayList<>();
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			dao.selectLikeName(conn, text);
		} catch (SQLException e) {
			throw new RuntimeException();
		} finally {
			DBUtil.close(conn);
		}
	}
}
