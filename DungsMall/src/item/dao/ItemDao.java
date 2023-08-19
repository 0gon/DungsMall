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
				String descript = rs.getString("descript");
				int price = rs.getInt("price");
				String img = rs.getString("img");
				String origin = rs.getString("origin");
				int weight = rs.getInt("weight");
				String unit = rs.getString("unit");
				Item item = new Item(name, descript, price, img, origin, weight, unit);
				list.add(item);
			}
		} finally {
			DBUtil.close(rs);
			DBUtil.close(stmt);
		}
		return list;
	}
	
	public Item getByName(Connection conn, String id) throws SQLException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement("SELECT * FROM dungsmall.item WHERE name = ?;");
			stmt.setString(1, id);
			rs = stmt.executeQuery();
			if (rs.next()) {
				String name = rs.getString("name");
				String descript = rs.getString("descript");
				int price = rs.getInt("price");
				String img = rs.getString("img");
				String origin = rs.getString("origin");
				int weight = rs.getInt("weight");
				String unit = rs.getString("unit");
				Item item = new Item(name, descript, price, img, origin, weight, unit);
				return item;
			}
		} finally {
			DBUtil.close(rs);
			DBUtil.close(stmt);
		}
		return null;
	}
	
	public List<Item> selectLikeName(Connection conn, String text) throws SQLException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Item> list = new ArrayList<Item>();
		try {
			stmt = conn.prepareStatement("SELECT * FROM dungsmall.item where name like ?;");
			stmt.setString(1, "%"+text+"%");
			rs = stmt.executeQuery();
			while (rs.next()) {
				String name = rs.getString("name");
				String descript = rs.getString("descript");
				int price = rs.getInt("price");
				String img = rs.getString("img");
				String origin = rs.getString("origin");
				int weight = rs.getInt("weight");
				String unit = rs.getString("unit");
				Item item = new Item(name, descript, price, img, origin, weight, unit);
				list.add(item);
			}
		} finally {
			DBUtil.close(rs);
			DBUtil.close(stmt);
		}
		return list;
	}
}
