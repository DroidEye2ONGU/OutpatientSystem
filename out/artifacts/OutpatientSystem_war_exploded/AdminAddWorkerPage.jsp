<%--
  Created by IntelliJ IDEA.
  User: DroidEye
  Date: 2017/6/29
  Time: 3:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="RightSideBackGroundSetter.jsp"/>
<html>
<head>
    <title>Title</title>
</head>
<body>
<br><center><h3>添加职工信息</h3></center><br><hr/><br>
<center>
    <h3>
        <form action="/AddWorkerServlet" method="post">
            请输入职工工号：<input type="text" name="workerID"><br><br>
            请输入职工姓名：<input type="text" name="workerName"><br><br>
            <input type="submit" value="添加">
        </form>
    </h3>
</center>
</body>
</html>