<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${param.search} 검색 결과</title>

    
    <c:if test="${empty gameList}" >
        <h3>검색 결과가 없습니다.</h3>
    </c:if>
</head>
<body>
    <h1>${param.search} 검색 결과</h1>

    <c:if test="${not empty gameList}" >
        <table border="1" style="border-collapse : collapse;">
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
                        
                        <td>
                        <a href="/game/detail?gameNo=${game.gameNo}">${game.gameTitle}</a>
                        </td>
                        
                        <td>${game.gameGenre}</td>
                        <td>${game.releaseDate}</td>
                    </tr>

                </c:forEach>  
                <%-- DB 조회 결과를 이용해서 화면 출력 --%>
                
            </tbody>
        </table>
    </c:if>
    <button id="goToList">목록으로</button>
    
    <script src="/resources/js/detail.js"></script>
</body>
</html>