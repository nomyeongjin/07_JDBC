package gameList.model.service;

import java.sql.SQLException;
import java.util.List;

import gameList.model.dto.Game;

public interface GameService {

	
	/** 전체 조회
	 * @return gameList
	 * @throws SQLException
	 */
	List<Game> selectAll() throws SQLException;

	/** 게임 추가
	 * @param gameTitle
	 * @param gameOverview
	 * @param gameGenre
	 * @param releaseDate
	 * @return
	 * @throws SQLException
	 */
	int addGame(String gameTitle, String gameOverview, String gameGenre, String releaseDate) throws SQLException;

	/** 상세 조회
	 * @param gameNo
	 * @return game
	 * @throws SQLException
	 */
	Game detailGame(int gameNo) throws SQLException;

	/** 삭제
	 * @param gameNo
	 * @return result
	 * @throws SQLException
	 */
	int deleteGame(int gameNo) throws SQLException;

	/** 수정
	 * @param gameNo
	 * @return result
	 * @throws SQLException
	 */
	int updateGame(Game game) throws SQLException;

	/** 검색
	 * @param gameTitle
	 * @param gameGenre
	 * @param search 
	 * @return gameList
	 * @throws SQLException
	 */
	List<Game> search(String gameTitle, String gameGenre, String search) throws SQLException;

}
