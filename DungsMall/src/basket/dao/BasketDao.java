package basket.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import basket.model.Basket;
import util.dbutil.DBUtil;

public class BasketDao {

	public int insert(Connection conn, Basket basket) throws SQLException {
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(
					"INSERT INTO `dungsmall`.`basket` (`member_id`, `item_name`, `count`) "
					+ "VALUES (?, ?, ?);");
			stmt.setString(1, basket.getId());
			stmt.setString(2, basket.getName());
			stmt.setInt(3, basket.getCount());
			return stmt.executeUpdate();
		} finally {
			DBUtil.close(stmt);
		}
	}
}
