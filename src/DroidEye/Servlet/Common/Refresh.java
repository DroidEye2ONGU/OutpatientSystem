package DroidEye.Servlet.Common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by DroidEye on 2017/6/29.
 */
public class Refresh {
    public static void refreshPage(String hint, String page, HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        out.print("<script language='javascript'>alert(" +
                "\'" + hint + "')</script>");
        response.setHeader("refresh", "0;URL=" + page);
    }
}
