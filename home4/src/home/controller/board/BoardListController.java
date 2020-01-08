package home.controller.board;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import home.bean.BoardDao;
import home.bean.BoardDto;
import home.controller.Controller;

public class BoardListController implements Controller{

	@Override
	public String doGet(HttpServletRequest req, HttpServletResponse resp) throws Exception {
//	 	페이지 크기
		int pagesize = 10;
//	 	네비게이터 크기
		int navsize = 10;
		
//	 	페이징 추가
		int pno;
		try{
			pno = Integer.parseInt(req.getParameter("pno"));
			if(pno <= 0) throw new Exception();
		}
		catch(Exception e){
			pno = 1;
		}
		
		int finish = pno * pagesize;
		int start = finish - (pagesize - 1);
//	 	System.out.println("start = " + start + " , finish = " + finish);

		String type = req.getParameter("type");
		String keyword = req.getParameter("keyword");
		
		boolean isSearch = type != null && keyword != null;
		
		BoardDao dao = new BoardDao();
//	 	List<BoardDto> list = 목록 or 검색;
		List<BoardDto> list;
		if(isSearch){
			list = dao.search(type, keyword, start, finish); 
		}
		else{
			list = dao.getList(start, finish);
		}
		
		int count = dao.getCount(type, keyword);
		
		//뷰에서 필요한 데이터를 첨부(5개)
		req.setAttribute("pno", pno);
		req.setAttribute("count", count);
		req.setAttribute("list", list);
		req.setAttribute("pagesize", pagesize);
		req.setAttribute("navsize", navsize);
		
		//포워딩
		return "/WEB-INF/view/board/list.jsp";
	}

	@Override
	public String doPost(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
