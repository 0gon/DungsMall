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
	
	public List<Item> search(String text) {
		List<Item> list = null;
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			list = dao.selectLikeName(conn, text);
		} catch (SQLException e) {
			throw new RuntimeException();
		} finally {
			DBUtil.close(conn);
		}
		return list;
	}
}
