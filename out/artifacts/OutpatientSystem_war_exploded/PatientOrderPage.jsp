<%@ page import="java.util.List" %>
<%@ page import="DroidEye.JavaBean.MedicineBean" %>
<%@ page import="DroidEye.DAO.MedicineDAO" %><%--
  Created by IntelliJ IDEA.
  User: DroidEye
  Date: 2017/6/29
  Time: 5:17
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
    List<MedicineBean> medicines;
    medicines = MedicineDAO.getMedicineDAOInstance().queryAllMedicines();
%>

<center>
    <h1>
        <%
            if (medicines.isEmpty()) {

        %>
        暂无药品信息
        <%
        } else {
        %>
        所有药品信息如下，点击药品编号即可下订单<br>
    </h1>
    <table width="2000" border="1" align="center" id="tab2">
        <tr>
            <td align="center" valign="middle">药品号</td>
            <td align="center" valign="middle">药品名</td>
            <td align="center" valign="middle">药品价格</td>
            <td align="center" valign="middle">药品主治</td>

        </tr>
        <%
            for (MedicineBean medicine : medicines
                    ) {


        %>
        <tr>

            <td align="center" valign="middle">
                <a href="PatientOrderSpecificOrder.jsp?message=<%=medicine.getMedicineID()%>">
                    <%=medicine.getMedicineID()%>
                </a>
            </td>
            <td align="center" valign="middle"><%=medicine.getMedicineName()%>
            </td>
            <td align="center" valign="middle"><%=medicine.getMedicinePrice()%>
            </td>
            <td align="center" valign="middle"><%=medicine.getMedicineFunction()%>
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
