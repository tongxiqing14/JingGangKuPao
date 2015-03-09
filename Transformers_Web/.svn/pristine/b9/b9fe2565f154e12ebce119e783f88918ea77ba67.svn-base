package transitServlet;

import beans.EquipMaxIndexBean;
import beans.FighterBean;
import beans.FighterItemBean;
import com.fancyy.json.util.JSON;
import common.JsonToBean;
import iptvNet.IptvNetException;
import iptvNet.NetHander;
import org.json.me.JSONException;
import service.HeroDataOp;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: tongxiqing
 * Date: 14-9-15
 * Time: 下午9:18
 * To change this template use File | Settings | File Templates.
 */
public class Armorbases2ArmorbasesServlet extends HttpServlet {

    HttpSession httpSession;

    public void init() throws ServletException {

    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if(req.getParameter("all_equip_got")!=null){
            /**清空收集到的装备*/
            //取得Application对象
            ServletContext application=this.getServletContext();
            httpSession = req.getSession();
            EquipMaxIndexBean equipMaxIndexBean = (EquipMaxIndexBean) httpSession.getAttribute("_EquipMaxIndex");
            equipMaxIndexBean.setEquipMaxIndex_zero(Integer.valueOf(req.getParameter("hero_index"))+1);

            NetHander netHander = new NetHander(application.getInitParameter("ServerURL"), (String) httpSession.getAttribute("UserID"), (String) httpSession.getAttribute("ProductID"), (String) httpSession.getAttribute("adAccount"), (String) httpSession.getAttribute("UserToken"));
            try {
                netHander.saveGameData(JSON.toJson(equipMaxIndexBean), 8);
            } catch (JSONException e) {
                e.printStackTrace();
            } catch (IptvNetException e) {
                e.printStackTrace();
            }
            /**升级一次*/
            updateHeroData(Integer.valueOf(req.getParameter("hero_index")));

            resp.setContentType("text/html; charset=gb2312");
            resp.sendRedirect(req.getContextPath()+"/armorbasescreen.jsp?task_selectIndex_y="+req.getParameter("hero_index"));

//            PrintWriter out = resp.getWriter();
//            out.println("[{id:0,name:''}]");
//            out.close();
        }else {
            String hero_index = req.getParameter("hero_index");
            HttpSession session = req.getSession();
            session.setAttribute("armorbase_hero_index",hero_index);

            resp.setContentType("text/html; charset=gb2312");
            resp.sendRedirect(req.getContextPath()+"/armorbasescreen.jsp?preScreen=self&direct=toleft");

//            PrintWriter out = resp.getWriter();

//            out.println("[{id:0,name:''}]");
//            out.close();
        }

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    private void updateHeroData(int index){
        List<FighterBean> fighterList = (List<FighterBean>) httpSession.getAttribute("_FighterData");
        List<FighterItemBean> fighterItemBeans = (List<FighterItemBean>) httpSession.getAttribute("_HeroData");

        if(fighterList.get(index).isGot_flag()>0) {
            httpSession.setAttribute("_HeroData", JsonToBean.jsonTobean2(HeroDataOp.upgradeHeroLevel(fighterItemBeans, index)));
        }else{
            httpSession.setAttribute("_FighterData", JsonToBean.jsonTobean(HeroDataOp.updateHeroData(fighterList, index)));
        }
    }
}
