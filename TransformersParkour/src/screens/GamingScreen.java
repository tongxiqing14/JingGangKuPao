package screens;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

import Entry.LWGameCanvas;
import common.*;
import elements.Enemy;
import elements.Hero;
import elements.Road;
//import iptvNet.IptvNetException;
import motion.Motion;
import org.json.me.JSONArray;
import org.json.me.JSONException;

public class GamingScreen extends Screen {

    public static final String GAMING_UI_PATH = "gaming/ui/";
    public static common.Vector roadVec = new Vector(); // road
    public static common.Vector starVec = new Vector(); // star
    public static int bgMoveFram = 10;
    public static int bgMoveFramTemp = bgMoveFram;
    public static int moveCount = 0;
    public static boolean isAddMap = false;
    public static final String ROAD_PATH = "road/";
    public static Image mapHead;
    public static Image mapBody;
    public static Image mapEnd;
    public boolean mapInit = true;
    public static int gameLevel = 0;

    public static Screen returnScreen;
    public static int achieveLen = 0;
    public static Image imgNUM;
    public static Image imgFillYun;

    private Image imgBG;// 地图背景
    private Image imgNewBG;// 地图背景
    private Image slashImg;
    private Image mImg;
//    private Image imgHead;
//    private Image imgHero;
    private Image imgTiao;
    private Image imgTiao2;
    private Image imgDoJu;
//    private Image imgPause;
    private Image[] imgUIYun = new Image[2];
    private Image titleImg;

    private JSONArray kengInfo; // keng数据

    public static int[][] enemyInfo; // enemy数据
    public static Enemy enemys[];

    private common.Vector enemyVector = new common.Vector();
    public static Hero hero;
    public static Enemy enemyStar;
    public Enemy enemy;
    public Enemy alarmEnemy = null;
    public Enemy huoQiuEnemy = null;
    public static java.util.Vector vecRoad = new java.util.Vector(); // road
    public static int confirmIndex=0;
    public static boolean isPause = false;

    //训练计时
    int tutorialTime = 0;

//    private Image commonImage1;
    private Image tf_name;
    private Image lv1Img;

    private Image[] imgWhiteNum;
    private Image[] imgNum;

    Motion icon8a_motion;

    public GamingScreen(int screenId) {
        super(screenId);
        isFillYun = false;
        isAddMap = false;
        isPause = false;
    }

    public void init() {
        Globe.downloadOver = false;
        Globe.downloadStage = 0;
        LWGameCanvas.commonBgImage = null;

        icon8a_motion = new Motion("/game/icon8a.anu",60,80);
        icon8a_motion.keepId(0);

        initRoadRes();
//		initEnemyInfo();

        slashImg = Globe.getImage("gaming/whitenum/00.png");
        mImg = Globe.getImage("gaming/whitenum/m.png");

        imgNUM = Globe.getImage("gaming/gamingNum1.png");
        imgFillYun = Globe.getImage("effect/yun.png");

        lv1Img = Globe.getImage("gaming/ui/lv1.png");

        switch (GameVariables.heroIndex){
            case 0:
                tf_name = Globe.getImage("gaming/ui/a.png");
                titleImg = Globe.getImage("game/11.png");
                break;
            case 1:
                tf_name = Globe.getImage("gaming/ui/b.png");
                titleImg = Globe.getImage("game/22.png");
                break;
            case 2:
                tf_name = Globe.getImage("gaming/ui/c.png");
                titleImg = Globe.getImage("game/33.png");
                break;
            case 3:
                tf_name = Globe.getImage("gaming/ui/d.png");
                titleImg = Globe.getImage("game/44.png");
                break;
        }

        imgWhiteNum = new Image[10];
        for(int i=0; i<imgWhiteNum.length; i++){
            imgWhiteNum[i] = Globe.getImage("gaming/whitenum/" + i + ".png");
        }

        imgNum = new Image[10];
        for(int i=0; i<imgNum.length; i++){
            imgNum[i] = Globe.getImage("gaming/blacknum/" + i + ".png");
        }

        initUI();

        hero = new Hero(Globe.SW >> 2, Globe.SH * 2 / 3 + 2, GameVariables.heroIndex);
        hero.setState(Hero.STAGE_MOVE);
        moveCount = 0;
        achieveLen = 0;

//        commonImage1 = Globe.getImage("common/commonBG1.png");
    }

    public void loding() {
        switch (Globe.downloadStage) {
            case 0:
                // initRoadRes();
                // imgNUM = Globe.getImage("gaming/gamingNum1.png");
                // imgFillYun = Globe.getImage("effect/yun.png");
                break;
            case 1:
                // hero = new Hero(Globe.SW >> 1, Globe.SH * 2 / 3 + 2,
                // GameVariables.heroIndex);
                // hero.setState(Hero.STAGE_MOVE);
                // mEnemy = new Enemy(0, 600, 250);
                break;
            case 2:
                // initUI();
                break;
            case 3:
                Globe.downloadOver = true;
                break;
        }
        Globe.downloadStage++;
    }

    private void initUI() {
//        imgHead = Globe.getImage(GAMING_UI_PATH + "head.png");
//        imgHero = Globe.getImage(GAMING_UI_PATH + "hero" + GameVariables.heroIndex + ".png");
        imgTiao2 = Globe.getImage(GAMING_UI_PATH + "tiao2.png");
        imgTiao = Globe.getImage(GAMING_UI_PATH + "tiao.png");
        imgDoJu = Globe.getImage(GAMING_UI_PATH + "daoju.png");
//        imgPause = Globe.getImage("game/pause.png");
        for (int i = 0; i < imgUIYun.length; i++) {
            imgUIYun[i] = Globe.getImage(GAMING_UI_PATH + "yun" + i + ".png");
        }
    }

    private void initRoadRes() {
        roadVec.removeAllElements();
        //imgBG = mapEnd = Globe.getImage(ROAD_PATH + "bg.png");
        imgNewBG = Globe.getImage("stageSelect/level" + gameLevel + ".jpg");
        System.out.println("gameLevel---" + gameLevel);
        // 初始化跑道、kengInfo跑道坑的数据、enemyInfo敌人数据
        // 共八大关　前七关有三小关　第八关为无尽关
        switch (gameLevel) {
            // stage 1
            case 0:
                // LWGameCanvas.commonBgImage = mapEnd = Globe.getImage(ROAD_PATH +
                // "level.png");
                if (Globe.isEndLess) {
                    huoQiuInterval = 15;
                }else {
                    huoQiuInterval = 138;
                }
                mapHead = Globe.getImage(ROAD_PATH + "caodi01.png");
                mapBody = Globe.getImage(ROAD_PATH + "caodi02.png");
                mapEnd = Globe.getImage(ROAD_PATH + "caodi03.png");
                break;
//            case 1:
//                if (Globe.isEndLess) {
//                    huoQiuInterval = 15;
//                }else {
//                    huoQiuInterval = 128;
//                }
//                mapHead = Globe.getImage(ROAD_PATH + "caodi01.png");
//                mapBody = Globe.getImage(ROAD_PATH + "caodi02.png");
//                mapEnd= Globe.getImage(ROAD_PATH + "caodi03.png");
//                break;
//            case 2:
//                huoQiuInterval = 128;
//                if (Globe.isEndLess) {
//                    huoQiuInterval = 15;
//                }
//                mapHead = Globe.getImage(ROAD_PATH + "caodi01.png");
//                mapBody = Globe.getImage(ROAD_PATH + "caodi02.png");
//                mapEnd= Globe.getImage(ROAD_PATH + "caodi03.png");
//                break;
            // stage 2
            case 1:
                huoQiuInterval = 110;
                if (Globe.isEndLess) {
                    huoQiuInterval = 15;
                }
                mapHead = Globe.getImage(ROAD_PATH + "caodi01.png");
                mapBody = Globe.getImage(ROAD_PATH + "caodi02.png");
                mapEnd= Globe.getImage(ROAD_PATH + "caodi03.png");
                break;
//            case 4:
//                huoQiuInterval = 115;
//                if (Globe.isEndLess) {
//                    huoQiuInterval = 15;
//                }
//                mapHead = Globe.getImage(ROAD_PATH + "caodi01.png");
//                mapBody = Globe.getImage(ROAD_PATH + "caodi02.png");
//                mapEnd= Globe.getImage(ROAD_PATH + "caodi03.png");
//                break;
//            case 5:
//                huoQiuInterval = 115;
//                if (Globe.isEndLess) {
//                    huoQiuInterval = 15;
//                }
//                mapHead = Globe.getImage(ROAD_PATH + "caodi01.png");
//                mapBody = Globe.getImage(ROAD_PATH + "caodi02.png");
//                mapEnd= Globe.getImage(ROAD_PATH + "caodi03.png");
//                break;
            // stage 3
            case 2:
                huoQiuInterval = 112;
                if (Globe.isEndLess) {
                    huoQiuInterval = 15;
                }
                mapHead = Globe.getImage(ROAD_PATH + "caodi01.png");
                mapBody = Globe.getImage(ROAD_PATH + "caodi02.png");
                mapEnd= Globe.getImage(ROAD_PATH + "caodi03.png");
                break;
//            case 7:
//                huoQiuInterval = 112;
//                if (Globe.isEndLess) {
//                    huoQiuInterval = 15;
//                }
//                mapHead = Globe.getImage(ROAD_PATH + "caodi01.png");
//                mapBody = Globe.getImage(ROAD_PATH + "caodi02.png");
//                mapEnd= Globe.getImage(ROAD_PATH + "caodi03.png");
//                break;
//            case 8:
//                huoQiuInterval = 110;
//                if (Globe.isEndLess) {
//                    huoQiuInterval = 15;
//                }
//                mapHead = Globe.getImage(ROAD_PATH + "caodi01.png");
//                mapBody = Globe.getImage(ROAD_PATH + "caodi02.png");
//                mapEnd= Globe.getImage(ROAD_PATH + "caodi03.png");
//                break;
            // stage 4
            case 3:
                huoQiuInterval = 115;
                if (Globe.isEndLess) {
                    huoQiuInterval = 15;
                }
                mapHead = Globe.getImage(ROAD_PATH + "huoshan01.png");
                mapBody = Globe.getImage(ROAD_PATH + "huoshan02.png");
                mapEnd= Globe.getImage(ROAD_PATH + "huoshan03.png");
                break;
//            case 10:
//                huoQiuInterval = 118;
//                if (Globe.isEndLess) {
//                    huoQiuInterval = 15;
//                }
//                mapHead = Globe.getImage(ROAD_PATH + "huoshan01.png");
//                mapBody = Globe.getImage(ROAD_PATH + "huoshan02.png");
//                mapEnd= Globe.getImage(ROAD_PATH + "huoshan03.png");
//                break;
//            case 11:
//                huoQiuInterval = 118;
//                if (Globe.isEndLess) {
//                    huoQiuInterval = 15;
//                }
//                mapHead = Globe.getImage(ROAD_PATH + "huoshan01.png");
//                mapBody = Globe.getImage(ROAD_PATH + "huoshan02.png");
//                mapEnd= Globe.getImage(ROAD_PATH + "huoshan03.png");
//                break;
            // stage 5
            case 4:
                huoQiuInterval = 118;
                if (Globe.isEndLess) {
                    huoQiuInterval = 15;
                }
                mapHead = Globe.getImage(ROAD_PATH + "huoshan01.png");
                mapBody = Globe.getImage(ROAD_PATH + "huoshan02.png");
                mapEnd= Globe.getImage(ROAD_PATH + "huoshan03.png");
                break;
//            case 13:
//                huoQiuInterval = 102;
//                if (Globe.isEndLess) {
//                    huoQiuInterval = 15;
//                }
//                mapHead = Globe.getImage(ROAD_PATH + "huoshan01.png");
//                mapBody = Globe.getImage(ROAD_PATH + "huoshan02.png");
//                mapEnd= Globe.getImage(ROAD_PATH + "huoshan03.png");
//                break;
//            case 14:
//                huoQiuInterval = 102;
//                if (Globe.isEndLess) {
//                    huoQiuInterval = 15;
//                }
//                mapHead = Globe.getImage(ROAD_PATH + "huoshan01.png");
//                mapBody = Globe.getImage(ROAD_PATH + "huoshan02.png");
//                mapEnd= Globe.getImage(ROAD_PATH + "huoshan03.png");
//                break;
            // stage 6
            case 5:
                huoQiuInterval = 98;
                if (Globe.isEndLess) {
                    huoQiuInterval = 15;
                }
                mapHead = Globe.getImage(ROAD_PATH + "bing01.png");
                mapBody = Globe.getImage(ROAD_PATH + "bing02.png");
                mapEnd= Globe.getImage(ROAD_PATH + "bing03.png");
                break;
//            case 16:
//                huoQiuInterval = 90;
//                if (Globe.isEndLess) {
//                    huoQiuInterval = 15;
//                }
//                mapHead = Globe.getImage(ROAD_PATH + "bing01.png");
//                mapBody = Globe.getImage(ROAD_PATH + "bing02.png");
//                mapEnd= Globe.getImage(ROAD_PATH + "bing03.png");
//                break;
//            case 17:
//                huoQiuInterval = 90;
//                if (Globe.isEndLess) {
//                    huoQiuInterval = 15;
//                }
//                mapHead = Globe.getImage(ROAD_PATH + "bing01.png");
//                mapBody = Globe.getImage(ROAD_PATH + "bing02.png");
//                mapEnd= Globe.getImage(ROAD_PATH + "bing03.png");
//                break;
            // stage 7
            case 6:
                huoQiuInterval = 86;
                if (Globe.isEndLess) {
                    huoQiuInterval = 15;
                }
                mapHead = Globe.getImage(ROAD_PATH + "bing01.png");
                mapBody = Globe.getImage(ROAD_PATH + "bing02.png");
                mapEnd= Globe.getImage(ROAD_PATH + "bing03.png");
                break;
//            case 19:
//                huoQiuInterval = 85;
//                if (Globe.isEndLess) {
//                    huoQiuInterval = 15;
//                }
//                mapHead = Globe.getImage(ROAD_PATH + "bing01.png");
//                mapBody = Globe.getImage(ROAD_PATH + "bing02.png");
//                mapEnd= Globe.getImage(ROAD_PATH + "bing03.png");
//                break;
//            case 20:
//                huoQiuInterval = 85;
//                if (Globe.isEndLess) {
//                    huoQiuInterval = 15;
//                }
//                mapHead = Globe.getImage(ROAD_PATH + "bing01.png");
//                mapBody = Globe.getImage(ROAD_PATH + "bing02.png");
//                mapEnd= Globe.getImage(ROAD_PATH + "bing03.png");


//                break;
        }

        kengInfo = NetInfo.netHander.getStageData(gameLevel);

    }

    public int deadFrame;

    public void update() {
        icon8a_motion.keepId(0);
        icon8a_motion.update(60,80);
//        if (LWGameCanvas.iskeyPressed(Globe.M_KEY_DOWN)) {
//            isPause = !isPause;
//            LWGameCanvas.keyReset();
//        }
        if (isPause) {
            return;
        }
        if (!Globe.downloadOver) {
            loding();
        } else {
            hero.update();// 英雄
            if (hero.isDead) {
                //deadFrame++;
                if (GameVariables.initPet[0][0] == 1 || GameVariables.initPet[1][0] == 1) {
                    //deadFrame = 0;
                    if (GameVariables.initPet[1][0] == 1) {
                        hero.pet = null;
//                        Hero.G_Y += 0.4;
                        GameVariables.initPet[1][0] = 0;
                    } else {
                        hero.pet2 = null;
                        GameVariables.initPet[1][0] = 0;
//                        Hero.G_Y += 0.4;
                        hero.pet = null;
                        GameVariables.initPet[0][0] = 0;
                    }
                    hero.setDead(false);
                    hero.setState(Hero.STAGE_BUFF);
                } else {
                    //deadFrame = 0;
                    // 复活界面
                    this.setActive(false);
//                    confirmIndex = 2;
//                    ConfirmScreen.buyIndex=25;
//                    ConfirmScreen.returnScreen = this;
//                    LWGameCanvas.addScreen(new ConfirmScreen(GameVariables.CONFIRM_SCREEN_ID));
//                    LWGameCanvas.deleteScreen(this);
                    LWGameCanvas.addScreen(new FailureScreen(0));
                }
            }

            addStars();
            for (int i = starVec.size() - 1; i >= 0; i--) {
                Enemy enemy = ((Enemy) starVec.elementAt(i));

                if (!enemy.isActive) {
                    starVec.removeElementAt(i);
                    enemy = null;
                    continue;
                }
                enemy.update();
            }

            // mEnemy.update();
            addEnemy();
            addMap();
            for (int i = enemyVector.size() - 1; i >= 0; i--) {
                Enemy enemy = ((Enemy) enemyVector.elementAt(i));
                if (enemy.deadMotion != null) {

                    if (enemy.deadMotion.getCurrentFrame() == 5) {
                        enemyVector.removeElementAt(i);
                        enemy = null;
//						enemys[i] = null;
                        continue;
                    }
                }
                enemy.update();
            }
            for (int i = roadVec.size() - 1; i >= 0; i--) {
                Road map = ((Road) roadVec.elementAt(i));
                if (map.active) {
                    map.update();
                    updateCollised(map);
                }else {
                    roadVec.removeElement(map);
                    map = null;
                }
            }
            teXiaoUpdate();

            //非训练模式下，响应按键
            if(!GameVariables.isTrainning){
//                if (LWGameCanvas.iskeyPressed(Globe.M_KEY_7)) {
//                    this.setActive(false);
//                    GiftTipScreen.returnScreen = this;
//                    LWGameCanvas.addScreen(new GiftTipScreen(0));
//                }else
                if (LWGameCanvas.iskeyPressed(Globe.M_KEY_OK)) {
                    bgMoveFramTemp = bgMoveFram;
                    if (Globe.isEndLess) {
                        bgMoveFram *= 2;
                    } else {
                        bgMoveFram = 20;
                    }
                    if (hero.getLan() >= 40) {
                        hero.setLan(hero.getLan() - 40);
                        GamingScreen.hero.setState(Hero.STAGE_CHONG);
                    } else {
                        confirmIndex = 1;
                        ConfirmScreen.buyIndex = 26;
                        // GamingScreen.numFillYun=0;
                        ConfirmScreen.returnScreen = this;
                        LWGameCanvas.addScreen(new ConfirmScreen(GameVariables.CONFIRM_SCREEN_ID));
                    }
                } else if (LWGameCanvas.iskeyPressed(Globe.M_KEY_RIGHT)) {
                    if(Hero.canSetInvincible == true){
                        if(hero.getLan() >= 30)
                        {
                            hero.setLan(hero.getLan()-30);
                            hero.setState(Hero.STAGE_INVINCIBLE);
                        }
                        else
                        {
                            confirmIndex = 3;
                            ConfirmScreen.buyIndex=27;
//							GamingScreen.numFillYun=0;
                            ConfirmScreen.returnScreen = this;
                            LWGameCanvas.addScreen(new ConfirmScreen(GameVariables.CONFIRM_SCREEN_ID));
                        }
                    }else if(hero.isChong != true){
                        Hero.canSetInvincible = true;
                    }
                } else if (LWGameCanvas.iskeyPressed(Globe.M_KEY_DOWN)) {
                    if(hero.getLan() >= 30)
                    {
                        hero.setLan(hero.getLan()-30);
                        isFillYun = true;
                    }
                    else
                    {
                        confirmIndex = 4;
                        ConfirmScreen.buyIndex=28;
                        ConfirmScreen.returnScreen = this;
                        LWGameCanvas.addScreen(new ConfirmScreen(GameVariables.CONFIRM_SCREEN_ID));
                    }

                } else if (LWGameCanvas.iskeyPressed(Globe.M_KEY_0)) {
                    this.setActive(false);
                    TipsScreen.returnScreen = this;
                    LWGameCanvas.addScreen(new TipsScreen(0));
/*					LWGameCanvas.deleteScreen(this);
					LoadingScreen.loadIndex = 3;
					LWGameCanvas.switchToScreen(new LoadingScreen(GameVariables.LOADING_SCREEN_ID));*/
                } else if (LWGameCanvas.iskeyPressed(Globe.M_KEY_LEFT)) {
                    if (!hero.isXiJin) {
                        if(hero.getLan() >= 30)
                        {
                            hero.setLan(hero.getLan()-30);;
                            hero.setState(Hero.STAGE_XIJIN);
                        }
                        else
                        {
                            confirmIndex = 5;
                            ConfirmScreen.buyIndex=29;
//							GamingScreen.numFillYun=0;
                            ConfirmScreen.returnScreen = this;
                            LWGameCanvas.addScreen(new ConfirmScreen(GameVariables.CONFIRM_SCREEN_ID));
                        }

                    }
                }
            }
            LWGameCanvas.keyReset();
            /**
             * 检测普通Enemy
             */
            for (int i = enemyVector.size() - 1; i >= 0; i--) {
                Enemy tempEnemy = (Enemy) enemyVector.elementAt(i);
                if (tempEnemy.isActive && !hero.isDead && hero.getStage() != Hero.STAGE_BUFF) {
                    if (hero.isChong) {
                        if (Globe.getchongCollision(hero.chongfengMotion, tempEnemy)) {
                            tempEnemy.isActive = false;
                        }
                    } else if (Hero.isInvincible) {
                        if (tempEnemy.type != 15) {//dici
                            switch (Globe.getnormalCollision(hero, tempEnemy)) {
                                case 0:
                                case 1:
                                    tempEnemy.isActive = false;
                                    hero.setLan(hero.getLan()+ 1);
                                    GameVariables.point ++;
                                    starVec.addElement(new Enemy(14, tempEnemy.factX + 100, tempEnemy.factY));
                                    break;
                            }
                        }

                    } else if (hero.isJump) {
                        int stateCollision = Globe.getnormalCollision(hero, tempEnemy);
                        if (tempEnemy.type == 15 && stateCollision != -1) {
                            stateCollision = 0;
                        }
                        switch (stateCollision) {
                            case 0:
                                hero.setDead(true);
                                hero.setState(Hero.STAGE_BEATTACK);
                                //hero.isfightingdead = true;
                                System.out.println("英雄死亡");
                                break;

                            case 1:
                                tempEnemy.isActive = false;
                                hero.setState(Hero.STAGE_BOUNCE);
                                GameVariables.point ++;
                                hero.setLan(hero.getLan()+ 1);
                                starVec.addElement(new Enemy(14, tempEnemy.factX + 100, tempEnemy.factY));
                                break;
                        }

                    } else if (Hero.STAGE_MOVE == hero.stage) {
                        if (Globe.getchongCollision(hero.motion, tempEnemy)) {
                            //hero.setDead(true);
                            hero.setState(Hero.STAGE_BEATTACK);
                            //hero.isfightingdead = true;
                            System.out.println("行走状态死亡");
                        }

                    }
                }
            }
            /**
             * 检测Star
             */
            for (int i = starVec.size() - 1; i >= 0; i--) {
                Enemy starEnemy = (Enemy) starVec.elementAt(i);
                if (starEnemy.isActive && !hero.isDead) {
                    if (Hero.isChong) {
                        if (Globe.getchongCollision2(hero.chongfengMotion, starEnemy)) // 检测冲锋motion与怪的碰撞
                        {
                            starEnemy.isActive = false;
//                        System.out.println("++++----*****++++----*****");
//                            starEnemy.isActive = false;
                            GameVariables.point ++;
                            hero.setLan(hero.getLan()+ 1);
                        }
                    } else {
//                        if (Globe.getnormalCollision(hero, starEnemy)==1 && starEnemy.isVisible)
//                        System.out.println("***"+Globe.getchongCollision(hero.motion, starEnemy));
//                        System.out.println("@@@"+starEnemy.isVisible);

                        if (Globe.getchongCollision2(hero.motion, starEnemy) && starEnemy.isVisible) // 检测英雄motion与怪的碰撞
                        {
                            starEnemy.isActive = false;
//                        System.out.println("*****++++----*****");
                            GameVariables.point ++;
                            hero.setLan(hero.getLan()+ 1);
                        }
                    }
                }
                if (hero.pet != null && Globe.getchongCollision(hero.pet.motion, starEnemy)) {
                    starEnemy.isActive = false;
                }
                if (hero.pet2 != null && Globe.getchongCollision(hero.pet2.motion, starEnemy)) {
                    starEnemy.isActive = false;
                }
            }

            //训练内容
            if(GameVariables.isTrainning){
                GameVariables.isTutorial = true;
                tutorialTime++;
                if(tutorialTime==10){
                    TutorialScreen.returnScreen = this;
                    TutorialScreen.returnScreen.setActive(false);
                    LWGameCanvas.addScreen(new TutorialScreen(GameVariables.TUTORIAL_SCREEN_ID,TutorialScreen.TUTORIALTYPE_INIT));
                }else if(tutorialTime==50){
                    TutorialScreen.returnScreen = this;
                    LWGameCanvas.addScreen(new TutorialScreen(GameVariables.TUTORIAL_SCREEN_ID,TutorialScreen.TUTORIALTYPE_CLOUD));
                }else if(tutorialTime == 80){
                    TutorialScreen.returnScreen = this;
                    LWGameCanvas.addScreen(new TutorialScreen(GameVariables.TUTORIAL_SCREEN_ID,TutorialScreen.TUTORIALTYPE_SHIELD));
                }else if(tutorialTime == 150){
                    TutorialScreen.returnScreen = this;
                    LWGameCanvas.addScreen(new TutorialScreen(GameVariables.TUTORIAL_SCREEN_ID,TutorialScreen.TUTORIALTYPE_MAGNET));
                }else if(tutorialTime == 190){
                    TutorialScreen.returnScreen = this;
                    LWGameCanvas.addScreen(new TutorialScreen(GameVariables.TUTORIAL_SCREEN_ID,TutorialScreen.TUTORIALTYPE_FLY));
                }else if(tutorialTime == 230){
                    TutorialScreen.returnScreen = this;
                    LWGameCanvas.addScreen(new TutorialScreen(GameVariables.TUTORIAL_SCREEN_ID,TutorialScreen.TUTORIALTYPE_PAUSE));
                }else if(tutorialTime == 300){
                    TutorialScreen.returnScreen = this;
                    LWGameCanvas.addScreen(new TutorialScreen(GameVariables.TUTORIAL_SCREEN_ID,TutorialScreen.TUTORIALTYPE_END));
                }
            }
        }
    }

    private void teXiaoUpdate() {
        if (null != alarmEnemy && alarmEnemy.isVisible) {
            alarmEnemy.update();
        }
        if (null != huoQiuEnemy && huoQiuEnemy.isVisible) {
            huoQiuEnemy.update();
            if (huoQiuEnemy.factX < Globe.SW) {
                if (alarmEnemy != null) {
                    alarmEnemy.isVisible = false;
                    alarmEnemy = null;
                }
            }
            if (huoQiuEnemy.factX < -110) {
                huoQiuEnemy.isVisible = false;
            }
            if (hero.isDead) {
                return;
            }
            if (hero.isChong) {
//				if (Globe.getchongCollision(hero.chongfengMotion, huoQiuEnemy)) { // 检测冲锋motion与怪的碰撞
                //huoQiuEnemy.isVisible = false;
                //huoQiuEnemy.isActive = false;
//				}
            } else if(hero.isInvincible){
//				if (Globe.getnormalCollision(hero, huoQiuEnemy) != -1) { 
                //hero.setDead(true);
                //hero.setState(Hero.STAGE_BEATTACK);
                //huoQiuEnemy.isVisible = false;
                //huoQiuEnemy.isActive = false;
//				}
            } else {
                if (huoQiuEnemy.isVisible && Globe.getnormalCollision(hero, huoQiuEnemy) != -1) {
                    hero.setDead(true);
                    hero.setState(Hero.STAGE_BEATTACK);
                    hero.isfightingdead = true;
                    huoQiuEnemy.isVisible = false;
                    huoQiuEnemy.isActive = false;
                    huoQiuEnemy = null;
                }
            }
        }
    }

    int huoQiuInterval = 100;
    int huoQiuPosX = 900;
    private void addStars() {
        if (isAddMap && moveCount % 20 == 0) {
            starVec.addElement(new Enemy(13, 660, 150));
            starVec.addElement(new Enemy(13, 715, 150));
            starVec.addElement(new Enemy(13, 770, 150));
            starVec.addElement(new Enemy(13, 825, 150));
        }
        if (isAddMap && moveCount % huoQiuInterval == 0) {
            if (null == alarmEnemy) {
                alarmEnemy = new Enemy(17, 560, 250);
            }
            alarmEnemy.isVisible = true;
            if (null == huoQiuEnemy) {
                huoQiuEnemy = new Enemy(16, huoQiuPosX, 340);
            }
            huoQiuEnemy.isVisible = true;
            huoQiuEnemy.setFactX(huoQiuPosX);
            huoQiuEnemy.setPosx(huoQiuPosX);
            huoQiuEnemy.isActive = true;
        }
    }

    int count = 0;
    private void addEnemy() {
        for (int i = count; i < enemyInfo.length; i++) {
            if (moveCount == enemyInfo[i][1] && isAddMap) {
                enemyVector.addElement(enemys[i]);
                count ++;
            }
        }
    }

    private void updateCollised(Road map) {
        int heroX = hero.getPosX();
        int heroY = hero.getPosY();
        int x = map.x, y = map.y, len = map.len, type = map.type;
        if (0 == type && x > 0 && heroY > 350 && hero.getStage() != Hero.STAGE_DEADING && hero.getStage() != Hero.STAGE_BUFF) {
            if (0 < heroX - x && heroX - x < len) {
                hero.setState(Hero.STAGE_DEAD);
            }
        }
    }


    boolean isMapHead = false;
    int kengCount = 1;
    // private Enemy mEnemy;
    public static boolean isFillYun = false;
    public static int numFillYun = 6;
    int randomSelect;

    private void addMap() {
        if (mapInit) {
            roadVec.addElement(new Road(1, 0, 0, 0));
            roadVec.addElement(new Road(2, mapHead.getWidth(), 0, 0));
            for (int i = 0; i < 7; i++) {
                roadVec.addElement(new Road(2, mapHead.getWidth() + i * mapBody.getWidth(), 0, 0));
                moveCount++;
            }
            roadVec.addElement(new Road(3, mapHead.getWidth() + 7 * mapBody.getWidth(), 0, 0));
            mapInit = false;
        }
        int size = roadVec.size();
        if (isAddMap && size < 12) {
            Road theLast = (Road) roadVec.elementAt(size - 1);
            int x = theLast.x;

            for (int i = kengCount; i < kengInfo.length(); i++) {
                try {
                    if (moveCount == ((Integer)kengInfo.getJSONObject(i).getJSONArray("ken"+i).get(0)).intValue()) {
                        roadVec.addElement(new Road(0, x + theLast.len, 0, ((Integer)kengInfo.getJSONObject(i).getJSONArray("ken"+i).get(1)).intValue()));
                        isAddMap = false;
                        isMapHead = true;
                        kengCount = i;
                        return;
                    } else if ((moveCount + 1) == ((Integer)kengInfo.getJSONObject(i).getJSONArray("ken"+i).get(0)).intValue()) {
                        roadVec.addElement(new Road(3, x + theLast.len, 0, ((Integer)kengInfo.getJSONObject(i).getJSONArray("ken"+i).get(1)).intValue()));
                        isAddMap = false;
                        return;
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            if (isMapHead) {
                roadVec.addElement(new Road(1, x + theLast.len, 0, 0));
                isMapHead = false;
                if (kengCount == (kengInfo.length() - 1)) {
                    System.out.println("is end");
                    returnScreen = this;
                    // 勝利界面　選擇是否進入下一關
                    if (Globe.isEndLess) {
                        gameLevel = Globe.getRandom(6);
                        //bgMoveFram += 5;
                        LWGameCanvas.switchToScreen(new LoadingScreen(0));
                    } else {
//                        LWGameCanvas.deleteScreen(this);
                        this.setActive(false);
                        if(gameLevel + 2 > GameVariables.maxMapStage)  {
                            GameVariables.maxMapStage = gameLevel + 2; // save 最大关
                        }
                        LWGameCanvas.addScreen(new SuccessScreen(0, gameLevel + 1, GameVariables.heroIndex, achieveLen, GameVariables.point, 0));
                    }
                    return;
                }
            } else {
                roadVec.addElement(new Road(2, x + theLast.len, 0, 0));
            }
            isAddMap = false;
        }

    }
    public void draw(Graphics g) {
        g.setColor(0, 0, 0);
        g.fillRect(0, 0, Globe.SW, Globe.SH);
        g.drawImage(imgNewBG, 0, 0, Graphics.TOP | Graphics.LEFT);
        drawGameYun(g);
        for (int i = enemyVector.size() - 1; i >= 0; i--) {
            Enemy enemy = ((Enemy) enemyVector.elementAt(i));
            enemy.draw(g);
        }
        for (int i = roadVec.size() - 1; i >= 0; i--) {
            Road map = ((Road) roadVec.elementAt(i));
            map.draw(g);

        }
        for (int i = starVec.size() - 1; i >= 0; i--) {
            Enemy star = ((Enemy) starVec.elementAt(i));
            star.draw(g);
        }
        teXiaoDraw(g);
        hero.draw(g);
        drawGameBGUI(g);

//        icon8a_motion.draw(g);
        //int color = g.getColor();
        //g.setColor(0xeeee55);
//		g.setFont(Globe.BigBoldFont);
//        if (isPause) {
//            g.drawImage(imgPause, Globe.SW/2 - 150, Globe.SH/2 - 100, Graphics.TOP | Graphics.LEFT);
//        }
        //g.setColor(color);
//        commonImage1 = Globe.getImage("common/commonBG1.png");

        g.setFont(Globe.BigBoldFont);
        g.setColor(0xffffff);
        g.drawString("积分:", 120, 470, 20);
//        g.drawString(kengInfo.toString(), 120, 470, 20);
        g.setFont(Globe.defaultFont);
        g.setColor(0x000000);
    }

    private void teXiaoDraw(Graphics g) {
        if (null != alarmEnemy && alarmEnemy.isVisible) {
            alarmEnemy.draw(g);
        }
        if (null != huoQiuEnemy && huoQiuEnemy.isVisible) {
            huoQiuEnemy.draw(g);
        }

    }

    int maxRange = 1200;

    public void drawGameYun(Graphics g) {

        g.drawImage(imgUIYun[0], maxRange - 320 - imgUIYun[0].getWidth(), 40, Graphics.TOP | Graphics.LEFT);
        g.drawImage(imgUIYun[1], maxRange - imgUIYun[1].getWidth(), 80, Graphics.TOP | Graphics.LEFT);

        maxRange -= bgMoveFram;
        if (maxRange <= 0) {
            maxRange = 1200;
        }
    }

    public void drawGameBGUI(Graphics g) {
//        g.drawImage(imgHead, 0, 0, Graphics.TOP | Graphics.LEFT);

        // if (hero.isPet != 0) {
        g.drawImage(imgTiao2, 405, 13, Graphics.TOP | Graphics.LEFT);
        g.drawRegion(imgTiao, 0, 0, (int)(imgTiao.getWidth()*(hero.getLan()/(double)100)), imgTiao.getHeight(), 0, 437, 31, Graphics.TOP | Graphics.LEFT);
        // }
        g.drawImage(imgDoJu, 0, 338, Graphics.TOP | Graphics.LEFT);

        g.drawImage(titleImg, 0, 418, Graphics.TOP | Graphics.LEFT);
        if (null != imgNUM) {
//            Globe.drawNum(g, achieveLen, 160, 50, imgNUM, 0);

            Globe.drawNum(g, achieveLen, 200, 30, imgWhiteNum, 1);
            g.drawImage(slashImg, 265, 30, Graphics.TOP | Graphics.LEFT);
            try {
                Globe.drawNum(g, ((Integer)kengInfo.getJSONObject(0).getJSONArray("distance").get(0)).intValue(), 265, 30, imgWhiteNum, 1);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            g.drawImage(mImg, 350, 27, Graphics.TOP | Graphics.LEFT);
//            Globe.drawNum(g, GameVariables.point, 170, 472, imgNUM, 0);
            Globe.drawNum(g, GameVariables.point, 165, 472, imgWhiteNum, 1);

            Globe.drawNum(g, Hero.heroChongTimeLV[GameVariables.heroIndex], 205, 443, imgNum, 1);
        }
        int color = g.getColor();
        g.setColor(0xffffff);
        g.drawString(Hero.heroName[GameVariables.heroIndex], 480, 15, 20);
        g.setColor(color);

        g.drawImage(tf_name, 120, 440, Graphics.TOP | Graphics.LEFT);
        g.drawImage(lv1Img, 185, 443, Graphics.TOP | Graphics.LEFT);
    }

    // 切换screen时销毁资源
    public void clear() {
        enemys = null;
//		enemyInfo = null;
        bgMoveFram = 10;
        bgMoveFramTemp = bgMoveFram;
        mapHead = null;
        mapBody = null;
        mapEnd = null;
        imgTiao = null;
        imgTiao2 = null;
        //imgBG = null;
        LWGameCanvas.commonBgImage = null;
        enemyVector.removeAllElements();
        roadVec.removeAllElements();
        starVec.removeAllElements();
        alarmEnemy = null;
        huoQiuEnemy = null;
        hero = null;
//        imgPause = null;
        imgNUM = null;
        imgUIYun = null;
        tf_name = null;
        lv1Img = null;
        slashImg = null;
        mImg = null;
        Motion.clear();
//        icon8a_motion.
//        commonImage1 = null;
        Runtime.getRuntime().gc();
    }

}
