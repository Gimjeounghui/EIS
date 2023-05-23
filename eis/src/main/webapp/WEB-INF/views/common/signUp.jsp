<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
	
	<script type="text/javascript">
	
		$(function() {
	
		});
	
	</script>

	<body>
<body>
    <h1>회원 가입</h1>
    <form action="/member/formMember" method="post">
        <label for="email">이메일:</label>
        <input type="email" id="email" name="mEmail" required><br>
        <label for="name">이름:</label>
        <input type="text" id="name" name="mName" required><br>
        <label for="pw">비밀번호:</label>
        <input type="password" id="pw" name="mPw" required><br>
        <label for="phone">전화번호:</label>
        <input type="tel" id="phone" name="mPhone" required><br>
        <input type="submit" value="가입하기">
    </form>
</body>
</body>