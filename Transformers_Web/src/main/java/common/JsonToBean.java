package common;

import beans.*;
import com.fancyy.json.util.JSON;
import elements.armorbase.EquipItem;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: tongxiqing
 * Date: 14-10-10
 * Time: ÏÂÎç12:34
 * To change this template use File | Settings | File Templates.
 */
public class JsonToBean {

    public static List<FighterBean> jsonTobean(String jsonStr){
        System.out.println("jsonStr="+jsonStr);
        return (List<FighterBean>) JSON.toObject(jsonStr, FighterBean.class);
    }

    public static List<FighterItemBean> jsonTobean1(String jsonStr){
        return (List<FighterItemBean>) JSON.toObject(jsonStr, FighterItemBean.class);
    }

    public static List<FighterItemBean> jsonTobean2(String jsonStr){
        return (List<FighterItemBean>) JSON.toObject(jsonStr, FighterItemBean.class);
    }

    public static List<FighterItemBean> jsonTobean3(String jsonStr){
        return (List<FighterItemBean>) JSON.toObject(jsonStr, FighterItemBean.class);
    }

    public static List<EquipItem> jsonTobean4(String jsonStr){
        return (List<EquipItem>) JSON.toObject(jsonStr, EquipItem.class);
    }

}
