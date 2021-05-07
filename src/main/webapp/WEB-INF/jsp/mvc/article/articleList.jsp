<%@ page import="kr.mjc.nayeon.web.dao.Article" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<body>
<h3>글 목록</h3>
<p><a href="/mvc/user/loginForm">로그인</a> <a href="/mvc/user/userForm">회원가입</a></p>
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
