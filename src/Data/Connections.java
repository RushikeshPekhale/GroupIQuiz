package Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connections {
	
		public static Connection getConnection() {
			Connection connection = null;
			try {
				Class.forName("com.mysql.jdbc.Driver");
				String url = "jdbc:mysql://localhost:3306/projectdb?characterEncoding=utf8";

				 connection = DriverManager.getConnection(url, "root", "R123");
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			
			return connection;
		}

	}

