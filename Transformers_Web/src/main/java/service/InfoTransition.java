package service;

import com.fancyy.json.util.JSON;
import elements.EnemyTeam;
import elements.Hero;
import elements.HeroTeam;
import elements.UserAccount;
import elements.armorbase.EquipItem;
import elements.armorbase.Technique;
import elements.screen.TeamScreenItemObj;
import elements.screen.TitleItem;
import elements.LevelItem;


import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: tongxiqing
 * Date: 14-8-29
 * Time: ÏÂÎç8:23
 * To change this template use File | Settings | File Templates.
 */
public class InfoTransition {

    public static void main(String[] args){
//        initialHeroData();
    }

    public static String updateHeroData(String selectIndex, UserAccount userAccount) {

        if(userAccount != null){
            userAccount.getRoleAccountList().get(0).getHeroList().get(Integer.valueOf(selectIndex)).setGot_flag(true);
        }
        String json = JSON.toJson(userAccount);
        return json;
    }

    public static  String setEnemyTeam(int stageIndex){
        List<EnemyTeam> enemyTeamList = new ArrayList<EnemyTeam>();

        if(stageIndex==0){

            EnemyTeam  enemyTeam = new EnemyTeam("right_horseImg",1,10,0.3,false);
            enemyTeamList.add(enemyTeam);
            enemyTeam = new EnemyTeam("right_horseImg",1,10,0.3,false);
            enemyTeamList.add(enemyTeam);
            enemyTeam = new EnemyTeam("right_batImg",2,10,0.3,false);
            enemyTeamList.add(enemyTeam);
            enemyTeam = new EnemyTeam("right_batImg",2,10,0.3,false);
            enemyTeamList.add(enemyTeam);
            enemyTeam = new EnemyTeam("renwu_Img",0,10,0.3,false);
            enemyTeamList.add(enemyTeam);

        }else if(stageIndex == 1){
            EnemyTeam  enemyTeam = new EnemyTeam("right_batImg",1,13.5,0.4,false);
            enemyTeamList.add(enemyTeam);

            enemyTeam = new EnemyTeam("right_batImg",1,13.5,0.4,false);
            enemyTeamList.add(enemyTeam);
            enemyTeam = new EnemyTeam("right_batImg",1,13.5,0.4,false);
            enemyTeamList.add(enemyTeam);
            enemyTeam = new EnemyTeam("right_birdImg",2,13.5,0.4,false);
            enemyTeamList.add(enemyTeam);
            enemyTeam = new EnemyTeam("atack_Img",0,13.5,0.4,false);
            enemyTeamList.add(enemyTeam);

        } else if(stageIndex == 2){

            EnemyTeam  enemyTeam = new EnemyTeam("right_birdImg",1,15.0,0.6,false);
            enemyTeamList.add(enemyTeam);
            enemyTeam = new EnemyTeam("right_birdImg",1,15.0,0.6,false);
            enemyTeamList.add(enemyTeam);
            enemyTeam = new EnemyTeam("right_birdImg",1,15.0,0.6,false);
            enemyTeamList.add(enemyTeam);
            enemyTeam = new EnemyTeam("right_clownImg",2,15.0,0.6,false);
            enemyTeamList.add(enemyTeam);
            enemyTeam = new EnemyTeam("renwu_Img",0,15.0,0.6,false);
            enemyTeamList.add(enemyTeam);
        }else if(stageIndex == 3){
            EnemyTeam   enemyTeam = new EnemyTeam("right_batImg",1,16.5,0.8,false);
            enemyTeamList.add(enemyTeam);

            enemyTeam = new EnemyTeam("right_batImg",1,16.5,0.8,false);
            enemyTeamList.add(enemyTeam);

            enemyTeam = new EnemyTeam("right_batImg",1,16.5,0.8,false);
            enemyTeamList.add(enemyTeam);

            enemyTeam = new EnemyTeam("right_clownImg",2,16.5,0.8,false);
            enemyTeamList.add(enemyTeam);
            enemyTeam = new EnemyTeam("atack_Img",0,16.5,0.8,false);
            enemyTeamList.add(enemyTeam);

        }else if(stageIndex == 4){

            EnemyTeam    enemyTeam = new EnemyTeam("right_birdImg",1,18.0,1.0,false);
            enemyTeamList.add(enemyTeam);

            enemyTeam = new EnemyTeam("right_birdImg",1,18.0,1.0,false);
            enemyTeamList.add(enemyTeam);

            enemyTeam = new EnemyTeam("right_clownImg",2,18.0,1.0,false);
            enemyTeamList.add(enemyTeam);
            enemyTeam = new EnemyTeam("right_clownImg",2,18.0,1.0,false);
            enemyTeamList.add(enemyTeam);
            enemyTeam = new EnemyTeam("atack_Img",0,18.0,1.0,false);
            enemyTeamList.add(enemyTeam);

        }

        else if(stageIndex == 5){

            EnemyTeam  enemyTeam = new EnemyTeam("right_batImg",1,19.5,1.2,false);
            enemyTeamList.add(enemyTeam);

            enemyTeam = new EnemyTeam("right_batImg",1,19.5,1.2,false);
            enemyTeamList.add(enemyTeam);

            enemyTeam = new EnemyTeam("right_frogfishImg",2,19.5,1.2,false);
            enemyTeamList.add(enemyTeam);

            enemyTeam = new EnemyTeam("right_frogfishImg",2,19.5,1.2,false);
            enemyTeamList.add(enemyTeam);
            enemyTeam = new EnemyTeam("green_monster_Img",0,19.5,1.2,false);
            enemyTeamList.add(enemyTeam);

        }else if(stageIndex == 6){


            EnemyTeam  enemyTeam = new EnemyTeam("right_birdImg",1,21.0,1.5,false);
            enemyTeamList.add(enemyTeam);

            enemyTeam = new EnemyTeam("right_birdImg",1,21.0,1.5,false);
            enemyTeamList.add(enemyTeam);

            enemyTeam = new EnemyTeam("right_frogfishImg",2,21.0,1.5,false);
            enemyTeamList.add(enemyTeam);

            enemyTeam = new EnemyTeam("right_frogfishImg",2,21.0,1.5,false);
            enemyTeamList.add(enemyTeam);
            enemyTeam = new EnemyTeam("green_monster_Img",0,21.0,1.5,false);
            enemyTeamList.add(enemyTeam);
        }else if(stageIndex == 7){
            EnemyTeam  enemyTeam = new EnemyTeam("right_birdImg",1,22.5,1.7,false);
            enemyTeamList.add(enemyTeam);

            enemyTeam = new EnemyTeam("right_birdImg",1,22.5,1.7,false);
            enemyTeamList.add(enemyTeam);

            enemyTeam = new EnemyTeam("right_frogfishImg",2,22.5,1.7,false);
            enemyTeamList.add(enemyTeam);

            enemyTeam = new EnemyTeam("right_frogfishImg",2,22.5,1.7,false);
            enemyTeamList.add(enemyTeam);
            enemyTeam = new EnemyTeam("green_monster_Img",0,22.5,1.7,false);
            enemyTeamList.add(enemyTeam);
        }else if(stageIndex == 8){
            EnemyTeam    enemyTeam = new EnemyTeam("right_horseImg",1,24.0,1.9,false);
            enemyTeamList.add(enemyTeam);

            enemyTeam = new EnemyTeam("right_horseImg",1,24.0,1.9,false);
            enemyTeamList.add(enemyTeam);

            enemyTeam = new EnemyTeam("right_frogfishImg",2,24.0,1.9,false);
            enemyTeamList.add(enemyTeam);

            enemyTeam = new EnemyTeam("right_frogfishImg",2,24.0,1.9,false);
            enemyTeamList.add(enemyTeam);
            enemyTeam = new EnemyTeam("green_monster_Img",0,24.0,1.9,false);
            enemyTeamList.add(enemyTeam);
        }else if(stageIndex == 9){
            EnemyTeam  enemyTeam = new EnemyTeam("right_clownImg",1,25.5,2.1,false);
            enemyTeamList.add(enemyTeam);

            enemyTeam = new EnemyTeam("right_clownImg",1,25.5,2.1,false);
            enemyTeamList.add(enemyTeam);

            enemyTeam = new EnemyTeam("right_frogfishImg",2,25.5,2.1,false);
            enemyTeamList.add(enemyTeam);

            enemyTeam = new EnemyTeam("right_frogfishImg",2,25.5,2.1,false);
            enemyTeamList.add(enemyTeam);

            enemyTeam = new EnemyTeam("hero_right_blueImg",0,25.5,2.1,false);
            enemyTeamList.add(enemyTeam);

        }else if(stageIndex == 10){
            EnemyTeam    enemyTeam = new EnemyTeam(" right_batImg",1,27.0,2.3,false);
            enemyTeamList.add(enemyTeam);

            enemyTeam = new EnemyTeam(" right_batImg",1,27.0,2.3,false);
            enemyTeamList.add(enemyTeam);

            enemyTeam = new EnemyTeam("right_mouseImg",2,27.0,2.3,false);
            enemyTeamList.add(enemyTeam);

            enemyTeam = new EnemyTeam("right_mouseImg",2,27.0,2.3,false);
            enemyTeamList.add(enemyTeam);
            enemyTeam = new EnemyTeam("king_monster_Img",0,27.0,2.3,false);
            enemyTeamList.add(enemyTeam);



        }else if(stageIndex == 11){
            EnemyTeam enemyTeam = new EnemyTeam("right_birdImg",1,28.5,2.5,false);
            enemyTeamList.add(enemyTeam);

            enemyTeam = new EnemyTeam("right_birdImg",1,28.5,2.5,false);
            enemyTeamList.add(enemyTeam);

            enemyTeam = new EnemyTeam("right_mouseImg",2,28.5,2.5,false);
            enemyTeamList.add(enemyTeam);

            enemyTeam = new EnemyTeam("right_mouseImg",2,28.5,2.5,false);
            enemyTeamList.add(enemyTeam);
            enemyTeam = new EnemyTeam("king_monster_Img",0,28.5,2.5,false);
            enemyTeamList.add(enemyTeam);


        } else if(stageIndex == 12){
            EnemyTeam  enemyTeam = new EnemyTeam("right_birdImg",1,30.0,2.7,false);
            enemyTeamList.add(enemyTeam);

            enemyTeam = new EnemyTeam("right_birdImg ",1,30.0,2.7,false);
            enemyTeamList.add(enemyTeam);

            enemyTeam = new EnemyTeam("right_mouseImg",2,30.0,2.7,false);
            enemyTeamList.add(enemyTeam);

            enemyTeam = new EnemyTeam("right_mouseImg",2,30.0,2.7,false);
            enemyTeamList.add(enemyTeam);
            enemyTeam = new EnemyTeam("king_monster_Img",0,30.0,2.7,false);
            enemyTeamList.add(enemyTeam);


        }else if(stageIndex == 13){
            EnemyTeam   enemyTeam = new EnemyTeam("right_clownImg",1,31.5,2.9,false);
            enemyTeamList.add(enemyTeam);

            enemyTeam = new EnemyTeam("right_clownImg",1,31.5,2.9,false);
            enemyTeamList.add(enemyTeam);

            enemyTeam = new EnemyTeam("right_mouseImg ",2,31.5,2.9,false);
            enemyTeamList.add(enemyTeam);

            enemyTeam = new EnemyTeam("right_mouseImg ",2,31.5,2.9,false);
            enemyTeamList.add(enemyTeam);
            enemyTeam = new EnemyTeam("white_wolf_Img",0,31.5,2.9,false);
            enemyTeamList.add(enemyTeam);


        }else if(stageIndex == 14){
            EnemyTeam enemyTeam = new EnemyTeam("right_frogfishImg",1,33.0,3.1,false);
            enemyTeamList.add(enemyTeam);

            enemyTeam = new EnemyTeam("right_frogfishImg",1,33.0,3.1,false);
            enemyTeamList.add(enemyTeam);

            enemyTeam = new EnemyTeam("right_mouseImg",2,33.0,3.1,false);
            enemyTeamList.add(enemyTeam);

            enemyTeam = new EnemyTeam("right_mouseImg",2,33.0,3.1,false);
            enemyTeamList.add(enemyTeam);
            enemyTeam = new EnemyTeam("white_wolf_Img",0,33.0,3.1,false);
            enemyTeamList.add(enemyTeam);
        }else if(stageIndex == 15){
            EnemyTeam  enemyTeam = new EnemyTeam("right_horseImg",1,34.5,3.3,false);
            enemyTeamList.add(enemyTeam);

            enemyTeam = new EnemyTeam("right_horseImg",1,34.5,3.3,false);
            enemyTeamList.add(enemyTeam);

            enemyTeam = new EnemyTeam("right_rabbitImg",2,34.5,3.3,false);
            enemyTeamList.add(enemyTeam);

            enemyTeam = new EnemyTeam("right_rabbitImg",2,34.5,3.3,false);
            enemyTeamList.add(enemyTeam);
            enemyTeam = new EnemyTeam("hammer_Img",0,34.5,3.3,false);
            enemyTeamList.add(enemyTeam);
        }else if(stageIndex == 16){
            EnemyTeam enemyTeam = new EnemyTeam("right_batImg",1,35.0,3.5,false);
            enemyTeamList.add(enemyTeam);

            enemyTeam = new EnemyTeam("right_batImg",1,35.0,3.5,false);
            enemyTeamList.add(enemyTeam);

            enemyTeam = new EnemyTeam("right_rabbitImg",2,35.0,3.5,false);
            enemyTeamList.add(enemyTeam);

            enemyTeam = new EnemyTeam("right_rabbitImg",2,35.0,3.5,false);
            enemyTeamList.add(enemyTeam);
            enemyTeam = new EnemyTeam("hammer_Img",0,35.0,3.5,false);
            enemyTeamList.add(enemyTeam);
        }else if(stageIndex == 17){


            EnemyTeam  enemyTeam = new EnemyTeam("right_birdImg",1,36.5,3.5,false);
            enemyTeamList.add(enemyTeam);

            enemyTeam = new EnemyTeam("right_birdImg",1,36.5,3.5,false);
            enemyTeamList.add(enemyTeam);

            enemyTeam = new EnemyTeam("right_rabbitImg",2,36.5,3.5,false);
            enemyTeamList.add(enemyTeam);

            enemyTeam = new EnemyTeam("right_rabbitImg",2,36.5,3.5,false);
            enemyTeamList.add(enemyTeam);
            enemyTeam = new EnemyTeam("hammer_Img",0,36.5,3.5,false);
            enemyTeamList.add(enemyTeam);
        }else if(stageIndex == 18){


            EnemyTeam  enemyTeam = new EnemyTeam("right_clownImg",1,38.0,3.9,false);
            enemyTeamList.add(enemyTeam);

            enemyTeam = new EnemyTeam("right_clownImg",1,38.0,3.9,false);
            enemyTeamList.add(enemyTeam);

            enemyTeam = new EnemyTeam("right_rabbitImg",2,38.0,3.9,false);
            enemyTeamList.add(enemyTeam);

            enemyTeam = new EnemyTeam("right_rabbitImg",2,38.0,3.9,false);
            enemyTeamList.add(enemyTeam);
            enemyTeam = new EnemyTeam("hammer_Img",0,38.0,3.9,false);
            enemyTeamList.add(enemyTeam);
        }else if(stageIndex == 19){

            EnemyTeam enemyTeam = new EnemyTeam("right_frogfishImg",1,39.5,4.1,false);
            enemyTeamList.add(enemyTeam);

            enemyTeam = new EnemyTeam("right_frogfishImg",1,39.5,4.1,false);
            enemyTeamList.add(enemyTeam);

            enemyTeam = new EnemyTeam("right_rabbitImg",2,39.5,4.1,false);
            enemyTeamList.add(enemyTeam);

            enemyTeam = new EnemyTeam("right_rabbitImg",2,39.5,4.1,false);
            enemyTeamList.add(enemyTeam);
            enemyTeam = new EnemyTeam(" hero_right_greenImg",0,39.5,4.1,false);
            enemyTeamList.add(enemyTeam);

        }else if(stageIndex == 20){

            EnemyTeam enemyTeam = new EnemyTeam("right_mouseImg",1,41.0,4.3,false);
            enemyTeamList.add(enemyTeam);

            enemyTeam = new EnemyTeam("right_mouseImg",1,41.0,4.3,false);
            enemyTeamList.add(enemyTeam);

            enemyTeam = new EnemyTeam("right_rabbitImg",2,41.0,4.3,false);
            enemyTeamList.add(enemyTeam);

            enemyTeam = new EnemyTeam("right_rabbitImg",2,41.0,4.3,false);
            enemyTeamList.add(enemyTeam);
            enemyTeam = new EnemyTeam("hammer_Img",0,41.0,4.3,false);
            enemyTeamList.add(enemyTeam);

        }else if(stageIndex == 21){


            EnemyTeam   enemyTeam = new EnemyTeam("right_horseImg",1,43.5,4.5,false);
            enemyTeamList.add(enemyTeam);

            enemyTeam = new EnemyTeam("right_horseImg",1,43.5,4.5,false);
            enemyTeamList.add(enemyTeam);

            enemyTeam = new EnemyTeam(" right_tigerImg",2,43.5,4.5,false);
            enemyTeamList.add(enemyTeam);

            enemyTeam = new EnemyTeam(" right_tigerImg",2,43.5,4.5,false);
            enemyTeamList.add(enemyTeam);
            enemyTeam = new EnemyTeam("blue2_monster_Img",0,43.5,4.5,false);
            enemyTeamList.add(enemyTeam);
        } else if(stageIndex == 22){


            EnemyTeam enemyTeam = new EnemyTeam("right_batImg",1,45.0,4.7,false);
            enemyTeamList.add(enemyTeam);

            enemyTeam = new EnemyTeam("right_batImg",1,45.0,4.7,false);
            enemyTeamList.add(enemyTeam);

            enemyTeam = new EnemyTeam("right_tigerImg",2,45.0,4.7,false);
            enemyTeamList.add(enemyTeam);

            enemyTeam = new EnemyTeam("right_tigerImg",2,45.0,4.7,false);
            enemyTeamList.add(enemyTeam);
            enemyTeam = new EnemyTeam("blue2_monster_Img",0,45.0,4.7,false);
            enemyTeamList.add(enemyTeam);
        }else if(stageIndex == 23){

            EnemyTeam   enemyTeam = new EnemyTeam("right_birdImg",1,46.5,4.7,false);
            enemyTeamList.add(enemyTeam);

            enemyTeam = new EnemyTeam("right_birdImg",1,46.5,4.7,false);
            enemyTeamList.add(enemyTeam);

            enemyTeam = new EnemyTeam("right_tigerImg",2,46.5,4.7,false);
            enemyTeamList.add(enemyTeam);

            enemyTeam = new EnemyTeam("right_tigerImg",2,46.5,4.7,false);
            enemyTeamList.add(enemyTeam);
            enemyTeam = new EnemyTeam("blue2_monster_Img",0,46.5,4.7,false);
            enemyTeamList.add(enemyTeam);

        }else if(stageIndex == 24){


            EnemyTeam   enemyTeam = new EnemyTeam("right_birdImg",1,48.0,5.1,false);
            enemyTeamList.add(enemyTeam);

            enemyTeam = new EnemyTeam("right_birdImg",1,48.0,5.1,false);
            enemyTeamList.add(enemyTeam);

            enemyTeam = new EnemyTeam("right_tigerImg",2,48.0,5.1,false);
            enemyTeamList.add(enemyTeam);

            enemyTeam = new EnemyTeam("right_tigerImg",2,48.0,5.1,false);
            enemyTeamList.add(enemyTeam);
            enemyTeam = new EnemyTeam("blue2_monster_Img",0,48.0,5.1,false);
            enemyTeamList.add(enemyTeam);
        }else if(stageIndex == 25){

            EnemyTeam    enemyTeam = new EnemyTeam("right_clownImg",1,49.5,5.1,false);
            enemyTeamList.add(enemyTeam);

            enemyTeam = new EnemyTeam("right_clownImg",1,49.5,5.1,false);
            enemyTeamList.add(enemyTeam);

            enemyTeam = new EnemyTeam("right_tigerImg",2,49.5,5.1,false);
            enemyTeamList.add(enemyTeam);

            enemyTeam = new EnemyTeam("right_tigerImg",2,49.5,5.1,false);
            enemyTeamList.add(enemyTeam);
            enemyTeam = new EnemyTeam("blue2_monster_Img",0,49.5,5.1,false);
            enemyTeamList.add(enemyTeam);

        }else if(stageIndex == 26){


            EnemyTeam   enemyTeam = new EnemyTeam("right_clownImg",1,51.0,5.5,false);
            enemyTeamList.add(enemyTeam);

            enemyTeam = new EnemyTeam("right_clownImg",1,51.0,5.5,false);
            enemyTeamList.add(enemyTeam);

            enemyTeam = new EnemyTeam(" right_tigerImg ",2,51.0,5.5,false);
            enemyTeamList.add(enemyTeam);

            enemyTeam = new EnemyTeam(" right_tigerImg ",2,51.0,5.5,false);
            enemyTeamList.add(enemyTeam);
            enemyTeam = new EnemyTeam("blue2_monster_Img",0,51.0,5.5,false);
            enemyTeamList.add(enemyTeam);
        }else if(stageIndex == 27){


            EnemyTeam  enemyTeam = new EnemyTeam(" right_frogfishImg",1,52.5,5.5,false);
            enemyTeamList.add(enemyTeam);

            enemyTeam = new EnemyTeam("  right_frogfishImg",1,52.5,5.5,false);
            enemyTeamList.add(enemyTeam);

            enemyTeam = new EnemyTeam("right_tigerImg",2,52.5,5.5,false);
            enemyTeamList.add(enemyTeam);

            enemyTeam = new EnemyTeam("right_tigerImg",2,52.5,5.5,false);
            enemyTeamList.add(enemyTeam);
            enemyTeam = new EnemyTeam("blue2_monster_Img",0,52.5,5.5,false);
            enemyTeamList.add(enemyTeam);
        }else if(stageIndex == 28){


            EnemyTeam  enemyTeam = new EnemyTeam("right_mouseImg",1,54.0,5.9,false);
            enemyTeamList.add(enemyTeam);

            enemyTeam = new EnemyTeam("right_mouseImg",1,54.0,5.9,false);
            enemyTeamList.add(enemyTeam);

            enemyTeam = new EnemyTeam("right_tigerImg ",2,54.0,5.9,false);
            enemyTeamList.add(enemyTeam);

            enemyTeam = new EnemyTeam("right_tigerImg ",2,54.0,5.9,false);
            enemyTeamList.add(enemyTeam);
            enemyTeam = new EnemyTeam("blue2_monster_Img",0,54.0,5.9,false);
            enemyTeamList.add(enemyTeam);
        }else if(stageIndex == 29){


            EnemyTeam enemyTeam = new EnemyTeam("right_rabbitImg",1,55.5,6.1,false);
            enemyTeamList.add(enemyTeam);

            enemyTeam = new EnemyTeam("right_rabbitImg",1,55.5,6.1,false);
            enemyTeamList.add(enemyTeam);

            enemyTeam = new EnemyTeam("right_tigerImg ",2,55.5,6.1,false);
            enemyTeamList.add(enemyTeam);

            enemyTeam = new EnemyTeam("right_tigerImg ",2,55.5,6.1,false);
            enemyTeamList.add(enemyTeam);
            enemyTeam = new EnemyTeam(" hero_right_rightImg",0,55.5,6.1,false);
            enemyTeamList.add(enemyTeam);
        }else if(stageIndex == 30){


            EnemyTeam  enemyTeam = new EnemyTeam("right_clownImg",1,57.0,6.3,false);
            enemyTeamList.add(enemyTeam);

            enemyTeam = new EnemyTeam("right_clownImg",1,57.0,6.3,false);
            enemyTeamList.add(enemyTeam);

            enemyTeam = new EnemyTeam("right_tortoiseImg",2,57.0,6.3,false);
            enemyTeamList.add(enemyTeam);

            enemyTeam = new EnemyTeam("right_tortoiseImg",2,57.0,6.3,false);
            enemyTeamList.add(enemyTeam);
            enemyTeam = new EnemyTeam("red_wolf_Img",0,57.0,6.3,false);
            enemyTeamList.add(enemyTeam);
        }else if(stageIndex == 31){


            EnemyTeam  enemyTeam = new EnemyTeam("right_mouseImg",1,58.5,6.3,false);
            enemyTeamList.add(enemyTeam);

            enemyTeam = new EnemyTeam("right_mouseImg",1,58.5,6.3,false);
            enemyTeamList.add(enemyTeam);

            enemyTeam = new EnemyTeam("right_tigerImg",2,58.5,6.3,false);
            enemyTeamList.add(enemyTeam);

            enemyTeam = new EnemyTeam("right_tigerImg",2,58.5,6.3,false);
            enemyTeamList.add(enemyTeam);
            enemyTeam = new EnemyTeam("blue_bear_Img",0,58.5,6.3,false);
            enemyTeamList.add(enemyTeam);
        } else if(stageIndex == 32){


            EnemyTeam enemyTeam = new EnemyTeam("right_rabbitImg",1,60.0,6.7,false);
            enemyTeamList.add(enemyTeam);

            enemyTeam = new EnemyTeam("right_rabbitImg",1,60.0,6.7,false);
            enemyTeamList.add(enemyTeam);

            enemyTeam = new EnemyTeam("right_tortoiseImg",2,60.0,6.7,false);
            enemyTeamList.add(enemyTeam);

            enemyTeam = new EnemyTeam("right_tortoiseImg",2,60.0,6.7,false);
            enemyTeamList.add(enemyTeam);
            enemyTeam = new EnemyTeam("yellow_king_Img ",0,60.0,6.7,false);
            enemyTeamList.add(enemyTeam);
        }else if(stageIndex == 33){


            EnemyTeam enemyTeam = new EnemyTeam(" right_tigerImg",1,61.5,7.0,false);
            enemyTeamList.add(enemyTeam);

            enemyTeam = new EnemyTeam(" right_tigerImg",1,61.5,7.0,false);
            enemyTeamList.add(enemyTeam);

            enemyTeam = new EnemyTeam("right_tortoiseImg",2,61.5,7.0,false);
            enemyTeamList.add(enemyTeam);

            enemyTeam = new EnemyTeam("right_tortoiseImg",2,61.5,7.0,false);
            enemyTeamList.add(enemyTeam);
            enemyTeam = new EnemyTeam("blue_bear_Img",0,61.5,7.0,false);
            enemyTeamList.add(enemyTeam);
        }else if(stageIndex == 34){


            EnemyTeam   enemyTeam = new EnemyTeam("blue_bear_Img",1,63.0,7.3,false);
            enemyTeamList.add(enemyTeam);

            enemyTeam = new EnemyTeam("blue_bear_Img",1,63.0,7.3,false);
            enemyTeamList.add(enemyTeam);

            enemyTeam = new EnemyTeam("right_rabbitImg",2,63.0,7.3,false);
            enemyTeamList.add(enemyTeam);

            enemyTeam = new EnemyTeam("right_rabbitImg",2,63.0,7.3,false);
            enemyTeamList.add(enemyTeam);
            enemyTeam = new EnemyTeam("hero_right_LredImg",0,63.0,7.3,false);
            enemyTeamList.add(enemyTeam);
        }else if(stageIndex == 35){


            EnemyTeam    enemyTeam = new EnemyTeam("right_rabbitImg",1,64.5,7.4,false);
            enemyTeamList.add(enemyTeam);

            enemyTeam = new EnemyTeam("right_rabbitImg",1,64.5,7.4,false);
            enemyTeamList.add(enemyTeam);

            enemyTeam = new EnemyTeam("right_rabbitImg",2,64.5,7.4,false);
            enemyTeamList.add(enemyTeam);

            enemyTeam = new EnemyTeam("right_rabbitImg",2,64.5,7.4,false);
            enemyTeamList.add(enemyTeam);
            enemyTeam = new EnemyTeam("yellow_king_Img",0,64.5,7.4,false);
            enemyTeamList.add(enemyTeam);
        }else if(stageIndex == 36){


            EnemyTeam  enemyTeam = new EnemyTeam("right_mouseImg ",1,66.0,7.7,false);
            enemyTeamList.add(enemyTeam);

            enemyTeam = new EnemyTeam("right_mouseImg",1,66.0,7.7,false);
            enemyTeamList.add(enemyTeam);

            enemyTeam = new EnemyTeam("right_tigerImg",2,66.0,7.7,false);
            enemyTeamList.add(enemyTeam);

            enemyTeam = new EnemyTeam("right_tigerImg",2,66.0,7.7,false);
            enemyTeamList.add(enemyTeam);
            enemyTeam = new EnemyTeam("yellow_king_Img",0,66.0,7.7,false);
            enemyTeamList.add(enemyTeam);
        }else if(stageIndex == 37){


            EnemyTeam enemyTeam = new EnemyTeam("right_tigerImg",1,67.5,8.0,false);
            enemyTeamList.add(enemyTeam);

            enemyTeam = new EnemyTeam("right_tigerImg",1,67.5,8.0,false);
            enemyTeamList.add(enemyTeam);

            enemyTeam = new EnemyTeam("right_tortoiseImg",2,67.5,8.0,false);
            enemyTeamList.add(enemyTeam);

            enemyTeam = new EnemyTeam("right_tortoiseImg",2,67.5,8.0,false);
            enemyTeamList.add(enemyTeam);
            enemyTeam = new EnemyTeam("gun_king_Img",0,67.5,8.0,false);
            enemyTeamList.add(enemyTeam);
        }else if(stageIndex == 38){


            EnemyTeam    enemyTeam = new EnemyTeam("right_rabbitImg",1,68.0,8.3,false);
            enemyTeamList.add(enemyTeam);

            enemyTeam = new EnemyTeam("right_rabbitImg",1,68.0,8.3,false);
            enemyTeamList.add(enemyTeam);

            enemyTeam = new EnemyTeam("right_tigerImg ",2,68.0,8.3,false);
            enemyTeamList.add(enemyTeam);

            enemyTeam = new EnemyTeam("right_tigerImg ",2,68.0,8.3,false);
            enemyTeamList.add(enemyTeam);
            enemyTeam = new EnemyTeam("blue_monster_Img ",0,68.0,8.3,false);
            enemyTeamList.add(enemyTeam);
        }else if(stageIndex == 39){

            EnemyTeam   enemyTeam = new EnemyTeam("right_tigerImg",1,69.5,8.6,false);
            enemyTeamList.add(enemyTeam);

            enemyTeam = new EnemyTeam("right_tigerImg",1,69.5,8.6,false);
            enemyTeamList.add(enemyTeam);

            enemyTeam = new EnemyTeam("right_tortoiseImg",2,69.5,8.6,false);
            enemyTeamList.add(enemyTeam);

            enemyTeam = new EnemyTeam("right_tortoiseImg",2,69.5,8.6,false);
            enemyTeamList.add(enemyTeam);
            enemyTeam = new EnemyTeam("blue_monster_Img ",0,69.5,8.6,false);
            enemyTeamList.add(enemyTeam);

        }else if(stageIndex == 40){


            EnemyTeam   enemyTeam = new EnemyTeam("blue_monster_Img",1,71.0,8.8,false);
            enemyTeamList.add(enemyTeam);

            enemyTeam = new EnemyTeam("blue_monster_Img ",1,71.0,8.8,false);
            enemyTeamList.add(enemyTeam);

            enemyTeam = new EnemyTeam("right_tortoiseImg",2,71.0,8.8,false);
            enemyTeamList.add(enemyTeam);

            enemyTeam = new EnemyTeam("right_tortoiseImg",2,71.0,8.8,false);
            enemyTeamList.add(enemyTeam);
            enemyTeam = new EnemyTeam("hero_right_LyellowImg",0,71.0,8.8,false);
            enemyTeamList.add(enemyTeam);
        }
        String json = JSON.toJson(enemyTeamList);
        return json;
    }


    public static String updateHeroTeam(TeamScreenItemObj teamScreenItemObj,int type, int hero_index){

        int tmp_num =-1;

        for (int i =0 ; i<teamScreenItemObj.getTitleItemList().size(); i++){
            if(teamScreenItemObj.getTitleItemList().get(i).getType()==type){
                tmp_num++;
            }
            if(tmp_num == hero_index){
                teamScreenItemObj.getTitleItemList().get(i).setSelected_flag(false);
            }
        }

        String json = JSON.toJson(teamScreenItemObj);

        return json;
    }

    public static String updateEnemyTeam(List<EnemyTeam> enemyTeamList,int enemy_index){

        enemyTeamList.get(enemy_index).setDead(true);
        enemyTeamList.get(enemy_index).setFight_number(0);

        String json = JSON.toJson(enemyTeamList);

        return json;
    }

    public static  String setHeroTeam(){
        HeroTeam heroTeam = new HeroTeam();
        heroTeam.setHeroName("hero_right_blueImg");
        heroTeam.setFollow1Name("renwu_Img");
        heroTeam.setFollow2Name("white_wolf_Img");
        heroTeam.setPet1Name("pet_horseImg");
        heroTeam.setPet2Name("pet_batImg");

        String json = JSON.toJson(heroTeam);
        return json;
    }

    public static String addTeamScreenItemObj(TeamScreenItemObj teamScreenItemObj,int item_index){
        int tem_item_index = -1;
        int selected_item_sum = 0;
        int already_selected_item_sum = 0;

        if(teamScreenItemObj != null){
            List<TitleItem> titleItemList = teamScreenItemObj.getTitleItemList();
            for(int i=0; i<titleItemList.size();i++){
                if(titleItemList.get(i).isSelected_flag()){
                    selected_item_sum ++;
                }
            }

            if(selected_item_sum < 6){
                for(int i=0; i<titleItemList.size();i++){
                    if(!titleItemList.get(i).isSelected_flag()){
                        tem_item_index++;
                    }
                    if(tem_item_index == item_index){
                        titleItemList.get(i).setSelected_flag(true);

                        for(int j=0; j<titleItemList.size();j++){
                            if(titleItemList.get(j).getType()==titleItemList.get(i).getType()&&titleItemList.get(j).isSelected_flag()){
                                already_selected_item_sum ++;
                                if(titleItemList.get(j).getType()==1&&already_selected_item_sum>1){
                                    titleItemList.get(i).setSelected_flag(false);
                                    break;
                                }else if(titleItemList.get(j).getType()==2&&already_selected_item_sum>2){
                                    titleItemList.get(i).setSelected_flag(false);
                                    break;
                                }else if(titleItemList.get(j).getType()==3&&already_selected_item_sum>2){
                                    titleItemList.get(i).setSelected_flag(false);
                                    break;
                                }

                            }
                        }

                        break;
                    }
                }
            }

        }

        String json = JSON.toJson(teamScreenItemObj);
        return json;
    }

    public static String removeTeamScreenItemObj(TeamScreenItemObj teamScreenItemObj,int selected_item_index){
        int tem_item_index = -1;

        if(teamScreenItemObj != null){
            List<TitleItem> titleItemList = teamScreenItemObj.getTitleItemList();

            for(int i=0; i<titleItemList.size();i++){
                if(titleItemList.get(i).isSelected_flag()){
                    tem_item_index++;
                }
                if(tem_item_index == selected_item_index){
                    titleItemList.get(i).setSelected_flag(false);
                    break;
                }
            }

        }

        String json = JSON.toJson(teamScreenItemObj);
        return json;
    }





}
