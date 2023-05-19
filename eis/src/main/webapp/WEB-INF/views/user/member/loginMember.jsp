
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
</head>
<body>
<h1>Login</h1>
<form action="memberLogin" method="post">
    <label for="m_email">Email:</label>
    <input type="text" id="m_email" name="m_email"><br>

    <label for="m_pw">Password:</label>
    <input type="password" id="m_pw" name="m_pw"><br>

    <input type="submit" value="Login">
</form>

<br>

<a href="singUp">회원가입</a>
<a href="forget_pw">비밀번호 찾기</a>
</body>
</html>