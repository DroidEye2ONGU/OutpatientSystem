package DroidEye.Servlet.WorkerServlet;

import DroidEye.DAO.WorkerDAO;
import DroidEye.JavaBean.WorkerBean;
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
@WebServlet(value = "/QueryWorkerServlet", name = "QueryWorkerServlet")
public class QueryWorkerServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EncodingSetter.setEncoding(request, response);

        String workerID = request.getParameter("workerID");
        String workerPassword = request.getParameter("workerPassword");

        WorkerDAO workerDAO = WorkerDAO.getWorkerDAOInstance();
        WorkerBean worker = workerDAO.queryWorkerAccount(workerID);

        if (worker != null) {
            if (worker.getWorkerPassword().equals(workerPassword)) {
                request.getSession().setAttribute("workerID", workerID);
                Refresh.refreshPage("登陆成功", "WorkerHasLogingPage.jsp", request, response);
            } else {
                Refresh.refreshPage("用户名或密码错误", "WorkerLoginTest.jsp", request, response);
            }
        } else {
            Refresh.refreshPage("用户名或密码错误", "WorkerLoginTest.jsp", request, response);
        }

    }
}
