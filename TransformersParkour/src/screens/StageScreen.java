package screens;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import Entry.LWGameCanvas;
import common.GameVariables;
import common.Globe;
import common.Screen;
import motion.ResourceLoader;
import motion.studio.MSimpleAnimationPlayer;
import motion.studio.MSpriteData;
import motion.studio.MSpriteLoader;

public class StageScreen extends Screen {

    public Image[] stageDownImage;
    public Image lockImg;
    public Image selectImage;
    public Image subSelectImage;
//    private Image commonImage1;
    boolean isSelected;
    private int frame;
    private int selectStage = (GameVariables.maxMapStage-1);
    private int subSelectStage = 0;

    private  int num =0;
    private int countNum =0;

    public MSpriteData rectAnimationData;
    public MSpriteData stageData;

    public Image[] getStageDownImage() {
        return stageDownImage;
    }

    public void setStageDownImage(Image[] stageDownImage) {
        this.stageDownImage = stageDownImage;
    }

    public StageScreen(int screenId) {
        super(screenId);
    }

    public void init() {
		stageDownImage[0] = Globe.getImage("stageSelect/level0.png");

//		stageDownImage[1] = Globe.getImage("stageSelect/stage.png");
		lockImg = Globe.getImage("stageSelect/lock.png");
		selectImage = Globe.getImage("stageSelect/select.png");
//		stageDownImage[2] = Globe.getImage("stageSelect/substage.png");
		subSelectImage = Globe.getImage("stageSelect/subselect.png");

        try {
            rectAnimationData = MSpriteLoader.loadMSprite("/selectHero/rect1.anu", true, ResourceLoader.getInstance());
            stageData = MSpriteLoader.loadMSprite("/stageSelect/stage.anu", true, ResourceLoader.getInstance());
        } catch (Exception e) {
            e.printStackTrace();
        }

//        commonImage1 = Globe.getImage("common/commonBG1.png");
    }

    public void draw(Graphics g) {
        MSimpleAnimationPlayer player1 = new MSimpleAnimationPlayer(stageData, 320, 265);
        MSimpleAnimationPlayer player2 = new MSimpleAnimationPlayer(rectAnimationData, -200, -200);
        g.drawImage(stageDownImage[0], 0, 0, 20);
//        if (isSelected) {
////            g.drawImage(stageDownImage[2], Globe.SW / 2, Globe.SH / 2, Globe.ANCHOR_H_V);
//            if (selectStage == (GameVariables.maxMapStage - 1)) {
//                switch (GameVariables.maxMapStage % 3) {
//                    case 1:
//                        g.drawImage(lockImg, Globe.SW / 2 - 110 + 90, Globe.SH / 2 + 20, Globe.ANCHOR_T_L);
//                        g.drawImage(lockImg, Globe.SW / 2 - 110 + 2* 90, Globe.SH / 2 + 20, Globe.ANCHOR_T_L);
//                        break;
//                    case 2:
//                        g.drawImage(lockImg, Globe.SW / 2 - 110 + 2* 90, Globe.SH / 2 + 20, Globe.ANCHOR_T_L);
//                        break;
//                }
//            }
//            for (int i = 0; i < 3; i++) {
//                if (i == subSelectStage && frame % 2 == 0) {
//                    g.drawImage(subSelectImage, Globe.SW / 2 + i % 3 * 90 - 125, Globe.SH / 2 - 25, Globe.ANCHOR_T_L);
//                }
//            }
//        } else {
//            g.drawImage(stageDownImage[1], Globe.SW / 2, Globe.SH / 2, Globe.ANCHOR_H_V);

            for (int i = 0; i < (GameVariables.maxMapStage - 1) + 1; i++) {
                if (i == selectStage) {
                    player2.setSpriteX(Globe.SW / 2 - 540 / 2 + i % 4 * 141 + 57);
                    player2.setSpriteY(Globe.SH / 2 - 430 / 2 +  i / 4 * 183 + 102);
//                    g.drawImage(selectImage, Globe.SW / 2 - 540 / 2 + i % 4 * 101 + 37, Globe.SH / 2 - 430 / 2 +  i / 4 * 133 + 72, Globe.ANCHOR_T_L);
                }
            }
//        }
//        g.drawImage(commonImage1, 320, 515, Graphics.HCENTER|Graphics.VCENTER);
        player1.setAnimation(0);
        player1.setFrame(0);

        player2.setAnimation(0);
        player2.setFrame((num+1)%player2.getFrameCount());
        if(countNum++%3==0){
            num++;
        }

        player1.drawFrame(g);
        player2.drawFrame(g);

        for (int i = (GameVariables.maxMapStage - 1) + 1; i < 8; i++) {
            if (i < 4) {
                g.drawImage(lockImg, Globe.SW / 2 - 540 / 2 + lockImg.getWidth() + 30 + i* 130, Globe.SH / 2 - 430 / 2 + lockImg.getHeight() + 50, Globe.ANCHOR_T_L);
            }else {
                g.drawImage(lockImg, Globe.SW / 2 - 540 / 2 + lockImg.getWidth() + 30 + (i - 4)* 130, Globe.SH / 2 - 430 / 2 + lockImg.getHeight() + 100 + 120, Globe.ANCHOR_T_L);
            }
        }
    }

    public void update() {

        frame ++;
        if (LWGameCanvas.iskeyPressed(Globe.M_KEY_RIGHT)) {
            if (isSelected) {
                subSelectStage ++;
            } else {
                selectStage++;
            }

        } else if (LWGameCanvas.iskeyPressed(Globe.M_KEY_LEFT)) {
            if (isSelected) {
                subSelectStage --;
            } else {
                selectStage--;
            }

        } else if (LWGameCanvas.iskeyPressed(Globe.M_KEY_UP)) {
            if (isSelected) {

            } else {
                selectStage += 4;
            }

        } else if (LWGameCanvas.iskeyPressed(Globe.M_KEY_DOWN)) {
            if (isSelected) {

            } else {
                selectStage -= 4;
            }

        }
        if((GameVariables.maxMapStage)==0){
            selectStage = 0;
        } else {
            selectStage = (selectStage + (GameVariables.maxMapStage  + 1)) % (GameVariables.maxMapStage + 1);
            if(selectStage > ((GameVariables.maxMapStage-1)) )   selectStage = (GameVariables.maxMapStage-1);
        }

//        if (selectStage == (GameVariables.maxMapStage - 1) / 3 && GameVariables.maxMapStage % 3 != 0) {
//            subSelectStage %= GameVariables.maxMapStage % 3;
//        }else {
//            subSelectStage %= 3;
//        }

        if(subSelectStage<0) subSelectStage = 0;

        if (LWGameCanvas.iskeyPressed(Globe.M_KEY_0) && isSelected) {
            isSelected = !isSelected;
        }else if(LWGameCanvas.iskeyPressed(Globe.M_KEY_0)){
            LoadingScreen.loadIndex = 2;
            LWGameCanvas.switchToScreen(new LoadingScreen(GameVariables.LOADING_SCREEN_ID));
        }
        if (LWGameCanvas.iskeyPressed(Globe.M_KEY_OK) && !isSelected) {
            if (selectStage == 7) {
                GamingScreen.gameLevel = 7;//无尽关　没有sub
                LWGameCanvas.switchToScreen(new LoadingScreen(GameVariables.LOADING_SCREEN_ID));
            }else {
//                isSelected = true;
                GamingScreen.gameLevel = selectStage;
                LWGameCanvas.switchToScreen(new LoadingScreen(GameVariables.LOADING_SCREEN_ID));
            }
        } else if (LWGameCanvas.iskeyPressed(Globe.M_KEY_OK) && isSelected) {
//            GamingScreen.gameLevel = selectStage * 3 + subSelectStage;
//            LWGameCanvas.switchToScreen(new LoadingScreen(GameVariables.LOADING_SCREEN_ID));
        }
        LWGameCanvas.keyReset();
    }

    public void clear() {
        lockImg = null;
        selectImage = null;
        subSelectImage = null;
        for(int i=0;i<stageDownImage.length;i++){
            stageDownImage[i]=null;
        }
        stageDownImage = null;
//        commonImage1 = null;
        Runtime.getRuntime().gc();
    }
}
