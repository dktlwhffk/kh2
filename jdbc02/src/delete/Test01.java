package delete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Test01 {
	public static void main(String[] args) throws Exception{
//		목표: 번호를 이용하여 kh_member의 데이터를 삭제하는 것
//		-일반적으로 삭제는 PK(기본키)에 의해 이루어진다
//		-수정과 동인한 코드 방식을 사용 (결과 행 개수를 알아야 함)
		
		int no = 1;
		
//		DB 처리
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe","sample","sample");
		
		String sql = "delete kh_member where no = ?";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, no);
		
//		ps.execute(sql); 실행은 되지만 결과 알 수 없음
		int count = ps.executeUpdate();
		System.out.println(count+" 개 행이 삭제되었습니다");
		
		con.close();
	}
}
