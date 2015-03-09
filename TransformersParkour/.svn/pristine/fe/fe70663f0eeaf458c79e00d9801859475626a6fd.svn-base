package screens;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

import Entry.LWGameCanvas;
import common.GameVariables;
import common.Globe;
import common.Screen;

public class MenuScreen extends Screen{
	
	public Image mainBG;
//	public Image[] helpImage;
//	public Image[] magicFairyCastleImage;
//	public Image[] rankingImage;
//	public Image[] exitImage;
//	public Image[] startImage;
	public int selectIndex = 0;

//    public Image greenButtonImg;
//    public Image yellowButtonImg;
    private Image startImg;
    private Image genaImg;
    private Image rankImg;
    private Image helpImg;
    private Image exitImg;
//    public Image textImg;

	public MenuScreen(int screenId) {
		super(screenId);
	}

	public void clear() {
		mainBG = null;
//        for(int i=0; i<helpImage.length; i++){
//            helpImage[i]=null;
//        }
//		helpImage = null;
//        for(int i=0; i<magicFairyCastleImage.length; i++){
//            magicFairyCastleImage[i]=null;
//        }
//		magicFairyCastleImage = null;
//        for(int i=0; i<rankingImage.length; i++){
//            rankingImage[i]=null;
//        }
//		rankingImage = null;
//        for(int i=0; i<exitImage.length; i++){
//            exitImage[i]=null;
//        }
//		exitImage = null;
//        for(int i=0; i<startImage.length; i++){
//            startImage[i]=null;
//        }
//		startImage = null;
        Runtime.getRuntime().gc();
	}

	public void draw(Graphics g) {		
		g.drawImage(mainBG, 0, 0, 20);

        switch (selectIndex){
            case 0:
                g.drawImage(startImg,35,65,20);
                break;
            case 1:
                g.drawImage(genaImg,58,184,20);
                break;
            case 2:
                g.drawImage(rankImg,86,263,20);
                break;
            case 3:
                g.drawImage(helpImg,116,342,20);
                break;
            case 4:
                g.drawImage(exitImg,144,420,20);
                break;
        }
		
//        g.drawImage(0==selectIndex?yellowButtonImg:greenButtonImg,410,165,20);
//        g.drawRegion(textImg, 0, 0, textImg.getWidth(), textImg.getHeight()/5, Globe.TRANS_NONE, 500,210, Globe.ANCHOR_H_V);
//        g.drawImage(1==selectIndex?yellowButtonImg:greenButtonImg,410,235,20);
//        g.drawRegion(textImg, 0, textImg.getHeight()/5, textImg.getWidth(), textImg.getHeight()/5, Globe.TRANS_NONE, 515,270, Globe.ANCHOR_H_V);
//        g.drawImage(2==selectIndex?yellowButtonImg:greenButtonImg,410,305,20);
//        g.drawRegion(textImg, 0, 2*textImg.getHeight()/5, textImg.getWidth(), textImg.getHeight()/5, Globe.TRANS_NONE, 520,335, Globe.ANCHOR_H_V);
//        g.drawImage(3==selectIndex?yellowButtonImg:greenButtonImg,410,375,20);
//        g.drawRegion(textImg, 0, 3*textImg.getHeight()/5, textImg.getWidth(), textImg.getHeight()/5, Globe.TRANS_NONE, 528,405, Globe.ANCHOR_H_V);
//        g.drawImage(4==selectIndex?yellowButtonImg:greenButtonImg,410,445,20);
//        g.drawRegion(textImg, 0, 4*textImg.getHeight()/5, textImg.getWidth(), textImg.getHeight()/5, Globe.TRANS_NONE, 528,470, Globe.ANCHOR_H_V);

    }

	public void init() {
		mainBG = Globe.getImage("menu/menuBG.jpg");

//        greenButtonImg = Globe.getImage("menu/greenButton.png");
//        yellowButtonImg = Globe.getImage("menu/yellowButton.png");

        startImg = Globe.getImage("menu/START.png");
        genaImg = Globe.getImage("menu/1.png");
        rankImg = Globe.getImage("menu/2.png");
        helpImg = Globe.getImage("menu/3.png");
        exitImg = Globe.getImage("menu/4.png");

//        textImg = Globe.getImage("menu/text.png");

//		helpImage = new Image[2];
//		for(int i=0; i<helpImage.length;i++){
//			helpImage[i]=Globe.getImage("menu/help0"+(i+1)+".png");
//		}
		
//		magicFairyCastleImage = new Image[2];
//		for(int i=0; i<magicFairyCastleImage.length;i++){
//			magicFairyCastleImage[i] = Globe.getImage("menu/magicFairyCastle0"+(i+1)+".png");
//		}
		
//		rankingImage = new Image[2];
//		for(int i=0; i< rankingImage.length; i++){
//			rankingImage[i]=Globe.getImage("menu/ranking0"+(i+1)+".png");
//		}
		
//		exitImage = new Image[2];
//		for(int i =0; i<exitImage.length; i++){
//			exitImage[i] = Globe.getImage("menu/exit0"+(i+1)+".png");
//		}
		
//		startImage = new Image[2];
//		for(int i=0; i<startImage.length; i++){
//			startImage[i] = Globe.getImage("menu/start0"+(i+1)+".png");
//		}
	}

	public void update() {
		if(LWGameCanvas.iskeyPressed(Globe.M_KEY_UP)){
			this.selectIndex--;
		}else if(LWGameCanvas.iskeyPressed(Globe.M_KEY_DOWN)){
			this.selectIndex++;
		}
		
		selectIndex=(selectIndex+5)%5;
		
		if(LWGameCanvas.iskeyPressed(Globe.M_KEY_OK)){
			switch(selectIndex){
			case 0:
                LoadingScreen.loadIndex = 1;
                LWGameCanvas.switchToScreen(new LoadingScreen(GameVariables.LOADING_SCREEN_ID));
                break;
			case 1:
                LWGameCanvas.switchToScreen(new MFairyCastleScreen(0,this));
                LWGameCanvas.keyReset();
                break;
			case 2:
                LWGameCanvas.switchToScreen(new RankingScreen(2));
                break;
			case 3:
                LWGameCanvas.switchToScreen(new HelpScreen(0));
                break;
			case 4:
//                LWGameCanvas.isExit = true;
                this.setActive(false);
                MenuTipsScreen.returnScreen = this;
                LWGameCanvas.addScreen(new MenuTipsScreen(0));
                break;
			}
		}
		
		if(LWGameCanvas.iskeyPressed(Globe.M_KEY_0)||
				LWGameCanvas.iskeyPressed(Globe.M_KEY_SOFT_R)){
//			LWGameCanvas.isExit = true;
            this.setActive(false);
            MenuTipsScreen.returnScreen = this;
            LWGameCanvas.addScreen(new MenuTipsScreen(0));
		}
		LWGameCanvas.keyReset();
	}

}
