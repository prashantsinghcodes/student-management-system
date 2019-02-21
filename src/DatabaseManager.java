import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {
	private Connection connection;
	private Statement stmt;
	
	DatabaseManager() {
	this.connection = null;
		this.stmt = null;
	}
	
	public void setConnection() {
		try {
			this.connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/Employee", "root", "root");
			this.stmt = connection.createStatement();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		return this.connection;
	}

	
	public Statement getStmt() {
		return this.stmt;
	}
	
}
