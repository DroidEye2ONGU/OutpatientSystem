<%--
  Created by IntelliJ IDEA.
  User: DroidEye
  Date: 2017/6/29
  Time: 3:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>left</title>
    <style>
        a{
            text-decoration:none;
            text-align:center;
            line-height:50px;

        }

        #menu2_2{
            width:235;
            height:150;

        }

        #menu2_1{
            width:150;
            height:150;
            background-image: url("touxiang.png");
            background-repeat: no-repeat;
            background-size:150px 150px;
            margin-left:55;
            padding-bottom:30;

        }

        #menu1{
            width:100%;
            height:97.3%;
            background-image: url("LeftBackGround.png");
            background-repeat: no-repeat;
            padding-top:26px;

        }
        *{
            margin:0;
            padding:0;
        }
    </style>

</head>
<body>
<div id="menu1">
    <div id="menu2_1">
    </div>
    <div id="menu2_2">
        <h3><br>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="AdminAddWorkerPage.jsp" target="right">添加值班医师信息</a><br>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="AdminAddMedicinePage.jsp" target="right">添加药品信息</a><br>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="AdminQueryOrdersGroupByWorkersPage.jsp" target="right">按值班医师查看订单</a><br>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="AdminQueryAllOrdersPage.jsp" target="right">查看所有订单</a><br>
            <h4>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="AdminHasLogingRightPage.jsp" target="right">返回首页</a></h4>
            <h4>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="LogoutPage.jsp" target="_top">注销</a></h4>
        </h3>
    </div>


</div>
</body>
</html>