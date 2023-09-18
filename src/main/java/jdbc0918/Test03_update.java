package jdbc0918;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Test03_update {

	public static void main(String[] args) {
		// sungjuk 테이블 행 수정 연습
		
		try {
			String url      = "jdbc:oracle:thin:@localhost:1521:xe";
			String user     = "system";
			String password = "1234";
			String driver   = "oracle.jdbc.driver.OracleDriver"; // ojdbc8.jar
			
			Class.forName(driver);
			Connection conn =  DriverManager.getConnection(url, user, password);			
			System.out.println("오라클DB 서버 연결 성공");
			
			StringBuilder sql = new StringBuilder();
			sql.append(" UPDATE SUNGJUK");
			sql.append("    SET TOT  = KOR + ENG + MAT");
			sql.append("      , AVER = (KOR + ENG + MAT) / 3");
			sql.append("  WHERE SNO = 21");
			
			// 5) SQL형식으로 변환
			PreparedStatement pstmt =  conn.prepareStatement(sql.toString());
			
			// 6) SQL문 실행
			int cnt = pstmt.executeUpdate(); // INSERT, UPDATE, DELETE문 실행
			if(cnt == 0)
				System.out.println("행 수정 실패");
			else 
				System.out.println("행 수정 성공");
			
			// 지원 반납
			pstmt.close();
		    conn.close();
			
			
		} catch (Exception e) {
			System.out.println("오라클 JDBC 실패 : " + e);
		}

	}

}
