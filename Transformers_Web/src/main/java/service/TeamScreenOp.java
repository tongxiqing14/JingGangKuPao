package service;

import com.fancyy.json.util.JSON;
import common.PropertiesOp;
import elements.screen.TeamScreenItemObj;
import elements.screen.TitleItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: tongxiqing
 * Date: 14-9-28
 * Time: ÏÂÎç8:00
 * To change this template use File | Settings | File Templates.
 */
public class TeamScreenOp {

    private static final String propname1 = "/initial/teamitem.properties";

    public static void main(String[] args){
        setTeamScreenItemObj();
    }

    public static String setTeamScreenItemObj(){
        PropertiesOp propertiesOp = new PropertiesOp();
        Properties properties = propertiesOp.load(propname1);
        return properties.getProperty("team1");
    }

    public static String updateTeamScreenItemObj_ForHero(TeamScreenItemObj teamScreenItemObj,int title_item_index){

        List<TitleItem> titleItemList = teamScreenItemObj.getTitleItemList();

        switch (title_item_index){
            case 0:
                TitleItem titleItem1 = new TitleItem(1,false,8,3,1);
                titleItemList.add(titleItem1);
                break;
            case 1:
                TitleItem titleItem4 = new TitleItem(1,false,8,3,4);
                titleItemList.add(titleItem4);
                break;
            case 2:
                TitleItem titleItem2 = new TitleItem(1,false,8,3,2);
                titleItemList.add(titleItem2);
                break;
            case 3:
                TitleItem titleItem5 = new TitleItem(1,false,8,3,5);
                titleItemList.add(titleItem5);
                break;
            case 4:
                TitleItem titleItem6 = new TitleItem(2,false,8,3,6);
                titleItemList.add(titleItem6);
                break;
            case 5:
                TitleItem titleItem7 = new TitleItem(2,false,8,3,7);
                titleItemList.add(titleItem7);
                break;
        }

        teamScreenItemObj.setTitleItemList(titleItemList);
        String json = JSON.toJson(teamScreenItemObj);
        return json;
    }

    public static String updateTeamScreenItemObj_ForFollow(TeamScreenItemObj teamScreenItemObj,int title_item_index){

        List<TitleItem> titleItemList = teamScreenItemObj.getTitleItemList();

        switch (title_item_index){
            case 0:
                TitleItem titleItem0 = new TitleItem(2,false,8,3,6);
                titleItemList.add(titleItem0);
                break;
            case 1:
                TitleItem titleItem1 = new TitleItem(2,false,8,3,7);
                titleItemList.add(titleItem1);
                break;
            case 2:
                TitleItem titleItem2 = new TitleItem(2,false,8,3,8);
                titleItemList.add(titleItem2);
                break;
            case 3:
                TitleItem titleItem3 = new TitleItem(2,false,8,3,9);
                titleItemList.add(titleItem3);
                break;
            case 4:
                TitleItem titleItem4 = new TitleItem(2,false,8,3,10);
                titleItemList.add(titleItem4);
                break;
            case 5:
                TitleItem titleItem5 = new TitleItem(2,false,8,3,10);
                titleItemList.add(titleItem5);
                break;
            case 6:
                TitleItem titleItem6 = new TitleItem(2,false,8,3,10);
                titleItemList.add(titleItem6);
                break;
            case 7:
                TitleItem titleItem7 = new TitleItem(2,false,8,3,10);
                titleItemList.add(titleItem7);
                break;
            case 8:
                TitleItem titleItem8 = new TitleItem(2,false,8,3,10);
                titleItemList.add(titleItem8);
                break;
            case 9:
                TitleItem titleItem9 = new TitleItem(2,false,8,3,10);
                titleItemList.add(titleItem9);
                break;
            case 10:
                TitleItem titleItem10 = new TitleItem(2,false,8,3,10);
                titleItemList.add(titleItem10);
                break;
            case 11:
                TitleItem titleItem11 = new TitleItem(2,false,8,3,10);
                titleItemList.add(titleItem11);
                break;
        }

        teamScreenItemObj.setTitleItemList(titleItemList);
        String json = JSON.toJson(teamScreenItemObj);
        return json;
    }

    public static String updateTeamScreenItemObj_ForPets(TeamScreenItemObj teamScreenItemObj,int title_item_index){

        List<TitleItem> titleItemList = teamScreenItemObj.getTitleItemList();

        switch (title_item_index){
            case 0:
                TitleItem titleItem0 = new TitleItem(2,false,8,3,6);
                titleItemList.add(titleItem0);
                break;
            case 1:
                TitleItem titleItem1 = new TitleItem(2,false,8,3,6);
                titleItemList.add(titleItem1);
                break;
            case 2:
                TitleItem titleItem2 = new TitleItem(2,false,8,3,6);
                titleItemList.add(titleItem2);
                break;
            case 3:
                TitleItem titleItem3 = new TitleItem(2,false,8,3,6);
                titleItemList.add(titleItem3);
                break;
            case 4:
                TitleItem titleItem4 = new TitleItem(2,false,8,3,6);
                titleItemList.add(titleItem4);
                break;
            case 5:
                TitleItem titleItem5 = new TitleItem(2,false,8,3,6);
                titleItemList.add(titleItem5);
                break;
            case 6:
                TitleItem titleItem6 = new TitleItem(2,false,8,3,6);
                titleItemList.add(titleItem6);
                break;
            case 7:
                TitleItem titleItem7 = new TitleItem(2,false,8,3,6);
                titleItemList.add(titleItem7);
                break;
            case 8:
                TitleItem titleItem8 = new TitleItem(2,false,8,3,6);
                titleItemList.add(titleItem8);
                break;
        }

        teamScreenItemObj.setTitleItemList(titleItemList);
        String json = JSON.toJson(teamScreenItemObj);
        return json;
    }

}
