package gameList.model.dao;

import static gameList.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import gameList.model.dto.Game;

public class GameDAOImpl implements GameDAO{
	
	// JDBC 객체 참조 변수 선언
		private Statement stmt;
		private PreparedStatement pstmt;
		private ResultSet rs;
		
		// Properties 객체 참조 변수 선언
		private Properties prop;
		
		

	public GameDAOImpl() {
			try {
				
				prop = new Properties();
				String path = GameDAOImpl.class.getResource("/gameList/sql/sql.xml").getPath();
				
				prop.loadFromXML(new FileInputStream(path));
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}


/////////////////////// 전체 조회
	@Override
	public List<Game> selectAll(Connection conn) throws SQLException {
		
		List<Game> gameList = new ArrayList<Game>();
		
		try {
			
			String sql = prop.getProperty("selectAll");
			
			stmt = conn.createStatement();
			
			// SQL 수행 후 결과 반환 받기
			rs = stmt.executeQuery(sql);
			
			// 조회 결과 한 행씩 접근
			while(rs.next()) {
				int gameNo = rs.getInt("GAME_NO");
				String gameTitle = rs.getString("GAME_TITLE");
				String gameGenre = rs.getString("GAME_GENRE");
				String releaseDate = rs.getString("RELEASE_DATE");
				
				// Game객체를 생성해서 값 세팅 후 GameList에 추가
				Game game = new Game(gameNo, gameTitle, gameGenre, releaseDate);
				gameList.add(game);
			} 
			
			
		
		}finally {
			
			close(stmt);
			close(rs);
		
		}
			return gameList;

	}


////////////////////////////// 게임추가
	@Override
	public int addGame(Connection conn, String gameTitle, String gameOverview, String gameGenre, String releaseDate)
			throws SQLException {
		int result = 0;
		
		try {
			
			String sql = prop.getProperty("addGame");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,gameTitle);
			pstmt.setString(2,gameOverview);
			pstmt.setString(3,releaseDate);
			pstmt.setString(4,gameGenre);
			
			result = pstmt.executeUpdate();
			
			
		} finally {
			close(pstmt);
		}
		
		return result;
	}

///////////////////게임 상세 조회
	@Override
	public Game detailGame(Connection conn, int gameNo) throws SQLException {

		Game game = null;
		
		try {
			
			String sql = prop.getProperty("detailGame");
			
			pstmt= conn.prepareStatement(sql);
			pstmt.setInt(1, gameNo);
			
			rs= pstmt.executeQuery();
			
			if(rs.next()) {
				game = new Game();
				game.setGameNo(rs.getInt("GAME_NO"));
				game.setGameTitle(rs.getString("GAME_TITLE"));
				game.setGameOverview(rs.getString("GAME_OVERVIEW"));
				game.setReleaseDate(rs.getString("RELEASE_DATE"));
				game.setGameGenre(rs.getString("GAME_GENRE"));
			}
			
			
		} finally {
			close(rs);
			close(pstmt);
			
		}
		
		
		
		return game;
	}

	//////////////////////////게임 삭제

	@Override
	public int deleteGame(Connection conn, int gameNo) throws SQLException {
		
		int result = 0;
		
		try {
		
			String sql = prop.getProperty("deleteGame");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, gameNo);
			
			result = pstmt.executeUpdate();
			
			
			
		} finally {

		close(pstmt);
			
		}
		
		
		return result;
	}

	//////////////////////// 게임 수정

	@Override
	public int updateGame(Connection conn, Game game) throws SQLException {
		int result = 0;
		try {
			String sql = prop.getProperty("updateGame");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, game.getGameTitle());
			pstmt.setString(2, game.getGameOverview());
			pstmt.setString(3, game.getGameGenre());
			pstmt.setString(4, game.getReleaseDate());
			pstmt.setInt(5,game.getGameNo());
			
			result = pstmt.executeUpdate();
			
			
			
		} finally {
		close(pstmt);
		
		}
		
		
		return result;
	}


	@Override
	public List<Game> search(Connection conn, String gameTitle, String gameGenre, String search) throws SQLException {

		List<Game> gameList = new ArrayList<Game>();
		
		try {
			
			String sql = prop.getProperty("search");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,search);
			pstmt.setString(2,search);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int gameNo = rs.getInt("GAME_NO");
				gameTitle = rs.getString("GAME_TITLE");
				gameGenre = rs.getString("GAME_GENRE");
				String releaseDate = rs.getString("RELEASE_DATE");
				
				// Game객체를 생성해서 값 세팅 후 GameList에 추가
				Game game = new Game(gameNo, gameTitle, gameGenre, releaseDate);
				gameList.add(game);
				
			}
			
			
			
		} finally {
			close(rs);
			close(pstmt);
		
		}
		
		return gameList;
	}
	
	
	
	
	
	
	
	
	
	
	
}
