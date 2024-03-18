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

@WebServlet("/game/search")
public class SearchServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			
			GameService service = new GameServiceImpl();
			
			String search = req.getParameter("search");
			String gameTitle = req.getParameter("gameTitle");
			String gameGenre = req.getParameter("gameGenre");
			
			List<Game> gameList = service.search(gameTitle, gameGenre,search);
			
			req.setAttribute("gameList", gameList);
			
			String path = "/WEB-INF/views/search.jsp";
			
			req.getRequestDispatcher(path).forward(req, resp);
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

}
