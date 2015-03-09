package salary;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-11-22
 * Time: 下午3:01
 * To change this template use File | Settings | File Templates.
 */
import common.NetInfo;
import elements.FishProperty;
import iptvNet.NetHander;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletSalary extends HttpServlet{

    public void init() throws ServletException{

    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        NetHander netHander = new NetHander();
        NetInfo netInfo = new NetInfo();
        netInfo.setNetHander(netHander);

        //取得Application对象
        ServletContext application=this.getServletContext();

        netHander.setServerURL(application.getInitParameter("ServerURL"));
        netHander.setAccount(req.getParameter("Account"));
        netHander.setGameId(req.getParameter("GameID"));

        // fetch the data
        String rtString = netInfo.getHeroData__(1);

        if(rtString.equals("success")){
            if(FishProperty.isGot[1]){   // red fish already sold
                FishProperty.krillNums[1]+=1;
            }else {  // red fish unsold
                FishProperty.krillNums[1]=1;
                FishProperty.isGot[1]=true;
            }

            // update the data
            if(netInfo.updateHeroData__(1)){
                resp.getWriter().println("{\"Description\":\"sucess\",\"Result\":0}");
            } else {
                resp.getWriter().println("{\"Description\":\"failure\",\"Result\":9}");
            }

        }else {
            if(FishProperty.isGot[1]){   // red fish already sold
                FishProperty.krillNums[1]+=1;
            }else {  // red fish unsold
                FishProperty.krillNums[1]=1;
                FishProperty.isGot[1]=true;
            }

            // initial the data
            if(netInfo.initData__()){
                resp.getWriter().println("{\"Description\":\"sucess\",\"Result\":0}");
            } else {
                resp.getWriter().println("{\"Description\":\"failure\",\"Result\":9}");
            }
        }

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

}
