package screens;

import Entry.LWGameCanvas;
import common.GameVariables;
import common.Globe;
import common.NetInfo;
import common.Screen;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public class SuccessScreen extends Screen {
	private final static String PATH = "success";
//	private Image heroimg ;
//    private Image btnimg;
    private Image bgimg ;//背景图
    private Image numimg; //积分数字图
    private Image levelnum_img; //关卡数字图
    public int selectIndex = 0;
    private int level;  //级别（关）
    private int hero_type ;//英雄的序号
    private int distance;//路程
    private int score;//分数
    private int success_score;//成就值
    private String distance_str;
    private String score_str;
    private String success_socrestr;
//    private Image[] buypetbtn;
    private Image[] jixubtn;
//    private Image[] backImage;
    private Image winImg;

    private int bg_x = Globe.SW >> 1;
    private int bg_y = Globe.SH >> 1;

    private boolean visible = true;
	
      public SuccessScreen(int screenId, int level, int hero_type, int distance, int score, int success_score) {
    	super(screenId);
    	this.level = level;
    	this.hero_type = hero_type;
    	this.distance = distance;
    	this.score = score;
    	this.success_score= success_score;
    	init();
    	}
	public void init() {
		     createImage();

//             buypetbtn = new Image[2];
//             for(int i=0; i<buypetbtn.length; i++){
//                 buypetbtn[i] = Globe.getImage("final/buypetbtn"+(i+1)+".png");
//             }

        winImg = Globe.getImage("success/win.png");

//        backImage = new Image[2];
//        for (int i = 1; i < 3; i++) {
//            backImage[i-1] = Globe.getImage("game/pets/back0"+ i + ".png");
//        }

             jixubtn = new Image[2];
             for(int i =0 ; i<jixubtn.length; i++){
                 jixubtn[i] = Globe.getImage("success/btn"+(i)+".png");
             }

			 distance_str = String.valueOf(distance);
			 score_str = String.valueOf(score);
			 success_socrestr = String.valueOf(success_score);
             GameVariables.point += 10;
			 NetInfo.saveScore(GameVariables.point, 0);
			 NetInfo.updateMapStage();
	}
	
    private int successSeletctIndex;
	public void update() {

//        if(LWGameCanvas.iskeyPressed(Globe.M_KEY_RIGHT)){
//            successSeletctIndex++;
//        }else if(LWGameCanvas.iskeyPressed(Globe.M_KEY_LEFT)){
//            successSeletctIndex--;
//        }else

        if (LWGameCanvas.iskeyPressed(Globe.M_KEY_OK)) {
			//训练模式死亡，回退至菜单界面
			if(GameVariables.isTrainning){
				LWGameCanvas.switchToScreen(new MenuScreen(0));
			}else{
//                if(successSeletctIndex==0){
//                    LWGameCanvas.switchToScreen(new MFairyCastleScreen(0,(new SelectingHeroScreen(0))));
//                    LWGameCanvas.keyReset();
//                }else if(successSeletctIndex==1){
                    //				LWGameCanvas.switchToScreen(new SelectingHeroScreen(0));
//                    this.setActive(false);
                    bgimg = Globe.getImage("stageSelect/level0.png");
//                    bg_x = 0; bg_y = 0;
                    visible = false;
                    LoadingScreen.loadIndex = GameVariables.STAGE_SCREEN_ID;
                    LWGameCanvas.addScreen(new LoadingScreen(GameVariables.STAGE_SCREEN_ID));
//                }

			}
			clear();
		}
//        successSeletctIndex = (successSeletctIndex+2)%2;
		LWGameCanvas.keyReset();
		
	}

	public void draw(Graphics g) {
        

//		g.drawImage(heroimg, (Globe.SW >> 1)-115, (Globe.SH >> 1)-11, Graphics.HCENTER|Graphics.VCENTER);
//	    g.drawImage(btnimg, 320, 400, Graphics.HCENTER|Graphics.VCENTER);

        if(visible){
            g.drawImage(bgimg, bg_x, bg_y, Graphics.HCENTER|Graphics.VCENTER);
            g.drawImage(winImg, 300, 100, Graphics.HCENTER|Graphics.VCENTER);

//        if(successSeletctIndex==0){
            g.drawImage(jixubtn[successSeletctIndex==0?1:0], 300, 400, Graphics.HCENTER|Graphics.VCENTER);
//            g.drawImage(backImage[successSeletctIndex==1?1:0], 400, 400, Graphics.HCENTER|Graphics.VCENTER);
//        }else if(successSeletctIndex==1){
//            g.drawImage(jixubtn[0], 280, 400, Graphics.HCENTER|Graphics.VCENTER);
//            g.drawImage(backImage[1], 360, 400, Graphics.HCENTER|Graphics.VCENTER);
//        }

            g.setFont(Globe.BigBoldFont);
            g.setColor(0xffffff);
            g.drawString("金刚小勇士真棒，", 180, 180 + Globe.currentFont.getHeight(), Graphics.TOP | Graphics.LEFT);
            g.drawString("继续你的冒险之旅吧!!", 180, 210 + Globe.currentFont.getHeight(), Graphics.TOP | Graphics.LEFT);
            g.setFont(Globe.defaultFont);
            g.setColor(0x000000);
        } else {
            g.drawImage(bgimg, 0, 0, 20);
        }


//	    g.setColor(255, 255, 255);
//	    g.drawString(distance_str, 410, 220, Graphics.TOP|Graphics.LEFT);
//	    g.drawString(score_str, 410, 265, Graphics.TOP|Graphics.LEFT);
//	    g.drawString(String.valueOf(GameVariables.point), 410, 265, Graphics.TOP|Graphics.LEFT);
//	    g.setColor(85, 196, 226);
//	    g.drawString(success_socrestr, 358, 345, Graphics.TOP|Graphics.LEFT);
//	    Globe.drawNum(g, level, 407, 180, levelnum_img, 0);
	}

	public void clear() {

//        for (int i = 1; i < 3; i++) {
//            backImage[i-1] = null;
//        }
//        backImage = new Image[2];

        for(int i =0 ; i<jixubtn.length; i++){
            jixubtn[i] = null;
        }
        jixubtn = new Image[2];
//		heroimg = null;
//		btnimg = null;
//		heroimg = null;
//		btnimg = null;
        winImg = null;
		bgimg = null;
        Runtime.getRuntime().gc();
	}
	private void createImage()
	{
//		switch (hero_type) {
//		case 0:
//			heroimg = Globe.getImage(PATH + "/hero0.png");
//			break;
//		case 1:
//			heroimg = Globe.getImage(PATH + "/hero1.png");
//			break;
//		case 2:
//			heroimg = Globe.getImage(PATH + "/hero2.png");
//			break;
//		case 3:
//			heroimg = Globe.getImage(PATH + "/hero3.png");
//			break;
//		}
//		btnimg = Globe.getImage(PATH+"/btn1.png");
		bgimg = Globe.getImage(PATH+"/success.png");
		levelnum_img = Globe.getImage("gaming/gamingNum1.png");
	}

}
