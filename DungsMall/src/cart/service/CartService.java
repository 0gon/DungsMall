package cart.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


import basket.dao.BasketDao;
import basket.model.BasketSub;
import util.dbutil.DBUtil;

public class CartService {
	BasketDao basketDao = new BasketDao();
	Connection conn = null;
	
	public List<BasketSub> itemCall(String id) {
		try {
			conn = DBUtil.getConnection();
			return basketDao.select(conn, id);
		} catch(SQLException e) {
			DBUtil.rollback(conn);
			throw new RuntimeException(e);
		} finally {
			DBUtil.close(conn);
		}
	}
	
	public int deleteBasket(String id, String itemName) {
		System.out.println(id+"의 장바구니에 있는"+itemName+"[삭제]");
		try {
			conn = DBUtil.getConnection();
			return basketDao.delete(conn, id, itemName);
		} catch(SQLException e) {
			DBUtil.rollback(conn);
			throw new RuntimeException(e);
		} finally {
			DBUtil.close(conn);
		}
	}
}