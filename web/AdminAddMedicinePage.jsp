<%@ page import="DroidEye.DAO.AdminDAO" %>
<%@ page import="DroidEye.DAO.MedicineDAO" %><%--
  Created by IntelliJ IDEA.
  User: DroidEye
  Date: 2017/6/29
  Time: 3:30
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
    int medicineNumber = MedicineDAO.getMedicineDAOInstance().getMedicineNumber();
%>
<br><center><h3>添加药品信息</h3></center><br><hr/><br>
<center>
    <h3>
        <form action="/AddMedicineServlet" method="post">
            请输入药品名称：<input type="text" name="medicineName"><br><br>
            请输入药品价格：<input type="text" name="medicinePrice"><br><br>
            请输入药品功效：<input type="text" name="medicineFunction"><br><br>
            <input type="submit" value="添加">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;现在共有<%= medicineNumber%>个药品信息
        </form>
    </h3>
</center>
</body>
</html>