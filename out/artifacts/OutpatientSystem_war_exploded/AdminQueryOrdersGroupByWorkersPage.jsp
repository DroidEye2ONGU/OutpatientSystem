<%@ page import="java.util.List" %>
<%@ page import="DroidEye.JavaBean.WorkerBean" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="javafx.concurrent.Worker" %>
<%@ page import="DroidEye.DAO.WorkerDAO" %><%--
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
    <br>
    <center><h3>为项目分配管理员</h3></center>
    <br>
    <hr/>
    <br>
</head>
<body>

<%

    List<WorkerBean> workers;
    workers = WorkerDAO.getWorkerDAOInstance().queryAllWorkers();

%>
<center>
    <h1>
        <%
            if (workers.isEmpty()) {

        %>
        暂无职工信息<a href="AdminHasLogingPage.jsp">返回</a>
        <%
        } else {
        %>
        所有职工如下<br>
        <h3>
            点击职工号即可查看其负责的订单<br>
        </h3>
    </h1>
    <table width="2000" border="1" align="center" id="tab2">
        <tr>
            <td align="center" valign="middle">职工号</td>
            <td align="center" valign="middle">职工姓名</td>

        </tr>
        <%
            for (WorkerBean worker : workers
                    ) {


        %>
        <tr>
            <td align="center" valign="middle">
                <a href="QueryOrdersBySpecificWorker.jsp?message=<%=worker.getWorkerID()%>">
                    <%=worker.getWorkerID()%>
                </a>
            </td>
            <td align="center" valign="middle"><%=worker.getWorkerName()%>
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