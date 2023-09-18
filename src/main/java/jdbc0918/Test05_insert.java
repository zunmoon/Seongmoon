package jdbc0918;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Test05_insert {

	public static void main(String[] args) {
		// 문제) sno = 41 행의 데이터를 아래의 내용으로 수정하시오
		
		int sno = 41;
		String uname = "JSPark";
		int kor = 90, eng = 85, mat = 100;
		int tot = kor + eng + mat;
		int aver = tot / 3;
		String addr = "Suwon";
		
		try {
			String url      = "jdbc:oracle:thin:@localhost:1521:xe";
			String user     = "system";
			String password = "1234";
			String driver   = "oracle.jdbc.driver.OracleDriver"; // ojdbc8.jar
			
			Class.forName(driver);
			Connection conn =  DriverManager.getConnection(url, user, password);			
			System.out.println("오라클DB 서버 연결 성공");
			
			StringBuilder sql = new StringBuilder();
			sql.append(" UPDATE SUNGJUK ");
			sql.append(" SET UNAME = ?, KOR = ?, ENG = ?, MAT = ?, TOT = ?, AVER = ?, ADDR = ? ");
			sql.append(" WHERE SNO = ? ");
			// -> ? 특정값으로 대입할 수 있는 표식
			
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			// -> ? 개수, 순서, 자료형이 일치해야 한다
			pstmt.setString(1, uname); // 1 -> 첫번째 물음표, uname 컬럼
			pstmt.setInt(2, kor);     // 2 -> 두번째 물음표, kor컬럼
			pstmt.setInt(3, eng);     // 3 -> 세번째 물음표, eng컬럼
			pstmt.setInt(4, mat);     // 4 -> 네번째 물음표, mat컬럼
			pstmt.setInt(5, tot);
			pstmt.setInt(6, aver);
			pstmt.setString(7, addr); // 5 -> 다섯번째 물음표, addr컬럼
			pstmt.setInt(8, sno);
			
			int cnt = pstmt.executeUpdate();
			if(cnt == 0)
				System.out.println("행 수정 실패");
			else
				System.out.println("행 수정 성공");
			
		} catch (Exception e) {
			System.out.println("오라클 JDBC 실패 : " + e);
		}

	}

}
