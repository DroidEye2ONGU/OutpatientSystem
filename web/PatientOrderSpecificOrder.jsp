<%@ page import="DroidEye.DAO.OrderDAO" %><%--
  Created by IntelliJ IDEA.
  User: DroidEye
  Date: 2017/6/29
  Time: 5:24
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
    String patientID = (String) session.getAttribute("patientID");
    String medicineID = request.getParameter("message");
%>
<center>
    <h1>

        <form action="/PatientOrderServlet" method="post">
            请输入要购买的数量：<input type="text" name="quantity"><br>
            <input type="hidden" name="patientID" value="<%=patientID%>"><br>
            <input type="hidden" name="medicineID" value="<%=medicineID%>"><br>
            <input type="submit" value="确认下单">
        </form>
    </h1>
</center>
</body>
</html>
