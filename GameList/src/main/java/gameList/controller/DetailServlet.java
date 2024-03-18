package gameList.controller;

import java.io.IOException;

import gameList.model.dto.Game;
import gameList.model.service.GameService;
import gameList.model.service.GameServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/game/detail")
public class DetailServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			GameService service = new GameServiceImpl();
			
			int gameNo = Integer.parseInt(req.getParameter("gameNo"));
			
			Game game = service.detailGame(gameNo);
			
			if(game != null) {
				req.setAttribute("game", game);
				String path = "/WEB-INF/views/detail.jsp";
				req.getRequestDispatcher(path).forward(req, resp);
				
			}else {
				req.getSession().setAttribute("message", "해당 게임이 존재 하지 않습니다.");
				
				resp.sendRedirect("/");
				
			}
		}catch (Exception e) {
			e.printStackTrace();
			
		}
	}

}
