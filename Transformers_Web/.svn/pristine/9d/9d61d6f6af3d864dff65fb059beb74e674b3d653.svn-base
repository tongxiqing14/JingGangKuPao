package salary;

import beans.EquipMaxIndexBean;
import beans.FighterBean;
import beans.FighterItemBean;
import com.fancyy.json.util.JSON;
import common.JsonToBean;
import common.NetInfo;
import common.PropertiesOp;
import iptvNet.IptvNetException;
import iptvNet.NetHander;
import org.json.me.JSONArray;
import org.json.me.JSONException;
import org.json.me.JSONObject;
import service.HeroDataOp;
import service.JigSawInfoOp;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: tongxiqing
 * Date: 14-8-29
 * Time: 下午8:02
 * To change this template use File | Settings | File Templates.
 */
public class HeroServlet extends HttpServlet {

    HttpSession httpSession;
    NetHander netHander;
    HttpServletRequest req;
    private static final String propname0 = "/follow_consume/consume_info.properties";
    private static final String propname1 = "/follow_consume/follow_consume_info.properties";
    private static final String propname2 = "/follow_consume/pet_consume_info.properties";
    private static final String propname3 = "/follow_consume/hero_consume_info.properties";

    public void init() throws ServletException {

    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.req = req;

        //取得Application对象
        ServletContext application=this.getServletContext();

        //取得request属性
        String consume_item_index = req.getParameter("consume_item_index");

        if(req.getParameter("grouptype")!=null){
            req.getSession().setAttribute("grouptype",req.getParameter("grouptype"));
        }

        //取得session属性
        httpSession = req.getSession();

        netHander = new NetHander(application.getInitParameter("ServerURL"), (String) httpSession.getAttribute("UserID"), (String) httpSession.getAttribute("ProductID"), (String) httpSession.getAttribute("adAccount"), (String) httpSession.getAttribute("UserToken"));

        NetInfo netInfo = new NetInfo();
        netInfo.setNetHander(netHander);

        resp.setContentType("application/x-javascript;charset=UTF-8");

        boolean result;

        PropertiesOp propertiesOp = new PropertiesOp();
        Properties properties;
        String buy_prices;

        try {

            if(Integer.valueOf(consume_item_index)>=4061&&Integer.valueOf(consume_item_index)<=4072
                    ||(Integer.valueOf(consume_item_index)>=4181&&Integer.valueOf(consume_item_index)<=4189)
                    ||(Integer.valueOf(consume_item_index)>=4001&&Integer.valueOf(consume_item_index)<=4006)){
                properties = propertiesOp.load(propname0);
                buy_prices = properties.getProperty("buy_prices");

                JSONObject json1 = new JSONObject(buy_prices);
                JSONArray arr11 = json1.getJSONArray("item4000");     /**获取升级的价格 和 名称*/

                result = netInfo.topupAndConsumeMoney__(Integer.valueOf(arr11.getString(1)),new String(arr11.getString(2).getBytes("ISO-8859-1"),"gbk"));

                if(result){
                    arr11 = json1.getJSONArray("item"+(Integer.valueOf(consume_item_index)-4000));    /**获取英雄的index*/
                    if(Integer.valueOf(consume_item_index)>=4001&&Integer.valueOf(consume_item_index)<=4006){
                        updateHeroData(Integer.valueOf(arr11.getString(0)));
                    }else if(Integer.valueOf(consume_item_index)>=4061&&Integer.valueOf(consume_item_index)<=4072){
                        updateFollowData(Integer.valueOf(arr11.getString(0)));
                    }else if(Integer.valueOf(consume_item_index)>=4181&&Integer.valueOf(consume_item_index)<=4189){
                        updatePetData(Integer.valueOf(arr11.getString(0)));
                    }
                    PrintWriter out = resp.getWriter();
                    out.println("[{id:"+(Integer.valueOf(consume_item_index)-4000)+",result:0}]");
                    out.close();

                }else {
                    PrintWriter out = resp.getWriter();
                    out.println("[{id:"+(Integer.valueOf(consume_item_index)-4000)+",result:2}]");
                    out.close();
                }
            }else if(Integer.valueOf(consume_item_index)>=61&&Integer.valueOf(consume_item_index)<=72
                    ||(Integer.valueOf(consume_item_index)>=181&&Integer.valueOf(consume_item_index)<=189)
                        ||(Integer.valueOf(consume_item_index)>=1&&Integer.valueOf(consume_item_index)<=6)){
                properties = propertiesOp.load(propname0);
                buy_prices = properties.getProperty("buy_prices");

                JSONObject json1 = new JSONObject(buy_prices);
                JSONArray arr11 = json1.getJSONArray("item"+(Integer.valueOf(consume_item_index)));

                result = netInfo.topupAndConsumeMoney__(Integer.valueOf(arr11.getString(1)),new String(arr11.getString(2).getBytes("ISO-8859-1"),"gbk"));

                if(result){
                    if(Integer.valueOf(consume_item_index)>=1&&Integer.valueOf(consume_item_index)<=6){
//                        httpSession.setAttribute("=selectIndex=",Integer.valueOf(consume_item_index));    /**增加跳转衔接*/
                        updateHeroData(Integer.valueOf(arr11.getString(0)));
                    }else if(Integer.valueOf(consume_item_index)>=61&&Integer.valueOf(consume_item_index)<=72){
                        updateFollowData(Integer.valueOf(arr11.getString(0)));
                    }else if(Integer.valueOf(consume_item_index)>=181&&Integer.valueOf(consume_item_index)<=189){
                        updatePetData(Integer.valueOf(arr11.getString(0)));
                    }
                    PrintWriter out = resp.getWriter();
                    out.println("[{id:"+Integer.valueOf(consume_item_index)+",result:0}]");
                    out.close();

                }else {
                    PrintWriter out = resp.getWriter();
                    out.println("[{id:"+Integer.valueOf(consume_item_index)+",result:2}]");
                    out.close();
                }
            }else if(Integer.valueOf(consume_item_index)>=1000&&Integer.valueOf(consume_item_index)<=1003){
                httpSession.setAttribute("=selectIndex=",Integer.valueOf(consume_item_index));    /**增加跳转衔接*/

                properties = propertiesOp.load(propname3);
                buy_prices = properties.getProperty("upgrade_heros_prices");

                JSONObject json1 = new JSONObject(buy_prices);
                JSONArray arr11 = json1.getJSONArray("item"+(Integer.valueOf(consume_item_index)));
                result = netInfo.topupAndConsumeMoney__(Integer.valueOf(arr11.getString(1)),new String(arr11.getString(2).getBytes("ISO-8859-1"),"gbk"));

                if(result){
                    strengthenHeroData(Integer.valueOf(arr11.getString(0)));
                    List<FighterBean> fighterList = (List<FighterBean>) httpSession.getAttribute("_FighterData");     /**与原hero jsp逻辑相符*/
                    String updateHeroData2;
                    if(Integer.valueOf(arr11.getString(0))!=6){
                        updateHeroData2 =  HeroDataOp.updateHeroData2(fighterList, Integer.valueOf(arr11.getString(0))-3);
                    }else {
                        updateHeroData2 =  HeroDataOp.updateHeroData2(fighterList, Integer.valueOf(arr11.getString(0))-4);
                    }
//                    String updateHeroData2 =  HeroDataOp.updateHeroData2(fighterList, 1);

                    try {
                        httpSession.setAttribute("_FighterData", JsonToBean.jsonTobean(updateHeroData2));
                        netHander.saveGameData(updateHeroData2, 1);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    } catch (IptvNetException e) {
                        e.printStackTrace();
                    }

                    PrintWriter out = resp.getWriter();
                    out.println("[{id:1001,result:0}]");
                    out.close();

                }else{
                    PrintWriter out = resp.getWriter();
                    out.println("[{id:1001,result:2}]");
                    out.close();
                }
            }else if(Integer.valueOf(consume_item_index)>=281&&Integer.valueOf(consume_item_index)<=287){
                properties = propertiesOp.load(propname0);
                buy_prices = properties.getProperty("buy_prices");

                JSONObject json1 = new JSONObject(buy_prices);
                JSONArray arr11 = json1.getJSONArray("item"+(Integer.valueOf(consume_item_index)));

//                List<FighterBean> fighterList = (List<FighterBean>) httpSession.getAttribute("_FighterData");
//                if(fighterList.get(0).isGot_flag()>0) {
                    result = netInfo.topupAndConsumeMoney__(Integer.valueOf(arr11.getString(1)),new String(arr11.getString(2).getBytes("ISO-8859-1"),"gbk"));
//                }else{
//                    result = netInfo.topupAndConsumeMoney__(Integer.valueOf(arr11.getString(1)),new String(arr11.getString(2).getBytes("ISO-8859-1"),"gbk"));
//                }

                if(result){
                    updateHeroData(Integer.valueOf(arr11.getString(0)));
                    PrintWriter out = resp.getWriter();
                    out.println("[{id:"+Integer.valueOf(consume_item_index)+",result:0}]");
                    out.close();
                }else {
                    PrintWriter out = resp.getWriter();
                    out.println("[{id:"+Integer.valueOf(consume_item_index)+",result:2}]");
                    out.close();
                }
            }else if(Integer.valueOf(consume_item_index)>=4281&&Integer.valueOf(consume_item_index)<=4287){
                properties = propertiesOp.load(propname0);
                buy_prices = properties.getProperty("buy_prices");

                JSONObject json1 = new JSONObject(buy_prices);
                JSONArray arr11 = json1.getJSONArray("item4000");

//                List<FighterBean> fighterList = (List<FighterBean>) httpSession.getAttribute("_FighterData");
//                if(fighterList.get(0).isGot_flag()>0) {
                    result = netInfo.topupAndConsumeMoney__(Integer.valueOf(arr11.getString(1)),new String(arr11.getString(2).getBytes("ISO-8859-1"),"gbk"));
//                }else{
//                    result = netInfo.topupAndConsumeMoney__(Integer.valueOf(arr11.getString(1)),new String(arr11.getString(2).getBytes("ISO-8859-1"),"gbk"));
//                }

                if(result){
                    arr11 = json1.getJSONArray("item"+(Integer.valueOf(consume_item_index)-4000));
                    updateHeroData(Integer.valueOf(arr11.getString(0)));
                    PrintWriter out = resp.getWriter();
                    out.println("[{id:"+(Integer.valueOf(consume_item_index)-4000)+",result:0}]");
                    out.close();
                }else {
                    PrintWriter out = resp.getWriter();
                    out.println("[{id:"+(Integer.valueOf(consume_item_index)-4000)+",result:2}]");
                    out.close();
                }
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        if(Integer.valueOf(consume_item_index) == 2000) {         //购买装备道具
            properties = propertiesOp.load(propname0);
            buy_prices = properties.getProperty("buy_prices");

            JSONObject json1 = null;
            JSONArray arr11 = null;
            try {
                json1 = new JSONObject(buy_prices);
                arr11 = json1.getJSONArray("item"+(Integer.valueOf(consume_item_index)));
                result = netInfo.topupAndConsumeMoney__(Integer.valueOf(arr11.getString(1)),new String(arr11.getString(2).getBytes("ISO-8859-1"),"gbk"));

                if(result){
                    updateEquipMaxIndexBean();
                    PrintWriter out = resp.getWriter();
                    out.println("[{id:2000,result:0}]");
                    out.close();
                }else {
                    PrintWriter out = resp.getWriter();
                    out.println("[{id:2000,result:1}]");
                    out.close();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }else if(Integer.valueOf(consume_item_index) == 3000) {         //购买拼图
            properties = propertiesOp.load(propname0);
            buy_prices = properties.getProperty("buy_prices");

            try {
                JSONObject json1 = new JSONObject(buy_prices);
                JSONArray arr11 = json1.getJSONArray("item"+(Integer.valueOf(consume_item_index)));

                result = netInfo.topupAndConsumeMoney__(Integer.valueOf(arr11.getString(1)),new String(arr11.getString(2).getBytes("ISO-8859-1"),"gbk"));
                if(result){
                    updateJigsawPic();
                    PrintWriter out = resp.getWriter();
                    out.println("[{id:2000,result:0}]");
                    out.close();
                }else {
                    PrintWriter out = resp.getWriter();
                    out.println("[{id:2000,result:2}]");
                    out.close();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }

    private void  updateJigsawPic(){

        String jigsawinfo = (String) httpSession.getAttribute("_jigsawinfo");
        int[][] jigsawinfo_array = JigSawInfoOp.getJigSawInfo(jigsawinfo);

        Integer selectIndex_item = Integer.valueOf(req.getParameter("selectIndex_item"));
        Integer selectIndex_sub = (Integer) httpSession.getAttribute("selectIndex_sub__");

        jigsawinfo_array[selectIndex_sub][selectIndex_item] = 1;    //更新为已经购买
        try {
            httpSession.setAttribute("_jigsawinfo", JigSawInfoOp.updateJigSawInfo(jigsawinfo_array));
            netHander.saveGameData(JigSawInfoOp.updateJigSawInfo(jigsawinfo_array), 10);
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IptvNetException e) {
            e.printStackTrace();
        }
    }

    private void  updateEquipMaxIndexBean(){
        Integer heroScreen_selectIndex = 0;

        try {
            if(httpSession.getAttribute("heroScreen_selectIndex")!=null){
                heroScreen_selectIndex = Integer.valueOf((String) httpSession.getAttribute("heroScreen_selectIndex"));
            }
            EquipMaxIndexBean equipMaxIndexBean = (EquipMaxIndexBean) httpSession.getAttribute("_EquipMaxIndex");
            equipMaxIndexBean.getEquipMaxIndex_plus(heroScreen_selectIndex+1);
            httpSession.setAttribute("_EquipMaxIndex", equipMaxIndexBean);
            netHander.saveGameData(JSON.toJson(equipMaxIndexBean), 8);
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IptvNetException e) {
            e.printStackTrace();
        }
    }

    private void strengthenHeroData(int index){
        List<FighterBean> fighterList = (List<FighterBean>) httpSession.getAttribute("_FighterData");
        List<FighterItemBean> fighterItemBeans = (List<FighterItemBean>) httpSession.getAttribute("_HeroData");

        String upgradeHeroLevel =  HeroDataOp.upgradeHeroLevel(fighterItemBeans,index);
        String updateHeroData2 =  HeroDataOp.updateHeroData(fighterList, index);

        try {
            httpSession.setAttribute("_HeroData", JsonToBean.jsonTobean2(upgradeHeroLevel));
            httpSession.setAttribute("_FighterData", JsonToBean.jsonTobean(updateHeroData2));
            netHander.saveGameData(updateHeroData2, 1);
            netHander.saveGameData(upgradeHeroLevel, 2);
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IptvNetException e) {
            e.printStackTrace();
        }
    }

    private void upgradeHeroData(int index){
//        List<FighterBean> fighterList = (List<FighterBean>) httpSession.getAttribute("_FighterData");
        List<FighterItemBean> fighterItemBeans = (List<FighterItemBean>) httpSession.getAttribute("_HeroData");

        String upgradeHeroLevel =  HeroDataOp.upgradeHeroLevel(fighterItemBeans,index);
//        String updateHeroData2 =  HeroDataOp.updateHeroData(fighterList, index);

        try {
            httpSession.setAttribute("_HeroData", JsonToBean.jsonTobean2(upgradeHeroLevel));
//            httpSession.setAttribute("_FighterData", JsonToBean.jsonTobean(updateHeroData2));
//            netHander.saveGameData(updateHeroData2, 1);
            netHander.saveGameData(upgradeHeroLevel, 2);
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IptvNetException e) {
            e.printStackTrace();
        }
    }

    private void updateHeroData(int index){
        List<FighterBean> fighterList = (List<FighterBean>) httpSession.getAttribute("_FighterData");
        List<FighterItemBean> fighterItemBeans = (List<FighterItemBean>) httpSession.getAttribute("_HeroData");

        try {
            if(fighterList.get(index).isGot_flag()>0) {
                String upgradeHeroLevel =  HeroDataOp.upgradeHeroLevel(fighterItemBeans,index);
                httpSession.setAttribute("_HeroData", JsonToBean.jsonTobean2(upgradeHeroLevel));
                netHander.saveGameData(upgradeHeroLevel, 2);
            }else{
                String updateHeroData =  HeroDataOp.updateHeroData(fighterList, index);
                httpSession.setAttribute("_FighterData", JsonToBean.jsonTobean(updateHeroData));
                netHander.saveGameData(updateHeroData, 1);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IptvNetException e) {
            e.printStackTrace();
        }
    }

    private void updateFollowData(int index){
        List<FighterBean> fighterList = (List<FighterBean>) httpSession.getAttribute("_FighterData");
        List<FighterItemBean> fighterItemBeans = (List<FighterItemBean>) httpSession.getAttribute("_MonsterData");

        try {
            if(fighterList.get(index+7).isGot_flag()>0) {
                String upgradeFollowLevel = HeroDataOp.upgradeFollowLevel(fighterItemBeans,index);
                httpSession.setAttribute("_MonsterData", JsonToBean.jsonTobean2(upgradeFollowLevel));
                netHander.saveGameData(upgradeFollowLevel, 3);
            }else{
                String updateFollowData = HeroDataOp.updateFollowData(fighterList, index);
                httpSession.setAttribute("_FighterData", JsonToBean.jsonTobean(updateFollowData));
                netHander.saveGameData(updateFollowData, 1);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IptvNetException e) {
            e.printStackTrace();
        }
    }

    private void updatePetData(int index){
        List<FighterBean> fighterList = (List<FighterBean>) httpSession.getAttribute("_FighterData");
        List<FighterItemBean> fighterItemBeans = (List<FighterItemBean>) httpSession.getAttribute("_PetData");

        try {
            if(fighterList.get(index+19).isGot_flag()>0) {
                String upgradePetLevel = HeroDataOp.upgradePetLevel(fighterItemBeans,index);
                httpSession.setAttribute("_PetData", JsonToBean.jsonTobean2(upgradePetLevel));
                netHander.saveGameData(upgradePetLevel, 4);
            }else{
                String updatePetData = HeroDataOp.updatePetData(fighterList, index);
                httpSession.setAttribute("_FighterData", JsonToBean.jsonTobean(updatePetData));
                netHander.saveGameData(updatePetData, 1);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IptvNetException e) {
            e.printStackTrace();
        }
    }

}


