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
 * Time: ÏÂÎç2:26
 * To change this template use File | Settings | File Templates.
 */
public class Out2TaskScreenAction extends HttpServlet {

    public void init() throws ServletException {

    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if(req.getParameter("preScreen")!=null){
            resp.setContentType("text/html; charset=gb2312");
            resp.sendRedirect(req.getContextPath()+"/taskscreen.jsp?preScreen="+req.getParameter("preScreen"));
        }else {
            resp.setContentType("text/html; charset=gb2312");
            resp.sendRedirect(req.getContextPath()+"/taskscreen.jsp");
        }

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

}
