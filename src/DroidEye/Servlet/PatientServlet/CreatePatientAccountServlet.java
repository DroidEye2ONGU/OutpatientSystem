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
@WebServlet(value = "/CreatePatientAccountServlet", name = "CreatePatientAccountServlet")
public class CreatePatientAccountServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EncodingSetter.setEncoding(request, response);


        String patientName = request.getParameter("patientName");
        String patientPassword = request.getParameter("patientPassword");
        String patientPassword2 = request.getParameter("patientPassword2");

        if (patientPassword.equals(patientPassword2)) {
            PatientDAO patientDAO = PatientDAO.getPatientDAOInstance();
//            PatientBean patient = new PatientBean();
//            patient.setPatientName(patientName);
//            patient.setPatientPassword(patientPassword);
            String patientID = patientDAO.addNewPatient(patientName, patientPassword);
            if (patientID != null) {
                request.getSession().setAttribute("patientID", patientID);
                Refresh.refreshPage("创建账号成功，您的账号是" + patientID + ",请凭此账号登录，点击确认后自动登录",
                        "PatientHasLogingPage.jsp", request, response);
            } else {
                Refresh.refreshPage("创建失败！请重试！", "PatientRegisterPage.jsp", request, response);
            }
        } else {
            Refresh.refreshPage("两次密码不同，请重试", "PatientRegisterPage.jsp", request, response);
        }

    }
}
