package transitServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: tongxiqing
 * Date: 14-12-22
 * Time: ÏÂÎç3:55
 * To change this template use File | Settings | File Templates.
 */
public class Team2TeamAction extends HttpServlet {

    public void init() throws ServletException {

    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=gb2312");
        resp.sendRedirect(req.getContextPath()+"/teamscreen.jsp?select_Index="+req.getParameter("select_Index")+"&select_title_horizontal_Index=0");
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

}
