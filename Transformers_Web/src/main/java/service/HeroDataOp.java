package service;

import beans.EquipMaxIndexBean;
import beans.FighterBean;
import beans.FighterItemBean;
import com.fancyy.json.util.JSON;
import common.PropertiesOp;
import elements.Hero;
import elements.HeroItem;
import elements.armorbase.EquipItem;
import elements.armorbase.Technique;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: tongxiqing
 * Date: 14-9-28
 * Time: 下午10:29
 * To change this template use File | Settings | File Templates.
 */
public class HeroDataOp {

    private static final String propname1 = "/visible_title_img_path.properties";
    private static final String propname2 = "/visible_pet_title_img_path.properties";
    private static final String propname3 = "/initial/herodata.properties";

    public static EquipMaxIndexBean initialEquipMaxIndex(){
        EquipMaxIndexBean equipMaxIndexBean = new EquipMaxIndexBean(0,0,0,0,0,0,0);
//        String json = JSON.toJson(equipMaxIndexBean);
        return equipMaxIndexBean;
    }

    public static String initialFighterData(){
        PropertiesOp propertiesOp = new PropertiesOp();
        Properties properties = propertiesOp.load(propname3);

//        return (List<HeroItem>) JSON.toObject(properties.getProperty("herodata"),HeroItem.class);
        System.out.println(properties.getProperty("fighterdata"));
        return properties.getProperty("fighterdata");
    }

    public static String initialHeroData(){
        PropertiesOp propertiesOp = new PropertiesOp();
        Properties properties = propertiesOp.load(propname3);

        return properties.getProperty("herodata");
    }

    public static String initialMonsterData(){
        PropertiesOp propertiesOp = new PropertiesOp();
        Properties properties = propertiesOp.load(propname3);

        return properties.getProperty("monsterdata");
    }

    public static String initialPetData(){
        PropertiesOp propertiesOp = new PropertiesOp();
        Properties properties = propertiesOp.load(propname3);

        return properties.getProperty("petdata");
    }

//    public static String initialHero2Data(){
//        PropertiesOp propertiesOp = new PropertiesOp();
//        Properties properties = propertiesOp.load(propname3);
//        return properties.getProperty("hero2");
//    }
//
//
//    public static String initialHero3Data(){
//        PropertiesOp propertiesOp = new PropertiesOp();
//        Properties properties = propertiesOp.load(propname3);
//        return properties.getProperty("hero3");
//    }

    public static String upgradeHeroLevel(List<FighterItemBean> heroList,int hero_index){
        heroList.get(hero_index).setStar_nums(heroList.get(hero_index).getStar_nums()+1);
        heroList.get(hero_index).setHp_num(heroList.get(hero_index).getHp_num()+5);    /**使血量快于攻击力*/
        heroList.get(hero_index).setFight_num(heroList.get(hero_index).getFight_num()+2);
        String json = JSON.toJson(heroList);
        return json;
    }

    public static String upgradeFollowLevel(List<FighterItemBean> fighterList,int hero_index){
        fighterList.get(hero_index).setStar_nums(fighterList.get(hero_index).getStar_nums()+1);
        fighterList.get(hero_index).setHp_num(fighterList.get(hero_index).getHp_num()+5);  /**使血量快于攻击力*/
        fighterList.get(hero_index).setFight_num(fighterList.get(hero_index).getFight_num()+2);
        String json = JSON.toJson(fighterList);
        return json;
    }

    public static String upgradePetLevel(List<FighterItemBean> fighterList,int hero_index){
        fighterList.get(hero_index).setStar_nums(fighterList.get(hero_index).getStar_nums()+1);
        fighterList.get(hero_index).setHp_num(fighterList.get(hero_index).getHp_num()+5);  /**使血量快于攻击力*/
        fighterList.get(hero_index).setFight_num(fighterList.get(hero_index).getFight_num()+2);
        String json = JSON.toJson(fighterList);
        return json;
    }

    public static String updateHeroData(List<FighterBean> heroList,int hero_index){
        if(hero_index==4){
            heroList.get(hero_index).setGot_flag(1);
            heroList.get(1).setGot_flag(2);
        }else if(hero_index==5){
            heroList.get(hero_index).setGot_flag(1);
            heroList.get(2).setGot_flag(2);
        } else if(hero_index==6){
            heroList.get(hero_index).setGot_flag(1);
            heroList.get(2).setGot_flag(3);
        }else {
            heroList.get(hero_index).setGot_flag(1);
        }

        String json = JSON.toJson(heroList);
        return json;
    }

    public static String updateHeroData2(List<FighterBean> heroList,int hero_index){   /**强化*/
        heroList.get(hero_index).setGot_flag(heroList.get(hero_index).isGot_flag()+1);
        String json = JSON.toJson(heroList);
        return json;
    }

    public static String updateFollowData(List<FighterBean> heroList,int hero_index){
        heroList.get(hero_index+7).setGot_flag(1);
        String json = JSON.toJson(heroList);
        return json;
    }

    public static String updatePetData(List<FighterBean> heroList,int hero_index){
        heroList.get(hero_index+19).setGot_flag(1);
        String json = JSON.toJson(heroList);
        return json;
    }

    public static String updatePetsData(List<Hero> heroList,int hero_index){
        PropertiesOp propertiesOp = new PropertiesOp();
        Properties properties = propertiesOp.load(propname2);
        heroList.get(hero_index+19).setTitle_img_path(properties.getProperty("visible"+hero_index));

        heroList.get(hero_index+19).setGot_flag(true);
        String json = JSON.toJson(heroList);
        return json;
    }

}
