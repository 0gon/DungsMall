package util.dbutil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

public class DBUtil {
	private static DataSource ds;

	public static void main(String[] args) {
		try {
			Properties prop = new Properties();
			ClassLoader classLoader = DBUtil.class.getClassLoader();
			prop.load(classLoader.getResourceAsStream("dungsmall.properties"));

			BasicDataSource basic = new BasicDataSource();
			basic.setUrl(prop.getProperty("jdbcURL"));
			basic.setDriverClassName(prop.getProperty("jdbcDriverName"));
			basic.setUsername(prop.getProperty("jdbcUserName"));
			basic.setPassword(prop.getProperty("jdbcPassword"));
			System.out.println(prop.getProperty("jdbcURL"));

			ds = basic;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	static {
		try {
			Properties prop = new Properties();
			ClassLoader classLoader = DBUtil.class.getClassLoader();
			prop.load(classLoader.getResourceAsStream("dungsmall.properties"));

			BasicDataSource basic = new BasicDataSource();
			basic.setUrl(prop.getProperty("jdbcURL"));
			basic.setDriverClassName(prop.getProperty("jdbcDriverName"));
			basic.setUsername(prop.getProperty("jdbcUserName"));
			basic.setPassword(prop.getProperty("jdbcPassword"));

			ds = basic;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void forTest() {
		try {
			Properties prop = new Properties();
			ClassLoader classLoader = DBUtil.class.getClassLoader();
			prop.load(classLoader.getResourceAsStream("foodchattest.properties"));

			BasicDataSource basic = new BasicDataSource();
			basic.setUrl(prop.getProperty("jdbcURL"));
			basic.setDriverClassName(prop.getProperty("jdbcDriverName"));
			basic.setUsername(prop.getProperty("jdbcUserName"));
			basic.setPassword(prop.getProperty("jdbcPassword"));

			ds = basic;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws SQLException {
		return ds.getConnection();
	}

	public static void close(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void close(Statement stmt) {
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void close(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void rollback(Connection conn) {
		if (conn != null) {
			try {
				conn.rollback();
			} catch (SQLException ex) {
			}
		}
	}
}
