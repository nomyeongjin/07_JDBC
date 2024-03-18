package gameList.controller;

import java.io.IOException;

import gameList.model.service.GameService;
import gameList.model.service.GameServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/game/delete")
public class DeleteServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			GameService service = new GameServiceImpl();
			
			int gameNo = Integer.parseInt(req.getParameter("gameNo"));
			
			int result = service.deleteGame(gameNo);
			
			String path = null;
			String message = null;
			
			if(result > 0) {
			
				path = "/";
				message = "삭제되었습니다.";
			
			}else {
				path = "/game/detail?gameNo="+gameNo;
				message = "삭제 실패";
			}
			req.getSession().setAttribute("message", message);
			resp.sendRedirect(path);
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
