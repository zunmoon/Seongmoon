package jdbc0918;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Test02_insert {

	public static void main(String[] args) {
		// sungjuk 테이블 행 추가 연습
		
		try {
			String url      = "jdbc:oracle:thin:@localhost:1521:xe";
			String user     = "system";
			String password = "1234";
			String driver   = "oracle.jdbc.driver.OracleDriver"; // ojdbc8.jar
			
			Class.forName(driver);
			Connection conn =  DriverManager.getConnection(url, user, password);			
			System.out.println("오라클DB 서버 연결 성공");
			
			// 4) SQL 작성
			// -> 주의사항 SQL 종결문자 ; 를 쓰면 오류남
			StringBuilder sql = new StringBuilder();
			sql.append(" INSERT INTO SUNGJUK(SNO, UNAME, KOR, ENG, MAT, ADDR, WDATE) ");
			sql.append(" VALUES (SUNGJUK_SEQ.NEXTVAL, '코리아', 80, 65, 90, 'Seoul', SYSDATE) ");

			
			// 5) SQL형식으로 변환
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			
			// 6) SQL문 실행
			int cnt = pstmt.executeUpdate(); // INSERT, UPDATE, DELETE문 실행
			
			System.out.println("실행결과 : " + cnt);
			
			// 자원 반납 (순서주의)
			pstmt.close();
			conn.close();
			
			
		} catch (Exception e) {
			System.out.println("오라클 JDBC 실패 : " + e);
		}

	}

}
