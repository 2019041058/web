<%@ page import="java.util.Optional" %>
<!DOCTYPE html>
<html>
<body>
<h3>게시글 수정</h3>
<form action="updateArticle" method="post">
    <p><input type="text" name="title" placeholder="수정할 제목" required autofocus/></p>
    <p><input type="text" name="content" placeholder="수정할 내용" required/></p>
    <p><input type="text" name="articleId" placeholder="수정할 글의 번호" required autofocus/></p>
    <p><input type="text" name="userId" placeholder="수정할 글의 작성자 번호" required/></p>
    <p>
        <button type="submit">수정</button>
    </p>
</form>
<p style="color:red;"><%= Optional.ofNullable(request.getParameter("msg"))
    .orElse("")%>
</body>
</html>