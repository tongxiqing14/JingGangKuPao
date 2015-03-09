package transitServlet;

import iptvNet.IptvNetException;
import iptvNet.NetHander;
import org.json.me.JSONException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: tongxiqing
 * Date: 14-12-18
 * Time: 下午4:52
 * To change this template use File | Settings | File Templates.
 */
public class TransitToScreenAction extends HttpServlet {

    public void init() throws ServletException {

    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //取得Application对象
        ServletContext application=this.getServletContext();
        if(req.getParameter("toWhere")!=null){
            if(req.getParameter("toWhere").equals("main")){
//                NetHander netHander = new NetHander(application.getInitParameter("ServerURL"), (String) req.getSession().getAttribute("UserID"), (String) req.getSession().getAttribute("ProductID"), (String) req.getSession().getAttribute("adAccount"), (String) req.getSession().getAttribute("UserToken"));
//                try {
//                    netHander.saveGameData((String)req.getSession().getAttribute("heroScreen_selectIndex"), 20);
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                } catch (IptvNetException e) {
//                    e.printStackTrace();
//                }
//                application.setAttribute("heroScreen_selectIndex",(String)req.getSession().getAttribute("heroScreen_selectIndex"));
                resp.setContentType("text/html; charset=gb2312");
                resp.sendRedirect(req.getContextPath()+"/main.jsp?heroScreen_selectIndex="+req.getSession().getAttribute("heroScreen_selectIndex"));
            }else if(req.getParameter("toWhere").equals("stage")){
                resp.setContentType("text/html; charset=gb2312");
                resp.sendRedirect(req.getContextPath()+"/stageMapScreen.jsp");
            }
        }

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

}
