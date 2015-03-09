package transitServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created with IntelliJ IDEA.
 * User: tongxiqing
 * Date: 14-9-2
 * Time: ÏÂÎç9:46
 * To change this template use File | Settings | File Templates.
 */
public class StageToTeamServlet extends HttpServlet {

    public void init() throws ServletException {

    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       System.out.println(req.getParameter("selectIndex"));
        req.getSession().setAttribute("selected_stage", req.getParameter("selectIndex"));

        PrintWriter out = resp.getWriter();

        out.println("[{id:0,name:''}]");
        out.close();

    }
}
