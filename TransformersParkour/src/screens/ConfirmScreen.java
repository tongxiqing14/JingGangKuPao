package screens;

import Entry.LWGameCanvas;
import common.GameVariables;
import common.Globe;
import common.NetInfo;
import common.Screen;
import elements.Hero;
import iptvNet.The9InputCanvas;
import iptvNet.The9InputScreen;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public class ConfirmScreen extends Screen {

    public static String tipInfo="该技能将花费你3代币；按OK键确认，按0键取消。";
    public static Screen returnScreen;
    public static int buyIndex;
    public static int confirmStage;
    public static int[] itemPrice={0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
//    private Image commonImage;
    private Image bgimage,indexImage,bgimageReturn;
    private Image[] images;
    private Image bgImg;
    private Image successImg;
    private Image confirmImg;
    private int selectIndex = 0;
    private int indexFrame = 0;
    private int heroId = 0;
    The9InputCanvas tic;

    private static int SCREEN_W = 640;
    private static int SCREEN_H = 530;

    public String[] wareName={
            "",
            "人物：大黄蜂",//1
            "人物：惊破天",//2
            "人物：通天晓",//3
            "人物：擎天柱",//4
            "伙伴：急速哈雷",//14
            "伙伴：动力本田",//15
            "伙伴：疯狂摩托",//16
            "伙伴：雷霆战车",//17
            "伙伴：奔跑者",//17
            "伙伴：雷霆战车",//17
            "伙伴：天天飞车",//17
            "伙伴：光之速",//17
            "伙伴：光明天使",//5
            "伙伴：雷霆之神",//6
            "伙伴：天空之翼",//7
            "伙伴：宇宙飞空",//8
            "伙伴：火凤凰",//9
            "伙伴：圣斗骑士",//10
            "伙伴：空袭者",//11
            "伙伴：终极者",//12
            "伙伴：机动悍将",//13
            "升级：金刚变身",//17
            "升级：防御罩",//18
            "升级：筋斗云",//19
            "升级：吸金石",//20
            "技能：金刚变身",//21
            "技能：防御罩",//22
            "技能：筋斗云",//23
            "技能：吸金石",//24
            "人物：复活"//     25
    };

    public ConfirmScreen(int screenId) {
        super(screenId);
        if(LWGameCanvas.rmidlet.getAppProperty("IsActiveOnOK").equals("true")) {
            selectIndex = 0;
        }else {
            selectIndex = 1;
        }
    }

    public ConfirmScreen(int screenId, int heroId) {
        super(screenId);
        this.heroId = heroId;
        if(LWGameCanvas.rmidlet.getAppProperty("IsActiveOnOK").equals("true")) {
            selectIndex = 0;
        }else {
            selectIndex = 1;
        }
    }

    public void clear() {
        // TODO Auto-generated method stub
        confirmStage = 0;
//        commonImage = null;
        bgimage = null;
        bgimageReturn = null;
        images = null;
        tic = null;
    }

    int font_height = 20;

    public void draw(Graphics g) {
        // TODO Auto-generated method stub
//		g.drawImage(commonImage, 0, 0, 20);
        if(GameVariables.isTrainning==true){
            GameVariables.isTrainning = false;
            return;
        }

        if(returnFromThe9){
            if (confirmStage == 2) {
                g.drawImage(bgimageReturn, Globe.SW >> 1, Globe.SH >> 1, Graphics.HCENTER|Graphics.VCENTER);
                g.drawImage(images[1==selectIndex?3:2], 235, 300, 20);
            }else {
                g.drawImage(bgImg, SCREEN_W>>1, SCREEN_H>>1, Graphics.RIGHT|Graphics.VCENTER);
                g.drawRegion(bgImg, 0,0,bgImg.getWidth(),bgImg.getHeight(),
                        2,SCREEN_W>>1, SCREEN_H>>1, Graphics.LEFT|Graphics.VCENTER);
            }

        }else if (confirmStage == 0) {
            g.drawImage(bgimage, Globe.SW >> 1, Globe.SH >> 1, Graphics.HCENTER|Graphics.VCENTER);
            g.drawImage(images[0==selectIndex?1:0], 370, 300, 20);
            g.drawImage(images[1==selectIndex?3:2], 170, 300, 20);
            g.drawImage(indexImage, 152+(1==selectIndex?0:1)*200+indexFrame, 312, Graphics.HCENTER|Graphics.VCENTER);
        } else {
            g.drawImage(bgimageReturn, Globe.SW >> 1, Globe.SH >> 1, Graphics.HCENTER|Graphics.VCENTER);
            //g.drawImage(images[0==selectIndex?1:0], 170, 300, 20);
            g.drawImage(images[1==selectIndex?3:2], 235, 300, 20);
        }
        int color = g.getColor();
//        g.setColor(0xffffff);
        g.setFont(Globe.BigBoldFont);
        g.setColor(0xffffff);
        if (confirmStage == 0) {
            g.drawString(""+wareName[buyIndex], 220, 140, Graphics.TOP|Graphics.LEFT);
            g.drawString("资费："+itemPrice[buyIndex]+"代币", 220, 145 + font_height, Graphics.TOP|Graphics.LEFT);
            if (Globe.needMoreToken > 0) {
                g.drawString("余额不足,需充值"+ Globe.needMoreToken+"代币", 220, 150 + font_height * 2, Graphics.TOP|Graphics.LEFT);
                int color1 = g.getColor();
                g.setColor(0xff0000);
                g.drawString("(1代币 = 1人民币)", 220, 153 + font_height * 3, Graphics.TOP|Graphics.LEFT);
                g.setColor(color1);
            } else {
                g.drawString("余额："+ Globe.token+"代币", 220, 148 + font_height * 2, Graphics.TOP|Graphics.LEFT);
            }
        } else if (confirmStage == 1) {
            if(returnFromThe9){
                g.setColor(0x000000);
                g.drawImage(successImg, 335, 230, Graphics.HCENTER|Graphics.BOTTOM);
                g.drawString(Globe.needMoreToken+"", 470, 180, Graphics.TOP|Graphics.LEFT);
                g.drawString(Globe.needMoreToken+"", 350, 210, Graphics.TOP|Graphics.LEFT);
                g.drawImage(confirmImg, 330, 400, Graphics.HCENTER|Graphics.BOTTOM);
            }else {
                g.drawString("消费成功！", 260, 180 + font_height, Graphics.TOP|Graphics.LEFT);
            }

        } else if (confirmStage == 2) {

            if(returnFromThe9){
                g.drawString("消费失败！", 260, 180 + font_height, Graphics.TOP | Graphics.LEFT);
            }else {
                g.drawString("消费失败！", 260, 180 + font_height, Graphics.TOP|Graphics.LEFT);
            }
            System.out.println("stage ========= 2");

        }
        /*if(returnScreen.getClass().equals(GamingScreen.class)){
            if(GamingScreen.confirmIndex==1){//冲技能
                g.drawString("购买该技能将花费您"+itemPrice[buyIndex]+"代币", 220, 180, Graphics.TOP|Graphics.LEFT);
            }else if(GamingScreen.confirmIndex == 2){//英雄复活
                g.drawString("复活英雄将花费您"+itemPrice[buyIndex]+"代币", 220, 180, Graphics.TOP|Graphics.LEFT);
                g.drawString("(提示：购买宠物可以免费自动复活一次)", 170, 190 + Globe.currentFont.getHeight(), Graphics.TOP|Graphics.LEFT);
            }else if(GamingScreen.confirmIndex == 3){//魔法护盾
                g.drawString("购买该技能将花费您"+itemPrice[buyIndex]+"代币", 220, 180, Graphics.TOP|Graphics.LEFT);
            }else if(GamingScreen.confirmIndex == 4){//魔法祥云
                g.drawString("购买该技能将花费您"+itemPrice[buyIndex]+"代币", 220, 180, Graphics.TOP|Graphics.LEFT);
            }else if(GamingScreen.confirmIndex == 5){//魔法吸星
                g.drawString("购买该技能将花费您"+itemPrice[buyIndex]+"代币", 220, 180, Graphics.TOP|Graphics.LEFT);
            }
        }*/
        g.setFont(Globe.defaultFont);
        g.setColor(color);
    }

    public void init() {
        // TODO Auto-generated method stub
//		commonImage = Globe.download.creatImage("common/commonBG.png");
//		bgimage = Globe.download.creatImage("confirm/buybg.png");
        bgimage = Globe.getImage("confirm/buybg.png");
        bgimageReturn = Globe.getImage("confirm/buybg1.png");
//	    indexImage = Globe.download.creatImage("success/index.png");
        indexImage = Globe.getImage("success/index.jpg");
        images = new Image[4];
        bgImg = Globe.getImage("the9Input/bg.jpg");
        successImg = Globe.getImage("the9Input/9.png");
        confirmImg = Globe.getImage("the9Input/2.png");
        for(int i = 0; i < images.length;i++){
            images[i] = Globe.getImage("confirm/btn"+i+".png");
        }
        if (LWGameCanvas.isOnOK) {
            selectIndex = 1;
        } else {
            selectIndex = 0;
        }
        Globe.needMoreToken=itemPrice[buyIndex]- Globe.token;
    }

    public void update() {
        indexFrame++;
        indexFrame =(indexFrame+10)%10;
        if(LWGameCanvas.iskeyPressed(Globe.M_KEY_RIGHT)){
            selectIndex++;
        }else if(LWGameCanvas.iskeyPressed(Globe.M_KEY_LEFT)){
            selectIndex--;
        }
        selectIndex = (selectIndex + 2) % 2;

        if(LWGameCanvas.iskeyPressed(Globe.M_KEY_OK)){
			/*if (selectIndex == 1) {
				NetInfo.buyItem(itemPrice[buyIndex], wareName[buyIndex]);
			}*/

            if (confirmStage == 0) {
                if(returnScreen.getClass().equals(MFairyCastleScreen.class)){
                    if(MFairyCastleScreen.selectIndex==0){
                        if(this.selectIndex==1){
                            topUp();
                        /*if(buyingSuccessMark==true){
                            Hero.heroChongTime[MFairyCastleScreen.heroIndex]+=1;
                            Hero.heroChongTimeLV[MFairyCastleScreen.heroIndex]+= 10;
                            NetInfo.updateHeroData(MFairyCastleScreen.heroIndex);
                            LWGameCanvas.setActive(returnScreen, true);
                        } else {
                            LWGameCanvas.deleteScreen(this);
                            LWGameCanvas.setActive(returnScreen, true);
                        }*/
                        }else{
                            LWGameCanvas.deleteScreen(this);
                            LWGameCanvas.setActive(returnScreen, true);
                        }
                    }else if(MFairyCastleScreen.selectIndex==1){
                        if(this.selectIndex==1){
                            topUp();
                        /*if(buyingSuccessMark==true){
                            Hero.heroInvincibleTime[MFairyCastleScreen.heroIndex]+=1;
                            Hero.heroInvincibleTimeLV[MFairyCastleScreen.heroIndex]+= 10;
                            NetInfo.updateHeroData(MFairyCastleScreen.heroIndex);
                            LWGameCanvas.setActive(returnScreen, true);
                        } else {
                            LWGameCanvas.deleteScreen(this);
                            LWGameCanvas.setActive(returnScreen, true);
                        }*/
                        }else{
                            LWGameCanvas.deleteScreen(this);
                            LWGameCanvas.setActive(returnScreen, true);
                        }
                    }else if(MFairyCastleScreen.selectIndex==2){
                        if(this.selectIndex==1){
                            topUp();
                        /*if(buyingSuccessMark==true){
                            Hero.heroXiangYun[MFairyCastleScreen.heroIndex]+=1;
                            Hero.heroXiangYunLV[MFairyCastleScreen.heroIndex]+= 10;
                            NetInfo.updateHeroData(MFairyCastleScreen.heroIndex);
                            LWGameCanvas.setActive(returnScreen, true);
                        }else {
                            LWGameCanvas.deleteScreen(this);
                            LWGameCanvas.setActive(returnScreen, true);
                        }*/
                        }else{
                            LWGameCanvas.deleteScreen(this);
                            LWGameCanvas.setActive(returnScreen, true);
                        }
                    }else if(MFairyCastleScreen.selectIndex==3){
                        if(this.selectIndex==1){
                            topUp();
                        /*if(buyingSuccessMark==true){
                            Hero.heroSuckStar[MFairyCastleScreen.heroIndex]+=2;
                            Hero.heroSuckStarLV[MFairyCastleScreen.heroIndex]+= 10;
                            NetInfo.updateHeroData(MFairyCastleScreen.heroIndex);
                            LWGameCanvas.setActive(returnScreen, true);
                        } else {
                            LWGameCanvas.deleteScreen(this);
                            LWGameCanvas.setActive(returnScreen, true);
                        }*/
                        }else{
                            LWGameCanvas.deleteScreen(this);
                            LWGameCanvas.setActive(returnScreen, true);
                        }
                    }
                }else if(returnScreen.getClass().equals(GamingScreen.class)){
                    if(GamingScreen.confirmIndex==1){//冲技能
                        if(this.selectIndex==1){
                            topUp();
                        /*if(buyingSuccessMark==true){
                            GamingScreen.hero.setLan(GamingScreen.hero.getLan()+60);
                            GamingScreen.hero.setState(Hero.STAGE_CHONG);
                            LWGameCanvas.setActive(returnScreen, true);
                        } else {
                            LWGameCanvas.deleteScreen(this);
                            LWGameCanvas.setActive(returnScreen, true);
                        }*/
                        }else{
                            LWGameCanvas.deleteScreen(this);
                            LWGameCanvas.setActive(returnScreen, true);
                        }
                    }else if(GamingScreen.confirmIndex == 2){//英雄复活
                        if(GameVariables.isTrainning == true){
                            GamingScreen.hero.setLan(GamingScreen.hero.getLan()+60);
                            GamingScreen.hero.setState(Hero.STAGE_INVINCIBLE);
                            LWGameCanvas.deleteScreen(this);
                            LWGameCanvas.setActive(returnScreen, true);
                            GamingScreen.confirmIndex=0;
                        }else {
                            if(this.selectIndex==1){
                                topUp();
                        /*if(buyingSuccessMark==true){
                            GamingScreen.hero.setDead(false);
                            GamingScreen.hero.setState(Hero.STAGE_BUFF);
                            LWGameCanvas.setActive(returnScreen, true);
                        }else {
                            LWGameCanvas.deleteScreen(this);
                            LWGameCanvas.switchToScreen(new FailureScreen(0));
                        }*/
//						LWGameCanvas.deleteScreen(this);
                            }else{
                                LWGameCanvas.deleteScreen(this);
                                LWGameCanvas.switchToScreen(new FailureScreen(0));
                            }
                        }
                    }else if(GamingScreen.confirmIndex == 3){//魔法护盾
                        if(this.selectIndex==1){
                            topUp();
                        /*if(buyingSuccessMark==true){
                            GamingScreen.hero.setLan(GamingScreen.hero.getLan()+60);
                            GamingScreen.hero.setState(Hero.STAGE_INVINCIBLE);
                            LWGameCanvas.setActive(returnScreen, true);
                        } else {
                            LWGameCanvas.deleteScreen(this);
                            LWGameCanvas.setActive(returnScreen, true);
                        }*/
                        }else{
                            LWGameCanvas.deleteScreen(this);
                            LWGameCanvas.setActive(returnScreen, true);
                        }
                    }else if(GamingScreen.confirmIndex == 4){//魔法祥云
                        if(this.selectIndex==1){
                            topUp();
                        /*if(buyingSuccessMark==true){
                            GamingScreen.hero.setLan(GamingScreen.hero.getLan()+60);
                            GamingScreen.numFillYun += Hero.heroXiangYun[GameVariables.heroIndex];
                            GamingScreen.isFillYun = true;
                            LWGameCanvas.setActive(returnScreen, true);
                        } else {
                            LWGameCanvas.deleteScreen(this);
                            LWGameCanvas.setActive(returnScreen, true);
                        }*/
                        }else{
                            LWGameCanvas.deleteScreen(this);
                            LWGameCanvas.setActive(returnScreen, true);
                        }
                    }else if(GamingScreen.confirmIndex == 5){//魔法吸星
                        if(this.selectIndex==1){
                            topUp();
                        /*if(buyingSuccessMark==true){
                            GamingScreen.hero.setLan(GamingScreen.hero.getLan()+60);
                            GamingScreen.hero.setState(Hero.STAGE_XIJIN);
                            LWGameCanvas.setActive(returnScreen, true);
                        } else {
                            LWGameCanvas.deleteScreen(this);
                            LWGameCanvas.setActive(returnScreen, true);
                        }*/
                        }else{
                            LWGameCanvas.deleteScreen(this);
                            LWGameCanvas.setActive(returnScreen, true);
                        }
                    }
//		    	GamingScreen.confirmIndex=0;
                }else if(returnScreen.getClass().equals(SelectingHeroScreen.class)){
                    if(SelectingHeroScreen.selectIndex==0){
                        if(this.selectIndex==1){
                            topUp();
                        /*if(buyingSuccessMark==true){
                            Hero.isGot[SelectingHeroScreen.selectIndex]=true;
                            NetInfo.updateHeroData(SelectingHeroScreen.selectIndex);
                            LWGameCanvas.switchToScreen(new SelectingPetScreen(0));
                        } else {
                            LWGameCanvas.deleteScreen(this);
                            LWGameCanvas.setActive(returnScreen, true);
                        }*/
                        }else{
                            LWGameCanvas.deleteScreen(this);
                            LWGameCanvas.setActive(returnScreen, true);
                        }
                    }else if(SelectingHeroScreen.selectIndex==1){
                        if(this.selectIndex==1){
                            topUp();
                        /*if(buyingSuccessMark==true){
                            Hero.isGot[SelectingHeroScreen.selectIndex]=true;
                            NetInfo.updateHeroData(SelectingHeroScreen.selectIndex);
                            LWGameCanvas.switchToScreen(new SelectingPetScreen(0));
                        }else {
                            LWGameCanvas.deleteScreen(this);
                            LWGameCanvas.setActive(returnScreen, true);	                        }*/
                        }else{
                            LWGameCanvas.deleteScreen(this);
                            LWGameCanvas.setActive(returnScreen, true);
                        }
                    }else if(SelectingHeroScreen.selectIndex==2){
                        if(this.selectIndex==1){
                            topUp();
                        /*if(buyingSuccessMark==true){
                            Hero.isGot[SelectingHeroScreen.selectIndex]=true;
                            NetInfo.updateHeroData(SelectingHeroScreen.selectIndex);
                            LWGameCanvas.switchToScreen(new SelectingPetScreen(0));
                        }else {
                            LWGameCanvas.deleteScreen(this);
                            LWGameCanvas.setActive(returnScreen, true);
                        }*/
                        }else{
                            LWGameCanvas.deleteScreen(this);
                            LWGameCanvas.setActive(returnScreen, true);
                        }
                    }else if(SelectingHeroScreen.selectIndex==3){
                        if(this.selectIndex==1){
                            topUp();
                        /*if(buyingSuccessMark==true){
                            Hero.isGot[SelectingHeroScreen.selectIndex]=true;
                            NetInfo.updateHeroData(SelectingHeroScreen.selectIndex);
                            LWGameCanvas.switchToScreen(new SelectingPetScreen(0));
                        }else {
                            LWGameCanvas.deleteScreen(this);
                            LWGameCanvas.setActive(returnScreen, true);
                        }*/
                        }else{
                            LWGameCanvas.deleteScreen(this);
                            LWGameCanvas.setActive(returnScreen, true);
                        }
                    }
                } else if (returnScreen.getClass().equals(SelectingPetScreen.class)) {
                    if(this.selectIndex==1){
                        topUp();
					/*if(SelectingPetScreen.petSelectIndex == 0){
						//飞行宠
						GameVariables.isFlyPetGot[GameVariables.initPet[0][1]] = true;
						NetInfo.savePetInfo(GameVariables.isFlyPetGot, 33);
	        			
					}else if(SelectingPetScreen.petSelectIndex == 1){
						//陆地宠
						GameVariables.isLandPetGot[GameVariables.initPet[1][1]] = true;
						NetInfo.savePetInfo(GameVariables.isLandPetGot, 34);
					}
					LWGameCanvas.switchToScreen(new SelectingPetScreen(0));*/
                    }else{
                        LWGameCanvas.deleteScreen(this);
                        LWGameCanvas.setActive(returnScreen, true);
                    }
                }
            } else if (confirmStage == 2){
                System.out.println("update  stage ==2--------");
                if(returnScreen.getClass().equals(MFairyCastleScreen.class)){
                    LWGameCanvas.deleteScreen(this);
                    LWGameCanvas.setActive(returnScreen, true);
                }else if(returnScreen.getClass().equals(GamingScreen.class)){
                    LWGameCanvas.deleteScreen(this);
                    if (GamingScreen.confirmIndex == 2) {
                        LWGameCanvas.switchToScreen(new FailureScreen(0));
                    } else {
                        LWGameCanvas.setActive(returnScreen, true);
                        GamingScreen.confirmIndex = 0;
                    }
                }else if(returnScreen.getClass().equals(SelectingHeroScreen.class)){
                    LWGameCanvas.deleteScreen(this);
                    LWGameCanvas.setActive(returnScreen, true);
                } else if (returnScreen.getClass().equals(SelectingPetScreen.class)) {
                    LWGameCanvas.deleteScreen(this);
                    LWGameCanvas.setActive(returnScreen, true);
                }

            } else if (confirmStage == 1) {
                if(returnScreen.getClass().equals(MFairyCastleScreen.class)){
                    if (MFairyCastleScreen.selectIndex == 0) {
//						if (buyingSuccessMark == true) {
                        Hero.heroChongTime[heroId] += 10;
                        Hero.heroChongTimeLV[heroId] += 1;
                        NetInfo.updateHeroData(heroId);
//						}
                    } else if (MFairyCastleScreen.selectIndex == 1) {
//						if (buyingSuccessMark == true) {
                        Hero.heroInvincibleTime[heroId] += 10;
                        Hero.heroInvincibleTimeLV[heroId] += 1;
                        NetInfo.updateHeroData(heroId);
//						}
                    } else if (MFairyCastleScreen.selectIndex == 2) {
//	                        if(buyingSuccessMark==true){
                        Hero.heroXiangYun[heroId]+=10;
                        Hero.heroXiangYunLV[heroId]+= 1;
                        NetInfo.updateHeroData(heroId);
//	                        }
                    } else if (MFairyCastleScreen.selectIndex == 3) {
//						if (buyingSuccessMark == true) {
                        Hero.heroSuckStar[heroId] += 2;
                        Hero.heroSuckStarLV[heroId] += 1;
                        NetInfo.updateHeroData(heroId);
//						}
                    }
                    LWGameCanvas.deleteScreen(this);
                    LWGameCanvas.setActive(returnScreen, true);
                }else if(returnScreen.getClass().equals(GamingScreen.class)){
                    if(GamingScreen.confirmIndex==1){//冲技能
//	                        if(buyingSuccessMark==true){
                        GamingScreen.hero.setLan(GamingScreen.hero.getLan()+60);
                        GamingScreen.hero.setState(Hero.STAGE_CHONG);
//	                        }
                    }else if(GamingScreen.confirmIndex == 2){//英雄复活
//	                        if(buyingSuccessMark==true){
                        GamingScreen.hero.setDead(false);
                        GamingScreen.hero.setState(Hero.STAGE_BUFF);
//	                            LWGameCanvas.deleteScreen(this);
//	                            LWGameCanvas.setActive(returnScreen, true);
//	                        }
                    }else if(GamingScreen.confirmIndex == 3){//魔法护盾
//	                        if(buyingSuccessMark==true){
                        GamingScreen.hero.setLan(GamingScreen.hero.getLan()+60);
                        GamingScreen.hero.setState(Hero.STAGE_INVINCIBLE);
//	                        }
                    }else if(GamingScreen.confirmIndex == 4){//魔法祥云
//	                        if(buyingSuccessMark==true){
                        GamingScreen.hero.setLan(GamingScreen.hero.getLan()+60);
                        GamingScreen.numFillYun += Hero.heroXiangYun[GameVariables.heroIndex];
                        GamingScreen.isFillYun = true;
//	                        }
                    }else if(GamingScreen.confirmIndex == 5){//魔法吸星
//	                        if(buyingSuccessMark==true){
                        GamingScreen.hero.setLan(GamingScreen.hero.getLan()+60);
                        GamingScreen.hero.setState(Hero.STAGE_XIJIN);
//	                        }
                    }
                    LWGameCanvas.deleteScreen(this);
                    LWGameCanvas.setActive(returnScreen, true);
//			    	LWGameCanvas.switchToScreen(returnScreen);
                    GamingScreen.confirmIndex=0;
                }else if(returnScreen.getClass().equals(SelectingHeroScreen.class)){
                    if(SelectingHeroScreen.selectIndex==0){
//	                        if(buyingSuccessMark==true){
                        Hero.isGot[SelectingHeroScreen.selectIndex]=true;
                        NetInfo.updateHeroData(SelectingHeroScreen.selectIndex);
                        System.out.println("------");
//                        LoadingScreen.loadIndex = 2;
//                        LWGameCanvas.switchToScreen(new LoadingScreen(GameVariables.LOADING_SCREEN_ID));
                        LWGameCanvas.deleteScreen(this);
                        LWGameCanvas.setActive(returnScreen, true);
//	                        }
                    }else if(SelectingHeroScreen.selectIndex==1){
//	                        if(buyingSuccessMark==true){
                        Hero.isGot[SelectingHeroScreen.selectIndex]=true;
                        NetInfo.updateHeroData(SelectingHeroScreen.selectIndex);
//                        LoadingScreen.loadIndex = 2;
//                        LWGameCanvas.switchToScreen(new LoadingScreen(GameVariables.LOADING_SCREEN_ID));
                        LWGameCanvas.deleteScreen(this);
                        LWGameCanvas.setActive(returnScreen, true);
//	                        }
                    }else if(SelectingHeroScreen.selectIndex==2){
//	                        if(buyingSuccessMark==true){
                        Hero.isGot[SelectingHeroScreen.selectIndex]=true;
                        NetInfo.updateHeroData(SelectingHeroScreen.selectIndex);
//                        LoadingScreen.loadIndex = 2;
//                        LWGameCanvas.switchToScreen(new LoadingScreen(GameVariables.LOADING_SCREEN_ID));
                        LWGameCanvas.deleteScreen(this);
                        LWGameCanvas.setActive(returnScreen, true);
//	                        }
                    }else if(SelectingHeroScreen.selectIndex==3){
//	                        if(buyingSuccessMark==true){
                        Hero.isGot[SelectingHeroScreen.selectIndex]=true;
                        NetInfo.updateHeroData(SelectingHeroScreen.selectIndex);
//                        LoadingScreen.loadIndex = 2;
//                        LWGameCanvas.switchToScreen(new LoadingScreen(GameVariables.LOADING_SCREEN_ID));
                        LWGameCanvas.deleteScreen(this);
                        LWGameCanvas.setActive(returnScreen, true);
//	                        }
                    }
                } else if (returnScreen.getClass().equals(SelectingPetScreen.class)) {
                    if(SelectingPetScreen.petSelectIndex == 0){
                        //飞行宠
                        GameVariables.isFlyPetGot[GameVariables.initPet[0][1]] = true;
                        NetInfo.savePetInfo(GameVariables.isFlyPetGot, 33);

                    }else if(SelectingPetScreen.petSelectIndex == 1){
                        //陆地宠
                        GameVariables.isLandPetGot[GameVariables.initPet[1][1]] = true;
                        NetInfo.savePetInfo(GameVariables.isLandPetGot, 34);
                    }
//						LWGameCanvas.switchToScreen(new SelectingPetScreen(0));
                    LWGameCanvas.deleteScreen(this);
                    LWGameCanvas.setActive(returnScreen, true);
                }

            }
        }else if(LWGameCanvas.iskeyPressed(Globe.M_KEY_0)){
            if(returnScreen.getClass().equals(GamingScreen.class)&& GamingScreen.confirmIndex == 2){
                LWGameCanvas.deleteScreen(this);
                LWGameCanvas.switchToScreen(new FailureScreen(0));
            }else{
                LWGameCanvas.deleteScreen(this);
                LWGameCanvas.setActive(returnScreen, true);
            }
        }
        LWGameCanvas.keyReset();
    }

    private boolean buyingSuccessMark=false;
    private boolean returnFromThe9 = false;
    The9InputScreen tis;
    private void topUp(){
        if (Globe.isAutoTopUp && Globe.needMoreToken>0) {
            System.out.println("-------------000");
            returnFromThe9 = true;
            tic=new The9InputCanvas(LWGameCanvas.rmidlet,NetInfo.netHander,itemPrice[buyIndex],Globe.needMoreToken,wareName[buyIndex]);
            tic.start();
            if(tic.isPayOK()){
                confirmStage = 1;
                NetInfo.buyItemNotEnoughToken();
                System.out.println("pay:true");
                Globe.token=0;
                buyingSuccessMark=true;
//				LWGameCanvas.deleteScreen(this);
            }else{
                confirmStage = 2;
                System.out.println("netHander.getMessage:"+NetInfo.netHander.getReceiveString());
                System.out.println("pay:false");
            }
            tic.end();
            tic = null;
//            tis = new The9InputScreen(NetInfo.netHander,itemPrice[buyIndex], Globe.needMoreToken,wareName[buyIndex]);
//            The9InputScreen.returnScreen = returnScreen;
//            LWGameCanvas.deleteScreen(this);
//            LWGameCanvas.addScreen(tis);
//            confirmStage = 1;
//            confirmStage = 3;

        } else if (Globe.needMoreToken <= 0) {
            System.out.println("-------------000 true");
            NetInfo.buyItem(itemPrice[buyIndex], wareName[buyIndex]);
        } else{
            System.out.println("-------------222 false");
            confirmStage = 2;
        }
    }

}
