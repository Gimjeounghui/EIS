<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>UpdateMember</title>
</head>
<body>
    <h1>�̸� �� �ڵ��� ��ȣ ����</h1>
    
    <%-- ������ �̸��� �ڵ��� ��ȣ�� �Է¹޴� �� --%>
    <form action="updateMember" method="POST">
        <label for="name">�̸�:</label>
        <input type="text" id="m_name" name="m_name" required><br><br>
        
        <label for="phone">�ڵ��� ��ȣ:</label>
        <input type="tel" id="m_phone" name="m_phone" required><br><br>
        
        <input type="submit" value="����">
    </form>
</body>
</html>