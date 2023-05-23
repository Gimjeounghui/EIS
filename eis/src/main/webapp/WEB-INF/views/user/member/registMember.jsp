<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
</head>
<body>
    <h1>회원 가입</h1>
    <form action="/memberForm" method="post">
        <label for="email">이메일:</label>
        <input type="email" id="mEmail" name="mEmail" required><br>
        <label for="name">이름:</label>
        <input type="text" id="name" name="name" required><br>
        <label for="pw">비밀번호:</label>
        <input type="password" id="pw" name="pw" required><br>
        <label for="phone">전화번호:</label>
        <input type="tel" id="phone" name="phone" required><br>
        <input type="submit" value="가입하기">
    </form>
</body>
</html>