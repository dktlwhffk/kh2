package select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Test08 {
	public static void main(String[] args) throws Exception{
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
		
		String sql = "select J.job_title 직업, avg(E.salary) 연봉평균 "
				+ "from employees E inner join jobs J on E.job_id=J.job_id "
				+ "group by j.job_title, J.job_title order by 직업";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		int count = 0;
		while (rs.next()) {
//			String name = rs.getString("이름");
//			System.out.println("이름: " + name);

			String job = rs.getString("직업");
			System.out.println("직업: " + job);

			int salary = rs.getInt("연봉평균");
			System.out.println("연봉평균: " + salary);
			
			System.out.println();
			count++;
		}	
		System.out.println("총 개수: "+count);
		con.close();
	}
}
