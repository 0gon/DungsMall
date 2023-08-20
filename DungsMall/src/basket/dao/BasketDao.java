package basket.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import basket.model.BasketSub;
import item.model.Item;
import util.dbutil.DBUtil;

public class BasketDao {
	public List<BasketSub> select(Connection conn, String id) throws SQLException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<BasketSub> list = new ArrayList<>();
		try {
			stmt = conn.prepareStatement("SELECT basket.member_id, basket.item_name, basket.count, item.price\r\n" + 
					"FROM basket\r\n" + 
					"JOIN item ON basket.item_name = item.name\r\n" + 
					"WHERE basket.member_id = '"+id+"'");
			rs = stmt.executeQuery();
			while (rs.next()) {
				String memberId = rs.getString("Member_id");
				String itemName = rs.getString("item_Name");
				int count = rs.getInt("basket.count");
				int price = rs.getInt("item.price");
				list.add(new BasketSub(memberId,itemName,count,price));
				System.out.println(list);
			}
		} finally {
			DBUtil.close(rs);
			DBUtil.close(stmt);
		}
		return list;
	}

	
	// 추후 예정
//	public List<Basket> update(Connection conn) throws SQLException {
//		PreparedStatement stmt = null;
//		ResultSet rs = null;
//		List<Basket> list = new ArrayList<>();
//		try {
//
//			stmt = conn.prepareStatement("UPDATE BASKET SET FROM basket ");
//			rs = stmt.executeQuery();
//			while (rs.next()) {
//				String id = rs.getString("member_id");
//				String item = rs.getString("item_item");
//				int count = rs.getInt("count");
//				list.add(new Basket(id, item, count));
//				System.out.println(list);
//			}
//		} finally {
//			DBUtil.close(rs);
//			DBUtil.close(stmt);
//		}
//		return list;
//	}
//
//	public int delete(Connection conn, String member, String item) throws SQLException {
//		PreparedStatement stmt = null;
//		try {
//			stmt = conn.prepareStatement("DELETE FROM basket " + "WHERE member_id ='" + member
//					+ "' and item_name ='" + item + "'");
//			return stmt.executeUpdate(); 
//		} finally {
//			DBUtil.close(stmt);
//			return 1;
//		}
//	}
}
