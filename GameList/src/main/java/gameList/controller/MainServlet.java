package gameList.controller;

import java.io.IOException;
import java.util.List;

import gameList.model.dto.Game;
import gameList.model.service.GameService;
import gameList.model.service.GameServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("") 
public class MainServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			
			// 서비스 객체 생성
			GameService service = new GameServiceImpl();
			
			// 게임 목록 조회
			// 서비스 호출 후 결과 반환 받기
			
			List<Game> gameList = service.selectAll();
			
			req.setAttribute("gameList", gameList);
			
			
			
			String path = "/WEB-INF/views/main.jsp";
			
			// main.jsp로 포워드
			req.getRequestDispatcher(path).forward(req, resp);
			
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		
		}
	}
	
}
