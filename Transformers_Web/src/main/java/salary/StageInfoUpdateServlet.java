package salary;

import beans.EquipMaxIndexBean;
import beans.FighterBean;
import com.fancyy.json.util.JSON;
import common.PropertiesOp;
import elements.armorbase.EquipItem;
import iptvNet.IptvNetException;
import iptvNet.NetHander;
import org.json.me.JSONException;
import screen.stage.StageBtnItem;
import service.HeroDataOp;
import service.StageInfoModify;
import service.StageInfoOp;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: tongxiqing
 * Date: 14-9-23
 * Time: 下午7:26
 * To change this template use File | Settings | File Templates.
 */
public class StageInfoUpdateServlet extends HttpServlet {

    /**取得session属性*/
    HttpSession httpSession;

    NetHander netHander;

    public void init() throws ServletException {

    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        /**取得Application对象*/
        ServletContext application=this.getServletContext();

        /**取得session属性*/
        httpSession = req.getSession();

        /**获取 hero list*/
        List<FighterBean> heroList = (List<FighterBean>) httpSession.getAttribute("_FighterData");

        /**筛选已选中 hero list*/
        List<FighterBean> selectHeroList = new ArrayList<FighterBean>();

        for (FighterBean heroItem : heroList){
            if(heroItem.isSelect_flag()) selectHeroList.add(heroItem);
        }

        PropertiesOp propertiesOp = new PropertiesOp();
        Properties properties = propertiesOp.load("/initial/equip.properties");


        netHander = new NetHander(application.getInitParameter("ServerURL"), (String) httpSession.getAttribute("UserID"), (String) httpSession.getAttribute("ProductID"), (String) httpSession.getAttribute("adAccount"), (String) httpSession.getAttribute("UserToken"));

        /**更新关卡*/
//        List<StageBtnItem> stageBtnItemList = new ArrayList<StageBtnItem>();
        List<EquipItem> equipItemList = new ArrayList<EquipItem>();
        String equip_img_path = "";

//        Integer stage_map_stage_btn_index = (Integer) httpSession.getAttribute("stage_map_stage_btn_index");

        Integer selected_stage= Integer.valueOf((String) httpSession.getAttribute("selected_stage"));

//        if(httpSession.getAttribute("UserID")!=null){
//            String account = (String) httpSession.getAttribute("UserID");
            if(httpSession.getAttribute("_StageData")!=null&&Integer.valueOf((String)httpSession.getAttribute("_StageData"))<=40){
//                stageBtnItemList = (List<StageBtnItem>) JSON.toObject((String) httpSession.getAttribute("_StageData"), StageBtnItem.class);
//                if(httpSession.getAttribute("_StageData")!=null){
//                    stageBtnItemList = StageInfoOp.getStageDataList().subList(0,(Integer.valueOf((String)httpSession.getAttribute("_StageData"))));
//                }

                    if(selected_stage == (Integer.valueOf((String)httpSession.getAttribute("_StageData")))-1){      /**解锁关卡*/
//                        if(stage_map_stage_btn_index<stageBtnItemList.size()){
//                            httpSession.setAttribute("stage_map_stage_btn_index", stage_map_stage_btn_index++);
//                        }
                        httpSession.setAttribute("_StageData", String.valueOf((Integer.valueOf((String)httpSession.getAttribute("_StageData"))) + 1));
                        try {
//                            netHander.saveGameData(stage_map_stage_btn_index.toString(), 9);
                            netHander.saveGameData(String.valueOf((Integer.valueOf((String)httpSession.getAttribute("_StageData")))), 5);    /**保存关卡*/
                        } catch (JSONException e) {
                            e.printStackTrace();
                        } catch (IptvNetException e) {
                            e.printStackTrace();
                        }
                    }

//                    Integer fighter_id=0;
////                    for (FighterBean fighterBean : selectHeroList){
////                        if(fighterBean.getType() == 0){
////                            fighter_id = fighterBean.getFighter_id();
////                        }
////                    }
//
//                    if(httpSession.getAttribute("heroScreen_selectIndex")!=null){
//                        fighter_id = Integer.valueOf((String) httpSession.getAttribute("heroScreen_selectIndex"));
//                    }
//
////                    equipItemList = (List<EquipItem>) JSON.toObject(properties.getProperty("equip1"), EquipItem.class);
//
//                    EquipMaxIndexBean equipMaxIndexBean = (EquipMaxIndexBean) httpSession.getAttribute("_EquipMaxIndex");
//
//                    if((equipMaxIndexBean.getEquipMaxIndex(fighter_id+1))<equipItemList.size()-1){     //8
////                        equipMaxIndexBean.setEquipMaxIndex_zero()
//                        equipMaxIndexBean.getEquipMaxIndex_plus(fighter_id+1);       //plus = equip num ++
////                        equip_img_path = equipItemList.get(equipMaxIndexBean.getEquipMaxIndex_plus(fighter_id+1)).getImg_path();
//                    }
//
//                    try {
//                        httpSession.setAttribute("_EquipMaxIndex", equipMaxIndexBean);
//                        netHander.saveGameData(JSON.toJson(equipMaxIndexBean), 8);
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    } catch (IptvNetException e) {
//                        e.printStackTrace();
//                    }


            }
//        }

        /**更新道具*/
        updateEquipMaxIndexBean();

        /**更新积分*/
        try {
            netHander.saveScore(netHander.getMyScore(0)+50, 0);
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IptvNetException e) {
            e.printStackTrace();
        }

        /**更新宝石 宝箱*/
        Integer jewelScore=0;
        Integer chestNum=0;

        if(httpSession.getAttribute("UserID")!=null){
            String account = (String) httpSession.getAttribute("UserID");
            if(httpSession.getAttribute("_JewelScore")!=null){
                jewelScore = Integer.valueOf((String) httpSession.getAttribute("_JewelScore")) +50;
                httpSession.setAttribute("_JewelScore",jewelScore+"");
                try {
                    netHander.saveGameData(jewelScore+"", 6);
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IptvNetException e) {
                    e.printStackTrace();
                }
            }

            if(httpSession.getAttribute("_ChestNum")!=null){
                chestNum = Integer.valueOf((String) httpSession.getAttribute("_ChestNum")) +2;
                httpSession.setAttribute("_ChestNum",chestNum+"");
                try {
                    netHander.saveGameData(chestNum+"", 7);
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IptvNetException e) {
                    e.printStackTrace();
                }
            }
        }

        PrintWriter out = resp.getWriter();
        out.println("[{id:0,equip_img_path:'"+equip_img_path+"',jewelScore:"+jewelScore+",chestNum:"+chestNum+"}]");
        out.close();
    }

    private void  updateEquipMaxIndexBean(){
        Integer heroScreen_selectIndex = 0;

        try {
            if(httpSession.getAttribute("heroScreen_selectIndex")!=null){
                heroScreen_selectIndex = Integer.valueOf((String) httpSession.getAttribute("heroScreen_selectIndex"));
            }
            EquipMaxIndexBean equipMaxIndexBean = (EquipMaxIndexBean) httpSession.getAttribute("_EquipMaxIndex");

            if((equipMaxIndexBean.getEquipMaxIndex(heroScreen_selectIndex+1))<8){     //8
                equipMaxIndexBean.getEquipMaxIndex_plus(heroScreen_selectIndex+1);
                httpSession.setAttribute("_EquipMaxIndex", equipMaxIndexBean);
                netHander.saveGameData(JSON.toJson(equipMaxIndexBean), 8);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IptvNetException e) {
            e.printStackTrace();
        }
    }

}
