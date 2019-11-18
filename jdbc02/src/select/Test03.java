package select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Test03 {
	public static void main(String[] args) throws Exception {
//		목표: 검색
		String keyword = "허니버터칩";
		
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "sample", "sample");

		String sql = "select * from snack where name = ?";

		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, keyword);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			int no = rs.getInt("no");
			System.out.println("no: " + no);

			String name = rs.getString("name");
			System.out.println("name: " + name);
			
			System.out.println();
		}
		con.close();
	}
}
