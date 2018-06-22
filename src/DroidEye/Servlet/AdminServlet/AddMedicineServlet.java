package DroidEye.Servlet.AdminServlet;

import DroidEye.DAO.AdminDAO;
import DroidEye.JavaBean.MedicineBean;
import DroidEye.Servlet.Common.EncodingSetter;
import DroidEye.Servlet.Common.Refresh;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by DroidEye on 2017/6/29.
 */
@WebServlet(value = "/AddMedicineServlet", name = "AddMedicineServlet")
public class AddMedicineServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EncodingSetter.setEncoding(request, response);

        String medicineName = request.getParameter("medicineName");
        String medicinePrice = request.getParameter("medicinePrice");
        String medicineFunction = request.getParameter("medicineFunction");

        MedicineBean medicine = new MedicineBean();
        medicine.setMedicineName(medicineName);
        medicine.setMedicinePrice(medicinePrice);
        medicine.setMedicineFunction(medicineFunction);

        AdminDAO adminDAO = AdminDAO.getAdminDAOInstance();

        if (adminDAO.addNewMedicine(medicine)) {
//            PrintWriter out = response.getWriter();
//            out.print("<script language='javascript'>alert('添加成功！')</script>");
//            response.setHeader("refresh", "0;URL=AdminAddWorkerPage.jsp");
            Refresh.refreshPage("添加成功！", "AdminAddMedicinePage.jsp", request, response);
        } else {
            Refresh.refreshPage("添加失败！", "AdminAddMedicinePage.jsp", request, response);
        }
    }
}
