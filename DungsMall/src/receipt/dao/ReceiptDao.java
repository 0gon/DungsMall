package receipt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import receipt.model.ReceiptDetail;
import receipt.model.ReceiptList;
import util.dbutil.DBUtil;

public class ReceiptDao {
	
	public List<ReceiptList> getList(Connection conn, String id) throws SQLException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<ReceiptList> list = new ArrayList<>();
		try {
			stmt = conn.prepareStatement("SELECT * FROM receiptlist WHERE member_id = ?;");
			stmt.setString(1, id);
			rs = stmt.executeQuery();
			while (rs.next()) {
				int no = rs.getInt("no");
				String memberId = rs.getString("member_id");
				String date = rs.getString("date");
				ReceiptList receipt = new ReceiptList(no, memberId, date);
				System.out.println(no);
				list.add(receipt);
			}
		} finally {
			DBUtil.close(rs);
			DBUtil.close(stmt);
		}
		return list;
	}
	
	public List<ReceiptDetail> getDetail(Connection conn, int id) throws SQLException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<ReceiptDetail> list = new ArrayList<>();
		try {
			stmt = conn.prepareStatement("SELECT * FROM receipt_detail WHERE no = ?;");
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			while (rs.next()) {
				int no = rs.getInt("no");
				String item = rs.getString("item");
				int count = rs.getInt("count");
				int price = rs.getInt("price");
				list.add(new ReceiptDetail(no, item, count, price));
			}
		} finally {
			DBUtil.close(rs);
			DBUtil.close(stmt);
		}
		return list;
	}
	
	public List<String> getFirst(Connection conn, String id) throws SQLException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<String> list = new ArrayList<>();
		try {
			stmt = conn.prepareStatement("SELECT MIN(item) AS first FROM receipt_detail WHERE no \r\n" + 
					"IN (select no from receiptlist WHERE member_id=?) GROUP BY no;");
			stmt.setString(1, id);
			rs = stmt.executeQuery();
			while (rs.next()) {
				String item = rs.getString("first");
				list.add(item);
			}
		} finally {
			DBUtil.close(rs);
			DBUtil.close(stmt);
		}
		return list;
	}
}
