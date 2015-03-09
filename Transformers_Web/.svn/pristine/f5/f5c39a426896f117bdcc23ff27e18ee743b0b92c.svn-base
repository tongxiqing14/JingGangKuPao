package common;

import com.fancyy.json.pojo.User;
import com.fancyy.json.util.JSON;
import elements.FishProperty;
import elements.Hero;
import elements.RoleAccount;
import elements.UserAccount;
import iptvNet.IptvNetException;
import iptvNet.NetHander;
import org.json.me.JSONArray;
import org.json.me.JSONException;
import org.json.me.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: tongxiqing
 * Date: 14-6-30
 * Time: ÏÂÎç2:13
 * To change this template use File | Settings | File Templates.
 */
public class NetInfo {

    private NetHander netHander;

    public static void main(String[] args){
//        initData__();
//        getHeroData__(0);
        UserAccount userAccount = new UserAccount();
        userAccount.setUser_account_id(001);

//        userAccount.setRoleAccountList(createRoleAccount());

        String json = JSON.toJson("");
    }

    public NetHander getNetHander() {
        return netHander;
    }

    public void setNetHander(NetHander netHander) {
        this.netHander = netHander;
    }

    public boolean initData__() {

        boolean rt = false;
        try {
            JSONObject role_jo = new JSONObject();
            for(int k =0 ; k < 1; k++){
                JSONArray roleArray = new JSONArray();
                for (int i = 0; i < 1; i++) {
                    JSONObject jo = new JSONObject();
                    JSONArray heroArray = new JSONArray();
                    for(int j = 0; j < 5; j++){
                        JSONObject hero_jo = new JSONObject();
                        hero_jo.put("hero"+j, "");
                        heroArray.put(hero_jo);
                    }

                    JSONArray humanArray = new JSONArray();
                    for(int j = 0; j < 5; j++){
                        JSONObject human_jo = new JSONObject();
                        human_jo.put("human"+j, "");
                        humanArray.put(human_jo);
                    }

                    JSONArray petArray = new JSONArray();
                    for(int j = 0; j < 5; j++){
                        JSONObject pet_jo = new JSONObject();
                        pet_jo.put("pet"+j, "");
                        petArray.put(pet_jo);
                    }

//                jo.put("role"+i, "");
                    jo.put("hero", heroArray);
                    jo.put("human", humanArray);
                    jo.put("pet", petArray);
                    roleArray.put(jo);
                }
                role_jo.put("role"+k,roleArray);
            }

            System.out.print(role_jo.toString());
            JSONObject jo = new JSONObject();
            jo.put("maxStage", "");
//            netHander.saveGameData(jo.toString(), 10);
//            netHander.saveScore(0,0);
//
//            rt = netHander.saveGameData("init", -1);
        } catch (JSONException e1) {
            e1.printStackTrace();
//        } catch (IptvNetException e) {
//            e.printStackTrace();
        }
        return rt;
    }

    public static String initData__$() {
        UserAccount userAccount = new UserAccount();
        userAccount.setUser_account_id(001);

        userAccount.setRoleAccountList(createRoleAccount());

        String json = JSON.toJson(userAccount);
        return json;
    }

    private static List<RoleAccount> createRoleAccount(){
        List<RoleAccount> roleAccounts = new ArrayList<RoleAccount>();

        RoleAccount roleAccount = new RoleAccount();
        roleAccount.setRole_account_id(001);
        roleAccount.setHeroList(createHero());

        roleAccounts.add(roleAccount);

        return roleAccounts;
    }

    private static List<Hero> createHero(){
        List<Hero> heroList = new ArrayList<Hero>();

        for (int i=0; i<4; i++){
            Hero hero = new Hero();
//            hero.setExps(1000+i);
            if(i==0) hero.setGot_flag(true);

            heroList.add(hero);
        }

        return heroList;
    }

    public boolean updateHeroData__(int heroType) {
        boolean rt = false;
        try {
            JSONObject role_jo = new JSONObject();
            for(int k =0 ; k < 1; k++){
                JSONArray roleArray = new JSONArray();
                for (int i = 0; i < 1; i++) {
                    JSONObject jo = new JSONObject();
                    JSONArray heroArray = new JSONArray();
                    for(int j = 0; j < 5; j++){
                        JSONObject hero_jo = new JSONObject();
//                        hero_jo.put("hero"+j, Hero.exps);
                        heroArray.put(hero_jo);
                    }

                    JSONArray humanArray = new JSONArray();
                    for(int j = 0; j < 5; j++){
                        JSONObject human_jo = new JSONObject();
                        human_jo.put("human"+j, "");
                        humanArray.put(human_jo);
                    }

                    JSONArray petArray = new JSONArray();
                    for(int j = 0; j < 5; j++){
                        JSONObject pet_jo = new JSONObject();
                        pet_jo.put("pet"+j, "");
                        petArray.put(pet_jo);
                    }

//                jo.put("role"+i, "");
                    jo.put("hero", heroArray);
                    jo.put("human", humanArray);
                    jo.put("pet", petArray);
                    roleArray.put(jo);
                }
                role_jo.put("role"+k,roleArray);
            }

            System.out.print(role_jo.toString());
            JSONObject jo = new JSONObject();
            jo.put("maxStage", "");
//            netHander.saveGameData(jo.toString(), 10);
//            netHander.saveScore(0,0);
//
//            rt = netHander.saveGameData("init", -1);
        } catch (JSONException e1) {
            e1.printStackTrace();
//        } catch (IptvNetException e) {
//            e.printStackTrace();
        }
        return rt;
    }

    public String getHeroData__(int heroType) {
        String rtString="";

        try {
            String heroData = "{\"role0\":[{\"pet\":[{\"pet0\":\"\"},{\"pet1\":\"\"},{\"pet2\":\"\"},{\"pet3\":\"\"},{\"pet4\":\"\"}],\"hero\":[{\"hero0\":\"\"},{\"hero1\":\"\"},{\"hero2\":\"\"},{\"hero3\":\"\"},{\"hero4\":\"\"}],\"human\":[{\"human0\":\"\"},{\"human1\":\"\"},{\"human2\":\"\"},{\"human3\":\"\"},{\"human4\":\"\"}]}]}\n";

            if(heroData.equals("")){
                rtString = "fail";
            }else {
                JSONObject jo = new JSONObject(heroData);
                JSONArray jsonArray = jo.getJSONArray("role0");

//                System.out.println("**"+jsonArray.get(0).toString());

                JSONObject jo2 = (JSONObject) jsonArray.get(0);

                System.out.println(jo2.getJSONArray("pet").toString());

//                jo2.getJSONArray("pet").toString();

                rtString = "success";
            }
        }catch (JSONException e) {
            e.printStackTrace();
//        } catch (IptvNetException e) {
//            e.printStackTrace();
        }
        return rtString;
    }

    public int getMyScore(int heroType){
        int score=0;
        try {
            score = netHander.getMyScore(heroType);
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IptvNetException e) {
            e.printStackTrace();
        }
        return score;
    }

    public int getBalance__(){
        int ret = 0;
        try {
           ret = netHander.getBalance();
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IptvNetException e) {
            e.printStackTrace();
        }
        return ret;
    }

    public int getMyRank__(int type){
        int ret = 0;
        try {
            ret = netHander.getMyRank(type);
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IptvNetException e) {
            e.printStackTrace();
        }
        return ret;
    }

    public String getNickName(){
        String nickName = "";
        try {
            nickName = netHander.getNickName();
        } catch (IptvNetException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return nickName;
    }

    public String[][] getScoreList__(int type, int getNum){
        String[][] rets = new String[0][];
        try {
            rets = netHander.getScoreList(type,getNum);
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IptvNetException e) {
            e.printStackTrace();
        }
        return rets;
    }

    public boolean topupAndConsumeMoney__(int money, String wareName){
        boolean isSucess = false;
        try {
            isSucess = netHander.topupAndConsumeMoney(money,wareName);
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IptvNetException e) {
            e.printStackTrace();
        }

        return isSucess;
    }

    public int topupAndConsumeMoney___(int money, String wareName,String password){

        int result = 1;

        try {
            result = netHander.judgeIsTopupPassword_topupAndConsumeMoney(money,wareName,password);
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IptvNetException e) {
            e.printStackTrace();
        }

        return result;
    }

    public boolean hasVerificationCode__(){
        boolean rt = false;
        try {
            rt = netHander.hasVerificationCode();
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IptvNetException e) {
            e.printStackTrace();
        }
        return  rt;
    }

    public static void saveJigsawInfo(Boolean[] o)
    {
        try {

            JSONObject jsonStage = new JSONObject();
            JSONArray jsonArray = new JSONArray();
            for (int i = 0; i < o.length; i++) {
                jsonArray.put(o[i]);
            }

            jsonStage.put("stageLockOrUnlock", jsonArray);
            System.out.println(jsonStage.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}
