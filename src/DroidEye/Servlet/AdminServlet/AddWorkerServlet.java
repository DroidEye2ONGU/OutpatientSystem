package DroidEye.Servlet.AdminServlet;

import DroidEye.DAO.AdminDAO;
import DroidEye.JavaBean.WorkerBean;
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
@WebServlet(value = "/AddWorkerServlet", name = "AddWorkerServlet")
public class AddWorkerServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EncodingSetter.setEncoding(request, response);

        String workerID = request.getParameter("workerID");
        String workerName = request.getParameter("workerName");

        WorkerBean worker = new WorkerBean();
        worker.setWorkerID(workerID);
        worker.setWorkerName(workerName);
        AdminDAO adminDAO = AdminDAO.getAdminDAOInstance();

        if (adminDAO.addNewWorker(worker)) {
//            PrintWriter out = response.getWriter();
//            out.print("<script language='javascript'>alert('添加成功！')</script>");
//            response.setHeader("refresh", "0;URL=AdminAddWorkerPage.jsp");
            Refresh.refreshPage("添加成功！","AdminAddWorkerPage.jsp",request,response);
        } else {
//            PrintWriter out = response.getWriter();
//            out.print("<script language='javascript'>alert('添加失败！')</script>");
//            response.setHeader("refresh", "0;URL=AdminAddWorkerPage.jsp");
            Refresh.refreshPage("添加失败！","AdminAddWorkerPage.jsp",request,response);
        }
    }
}
