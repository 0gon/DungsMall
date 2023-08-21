package order.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

import basket.dao.BasketDao;
import util.dbutil.DBUtil;

public class OrderService {
	BasketDao basketDao = new BasketDao();
	Connection conn = null;

	public int insertReceipt(String id, LocalDate date) {
		try {
			conn = DBUtil.getConnection();
			return basketDao.insert(conn, id, date);
		} catch (SQLException e) {
			DBUtil.rollback(conn);
			throw new RuntimeException(e);
		} finally {
			DBUtil.close(conn);
		}
	}

	// 최신 no 체크용임
	public int checkSelect() {
		try {
			conn = DBUtil.getConnection();
			return basketDao.selectNo(conn);
		} catch (SQLException e) {
			DBUtil.rollback(conn);
			throw new RuntimeException(e);
		} finally {
			DBUtil.close(conn);
		}
	}
	
	public int insertReceiptDetail(String itemName, int count, int price) {
		int no = checkSelect();
		try {
			conn = DBUtil.getConnection();
			return basketDao.insertDetail(conn, no, itemName, count, price);
		} catch (SQLException e) {
			DBUtil.rollback(conn);
			throw new RuntimeException(e);
		} finally {
			DBUtil.close(conn);
		}
	}
	
	
	// 주문하기 누르면 실행되는 장바구니에 있던 항목 지우기
	public int deleteBasket(String id, String itemName) {
		try {
			conn = DBUtil.getConnection();
			return basketDao.delete(conn, id, itemName);
		} catch (SQLException e) {
			DBUtil.rollback(conn);
			throw new RuntimeException(e);
		} finally {
			DBUtil.close(conn);
		}
	}
	
}
