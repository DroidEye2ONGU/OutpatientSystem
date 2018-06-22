package DroidEye.Servlet.PatientServlet;

import DroidEye.DAO.PatientDAO;
import DroidEye.JavaBean.PatientBean;
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
@WebServlet(value = "/QueryPatientServlet", name = "QueryPatientServlet")
public class QueryPatientServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EncodingSetter.setEncoding(request, response);

        String patientID = request.getParameter("patientID");
        String patientPassword = request.getParameter("patientPassword");

        PatientDAO patientDAO = PatientDAO.getPatientDAOInstance();
        PatientBean patient = patientDAO.queryPatient(patientID);

        if (patient != null) {
            if (patient.getPatientPassword().equals(patientPassword)) {
                request.getSession().setAttribute("patientID", patientID);
                Refresh.refreshPage("登陆成功！", "PatientHasLogingPage.jsp", request, response);
            } else {
                Refresh.refreshPage("用户名或密码错误！", "PatientLoginPage.jsp", request, response);
            }
        } else {
            Refresh.refreshPage("用户名或密码错误！", "PatientLoginPage.jsp", request, response);
        }

    }
}
