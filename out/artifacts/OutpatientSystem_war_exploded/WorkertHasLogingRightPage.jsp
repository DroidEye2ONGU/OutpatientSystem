<%@ page import="DroidEye.DAO.WorkerDAO" %><%--
  Created by IntelliJ IDEA.
  User: DroidEye
  Date: 2017/6/29
  Time: 6:25
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
    String workerID = (String) session.getAttribute("workerID");
    String workerName = WorkerDAO.getWorkerDAOInstance().queryWorkerAccount(workerID).getWorkerName();
%>
<center>
    <h1>
        <%=workerName%>，欢迎您！请按左侧导航栏进行操作
    </h1>
</center>

</body>
</html>
