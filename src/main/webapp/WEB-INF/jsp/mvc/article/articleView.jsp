<%@ page import="kr.mjc.nayeon.web.dao.Article" %>
<!DOCTYPE html>
<% Article article = (Article) session.getAttribute("ARTICLE"); %>
<html>
<body>
<h3>글 정보</h3>
<p><%= article %>
</p>
</body>
</html>
