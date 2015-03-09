package screens;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

import Entry.LWGameCanvas;
import common.GameVariables;
import common.Globe;
import common.Screen;

public class FailureScreen  extends Screen{

    private Image img;
//    private Image btnimg;
//    private Image commonImage;

//    private Image commonImage1;

    private Image[] buypetbtn;
    private Image[] xuanlianbtn;
//    private Image[] backImage;

    private Image loseImg;

    private Image indexImage;

    private int indexFrame;

    private int bg_x = Globe.SW >> 1;
    private int bg_y = Globe.SH >> 1;

    private boolean visible = true;

    public FailureScreen(int screenId)
    {
        super(screenId);
        init();
    }
    public void init() {

        buypetbtn = new Image[2];
        for(int i=0; i<buypetbtn.length; i++){
            buypetbtn[i] = Globe.getImage("final/buypetbtn"+(i+1)+".png");
        }

        xuanlianbtn = new Image[2];
        for(int i=0; i<xuanlianbtn.length; i++){
            xuanlianbtn[i] = Globe.getImage("final/xuanlian"+(i+1)+".png");
        }

//        backImage = new Image[2];
//        for (int i = 1; i < 3; i++) {
//            backImage[i-1] = Globe.getImage("game/pets/back0"+ i + ".png");
//        }

        img = Globe.getImage("success/success.png");
//        btnimg = Globe.download.creatImage("success/btn1.png");
//        commonImage = Globe.getImage("stageSelect/level0.png");

//        commonImage1 = Globe.getImage("common/commonBG1.png");
        loseImg = Globe.getImage("success/lose.png");

        indexImage = Globe.getImage("success/index.jpg");
    }

    private int failSelectIndex;
    public void update() {

        indexFrame++;
        indexFrame = (indexFrame + 10) % 10;

        if(LWGameCanvas.iskeyPressed(Globe.M_KEY_RIGHT)){
            failSelectIndex++;
        }else if(LWGameCanvas.iskeyPressed(Globe.M_KEY_LEFT)){
            failSelectIndex--;
        }else if (LWGameCanvas.iskeyPressed(Globe.M_KEY_OK)) {
//			LWGameCanvas.switchToScreen(new SelectingHeroScreen(0));
            if(failSelectIndex==0){
                LoadingScreen.loadIndex = 2;
                img = Globe.getImage("game/pets/bg01.png");
//                bg_x = 0; bg_y = 0;
                visible = false;
//                this.setActive(false);
                LWGameCanvas.addScreen(new LoadingScreen(GameVariables.LOADING_SCREEN_ID));
                return;
            }else if(failSelectIndex==1){
                LWGameCanvas.switchToScreen(new MFairyCastleScreen(0,(new SelectingHeroScreen(0))));
                LWGameCanvas.keyReset();
            }else if(failSelectIndex==2){
                LWGameCanvas.switchToScreen(new MenuScreen(0));
                clear();
            }

        }
        failSelectIndex = (failSelectIndex+2)%2;
        LWGameCanvas.keyReset();
    }

    public void draw(Graphics g) {
//        g.drawImage(commonImage, 0, 0, 20);

//        g.drawImage(btnimg, 320, 400, Graphics.HCENTER|Graphics.VCENTER);
        if(visible){
            g.drawImage(img, bg_x, bg_y, Graphics.HCENTER|Graphics.VCENTER);
            g.drawImage(loseImg, 300, 100, Graphics.HCENTER|Graphics.VCENTER);
//        if(failSelectIndex==0){
            g.drawImage(buypetbtn[failSelectIndex==0?1:0], 220, 380, Graphics.HCENTER|Graphics.VCENTER);
            g.drawImage(xuanlianbtn[failSelectIndex==1?1:0], 435, 380, Graphics.HCENTER|Graphics.VCENTER);
//            g.drawImage(backImage[failSelectIndex==2?1:0], 470, 400, Graphics.HCENTER|Graphics.VCENTER);
            g.setFont(Globe.BigBoldFont);
            g.setColor(0xffffff);
            g.drawString("金刚小勇士不要气馁，", 180, 180 + Globe.currentFont.getHeight(), Graphics.TOP | Graphics.LEFT);
            g.drawString("快快召唤伙伴，提升等级，", 180, 210 + Globe.currentFont.getHeight(), Graphics.TOP | Graphics.LEFT);
            g.drawString("您将得到异乎寻常的力量！！", 180, 240 + Globe.currentFont.getHeight(), Graphics.TOP | Graphics.LEFT);
            g.setFont(Globe.defaultFont);
            g.setColor(0x000000);

            g.drawImage(indexImage, 152 + failSelectIndex * 200 + indexFrame, 382, Graphics.HCENTER | Graphics.VCENTER);
        }else {
            g.drawImage(img, 0, 0, 20);
        }


//        g.drawImage(commonImage1, 0, 550, Graphics.HCENTER|Graphics.VCENTER);
//        }else if(failSelectIndex==1){
//            g.drawImage(buypetbtn[0], 270, 400, Graphics.HCENTER|Graphics.VCENTER);
//            g.drawImage(xuanlianbtn[1], 320, 400, Graphics.HCENTER|Graphics.VCENTER);
//            g.drawImage(backImage[0], 370, 400, Graphics.HCENTER|Graphics.VCENTER);
//        }else if(failSelectIndex==2){
//            g.drawImage(buypetbtn[0], 270, 400, Graphics.HCENTER|Graphics.VCENTER);
//            g.drawImage(xuanlianbtn[0], 320, 400, Graphics.HCENTER|Graphics.VCENTER);
//            g.drawImage(backImage[1], 370, 400, Graphics.HCENTER|Graphics.VCENTER);
//        }
    }

    public void clear() {
        img = null;
        loseImg = null;

        for(int i=0; i<buypetbtn.length; i++){
            buypetbtn[i] = null;
        }
        buypetbtn = null;

        for(int i=0; i<xuanlianbtn.length; i++){
            xuanlianbtn[i] = null;
        }
        xuanlianbtn = null;
        indexImage = null;
//        btnimg = null;
//        commonImage =null;
//        commonImage1 = null;
        Runtime.getRuntime().gc();
    }



}
