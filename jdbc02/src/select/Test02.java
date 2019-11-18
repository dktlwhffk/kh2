package select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Test02 {
	public static void main(String[] args) throws Exception {
//		kh member의 모든 데이터 정보를 화면에 출력

		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "sample", "sample");

		String sql = "select * from kh_member order by no";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			int no = rs.getInt("no");
			System.out.println("no: " + no);

			String name = rs.getString("name");
			System.out.println("name: " + name);

			String id = rs.getString("id");
			System.out.println("id: " + id);

			String pw = rs.getString("pw");
			System.out.println("pw: " + pw);

			int point = rs.getInt("point");
			System.out.println("point: " + point);

			String date = rs.getString("joindate");
			System.out.println("joindate: " + date);
			
			System.out.println();
			
		}
		con.close();
		System.out.println("실행완료");
	}
}
