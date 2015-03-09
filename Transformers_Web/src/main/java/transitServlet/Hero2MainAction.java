package transitServlet;

import beans.FighterBean;
import beans.FighterItemBean;
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
 * Date: 14-9-4
 * Time: 下午10:25
 * To change this template use File | Settings | File Templates.
 */
public class Hero2MainAction extends HttpServlet {
    NetHander netHander;
    HttpSession httpSession;

    public void init() throws ServletException {

    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //取得Application对象
        ServletContext application=this.getServletContext();

        //取得session属性
        httpSession = req.getSession();

        netHander = new NetHander(application.getInitParameter("ServerURL"), (String) httpSession.getAttribute("UserID"), (String) httpSession.getAttribute("ProductID"), (String) httpSession.getAttribute("adAccount"), (String) httpSession.getAttribute("UserToken"));


        if(req.getParameter("selectIndex")!=null){
            HttpSession httpSession = req.getSession();

            /**获取 hero list*/
            List<FighterBean> heroList = (List<FighterBean>) httpSession.getAttribute("_FighterData");

            for (int i=0; i<heroList.size(); i++){
                if(heroList.get(i).getType()==0){
                    heroList.get(i).setSelect_flag(false);
                }
            }

            if(heroList.get(2).isGot_flag()==3){
                List<FighterBean> fighterList = (List<FighterBean>) httpSession.getAttribute("_FighterData");
                String updateHeroData =  HeroDataOp.updateHeroData(fighterList, 6);

                try {
                    httpSession.setAttribute("_FighterData", JsonToBean.jsonTobean(updateHeroData));
                    netHander.saveGameData(updateHeroData, 1);
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IptvNetException e) {
                    e.printStackTrace();
                }
            }

            if(heroList.get(Integer.valueOf(req.getParameter("selectIndex"))).isGot_flag()>=2){      /**判断是否已经变身*/

                if(Integer.valueOf(req.getParameter("selectIndex"))==2){
                    if(heroList.get(Integer.valueOf(req.getParameter("selectIndex"))).isGot_flag()==3){
                        heroList.get((Integer.valueOf(req.getParameter("selectIndex"))+4)).setSelect_flag(true);
                        httpSession.setAttribute("heroScreen_selectIndex",String.valueOf(Integer.valueOf(req.getParameter("selectIndex"))+4));
                    }else {
                        heroList.get((Integer.valueOf(req.getParameter("selectIndex"))+3)).setSelect_flag(true);
                        httpSession.setAttribute("heroScreen_selectIndex",String.valueOf(Integer.valueOf(req.getParameter("selectIndex"))+3));
                    }
                }else {
                    heroList.get((Integer.valueOf(req.getParameter("selectIndex"))+3)).setSelect_flag(true);
                    httpSession.setAttribute("heroScreen_selectIndex",String.valueOf(Integer.valueOf(req.getParameter("selectIndex"))+3));
                }
            }else {
                httpSession.setAttribute("heroScreen_selectIndex",req.getParameter("selectIndex"));
                heroList.get(Integer.valueOf(req.getParameter("selectIndex"))).setSelect_flag(true);
            }

        }

//        NetHander netHander = new NetHander(application.getInitParameter("ServerURL"), (String) req.getSession().getAttribute("UserID"), (String) req.getSession().getAttribute("ProductID"), (String) req.getSession().getAttribute("adAccount"), (String) req.getSession().getAttribute("UserToken"));

//        netHander.saveGameData(updateHeroData, 1);

        resp.setContentType("text/html; charset=gb2312");
        resp.sendRedirect(req.getContextPath()+"/hero2main.jsp?hero_index="+req.getParameter("selectIndex"));
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


    }
}
