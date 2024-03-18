package gameList.model.dto;

public class Game {
	
	private int gameNo; // 게임 번호
	private String gameTitle; // 게임 제목
	private String gameOverview; // 게임 개요
	private String gameGenre; // 게임 장르
	private String releaseDate; // 출시일
	

 // 기본 생성자
	public Game() {	}

	
	
	
public Game(int gameNo, String gameTitle, String gameGenre, String releaseDate) {
	super();
	this.gameNo = gameNo;
	this.gameTitle = gameTitle;
	this.gameGenre = gameGenre;
	this.releaseDate = releaseDate;
}






public Game(int gameNo, String gameTitle, String gameOverview, String gameGenre, String releaseDate) {
	super();
	this.gameNo = gameNo;
	this.gameTitle = gameTitle;
	this.gameOverview = gameOverview;
	this.gameGenre = gameGenre;
	this.releaseDate = releaseDate;
}




// 게터 세터
	public int getGameNo() {
		return gameNo;
	}



	public void setGameNo(int gameNo) {
		this.gameNo = gameNo;
	}


	public String getGameTitle() {
		return gameTitle;
	}



	public void setGameTitle(String gameTitle) {
		this.gameTitle = gameTitle;
	}



	public String getGameOverview() {
		return gameOverview;
	}


	public void setGameOverview(String gameOverview) {
		this.gameOverview = gameOverview;
	}



	public String getGameGenre() {
		return gameGenre;
	}




	public void setGameGenre(String gameGenre) {
		this.gameGenre = gameGenre;
	}




	public String getReleaseDate() {
		return releaseDate;
	}





	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}



	// toString
	@Override
	public String toString() {
		return "Game [gameNo=" + gameNo + ", gameTitle=" + gameTitle + ", gameOverview=" + gameOverview + ", gameGenre="
				+ gameGenre + ", releaseDate=" + releaseDate + "]";
	}
	
	

}
