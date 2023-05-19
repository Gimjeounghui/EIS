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
    <form action="/eis/member/memberForm" method="post">
        <label for="m_email">이메일:</label>
        <input type="email" id="m_email" name="m_email" required><br>
        <label for="m_name">이름:</label>
        <input type="text" id="m_name" name="m_name" required><br>
        <label for="m_pw">비밀번호:</label>
        <input type="password" id="m_pw" name="m_pw" required><br>
        <label for="m_phone">전화번호:</label>
        <input type="tel" id="m_phone" name="m_phone" required><br>
        <input type="submit" value="가입하기">
    </form>
</body>
</html>