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

@WebServlet("/game/update")
public class UpdateServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			GameService service = new GameServiceImpl();
			
			int gameNo = Integer.parseInt(req.getParameter("gameNo"));
			
			Game game = service.detailGame(gameNo);
			
			if(game != null) {
				req.setAttribute("game", game);
				
				String path = "/WEB-INF/views/update.jsp";
				req.getRequestDispatcher(path).forward(req, resp);
			
			}else {
				req.getSession().setAttribute("message", "리스트에 존재 하지 않는 게임입니다.");
				resp.sendRedirect("/");
				
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			GameService service = new GameServiceImpl();
			

			
			int gameNo = Integer.parseInt(req.getParameter("gameNo"));
			String gameTitle = req.getParameter("gameTitle");
			String gameOverview = req.getParameter("gameOverview");
			String gameGenre = req.getParameter("gameGenre");
			String releaseDate = req.getParameter("releaseDate");
			
			Game game = new Game(gameNo, gameTitle, gameOverview, gameGenre, releaseDate);
			
			int result = service.updateGame(game);
			
			String path = null;
			String message = null;
			
			if(result > 0) {
				path = "/game/detail?gameNo="+gameNo;
				message = "수정 성공";
				
			}else {
				path = "/game/update?gameNo="+gameNo;
				message = "수정 실패";
			}
			req.getSession().setAttribute("message", message);
			resp.sendRedirect(path);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	
	}
	
	
	
}
