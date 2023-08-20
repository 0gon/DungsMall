package detail.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import basket.dao.BasketDao;
import basket.model.Basket;
import item.dao.ItemDao;
import item.model.Item;
import util.dbutil.DBUtil;

public class DetailService {
	ItemDao dao = new ItemDao();
	BasketDao bDao = new BasketDao();
	
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
	
	public int plusBasket(String id, String name, int count) {
		Connection conn = null;
		Basket basket = new Basket(id, name, count);
		try {
			conn = DBUtil.getConnection();
			if (bDao.getOne(conn, basket) == 0) {
				return bDao.insert(conn, basket);
			} else {
				return bDao.update(conn, basket);
			}
		} catch (SQLException e) {
			throw new RuntimeException();
		} finally {
			DBUtil.close(conn);
		}
	}
	
}
