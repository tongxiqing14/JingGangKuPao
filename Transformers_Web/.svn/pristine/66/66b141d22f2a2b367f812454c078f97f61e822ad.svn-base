package web_services;

import common.MySessionContext;
import iptvNet.IptvNetException;
import iptvNet.NetHander;
import org.json.me.JSONException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: tongxiqing
 * Date: 15-1-20
 * Time: 下午5:18
 * To change this template use File | Settings | File Templates.
 */
public class SaveGameDataServlet extends HttpServlet {

    NetHander netHander;

    public void init() throws ServletException {

    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //取得Application对象
        ServletContext application=this.getServletContext();

        ServletOutputStream out_  = resp.getOutputStream();
        String sessionId = req.getParameter("sessionId");
        HttpSession session1 = MySessionContext.getSession(sessionId);

        netHander = new NetHander(application.getInitParameter("ServerURL"), (String) session1.getAttribute("UserID"), (String) session1.getAttribute("ProductID"), (String) session1.getAttribute("adAccount"), (String) session1.getAttribute("UserToken"));

        try {
            netHander.saveGameData(req.getParameter("GameData"), Integer.valueOf(req.getParameter("Type")));
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IptvNetException e) {
            e.printStackTrace();
        }

        out_.write(netHander.str.getBytes("GBK"));
        out_.println();
        out_.close();
    }

}
