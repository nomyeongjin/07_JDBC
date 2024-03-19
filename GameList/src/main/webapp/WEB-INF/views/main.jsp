<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Game List</title>
    <link rel="stylesheet" href="/resources/css/main.css">
</head>
<body>

<h1>Game List</h1>
<div class="search">
<form action="/game/search" method="GET" class="formSearch">
    <input type="text" name="search" class="searchbar" placeholder="제목/장르 검색">
<button class="searchBTn">검색</button>
</form>
</div>
<hr>

<div id="container">
    <h4>총 ${fn:length(gameList)}개</h4>
    
    <table border="1" style="border-collapse : collapse;" class="table">
            <thead>
                <th>번호</th>
                <th>게임 제목</th>
                <th>장르</th>
                <th>출시일</th>
            </thead>
    
            <tbody>
                <c:forEach items="${gameList}" var="game">
                  
                    <tr>
                        <td>${game.gameNo}</td>
                        
                        <td class="aTag">
                        <a href="/game/detail?gameNo=${game.gameNo}">${game.gameTitle}</a>
                        </td>
                        
                        <td>${game.gameGenre}</td>
                        <td>${game.releaseDate}</td>
                    </tr>
    
                </c:forEach>  
                <%-- DB 조회 결과를 이용해서 화면 출력 --%>
                
            </tbody>
    
        </table>
    
    <hr>
        
     <form action="/game/add" method = "POST" class="form">
            <h4>게임 추가</h4>
    
            <div>
                제목 : <input type="text" name="gameTitle" class="input">
            </div>
            <div>
                <textarea name="gameOverview" cols="50" rows="5" placeholder="게임 개요 작성"></textarea>
            </div>
            <div>
                장르 : <input type="text" name="gameGenre" class="input">
            </div>
            <div>
                출시일 : <input type="date" name="releaseDate" placeholder="YYYY-MM-DD" class="input">
            </div>
            <button>추가</button>
        </form>
    
    
        <c:if test="${not empty message}" >
            <script>
                alert("${message}");
            </script>
    
            <c:remove var="message" />
        </c:if>
</div>
    



</body>
</html>