package item.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import item.model.Item;
import util.dbutil.DBUtil;

public class ItemDao {
	
	public List<Item> getAll(Connection conn) throws SQLException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Item> list = new ArrayList<>();
		try {
			stmt = conn.prepareStatement("SELECT * FROM dungsmall.item;");
			rs = stmt.executeQuery();
			while (rs.next()) {
				String name = rs.getString("name");
				int price = rs.getInt("price");
				Item item = new Item(name, price);
				list.add(item);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs);
			DBUtil.close(stmt);
		}
		return list;
	}
	
	public List<Item> get(Connection conn) throws SQLException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Item> list = new ArrayList<>();
		try {
			stmt = conn.prepareStatement("SELECT * FROM dungsmall.item;");
			rs = stmt.executeQuery();
			while (rs.next()) {
				String name = rs.getString("name");
				int price = rs.getInt("price");
				Item item = new Item(name, price);
				list.add(item);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs);
			DBUtil.close(stmt);
		}
		return list;
	}
	
	public Item getByName(Connection conn, String name) throws SQLException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement("SELECT * FROM dungsmall.item WHERE name = ?;");
			rs = stmt.executeQuery();
			stmt.setString(1, name);
			if (rs.next()) {
				int price = rs.getInt("price");
				Item item = new Item(name, price);
				return item;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs);
			DBUtil.close(stmt);
		}
		return null;
	}
}
