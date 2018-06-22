<%@ page import="DroidEye.DAO.OrderDAO" %>
<%--
  Created by IntelliJ IDEA.
  User: DroidEye
  Date: 2017/6/29
  Time: 6:32
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
    String orderID = request.getParameter("message");

    OrderDAO orderDAO = OrderDAO.getOrderDAOInstance();


    if (orderDAO.modifyOrderProcess(orderID, "已处理，并开具发票") && orderDAO.setOrderWorker(workerID,orderID)) {

%>

<script language='javascript'>alert('处理成功！')</script>
<%
    response.setHeader("refresh", "0;URL=WorkerHandleOrders.jsp");
} else {
%>
<script language='javascript'>alert('处理失败！')</script>
<%
        response.setHeader("refresh", "0;URL=WorkerHandleOrders.jsp");

    }

%>
</body>
</html>
