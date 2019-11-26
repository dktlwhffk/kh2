package beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SnackDao {

	public Connection getConnection() throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "sample", "sample");
		return con;
	}

//
	public void insert(String name, int price, int stock) throws Exception{
		Connection con = this.getConnection();
		
		String sql = "insert into snack values(snack_seq.nextval,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, name);
		ps.setInt(2, price);
		ps.setInt(3, stock);
		ps.execute();
	}//상품명 상품판매가 입력 메소드

//	public void insert(String name, int price, int stock) throws Exception{
//		Connection con = this.getConnection();
//		
//		String sql = "insert into snack values(snack_seq.nextval,?,?,?)";
//		PreparedStatement ps = con.prepareStatement(sql);
//		ps.setString(1, name);
//		ps.setInt(2, price);
//		ps.setInt(3, stock);
//		
//		ps.execute();
//	}// 상품명, 상품판매가, 재고수량 입력 메소드

//		기능3: snackdto를 등록
//		준비물: snackdto(과자1개)
//		결과물: X
	public void insert(SnackDto dto) throws Exception {
		Connection con = this.getConnection();
		String sql = "insert into snack values(snack_seq.nextval,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, dto.getName());
		ps.setInt(2, dto.getPrice());
		ps.setInt(3, dto.getStock());

		ps.execute();
		con.close();
	}

//	기능4: snack의 목록을 예쁘게 포장해서 반환하는 기능
//	준비물:x
//	반환형: List<snackdto>
	public List<SnackDto> getList() throws Exception {
		Connection con = this.getConnection();
		String sql = "select*from snack";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();

//		ResultSet의 데이터를 List<snackdto>형태로 변환
//		resultSet은 연결종료되면 사용불가하기 때문

		List<SnackDto> list = new ArrayList<>();

		while (rs.next()) {
//			데이터 1줄을 가공 및 추가
			SnackDto dto = new SnackDto();
			int no = rs.getInt("no");
			dto.setNo(no);
			String name = rs.getString("name");
			dto.setName(name);
			int price = rs.getInt("price");
			dto.setPrice(price);
			int stock = rs.getInt("stock");
			dto.setStock(stock);

			list.add(dto);
		}
		con.close();

		return list;
	}

	public List<SnackDto> search(String keyword1) throws Exception {
		Connection con = this.getConnection();
		String sql = "select*from snack where name like '%'||?||'%'";
		PreparedStatement ps = con.prepareStatement(sql);

		SnackDto dto1 = new SnackDto();
//		String keyword = "a";
//		ps.setString(1, dto1.getKeyword());
		ps.setString(1, keyword1);
//		ps.execute();
		
		ResultSet rs = ps.executeQuery();
		List<SnackDto> search = new ArrayList<>();

		while (rs.next()) {
			SnackDto dto = new SnackDto();
//			int no = rs.getInt("no");
//			dto.setNo(no);
			String name = rs.getString("name");
			dto.setName(name);
			int price = rs.getInt("price");
			dto.setPrice(price);
//			int stock = rs.getInt("stock");
//			dto.setStock(stock);

			search.add(dto);
		}
		con.close();
		return search;
	}
//수정기능: 번호를 이용하여 모든 정보를 수정
	public boolean edit(SnackDto dto) throws Exception {
		
		Connection con = getConnection();
		
		String sql="update snack set name=?, price=?, stock=? where no=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, dto.getName());
		ps.setInt(2, dto.getPrice());
		ps.setInt(3, dto.getStock());
		ps.setInt(4, dto.getNo());
		
		int result = ps.executeUpdate();
		
		con.close();
		return result>0;
	}
//	단일조회 기능
//	이름: get
//	매개변수: 번호(int)
//	반환형: 과자정보(snackdto)
	public SnackDto get(int no) throws Exception{
		
		Connection con = getConnection();
		
		String sql = "select*from Snack where no=?";
		
		PreparedStatement ps =  con.prepareStatement(sql);
		ps.setInt(1, no);
		ResultSet rs = ps.executeQuery();
		SnackDto dto;
		if(rs.next()) {
			dto = new SnackDto();
		
			dto.setNo(rs.getInt("no"));	
			dto.setName(rs.getString("name"));
			dto.setPrice(rs.getInt("price"));
			dto.setStock(rs.getInt("stock"));
			
		} else {
			dto=null;
		}
		con.close();
		return dto;		
	}
}
