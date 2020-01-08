package home.servlet;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import home.beans.BoardDao;
import home.beans.BoardDto;
import home.beans.FilesDao;
import home.beans.FilesDto;
import home.beans.ReplyDao;
import home.beans.ReplyDto;

@WebServlet(urlPatterns="/board/content.do")
public class BoardContentServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//[1] 번호를 받고 [2] 조회수 증가 후 [3] 게시글을 불러오고 [4] 출력
			int no = Integer.parseInt(req.getParameter("no"));
			BoardDao bdao = new BoardDao();
			BoardDto bdto = bdao.get(no); 
			
//		 	본인글인지 여부와 관리자인지 여부를 미리 계산
			HttpSession session = req.getSession();
			String userId = (String)session.getAttribute("id");
			String grade = (String)session.getAttribute("grade");
			
			boolean isMine = userId.equals(bdto.getWriter()); //사용자 id = 작성자 id
			boolean isAdmin = grade.equals("관리자"); //사용자권한==관리자
			
			//추가: set<integer> 형태의 저장소를 이용하여 이미 읽은 글은 조회수 증가를 방지
			//[1] 세션에 있는 저장소를 꺼내고 없으면 신규생성한다.
			Set<Integer> memory = (Set<Integer>)session.getAttribute("memory");
			//memory가 없는 경우에는 null 값을 가진다
			if(memory==null){
				memory = new HashSet<>();
			}
			//[2]처리를 수행한다
			boolean isFirst = memory.add(no);
			System.out.println(memory);
			//[3]처리를 마치고 저장소를 다시 세션에 저장한다
			session.setAttribute("memory", memory);
			
			
			//남의글이라면 ==!isMine
			//처음읽는 글이라면 == isFirst
			if(!isMine && isFirst){
			bdto.setReadcount(bdto.getReadcount()+1);
			bdao.cu(no); //조회수 증가
			}
			//댓글이 있다면 불러와서 출력(개수는 모름)
			ReplyDao rdao = new ReplyDao();
			ReplyDto rdto = new ReplyDto();
			
			List<ReplyDto> list = rdao.getreplylist(no);

			//첨부파일이 있다면 불러와서 출력(개수는 여러개)
			FilesDao fdao = new FilesDao();
			List<FilesDto> flist = fdao.getList(no);
			
			req.setAttribute("bdto", bdto);
			req.setAttribute("list", list);
			req.setAttribute("flist", flist);
			req.setAttribute("isMine", isMine);
			req.setAttribute("isAdmin", isAdmin);
			req.setAttribute("dto", rdto);
			req.setAttribute("id", userId);
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/board/content.jsp");
			dispatcher.forward(req, resp);
		}
		catch(Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}
}
