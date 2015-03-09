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
 * Time: ÏÂÎç7:47
 * To change this template use File | Settings | File Templates.
 */
public class Main2MainAction extends HttpServlet {

    public void init() throws ServletException {

    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=gb2312");
        resp.sendRedirect(req.getContextPath()+"/main.jsp?refresh=true");
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
