package basket.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;

import basket.model.Basket;
import util.dbutil.DBUtil;


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

	
	// 장바구니에서 주문한 녀석들 인설트
	public int insert(Connection conn, String member, LocalDate date) throws SQLException {
		PreparedStatement stmt = null;
		try {

			stmt = conn.prepareStatement("INSERT INTO receiptlist (member_ID, date) VALUES\r\n" + 
					"('"+ member +"',"+"'"+ date +"');");
			return stmt.executeUpdate();

		} finally {
			DBUtil.close(stmt);
		}
	}
	
	// 위에서 넣은 영수증 번호 확인
	public int selectNo(Connection conn) throws SQLException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement("SELECT * FROM receiptlist ORDER BY no DESC LIMIT 1;");
			rs = stmt.executeQuery();
			if(rs.next()) {
			int no = rs.getInt("no");
			return no;
			}

		} finally {
			DBUtil.close(stmt);
		}
		return 0;
	}
	
	// receiptdetail 인설트
	public int insertDetail(Connection conn, int no, String itemName, int count, int price ) throws SQLException {
		PreparedStatement stmt = null;
		try {

			stmt = conn.prepareStatement("INSERT INTO receipt_detail values("+no+",'"+itemName+"',"+count+","+price+");" );
			return stmt.executeUpdate();

		} finally {
			DBUtil.close(stmt);
		}
	}	
	
	
	// 장바구니 항목 지우기
	public int delete(Connection conn, String member, String item) throws SQLException {
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement("DELETE FROM basket " + "WHERE member_id ='" + member
					+ "' and item_name ='" + item + "'");
			
			
			return stmt.executeUpdate(); 
		} finally {
			DBUtil.close(stmt);
		}
	}
	
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
	
	public int getOne(Connection conn, Basket basket) throws SQLException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement(
					"SELECT COUNT(*) FROM `dungsmall`.`basket` "
					+ "WHERE `member_id` = ? AND `item_name` = ?;");
			stmt.setString(1, basket.getId());
			stmt.setString(2, basket.getName());
			rs = stmt.executeQuery();
			if (rs.next()) {
				return rs.getInt("COUNT(*)");
			}
			return -1;
		} finally {
			DBUtil.close(stmt);
		}
	}
	
	public int update(Connection conn, Basket basket) throws SQLException {
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(
					"UPDATE `dungsmall`.`basket` SET `count` = count + ? "
					+ "WHERE `member_id` = ? AND `item_name` = ?;");
			stmt.setInt(1, basket.getCount());
			stmt.setString(2, basket.getId());
			stmt.setString(3, basket.getName());
			return stmt.executeUpdate();
		} finally {
			DBUtil.close(stmt);
		}
	}
	
}
