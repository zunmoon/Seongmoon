package jdbc0918;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Test04_delete {

	public static void main(String[] args) {
		// sungjuk 테이블 행 삭제 연습
		
		try {
			String url      = "jdbc:oracle:thin:@localhost:1521:xe";
			String user     = "system";
			String password = "1234";
			String driver   = "oracle.jdbc.driver.OracleDriver"; // ojdbc8.jar
			
			Class.forName(driver);
			Connection conn =  DriverManager.getConnection(url, user, password);			
			System.out.println("오라클DB 서버 연결 성공");
			
			StringBuilder sql = new StringBuilder();
			sql.append("DELETE FROM SUNGJUK WHERE SNO = 1");
			
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			
			int cnt = pstmt.executeUpdate();
			
			if (cnt == 0)
				System.out.println("행 삭제 실패 : " + cnt);
			else
				System.out.println("행 삭제 성공 : " + cnt);
			
			pstmt.close();
			conn.close();
						
		} catch (Exception e) {
			System.out.println("오라클 JDBC 실패 : " + e);
		}

	}

}
