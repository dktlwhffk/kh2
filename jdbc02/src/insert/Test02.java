package insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Test02 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("상세정보를 입력하세요");		
		String name = sc.next();
		String type = sc.next();
		int tall = sc.nextInt();
		int grande = sc.nextInt();
		int venti = sc.nextInt();
		sc.close();

		Class.forName("oracle.jdbc.OracleDriver"); // ojdbc6.jar
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe", "sample", "sample");
		
		String sql = "insert into menu_coffee values(?, ?, ?, ?, ?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1,name);
		ps.setString(2, type); 
		ps.setInt(3, tall);
		ps.setInt(4, grande);
		ps.setInt(5, venti);
		
		ps.execute();
		
		con.close();
		System.out.println("처리 완료!");
	}
}
