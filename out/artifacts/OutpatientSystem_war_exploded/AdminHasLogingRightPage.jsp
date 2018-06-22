<%@ page import="DroidEye.DAO.AdminDAO" %><%--
  Created by IntelliJ IDEA.
  User: DroidEye
  Date: 2017/6/29
  Time: 3:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="RightSideBackGroundSetter.jsp"/>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String adminID = (String) session.getAttribute("adminID");
    String adminName = AdminDAO.getAdminDAOInstance().queryAdminAccount(adminID).getAdminName();
%>

<h1><br><br><br><br>
    <center>
        <%=adminName%>,欢迎您！
    </center>
</h1>

</body>
</html>
