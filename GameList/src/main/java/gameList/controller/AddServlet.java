package gameList.controller;

import java.io.IOException;

import gameList.model.service.GameService;
import gameList.model.service.GameServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/game/add")
public class AddServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			GameService service = new GameServiceImpl();
			
			String gameTitle = req.getParameter("gameTitle");
			String gameOverview = req.getParameter("gameOverview");
			String gameGenre = req.getParameter("gameGenre");
			String releaseDate = req.getParameter("releaseDate");
			
			
			int result = service.addGame(gameTitle,gameOverview,gameGenre,releaseDate);
			
			String message = null;
			
			if(result>0) message = "게임 추가 성공";
			else 	     message = "게임 추가 실패";
			
			HttpSession session = req.getSession();
			session.setAttribute("message", message);
			
			resp.sendRedirect("/");
		}catch (Exception e) {
			e.printStackTrace();
		}
	
	
	}

}
