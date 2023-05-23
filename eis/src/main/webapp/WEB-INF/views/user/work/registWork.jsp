<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Work Registration</title>
</head>
<body>
    <h1>Work Registration</h1>
    
    <%-- 업무 등록 폼 --%>
    <form action="/workForm" method="post">
        <label for="title">업무 제목:</label>
        <input type="text" id="title" name="wTitle" required><br><br>       
        <label for="content">업무 내용:</label><br>
        <textarea id="content" name="wContent" rows="5" required></textarea><br><br>     
        <label for="file">업무 파일:</label>
        <input type="file" id="file" name="wFile"><br><br>
        
        <input type="submit" value="등록">
    </form>
</body>
</html>
  