<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${game.gameTitle} 수정</title>
</head>
<body>
    <h1>${game.gameTitle}</h1>

    <hr>

    <form action="/game/update" method = "POST">
        <div>
        제목 : <input type="text" name="gameTitle" value = "${game.gameTitle}">
        </div>

        <div>
            <textarea name="gameOverview" 
            cols="50" rows="5" placeholder="게임 개요">${game.gameOverview}</textarea>
        </div>

        <div>
        장르 : <input type="text" name="gameGenre" value = "${game.gameGenre}">
        </div>

        <div>
        날짜 : <input type="date" name="releaseDate" value = "${game.releaseDate}">
        </div>

        <%-- 할 일 번호를 숨겨둠 --%>
        <input type="hidden" name = "gameNo" value="${param.gameNo}">


        <button>수정 하기</button>
    </form>



</body>
</html>