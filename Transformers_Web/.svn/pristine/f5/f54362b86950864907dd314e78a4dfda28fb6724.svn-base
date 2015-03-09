package transitServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: tongxiqing
 * Date: 14-12-19
 * Time: ÏÂÎç5:00
 * To change this template use File | Settings | File Templates.
 */
public class The9Input2NextAction extends HttpServlet {

    public void init() throws ServletException {

    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if(req.getParameter("toWhere").equals("teamscreen")){
            resp.setContentType("text/html; charset=gb2312");
            resp.sendRedirect(req.getContextPath()+"/teamscreen.jsp");
        }else if(req.getParameter("toWhere").equals("backpackscreen")){
            resp.setContentType("text/html; charset=gb2312");
            resp.sendRedirect(req.getContextPath()+"/backpackscreen.jsp");
        }else if(req.getParameter("toWhere").equals("hero")){
            resp.setContentType("text/html; charset=gb2312");
            resp.sendRedirect(req.getContextPath()+"/hero.jsp");
        }else if(req.getParameter("toWhere").equals("armorbasescreen")){
            resp.setContentType("text/html; charset=gb2312");
            resp.sendRedirect(req.getContextPath()+"/armorbasescreen.jsp"+"?task_selectIndex_y="+req.getParameter("task_selectIndex_y"));
        }else if(req.getParameter("toWhere").equals("ShopRoomScreen")){
            resp.setContentType("text/html; charset=gb2312");
            resp.sendRedirect(req.getContextPath()+"/ShopRoomScreen.jsp");
        }else if(req.getParameter("toWhere").equals("sub_jigsawscreen")){
            resp.setContentType("text/html; charset=gb2312");
            resp.sendRedirect(req.getContextPath()+"/sub_jigsawscreen.jsp?selectIndex_sub="+req.getParameter("selectIndex_sub"));
        }



    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

}
