<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>UpdateMember</title>
</head>
<body>
    <h1>이름 및 핸드폰 번호 수정</h1>
    
    <%-- 수정할 이름과 핸드폰 번호를 입력받는 폼 --%>
    <form action="updateMember" method="POST">
        <label for="name">이름:</label>
        <input type="text" id="m_name" name="m_name" required><br><br>
        
        <label for="phone">핸드폰 번호:</label>
        <input type="tel" id="m_phone" name="m_phone" required><br><br>
        
        <input type="submit" value="수정">
    </form>
</body>
</html>