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
 * Time: ÏÂÎç12:12
 * To change this template use File | Settings | File Templates.
 */
public class Out2MainScreenAction extends HttpServlet {

    public void init() throws ServletException {

    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if(req.getParameter("task_selectIndex_y")!=null){
            resp.setContentType("text/html; charset=gb2312");
            resp.sendRedirect(req.getContextPath()+"/armorbasescreen.jsp?task_selectIndex_y="+req.getParameter("task_selectIndex_y"));
        }else {
            resp.setContentType("text/html; charset=gb2312");
            resp.sendRedirect(req.getContextPath()+"/armorbasescreen.jsp?preScreen=mainscreen");
        }

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

}
