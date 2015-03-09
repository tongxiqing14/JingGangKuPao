package transitServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: tongxiqing
 * Date: 14-12-18
 * Time: ÉÏÎç12:42
 * To change this template use File | Settings | File Templates.
 */
public class GameOver2NextAction extends HttpServlet {

    public void init() throws ServletException {

    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if(req.getParameter("overAs")!=null){
             if(req.getParameter("overAs").equals("fail")){
                 resp.setContentType("text/html; charset=gb2312");
                 resp.sendRedirect(req.getContextPath()+"/armorbasescreen.jsp?preScreen=mainscreen");
             }else if(req.getParameter("overAs").equals("success")){
                 resp.setContentType("text/html; charset=gb2312");
                 resp.sendRedirect(req.getContextPath()+"/stageMapScreen.jsp");
             }
        }

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

}
