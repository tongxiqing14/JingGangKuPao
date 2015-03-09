package salary;

import com.fancyy.json.util.JSON;
import common.NetInfo;
import elements.UserAccount;
import iptvNet.NetHander;
import service.InfoTransition;

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
 * Date: 14-9-11
 * Time: 下午2:40
 * To change this template use File | Settings | File Templates.
 */
public class BalanceServlet extends HttpServlet {
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

        HttpSession httpSession = req.getSession();
        netHander.setAdAccount((String) httpSession.getAttribute("adAccount"));

        PrintWriter out = resp.getWriter();

        out.println("[{id:1,balance:"+netInfo.getBalance__()+"}]");
        out.close();
    }
}
