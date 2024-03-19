<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${game.gameTitle}</title>
    <link rel="stylesheet" href="/resources/css/main.css">
</head>
<body>
     <style>
        table{
            border-collapse : collapse;
        }

        .game-content{
            <%-- pre태그 처럼 처리 == HTML에 작성된 모양 그대로 화면에 출력 --%>
            white-space : pre-wrap;
        }
    </style>

</head>
<body>


    <div id="container1">
        <h1 id="gameTitle">${game.gameTitle}</h1>
    
        <table border="1">
            <tr>
                <th>번호</th>
                <td>${game.gameNo}</td>
            </tr>
            <tr>
                <th>출시일</th>
                <td>${game.releaseDate}</td>
            </tr>
            <tr>
                <th>장르</th>
                <td>${game.gameGenre}</td>
               
            </tr>
    
            <tr>
                <th>내용</th>
                <td class="game-content">${game.gameOverview}</td>
            </tr>
        </table>
        <div class="btnDiv">
        <button id="goToList">목록으로</button>
        <button id="updateBtn" data-game-no="${game.gameNo}">수정</button>
        <button id="deleteBtn" data-game-no="${game.gameNo}">삭제</button>
        </div>
    </div>

 <c:if test="${not empty message}" >
            <script>
                alert("${message}");
            </script>
    
            <c:remove var="message" />
        </c:if>

    <script src="/resources/js/detail.js">

    </script>

    
</body>
</html>