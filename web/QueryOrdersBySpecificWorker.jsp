<%@ page import="java.util.List" %>
<%@ page import="DroidEye.JavaBean.OrderBean" %>
<%@ page import="DroidEye.DAO.OrderDAO" %>
<%@ page import="DroidEye.DAO.MedicineDAO" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: DroidEye
  Date: 2017/6/29
  Time: 4:12
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
    String workerID = request.getParameter("message");
    List<OrderBean> orders = OrderDAO.getOrderDAOInstance().queryOrdersGroupByWorker(workerID);
%>

<center>
    <h1>
        <%
            if (orders.isEmpty()) {

        %>
        该值班医师暂未处理订单<a href="AdminQueryOrdersGroupByWorkersPage.jsp">返回</a>
        <%
        } else {
        %>
        该值班医师负责的订单如下<br>
    </h1>
    <table width="2000" border="1" align="center" id="tab2">
        <tr>
            <td align="center" valign="middle">订单号</td>
            <td align="center" valign="middle">下订单患者号</td>
            <td align="center" valign="middle">购买药品号</td>
            <td align="center" valign="middle">购买药品名</td>
            <td align="center" valign="middle">购买数量</td>
            <td align="center" valign="middle">总价</td>
            <td align="center" valign="middle">是否可以退款</td>
            <td align="center" valign="middle">订单状态</td>
            <td align="center" valign="middle">下订单时间</td>

        </tr>
        <%
            for (OrderBean order : orders
                    ) {


        %>
        <tr>

            <td align="center" valign="middle"><%=order.getOrderID()%>
            </td>
            <td align="center" valign="middle"><%=order.getPatientID()%>
            </td>
            <td align="center" valign="middle"><%=order.getMedicineID()%>
            </td>
            <td align="center" valign="middle"><%=MedicineDAO.getMedicineDAOInstance()
            .querySingleMedicine(order.getMedicineID()).getMedicineName()%>
            </td>
            <td align="center" valign="middle"><%=order.getQuantity()%>
            </td>
            <td align="center" valign="middle"><%=order.getTotalPrice()%>
            </td>
            <td align="center" valign="middle"><%=order.getOrderProcess()%>
            </td>
        </tr>
        <%
                }

            }
        %>

    </table>
    </h1>
</center>

</body>
</html>
