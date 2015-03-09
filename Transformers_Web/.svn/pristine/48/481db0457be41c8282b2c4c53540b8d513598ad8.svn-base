package salary;

import common.NetInfo;
import iptvNet.NetHander;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created with IntelliJ IDEA.
 * User: tongxiqing
 * Date: 14-8-8
 * Time: 下午4:35
 * To change this template use File | Settings | File Templates.
 */
public class ConsumeServlet extends HttpServlet {

    public void init() throws ServletException {

    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        NetHander netHander = new NetHander();
        NetInfo netInfo = new NetInfo();
        netInfo.setNetHander(netHander);

        //取得Application对象
        ServletContext application=this.getServletContext();

        netHander.setServerURL(application.getInitParameter("ServerURL"));
        netHander.setGameId(req.getParameter("GameID"));

        String consume_item_index = req.getParameter("consume_item_index");

        HttpSession httpSession = req.getSession();
        netHander.setAdAccount((String) httpSession.getAttribute("adAccount"));
        netHander.setAccount((String) httpSession.getAttribute("UserID"));
        netHander.setUserToken((String) httpSession.getAttribute("UserToken"));
        application.setAttribute(netHander.getAccount(),netInfo.initData__$());

        resp.setContentType("application/x-javascript;charset=UTF-8");

        if(Integer.valueOf(consume_item_index) == 4) {
            if(netInfo.topupAndConsumeMoney__(10,"购买大招")){
                PrintWriter out = resp.getWriter();

                out.println("[{id:10,name:''}]");
                out.close();
            }else {
                PrintWriter out = resp.getWriter();

                out.println("[{id:1,name:''}]");
                out.close();
            }
        }else {
            if(netInfo.topupAndConsumeMoney__(10,"购买人物")){
                PrintWriter out = resp.getWriter();

                out.println("[{id:0,name:''}]");
                out.close();
            }else {
                PrintWriter out = resp.getWriter();

                out.println("[{id:1,name:''}]");
                out.close();
            }
        }

    }

}
