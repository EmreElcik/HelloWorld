package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionUtils {
	
	
	
	private ConnectionUtils() {
		// Bu class artýk new lenemez ve memory de yer tutamaz static olduðu için direk çaðrýlýr.
	}

	public static Connection getConnection() {
		
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@//opusprep-scan.allianz-tr.local:1521/OPUSPREP", "eelcik", "eelcik2013");
			return con;

			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Hata aldým ConnectionUtils - getConnection");
		}
		
		return null;
		
	}

	public static void closeConnection(Connection c) {
		try {
			if (c!= null) {
				c.close();
			}		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void closeStatement(Statement s) {
		try {
			if (s!= null) {
				s.close();
			}			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void closeResultSet(ResultSet rs) {
		try {
			if (rs!= null) {
				rs.close();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void closeAll(Connection c, Statement s, ResultSet rs) {
		closeConnection(c);
		closeStatement(s);
		closeResultSet(rs);
	}	
	
}
