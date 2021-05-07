<!DOCTYPE html>
<html>
<body>
<h3>게시글 쓰기</h3>
<form action="addArticle" method="post">
    <p><input type="text" name="title" placeholder="제목" required autofocus/></p>
    <p><input type="text" name="content" placeholder="내용" required/></p>
    <p><input type="text" name="userId" placeholder="작성자 번호" required/></p>
    <p><input type="text" name="name" placeholder="이름" required/></p>
    <p>
        <button type="submit">저장</button>
    </p>
</form>
</body>
</html>