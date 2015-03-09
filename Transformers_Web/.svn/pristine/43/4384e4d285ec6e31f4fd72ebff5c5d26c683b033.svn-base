package tools;

import com.fancyy.json.util.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: tongxiqing
 * Date: 14-10-24
 * Time: обнГ4:34
 * To change this template use File | Settings | File Templates.
 */
public class HeroShowOp {

    public static void main(String[] args){
        initialHeroShowData();
    }

    public static String initialHeroShowData(){
        List<HeroShowBean> heroShowBeans = new ArrayList<HeroShowBean>();
        HeroShowBean heroShowBean = new HeroShowBean();
        heroShowBeans.add(heroShowBean);
        String json = JSON.toJson(heroShowBeans);
        return json;
    }
}
