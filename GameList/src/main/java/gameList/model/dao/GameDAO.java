package gameList.model.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import gameList.model.dto.Game;

public interface GameDAO {

	/** 전체 조회
	 * @param conn
	 * @return gameList
	 * @throws SQLException
	 */
	List<Game> selectAll(Connection conn) throws SQLException;

	/** 게임 추가
	 * @param conn
	 * @param gameTitle
	 * @param gameOverview
	 * @param gameGenre
	 * @param releaseDate
	 * @return result
	 * @throws SQLException
	 */
	int addGame(Connection conn, String gameTitle, String gameOverview, String gameGenre, String releaseDate) throws SQLException;

	/** 게임 상세 조회
	 * @param conn
	 * @param gameNo
	 * @return game
	 * @throws SQLException
	 */
	Game detailGame(Connection conn, int gameNo) throws SQLException;

	/** 게임 삭제
	 * @param conn
	 * @param gameNo
	 * @return result
	 * @throws SQLException
	 */
	int deleteGame(Connection conn, int gameNo) throws SQLException;

	/** 게임 수정
	 * @param conn
	 * @param gameNo
	 * @return result
	 * @throws SQLException
	 */
	int updateGame(Connection conn, Game game) throws SQLException;

	/** 게임 검색
	 * @param conn
	 * @param gameTitle
	 * @param gameGenre
	 * @param search 
	 * @return
	 * @throws SQLException
	 */
	List<Game> search(Connection conn, String gameTitle, String gameGenre, String search) throws SQLException;

}
