package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConnection {
	
	public static Connection getConnection() {
		
		try {
			
			// ojdbc jar���Ͽ��� ����Ŭ����̹� Ŭ������ �ҷ��´�.
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// �ҷ��� Ŭ������ �̿��Ͽ� DB�� �����ϰ� ��ü�� �����Ѵ�. c##madang���� �ٲܰ�
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "cos", "bitc5600");
			
			// ��ü�� �����Ѵ�.
			return conn;
			
		} catch (Exception e) {
			
			System.out.println("DB ���� ���� : " + e.getMessage());
			
		}
		
		return null;
		
	}
	
	public static void close(Connection conn, PreparedStatement pstmt) {
		try {
			if (conn != null) {
				conn.close();				
			}
			if (pstmt != null) {		
				pstmt.close();
			}
		} catch (Exception e) {
			System.out.println("DB����� ������ �߻� : " +e.getMessage());
		}
	}
	
	
	public static void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		try {
			if (conn != null) {
				conn.close();				
			}
			if (pstmt != null) {		
				pstmt.close();
			}
			if (rs != null) {		
				rs.close();
			}
			
		} catch (Exception e) {
			System.out.println("DB����� ������ �߻� : " +e.getMessage());
		}
	}
	
}
