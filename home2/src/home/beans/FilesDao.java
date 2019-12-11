package home.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class FilesDao {

	private static DataSource source;
	static {
		try {
			InitialContext ctx = new InitialContext();
			source = (DataSource) ctx.lookup("java:comp/env/jdbc/oracle");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	public Connection getConnection() throws Exception {
		return source.getConnection();
	}
	
//	등록기능(파일저장이 아님)
	public void fileupload(FilesDto dto) throws Exception{
		Connection con = getConnection();
		String sql = "insert into files(no,origin,uploadname,savename,filetype,filesize) values(files_seq.nextval,?,?,?,?,? )";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, dto.getOrigin());
		ps.setString(2, dto.getUploadname());
		ps.setString(3, dto.getSavename());
		ps.setString(4, dto.getFiletype());
		ps.setLong(5, dto.getFilesize());
		ps.execute();
		con.close();
	}
	
//	조회기능
	public List<FilesDto> getList(int origin) throws Exception{
		Connection con = getConnection();
		String sql = "select*from files where origin=? order by no";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1,origin);
		ResultSet rs = ps.executeQuery();
		List<FilesDto> list = new ArrayList<>();
		while(rs.next()) {
			FilesDto fdto = new FilesDto();
			fdto.setNo(rs.getInt("no"));
			fdto.setOrigin(rs.getInt("origin"));
			fdto.setUploadname(rs.getString("uploadname"));
			fdto.setSavename(rs.getString("savename"));
			fdto.setFiletype(rs.getString("filetype"));
			fdto.setFilesize(rs.getInt("filesize"));
			
			list.add(fdto);
		}
		con.close();
		return list;
	}
//	단일조회
	public FilesDto get(int no) throws Exception{
		Connection con = getConnection();
		String sql = "select*from files where no=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, no);
		ResultSet rs = ps.executeQuery();
		
		FilesDto fdto = null;
		if(rs.next()) {
			fdto = new FilesDto();
			fdto.setNo(rs.getInt("no"));
			fdto.setOrigin(rs.getInt("origin"));
			fdto.setUploadname(rs.getString("uploadname"));
			fdto.setSavename(rs.getString("savename"));
			fdto.setFiletype(rs.getString("filetype"));
			fdto.setFilesize(rs.getInt("filesize"));
		}
		
		con.close();
		return fdto;
		
	}
	
//	삭제기능
}
