package util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	
	private static Connection con;
	
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/pesquisa_eleicao";
			con = DriverManager.getConnection(url, "root", "");
			con.setAutoCommit(true);
			return con;
		} catch ( ClassNotFoundException e) {
			e.printStackTrace();
		} catch ( SQLException se) {
			se.printStackTrace();
		}
		return null;
	}
	
	public static void closeConnection() {
		try {
			con.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
}
