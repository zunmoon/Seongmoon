package jdbc0918;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Test07_selectCount {

	public static void main(String[] args) {
		// sungjuk 테이블의 전체 행의 개수를 출력하시오
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		try {
			String url      = "jdbc:oracle:thin:@localhost:1521:xe";
			String user     = "system";
			String password = "1234";
			String driver   = "oracle.jdbc.driver.OracleDriver"; // ojdbc8.jar
			
			Class.forName(driver);
			 conn =  DriverManager.getConnection(url, user, password);			
			System.out.println("오라클DB 서버 연결 성공");
			
			StringBuilder sql = new StringBuilder();
			sql.append(" SELECT COUNT(*) AS CNT FROM SUNGJUK ");
			
			pstmt = conn.prepareStatement(sql.toString());
			
			rs = pstmt.executeQuery(); // select문 실행
			
			// cursor : 행을 가리키는 값. 이동할 수 있다
			if(rs.next())  // cursor가 있는지?
				System.out.println("자료 있음");
			else
				System.out.println("자료 없음");
		
						
		} catch (Exception e) {
			System.out.println("오라클 JDBC 실패 : " + e);
		} finally { // 자원반납 (순서주의)
			try {
				if(rs!=null)
					rs.close();
			} catch (Exception e) {}
			try {
				if(pstmt!=null)
					pstmt.close();
			} catch (Exception e) {}
			try {
				if(conn!=null)
					conn.close();
			} catch (Exception e) {}
		}

	}

}
