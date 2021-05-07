<%@ page import="kr.mjc.nayeon.web.dao.User" %>
<!DOCTYPE html>
<% User user = (User) session.getAttribute("USER"); %>
<html>
<body>
<h3>사용자 정보</h3>
<p><%= user %> <%-- user.getName() --%>
</p>
<p><a href="/mvc/article/articleForm">글 쓰기</a> <a href="/mvc/article/articleUpdate">글 수정</a>
    <a href="/mvc/article/articleDelete">글 삭제</a></p>
</body>
</html>
