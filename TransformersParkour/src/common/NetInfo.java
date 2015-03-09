package common;

import iptvNet.IptvNetException;
import iptvNet.NetHander;

import org.json.me.JSONArray;
import org.json.me.JSONException;
import org.json.me.JSONObject;

import screens.ConfirmScreen;

import elements.Hero;

public class NetInfo {
	public static NetHander netHander;
//	private static boolean isTest = true;

	/**
	 * 道具; 0~5 购买人物; 6~9 训练; 10~12 购买道具; 13: 复活; 14: 特殊技能;
	 * */

	/**
	 *Type说明:
	 * 
	 * 0~5:英雄角色信息; 10~14道具信息; 20:获取最大关卡 21:获取成就;
	 */
	public static void getGameScore(){
		try {
			GameVariables.point=netHander.getMyScore(0);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IptvNetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void updateAchieve() {
		JSONObject jo = new JSONObject();
		try {
			JSONArray ja0 = new JSONArray();
			JSONArray ja1 = new JSONArray();
			jo.put("achieve", ja0);
			jo.put("bonus", ja1);
			netHander.saveGameData(jo.toString(), 21);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IptvNetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void savePetInfo(boolean[] o,int type)
	{
		JSONObject jsonPet = new JSONObject();
		JSONArray jsonArray = new JSONArray();
		for (int i = 0; i < o.length; i++) {
			jsonArray.put(o[i]);
		}
		try {
			jsonPet.put("petinfo", jsonArray);
			NetInfo.netHander.saveGameData(jsonPet.toString(), type);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IptvNetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void getPetInfo()
	{
		try {
			String petInfo1 = netHander.getGameData(33);
			//System.out.println(petInfo1);
			JSONObject json1 = new JSONObject(petInfo1);
			String petInfo2 = netHander.getGameData(34);
			JSONObject json2 = new JSONObject(petInfo2);
			JSONArray arr1 = json1.getJSONArray("petinfo");
			JSONArray arr2 = json2.getJSONArray("petinfo");
			for (int i = 0; i < arr1.length(); i++) {
				GameVariables.isFlyPetGot[i] =arr1.getBoolean(i);
			}
			for (int i = 0; i < arr2.length(); i++) {
				GameVariables.isLandPetGot[i] =arr2.getBoolean(i);
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IptvNetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void saveScore(int score,int type){
		try {
			NetInfo.netHander.saveScore(score, type);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IptvNetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void getAchieve() {
		try {
			String achieve = netHander.getGameData(21);
			JSONObject jo0 = new JSONObject(achieve);
			JSONArray achieveArray = jo0.getJSONArray("achieve");
			for (int i = 0; i < achieveArray.length(); i++) {
//				AchieveScreen.achievement[i] = achieveArray.getBoolean(i);
			}

			String bouns = netHander.getGameData(21);
			JSONObject jo1 = new JSONObject(bouns);
			JSONArray bounsArray = jo1.getJSONArray("bonus");
			for (int i = 0; i < bounsArray.length(); i++) {
//				AchieveScreen.bonus[i] = bounsArray.getBoolean(i);
			}

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IptvNetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void updateMapStage() {
		JSONObject jo = new JSONObject();
		try {
			jo.put("maxStage", GameVariables.maxMapStage);
			netHander.saveGameData(jo.toString(), 10);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IptvNetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void getMapStage() {
		try {
			String mapStage = netHander.getGameData(10);
			JSONObject jo = new JSONObject(mapStage);
			GameVariables.maxMapStage = jo.getInt("maxStage");
		} catch (JSONException e) {

			e.printStackTrace();
		} catch (IptvNetException e) {

			e.printStackTrace();
		}
	}

	public static void initData() {
		for (int i = 0; i < 4; i++) {
			JSONObject jo = new JSONObject();
			try {
				jo.put("isGot", Hero.isGot[i]);
				jo.put("heroChongTime", Hero.initHeroChongTime[i]);
				jo.put("heroInvincibleTime", Hero.initHeroInvincibleTime[i]);
				jo.put("heroXiangYun", Hero.initHeroXiangYun[i]);
				jo.put("heroSuckStar", Hero.initHeroSuckStar[i]);

                jo.put("heroChongTimeLV", Hero.initHeroChongTimeLV[i]);
                jo.put("heroInvincibleTimeLV", Hero.initHeroInvincibleTimeLV[i]);
                jo.put("heroXiangYunLV", Hero.initHeroXiangYunLV[i]);
                jo.put("heroSuckStarLV", Hero.initHeroSuckStarLV[i]);
                
                Hero.heroChongTime[i] = Hero.initHeroChongTime[i];
				Hero.heroInvincibleTime[i] = Hero.initHeroInvincibleTime[i];
				Hero.heroXiangYun[i] = Hero.initHeroXiangYun[i];
				Hero.heroSuckStar[i] = Hero.initHeroSuckStar[i];

                Hero.heroChongTimeLV[i] = Hero.initHeroChongTimeLV[i];
                Hero.heroInvincibleTimeLV[i] = Hero.initHeroInvincibleTimeLV[i];
                Hero.heroXiangYunLV[i] = Hero.initHeroXiangYunLV[i];
                Hero.heroSuckStarLV[i] = Hero.initHeroSuckStarLV[i];
				
				netHander.saveGameData(jo.toString(), i);
			} catch (JSONException e1) {
				e1.printStackTrace();
			} catch (IptvNetException e) {
				e.printStackTrace();
			}
		}
		
		try {
			JSONObject jo = new JSONObject();
			jo.put("maxStage", GameVariables.maxMapStage);
			netHander.saveGameData(jo.toString(), 10);
			
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (IptvNetException e) {
			e.printStackTrace();
		}
		
		savePetInfo(GameVariables.isFlyPetGot,33);
		savePetInfo(GameVariables.isLandPetGot,34);
	}
	
	public static void getHeroData(int heroType) {
		try {
			String heroData = netHander.getGameData(heroType);
			JSONObject jo = new JSONObject(heroData);
            Hero.isGot[heroType] = jo.getBoolean("isGot");

            Hero.heroChongTime[heroType] = jo.getInt("heroChongTime");
            Hero.heroInvincibleTime[heroType] = jo.getInt("heroInvincibleTime");
            Hero.heroXiangYun[heroType] = jo.getInt("heroXiangYun");
            Hero.heroSuckStar[heroType] = jo.getInt("heroSuckStar");

            Hero.heroChongTimeLV[heroType] = jo.getInt("heroChongTimeLV");
            Hero.heroInvincibleTimeLV[heroType] = jo.getInt("heroInvincibleTimeLV");
            Hero.heroXiangYunLV[heroType] = jo.getInt("heroXiangYunLV");
            Hero.heroSuckStarLV[heroType] = jo.getInt("heroSuckStarLV");
		}catch (JSONException e) {
			e.printStackTrace();
		} catch (IptvNetException e) {
			e.printStackTrace();
		}
	}

	public static void getItemInfo() {
		for (int i = 0; i < 5; i++) {
			try {
				String itemInfo = netHander.getGameData(10 + i);
				JSONObject jo = new JSONObject(itemInfo);
//				Hero.itemNum[10 + i] = jo.getInt("itemNum");
				
			} catch (JSONException e) {
	
				e.printStackTrace();
			} catch (IptvNetException e) {

				e.printStackTrace();
			}
		}
//		Hero.itemNum[14]=10;

	}

	public static void updateItemInfo(int itemType) {
		JSONObject jo = new JSONObject();
		try {
//			jo.put("itemNum", Hero.itemNum[itemType]);
			netHander.saveGameData(jo.toString(), itemType);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IptvNetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void updateHeroData(int heroType) {
		JSONObject jo = new JSONObject();
		try {
			jo.put("isGot", Hero.isGot[heroType]);
			jo.put("heroChongTime", Hero.heroChongTime[heroType]);
			jo.put("heroInvincibleTime", Hero.heroInvincibleTime[heroType]);
			jo.put("heroXiangYun", Hero.heroXiangYun[heroType]);
			jo.put("heroSuckStar", Hero.heroSuckStar[heroType]);

            jo.put("heroChongTimeLV", Hero.heroChongTimeLV[heroType]);
            jo.put("heroInvincibleTimeLV", Hero.heroInvincibleTimeLV[heroType]);
            jo.put("heroXiangYunLV", Hero.heroXiangYunLV[heroType]);
            jo.put("heroSuckStarLV", Hero.heroSuckStarLV[heroType]);
			netHander.saveGameData(jo.toString(), heroType);
		} catch (JSONException e1) {
			e1.printStackTrace();
		} catch (IptvNetException e) {
			e.printStackTrace();
		}
	}
	public static void buyItemNotEnoughToken(){
			int tempNum = 0;

			Hero.gotHeroID = new int[tempNum];

	}
	public static void buyItem(int token, String wareName) {
		boolean consume = false;
		try {
			consume = netHander.topupAndConsumeMoney(token, wareName);
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			ConfirmScreen.confirmStage = 2;
			e.printStackTrace();
		} catch (IptvNetException e) {
			ConfirmScreen.confirmStage = 2;
			//System.out.println("nethandle:" + netHander.getReceiveString());
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (consume) {
			ConfirmScreen.tipInfo = "消费成功!";
			ConfirmScreen.confirmStage = 1;
		} else {
			//System.out.println("netHander.getMessage:"+netHander.getReceiveString());
			ConfirmScreen.tipInfo = "消费失败,请去大厅充值!";
			ConfirmScreen.confirmStage = 2;
		}
		try {
			Globe.token = NetInfo.netHander.getBalance();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IptvNetException e) {
			//System.out.println("nethandle:" + netHander.getReceiveString());
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
