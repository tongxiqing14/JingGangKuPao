package salary;

import common.NetInfo;
import iptvNet.NetHander;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: tongxiqing
 * Date: 14-9-22
 * Time: ÏÂÎç10:48
 * To change this template use File | Settings | File Templates.
 */
public class VerificationServlet extends HttpServlet {

    public void init() throws ServletException {

    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        NetHander netHander = new NetHander();
        NetInfo netInfo = new NetInfo();
        netInfo.setNetHander(netHander);

        netInfo.hasVerificationCode__();
    }

}
