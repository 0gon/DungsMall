package cart.service;

import java.lang.reflect.Member;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import basket.dao.BasketDao;
import basket.model.BasketSub;
import util.dbutil.DBUtil;

public class CartService {
	BasketDao basketDao = new BasketDao();
	
	public List<BasketSub> itemCall(String id) {
		Connection conn = null;
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
}
