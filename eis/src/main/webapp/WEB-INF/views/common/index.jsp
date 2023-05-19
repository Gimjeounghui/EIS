<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<script type="text/javascript">
	$(function() {

	});
</script>

<body>
	
<body>
	<h1>Login</h1>
<form action="/member/loginMember" method="post">
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
	<p>
		<strong>회원가입 후 관리자의 승인완료 시 접속가능 하도록 구현</strong>
	</p>

	<p>실행 시 처음으로 보여지는 페이지 입니다.(로그인, 회원가입, 아이디 및 비밀번호 찾기)</p>
	<br />
	<br />
	<p>추가 : sns 연동 로그인 및 회원가입 기능추가</p>
	<p>추가 : 비밀번호 x회 이상 틀렸을 때 보안기능</p>

</body>