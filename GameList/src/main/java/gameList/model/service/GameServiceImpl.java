package gameList.model.service;

import static gameList.common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import gameList.model.dao.GameDAO;
import gameList.model.dao.GameDAOImpl;
import gameList.model.dto.Game;

public class GameServiceImpl implements GameService{
	
	private GameDAO dao;
	
	

	public GameServiceImpl() {
		dao = new GameDAOImpl();
	}


//////////////////// 전체조회
	@Override
	public List<Game> selectAll() throws SQLException {

		Connection conn = getConnection();
		
		List<Game> gameList = dao.selectAll(conn);
		
		close(conn);
		
		return gameList;
	}



//////////////////// 게임 추가
	@Override
	public int addGame(String gameTitle, String gameOverview, String gameGenre, String releaseDate)
			throws SQLException {

		Connection conn = getConnection();
		
		int result = dao.addGame(conn, gameTitle, gameOverview,gameGenre,releaseDate);
		
		close(conn);
		
		return result;
	}

/////////////////// 게임 상세 조회
	@Override
	public Game detailGame(int gameNo) throws SQLException {
		Connection conn = getConnection();
		
		Game game = dao.detailGame(conn,gameNo);
		
		close(conn);
		
		
		return game;
	}

/////////////////// 게임 삭제

	@Override
	public int deleteGame(int gameNo) throws SQLException {

		Connection conn = getConnection();
		
		int result = dao.deleteGame(conn, gameNo);
		
		close(conn);
		
		return result;
	}

/////////////////// 게임 수정
	@Override
	public int updateGame(Game game) throws SQLException {
		Connection conn = getConnection();
		
		int result = dao.updateGame(conn, game);
		
		close(conn);
		
		return result;
	}

/////////////////// 게임 검색
	@Override
	public List<Game> search(String gameTitle, String gameGenre, String search) throws SQLException {

		Connection conn = getConnection();
		
		List<Game> gameList = dao.search(conn,gameTitle,gameGenre,search);
		
		close(conn);
		
		
		return gameList;
	}

}
