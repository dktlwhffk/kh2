package home.bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class MemberDao {
	
	//자원을 참조하는 변수 생성(리모컨)
	//private static DataSource source = context.xml의 자원 정보;
	private static DataSource source;
	static {
		//source에 context.xml의 Resource 정보를 설정
		//[1] 탐색 도구 생성
		//[2] 도구를 이용하여 탐색 후 source에 대입
		try {
			InitialContext ctx = new InitialContext();//[1]
			source = (DataSource) ctx.lookup("java:comp/env/jdbc/oracle");			
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
	}
	
	//연결 메소드
	public Connection getConnection() throws Exception{
		return source.getConnection();
	}
	
	//로그인 메소드
	public boolean login(String id, String pw) throws Exception{
		Connection con = getConnection();
		
		String sql = "select * from member where id=? and pw=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, id);
		ps.setString(2, pw);
		ResultSet rs = ps.executeQuery();
		
		boolean result = rs.next();
		
		con.close();
		
		return result;
	}
	
	public boolean login(MemberDto dto) throws Exception{
		boolean result = this.login(dto.getId(), dto.getPw()); 
		return result;
	}

	//회원가입
	public void regist(String id, String pw, String name, String phone, String post, String basic_addr, String extra_addr) throws Exception {
		MemberDto dto = new MemberDto(id, pw, name, null, null, 0, post, basic_addr, extra_addr, phone, null);
		this.regist(dto);
	}
	
	public void regist(MemberDto dto) throws Exception{
		Connection con = getConnection();
		
		String sql = "insert into member values("
				+ "?, ?, ?, sysdate, '일반회원', 0, ?, ?, ?, ?, null)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, dto.getId());
		ps.setString(2, dto.getPw());
		ps.setString(3, dto.getName());
		ps.setString(4, dto.getPost());
		ps.setString(5, dto.getBasic_addr());
		ps.setString(6, dto.getExtra_addr());
		ps.setString(7, dto.getPhone());
		
		ps.execute();
		
		con.close();
	}
	
	//아이디 찾기
	public String find(String name, String phone) throws Exception{
		Connection con = getConnection();
		
		String sql = "select id from member where name=? and phone=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, name);
		ps.setString(2, phone);
		ResultSet rs = ps.executeQuery();
		
		String id = null;
		if(rs.next()) {
//			id = rs.getString(1);
			id = rs.getString("id");
		}
		
		con.close();
		
		return id;
	}
	
	//단일조회
	public MemberDto get(String id) throws Exception{
		Connection con = getConnection();
		
		String sql = "select * from member where id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, id);
		ResultSet rs = ps.executeQuery();//많아봐야 1개
		
//		MemberDto dto = null or 객체;
		MemberDto dto;
		if(rs.next()) {
			dto = new MemberDto();
			
			dto.setId(rs.getString("id"));
			dto.setPw(rs.getString("pw"));
			dto.setName(rs.getString("name"));
			dto.setJoindate(rs.getString("joindate"));
			dto.setGrade(rs.getString("grade"));
			dto.setPhone(rs.getString("phone"));
			dto.setPoint(rs.getInt("point"));
			dto.setPost(rs.getString("post"));
			dto.setLast_login(rs.getString("last_login"));
			dto.setBasic_addr(rs.getString("basic_addr"));
			dto.setExtra_addr(rs.getString("extra_addr"));
		}
		else {
			dto = null;
		}
		
		con.close();
		
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
	
	//관리자 기능(조회)
	public List<MemberDto> search(String type, String keyword) throws Exception{
		Connection con = getConnection();
		
		String sql = "select * from member "
							+ "where "+type+" like '%'||?||'%' "
							+ "order by "+type+" asc";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, keyword);
		ResultSet rs = ps.executeQuery();

		//ResultSet을 List로 변환
		List<MemberDto> list = new ArrayList<>();
		while(rs.next()) {
			MemberDto dto = new MemberDto();
			dto.setId(rs.getString("id"));
			dto.setPw(rs.getString("pw"));
			dto.setName(rs.getString("name"));
			dto.setGrade(rs.getString("grade"));
			dto.setPoint(rs.getInt("point"));
			dto.setPost(rs.getString("post"));
			dto.setBasic_addr(rs.getString("basic_addr"));
			dto.setExtra_addr(rs.getString("extra_addr"));
			dto.setPhone(rs.getString("phone"));
			dto.setJoindate(rs.getString("joindate"));
			dto.setLast_login(rs.getString("last_login"));
			
			list.add(dto);
		}
		
		con.close();
		
		return list;
	}

	//관리자용 회원정보 수정 메소드
	public void adminChangeInput(MemberDto dto) throws Exception{
		Connection con = getConnection();
		
		String sql = "update member "
							+ "set "
								+ "name=?, "
								+ "grade=?, "
								+ "point=?, "
								+ "phone=?, "
								+ "post=?, "
								+ "basic_addr=?, "
								+ "extra_addr=? "
							+ "where id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, dto.getName());
		ps.setString(2, dto.getGrade());
		ps.setInt(3, dto.getPoint());
		ps.setString(4, dto.getPhone());
		ps.setString(5, dto.getPost());
		ps.setString(6, dto.getBasic_addr());
		ps.setString(7, dto.getExtra_addr());
		ps.setString(8, dto.getId());
		
		ps.execute();
		
		con.close();
	}
}









