package web_services;

import beans.FighterBean;
import beans.FighterItemBean;
import com.fancyy.json.util.JSON;
import common.MySessionContext;
import elements.EnemyTeam;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: tongxiqing
 * Date: 14-12-17
 * Time: 上午11:53
 * To change this template use File | Settings | File Templates.
 */
public class GameInfoServlet extends HttpServlet {

    public void init() throws ServletException {

    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletOutputStream out_  = resp.getOutputStream();

        String sessionId = req.getParameter("sessionId");

        HttpSession session1 = MySessionContext.getSession(sessionId);

//        String enemyTeamStr = (String) session1.getAttribute("_Test");
//        System.out.println("{id:"+enemyTeamStr+",Result:0}");

        double sum_enemy_hp_num = 0;
        double sum_hero_hp_num = 0;

        /**获取敌方成员*/
        List<EnemyTeam> enemyTeamList = new ArrayList<EnemyTeam>();

        if(req.getSession().getAttribute("enemy_team")!=null){
            enemyTeamList = (List<EnemyTeam>) JSON.toObject((String) session1.getAttribute("enemy_team"), EnemyTeam.class);
        }

        for(int h = 0; h < enemyTeamList.size(); h++){
            sum_enemy_hp_num += enemyTeamList.get(h).getHpNumber();
        }

        /**获取 hero list*/
        List<FighterBean> heroList = (List<FighterBean>) session1.getAttribute("_FighterData");

        /**筛选已选中 hero list*/
        List<FighterBean> selectHeroList = new ArrayList<FighterBean>();

        for (FighterBean heroItem : heroList){
            if(heroItem.isSelect_flag()) selectHeroList.add(heroItem);
        }

        /**筛选 hero list中的hero list*/
        List<FighterItemBean> monsterList_in_heroList = new ArrayList<FighterItemBean>();
        List<FighterBean> herolist_in_selectHerolist = new ArrayList<FighterBean>();
        for (FighterBean heroItem : selectHeroList){
            if (heroItem.getType() == 0){
                herolist_in_selectHerolist.add(heroItem);
                for(FighterItemBean fighterBean : ((List<FighterItemBean>) session1.getAttribute("_HeroData"))){
                    if(heroItem.getFighter_id() == fighterBean.getFighter_id()){
                        monsterList_in_heroList.add(fighterBean);
                    }
                }
            }
        }

        /**筛选 hero list中的monster list*/
        List<FighterBean> followlist_in_selectHerolist = new ArrayList<FighterBean>();
        for(FighterBean heroItem : selectHeroList){
            if(heroItem.getType() == 1){
                followlist_in_selectHerolist.add(heroItem);
                for(FighterItemBean fighterItemBean : (List<FighterItemBean>) session1.getAttribute("_MonsterData")){
                    if(heroItem.getFighter_id() == fighterItemBean.getFighter_id()){
                        monsterList_in_heroList.add(fighterItemBean);
                    }
                }
            }
        }

        /**筛选 hero list中的pet list*/
        List<FighterBean> petlist_in_selectHerolist = new ArrayList<FighterBean>();
        for(FighterBean heroItem : selectHeroList){
            if(heroItem.getType() == 2){
                petlist_in_selectHerolist.add(heroItem);
                for (FighterItemBean fighterBean : ((List<FighterItemBean>) session1.getAttribute("_PetData"))){
                    if(heroItem.getFighter_id() == fighterBean.getFighter_id()){
                        monsterList_in_heroList.add(fighterBean);
                    }
                }
            }
        }

        for(int h = 0; h < monsterList_in_heroList.size(); h++){
            sum_hero_hp_num += monsterList_in_heroList.get(h).getHp_num();
        }

//        String return__ =  "5{id:"+enemyTeamStr+",Result:0}";
        String return__ =  "{id:"+Integer.valueOf((String)session1.getAttribute("_JewelScore"))+",chestnum:"+Integer.valueOf((String)session1.getAttribute("_ChestNum"))+",enemyhp:"+sum_enemy_hp_num+",herohp:"+sum_hero_hp_num+",Result:0}";

        System.out.println(return__);

        out_.write(return__.getBytes("GBK"));
        out_.println();
        out_.close();

    }

}
