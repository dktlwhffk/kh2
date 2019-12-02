package home.beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MemberDao {

	public Connection getConnection() throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");
		return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "home", "home");
	}

//	로그인 기능
	public boolean login(String id, String pw) throws Exception {
		Connection con = getConnection();

		String sql = "select*from member where id = ? and pw = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, id);
		ps.setString(2, pw);
		ResultSet rs = ps.executeQuery();

		boolean result = rs.next(); // 행 개수 파악 구문 0이면 로그인실패 1이면 로그인 성공

		con.close();

		return result;

	}

//	가입 기능
	public void regist(MemberDto dto) throws Exception {
		Connection con = getConnection();

		String sql = "insert into member values(?,?,?,sysdate,'일반회원',0,?,?,?,?,null)";

		PreparedStatement ps = con.prepareStatement(sql);

		ps.setString(1, dto.getId());
		ps.setString(2, dto.getPw());
		ps.setString(3, dto.getName());
//		ps.setString(4, "일반회원");
		ps.setString(4, dto.getPost());
		ps.setString(5, dto.getBasic_addr());
		ps.setString(6, dto.getExtra_addr());
		ps.setString(7, dto.getPhone());
		ps.execute();

		con.close();
		System.out.println("등록완료");
	}

//	아이디 찾기 기능
	public String findid(String name, String phone) throws Exception {
		Connection con = getConnection();

		String sql = "select id from member where name = ? and phone = ?";

		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, name);
		ps.setString(2, phone);

		ResultSet rs = ps.executeQuery();
		String result = null;
		if (rs.next()) {

			result = rs.getString("id");
		}
		con.close();
		return result;

	}

//	단일조회
	public MemberDto get(String id) throws Exception {
		Connection con = getConnection();

		String sql = "select * from member where id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, id);
		ResultSet rs = ps.executeQuery(); // 많아봐야 1개

		MemberDto dto;
		if (rs.next()) {
			dto = new MemberDto();

			dto.setId(rs.getString("id"));
			dto.setPw(rs.getString("Pw"));
			dto.setName(rs.getString("Name"));
			dto.setJoindate(rs.getString("Joindate"));
			dto.setGrade(rs.getString("Grade"));
			dto.setPhone(rs.getString("Phone"));
			dto.setPost(rs.getString("Post"));
			dto.setLast_login(rs.getString("Last_login"));
			dto.setBasic_addr(rs.getString("Basic_addr"));
			dto.setExtra_addr(rs.getString("Extra_addr"));
		} else {
			dto = null;
		}
		System.out.println(dto.getPhone());
		return dto;
	}
	
	//최종 로그인 시각 변경 메소드
		public void updateLastLogin(String id) throws Exception {
			Connection con = getConnection();
			
			String sql = "update member set last_login = sysdate where id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.execute();
			
			con.close();
		}

		//탈퇴 기능
		public void exit(String id) throws Exception{
			Connection con = getConnection();
			
			String sql = "delete member where id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.execute();
			
			con.close();
		}
		
		//비밀번호 변경 메소드
		public void changePassword(String id, String pw) throws Exception{
			Connection con = getConnection();
			
			String sql = "update member set pw=? where id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, pw);
			ps.setString(2, id);
			
			ps.execute();
			
			con.close();
		}

		//정보수정 메소드
		public void changeInfo(MemberDto dto) throws Exception{
			Connection con = getConnection();
			
			String sql = "update member "
								+ "set phone=?, post=?, basic_addr=?, extra_addr=? "
								+ "where id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, dto.getPhone());
			ps.setString(2, dto.getPost());
			ps.setString(3, dto.getBasic_addr());
			ps.setString(4, dto.getExtra_addr());
			ps.setString(5, dto.getId());
			
			ps.execute();
			
			con.close();
		}
	// 관리자 기능(조회)
	public List<MemberDto> search(String type, String keyword) throws Exception {
		Connection con = getConnection();

		String sql = "select*from member where " + type + " like '%'||?||'%' order by " + type + " asc";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, keyword);
		ResultSet rs = ps.executeQuery();

		// ResultSet을 List로 변환
		List<MemberDto> list = new ArrayList<>();
		while (rs.next()) {
			MemberDto dto = new MemberDto();
			dto.setId(rs.getString("id"));
			dto.setPw(rs.getString("Pw"));
			dto.setName(rs.getString("Name"));
			dto.setJoindate(rs.getString("Joindate"));
			dto.setGrade(rs.getString("Grade"));
			dto.setPhone(rs.getString("Phone"));
			dto.setPost(rs.getString("Post"));
			dto.setLast_login(rs.getString("Last_login"));
			dto.setBasic_addr(rs.getString("Basic_addr"));
			dto.setExtra_addr(rs.getString("Extra_addr"));
			dto.setPoint(rs.getInt("point"));

			list.add(dto);
		}
		con.close();
		return list;
	}

//	회원상세정보조회
	public MemberDto adminget(String id) throws Exception {
		Connection con = getConnection();

		String sql = "select * from member where id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, id);
		ResultSet rs = ps.executeQuery(); // 많아봐야 1개

		MemberDto dto;
		if (rs.next()) {
			dto = new MemberDto();

			dto.setId(rs.getString("id"));
			dto.setPw(rs.getString("Pw"));
			dto.setName(rs.getString("Name"));
			dto.setJoindate(rs.getString("Joindate"));
			dto.setGrade(rs.getString("Grade"));
			dto.setPhone(rs.getString("Phone"));
			dto.setPost(rs.getString("Post"));
			dto.setLast_login(rs.getString("Last_login"));
			dto.setBasic_addr(rs.getString("Basic_addr"));
			dto.setExtra_addr(rs.getString("Extra_addr"));
			dto.setPoint(rs.getInt("point"));
		} else {
			dto = null;
		}
		return dto;
	}

	
}
