package DroidEye.Servlet.PatientServlet;

import DroidEye.DAO.OrderDAO;
import DroidEye.JavaBean.OrderBean;
import DroidEye.Servlet.Common.EncodingSetter;
import DroidEye.Servlet.Common.Refresh;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by DroidEye on 2017/6/29.
 */
@WebServlet(value = "/PatientOrderServlet", name = "PatientOrderServlet")
public class PatientOrderServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EncodingSetter.setEncoding(request, response);

        String quantity = request.getParameter("quantity");
        String patientID = request.getParameter("patientID");
        String medicineID = request.getParameter("medicineID");

        OrderDAO orderDAO = OrderDAO.getOrderDAOInstance();
        OrderBean order = new OrderBean();
        order.setPatientID(patientID);
        order.setQuantity(quantity);
        order.setMedicineID(medicineID);

        if (orderDAO.addNewOrder(order)) {
            Refresh.refreshPage("下单成功，请等待值班医师确认", "PatientOrderSpecificOrder.jsp", request, response);
        } else {
            Refresh.refreshPage("下单失败", "PatientOrderSpecificOrder.jsp", request, response);
        }
    }
}
