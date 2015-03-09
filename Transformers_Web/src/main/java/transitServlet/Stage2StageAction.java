package transitServlet;

import iptvNet.IptvNetException;
import iptvNet.NetHander;
import org.json.me.JSONException;

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
 * Date: 14-9-19
 * Time: 下午5:13
 * To change this template use File | Settings | File Templates.
 */
public class Stage2StageAction extends HttpServlet {

//    NetHander netHander;

    public void init() throws ServletException {

    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //取得Application对象
//        ServletContext application=this.getServletContext();

//        Integer stage_btn_index = Integer.valueOf(req.getParameter("stage_btn_index"));

//        HttpSession httpSession = req.getSession();

//        netHander = new NetHander(application.getInitParameter("ServerURL"), (String) httpSession.getAttribute("UserID"), (String) httpSession.getAttribute("ProductID"), (String) httpSession.getAttribute("adAccount"), (String) httpSession.getAttribute("UserToken"));

//        httpSession.setAttribute("stage_map_stage_btn_index", stage_btn_index);

//        try {
//            netHander.saveGameData(stage_btn_index.toString(), 9);
//        } catch (JSONException e) {
//            e.printStackTrace();
//        } catch (IptvNetException e) {
//            e.printStackTrace();
//        }

//        PrintWriter out = resp.getWriter();
//
//        out.println("[{id:0,name:''}]");
//        out.close();
    }
}
