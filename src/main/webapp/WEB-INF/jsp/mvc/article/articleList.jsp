<%@ page import="kr.mjc.nayeon.web.dao.Article" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<body>
<p><a href="/mvc/user/loginForm">로그인</a> <a href="/mvc/user/userForm">회원가입</a> <a href="/mvc/article/articleGet">글 상세보기</a></p>
<h3>글 목록</h3>
<%
    List<Article> articleList = (List<Article>) request.getAttribute("articleList");
    for (Article article : articleList) {%>
<p><%= article %>
</p>
<%
    }
%>
</body>
</html>
