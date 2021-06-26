package DBconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnectivity {

	private DatabaseConnectivity() {

	}
	static DatabaseConnectivity databaseConnectivity = null;
	Connection con = null;
	Statement state = null;

	public void openConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/imageupload", "root",
				"Admin@123");
		state = con.createStatement();
	}
	public void closeConnection() throws SQLException {
		con.close();
	}
	public void excuteData(String sql) throws SQLException {
		state.executeUpdate(sql);
	}
	public ResultSet fatchData(String sql) throws SQLException {
		return state.executeQuery(sql);
	}
	public static DatabaseConnectivity getInstance() {
		 if(databaseConnectivity == null)
			 databaseConnectivity = new DatabaseConnectivity();
		 return databaseConnectivity;
	}
}
