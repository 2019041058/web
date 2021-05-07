<%@ page import="java.util.Optional" %>
<!DOCTYPE html>
<html>
<body>
<h3>게시글 삭제</h3>
<form action="deleteArticle" method="post">
    <p><input type="text" name="articleId" placeholder="삭제할 글 번호" required autofocus/></p>
    <p><input type="text" name="userId" placeholder="삭제할 작성자 번호" required/></p>
    <p>
        <button type="submit">삭제</button>
    </p>
</form>
<p style="color:red;"><%= Optional.ofNullable(request.getParameter("msg"))
    .orElse("")%>
</body>
</html>