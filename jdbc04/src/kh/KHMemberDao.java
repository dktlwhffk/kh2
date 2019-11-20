package kh;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class KHMemberDao {
//메소드 이름:regist
//준비물: kh_member
//결과물: X
//	사용자에게 아이디, 비밀번호, 이름을 입력받아 등록하는 프로그램
	public Connection getConnection() throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "sample", "sample");
		return con;
	}

	public void regist(String name, String id, String pw) throws Exception {
		Connection con = this.getConnection();
		String sql = "insert into kh_member values(kh_member_seq.nextval,?,?,?,0,sysdate)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, name);
		ps.setString(2, id);
		ps.setString(3, pw);
		ps.execute();

		con.close();

	}
	
//	메소드이름:getlist
//	준비물: X
//	결과물: List<KHMemberDto>
	public List<KHMemberDto> getlist() throws Exception{
		Connection con = this.getConnection();
		String sql = "select*from kh_member order by no asc";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		List<KHMemberDto> list = new ArrayList<>();
		
		while(rs.next()) {
			KHMemberDto dto = new KHMemberDto();
			int no = rs.getInt("no");
			dto.setNo(no);
			String name = rs.getString("name");
			dto.setName(name);
			String id = rs.getString("id");
			dto.setId(id);
			String pw = rs.getString("pw");
			dto.setPw(pw);
			int point = rs.getInt("point");
			dto.setPoint(point);
			String joindate = rs.getString("joindate");
			dto.setJoindate(joindate);
			
			list.add(dto);

		}
		con.close();
		return list;	
	}
	
//	메소드 이름: search
//	준비물: String keyword
//	결과물: List<KHMemberDto> 
	public List<KHMemberDto> search(String keyword) throws Exception{
		
		Connection con = this.getConnection();
		String sql = "select * from kh_member where name like '%'||?||'%'";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, keyword);
		ResultSet rs = ps.executeQuery();
		
		List<KHMemberDto> search = new ArrayList<>();
		while(rs.next()) {
			KHMemberDto dto = new KHMemberDto();
			int no = rs.getInt("no");
			dto.setNo(no);
			String name = rs.getString("name");
			dto.setName(name);
			String id = rs.getString("id");
			dto.setId(id);
			String pw = rs.getString("pw");
			dto.setPw(pw);
			int point = rs.getInt("point");
			dto.setPoint(point);
			String joindate = rs.getString("joindate");
			dto.setJoindate(joindate);
			
			search.add(dto);
		}
		con.close();
		return search;
	}
//	메소드 이름: login
//	매개변수: String id
//	결과물: List<KHMemberDto>
//	public List<KHMemberDto> login(String id, String pw) throws Exception {

//		Connection con = this.getConnection();
//		String sql = "select id, pw from kh_member where id = ? and pw = ?";
//		PreparedStatement ps = con.prepareStatement(sql);
//		ps.setString(1, id);
//		ps.setString(2, pw);
//		ResultSet rs = ps.executeQuery();
//		
//		List<KHMemberDto> login = new ArrayList<>();
//		while(rs.next()) {
//			KHMemberDto dto = new KHMemberDto();
//			String id1 = rs.getString("id");
//			dto.setId(id1);
//			String pw1 = rs.getString("pw");
//			dto.setPw(pw1);
//			
//			login.add(dto);
//		}
//		con.close();
//		return login;
//	}

	public boolean login(KHMemberDto dto) throws Exception{
		Connection con = getConnection();

		String sql = "select * from kh_member where id = ? and pw = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, dto.getId());
		ps.setString(2, dto.getPw());
		ResultSet rs = ps.executeQuery();

		boolean result = rs.next();

		con.close();

		return result;

	}

}
