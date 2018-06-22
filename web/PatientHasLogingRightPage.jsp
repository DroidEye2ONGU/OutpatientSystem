<%@ page import="DroidEye.DAO.PatientDAO" %><%--
  Created by IntelliJ IDEA.
  User: DroidEye
  Date: 2017/6/29
  Time: 5:10
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
    String patientName = PatientDAO.getPatientDAOInstance().queryPatient(patientID).getPatientName();
%>
<center>
    <h1>
        <%=patientName%>，欢迎您！请按左侧导航栏进行操作
    </h1>
</center>

</body>
</html>
