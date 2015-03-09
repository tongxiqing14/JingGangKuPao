package screens;

import javax.microedition.lcdui.Graphics;

import Entry.LWGameCanvas;
import common.GameVariables;
import common.Globe;
import common.Screen;
import elements.Hero;

public class TutorialScreen extends Screen {
	//技能类型
	int tutorialType;
	//返回窗口
	public static Screen returnScreen;
	//初始化
	public static final int TUTORIALTYPE_INIT=0;
	//盾
	public static final int TUTORIALTYPE_SHIELD=1;
	//云
	public static final int TUTORIALTYPE_CLOUD=2;
	//磁石
	public static final int TUTORIALTYPE_MAGNET=3;
	//飞行
	public static final int TUTORIALTYPE_FLY=4;
	//结束
	public static final int TUTORIALTYPE_END=5;
	//暂停
	public static final int TUTORIALTYPE_PAUSE=6;
	//提示文本信息
	String tutorialInfo;
	
	public TutorialScreen(int screenId) {
		super(screenId);
		// TODO Auto-generated constructor stub
	}
	
	public TutorialScreen(int screenId,int tutorialType) {
		super(screenId);
		this.tutorialType = tutorialType;
	}

	public void init() {
		// TODO Auto-generated method stub
		switch (tutorialType) {
		case TUTORIALTYPE_INIT:
			tutorialInfo = "游戏中，按↑ 为跳跃。按‘↑’键继续";
			break;
		case TUTORIALTYPE_SHIELD:
			tutorialInfo = "无敌状态，可防御任意攻击！按‘1’键继续";
			break;
		case TUTORIALTYPE_CLOUD:
			tutorialInfo = "召唤仙云，填补坑洞，让你一马平川！按‘2’键继续";
			break;
		case TUTORIALTYPE_MAGNET:
			tutorialInfo = "使用磁石，自动吸引道具！按‘3’键继续";
			break;
		case TUTORIALTYPE_FLY:
			tutorialInfo = "飞行状态，冲破一切障碍！按‘OK’键继续";
			break;
		case TUTORIALTYPE_PAUSE:
			tutorialInfo = "游戏暂停，思考一下！按‘↓’键继续 ,再按下‘↓’键游戏继续";
			break;
		case TUTORIALTYPE_END:
			tutorialInfo = "教程结束，开始你的跑酷吧！按‘OK’键退出教程！";
			break;
		}
	}

	public void update() {
		// TODO Auto-generated method stub
		switch (tutorialType) {
		case TUTORIALTYPE_INIT:
			if(LWGameCanvas.iskeyPressed(Globe.M_KEY_UP)) {
				//LWGameCanvas.keyReset();
				tutorialAction();
			}
			break;
		case TUTORIALTYPE_SHIELD: //开盾
			if(LWGameCanvas.iskeyPressed(Globe.M_KEY_1)) {
				GamingScreen.hero.setState(Hero.STAGE_INVINCIBLE);
				tutorialAction();
			}
			break;
		case TUTORIALTYPE_CLOUD: //仙云
			if(LWGameCanvas.iskeyPressed(Globe.M_KEY_2)) {
				GamingScreen.isFillYun = true;
				tutorialAction();
			}
			break;
		case TUTORIALTYPE_MAGNET: //磁石
			if(LWGameCanvas.iskeyPressed(Globe.M_KEY_3)) {
				GamingScreen.isFillYun = true;
				if (!GamingScreen.hero.isXiJin) {
					GamingScreen.hero.setState(Hero.STAGE_XIJIN);
				}
				tutorialAction();
			}
			break;
		case TUTORIALTYPE_FLY: //飞行
			if(LWGameCanvas.iskeyPressed(Globe.M_KEY_OK)) {
				GamingScreen.bgMoveFram = 20;
				GamingScreen.hero.setState(Hero.STAGE_CHONG);
				tutorialAction();
			}
			break;
		case TUTORIALTYPE_PAUSE:
			if(LWGameCanvas.iskeyPressed(Globe.M_KEY_DOWN)) {
				tutorialAction();
				}
			break;
		case TUTORIALTYPE_END:
			if(LWGameCanvas.iskeyPressed(Globe.M_KEY_OK)) {
				LWGameCanvas.deleteScreen(this);
				returnScreen = null;
				LWGameCanvas.keyReset();
				LWGameCanvas.switchToScreen(new MenuScreen(GameVariables.MENU_SCREEN_ID));
			}
			break;
		}
	}
	
	private void tutorialAction() {
//		if (GameVariables.isTutorial) {
//			returnScreen.init();
//			LWGameCanvas.setActive(returnScreen, true);
//		} else {
//			LWGameCanvas.keyReset();
			LWGameCanvas.deleteScreen(this);
//		}
		//JVMGameCanvas.keyReset();
	}

	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(0xDEB887);
		g.setFont(Globe.BigBoldFont);
//		g.drawRegion(faceImg, 0, 0, faceImg.getWidth(), faceImg.getHeight(), Globe.TRANS_MIRROR,
//				Globe.SW-20, Globe.SH-faceImg.getHeight()-60, Globe.ANCHOR_B_R);
		g.fillRoundRect(10, Globe.SH-180, Globe.SW-20, 70, 10, 10);
		
		g.setColor(0x000000);
		g.drawString(tutorialInfo, 20, Globe.SH-155, 20);
		
//		for (int i = 0; i < info.length; i++) {
//			Globe.drawShadeString(g, info[i], 20, Globe.SH-170+i*Globe.currentFont.getHeight(), 0x000000, 0xffffff, Globe.ANCHOR_T_L);
//		}
//		if(textImage != null){
//			for(int i=0; i<textImage.length; i++){
//				g.drawImage(textImage[i], 20, 360+i*30, 20);
//			}			
//		}
	}

	public void clear() {
		// TODO Auto-generated method stub
		returnScreen = null;
//        System.gc();
        Runtime.getRuntime().gc();
	}

}
