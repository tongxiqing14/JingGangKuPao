package screens;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

import motion.Motion;
import Entry.LWGameCanvas;
import common.GameVariables;
import common.Globe;
import common.NetInfo;
import common.Screen;
import motion.ResourceLoader;
import motion.studio.MSimpleAnimationPlayer;
import motion.studio.MSpriteData;
import motion.studio.MSpriteLoader;

public class SelectingPetScreen extends Screen {

	public Image[] petDownImage;

	public Image[] getPetDownImage() {
		return petDownImage;
	}

	public void setPetDownImage(Image[] petDownImage) {
		this.petDownImage = petDownImage;
	}

//	private Image petBgImage;
//	private Image[] petYuanImage;
	private Image[] petBuyImage;
//    private Image[] petUseImage;
	private Image[] arrowImage;
	private Image[] okImage;
//	private Image[] backImage;
//	private Image selectedImage;
	private Image selectImage;

	private String petNameFly[];
	private String petNameLand[];
	private Motion[] petMotionFly;
	private Motion[] petMotionLand;

	private int indexFrame = 0;
	//�л����г衢½�س�
	public static int petSelectIndex = 2;
	//���г�����
	private int petFlyIndex = 0;
	//½�س�����
	private int petLandIndex = 0;
	//confirm
	private int petConfirmIndex = 0;

    private  int num =0;
    private int countNum =0;

    private Image indexImage;

    public MSpriteData rectAnimationData;

	public SelectingPetScreen(int screenId) {
		super(screenId);
//		NetInfo.getPetInfo();
	}

	public void init() {
		//��ȡ��ѡ��ĳ�������
//		petFlyIndex = GameVariables.initPet[0][1];
//		petLandIndex = GameVariables.initPet[1][1];

        indexImage = Globe.getImage("success/index.jpg");

		//����ͼƬ
//		petBgImage = Globe.download.creatImage("game/pets/yuan.png");
//		petYuanImage = new Image[2];
//        for(int i=0; i<petYuanImage.length;i++){
//        	petYuanImage[i] = Globe.download.creatImage("game/pets/yuan0"+(i+1)+".png");
//        }
        //����ͼƬ
        petBuyImage = new Image[2];
        for(int i=0; i<petBuyImage.length;i++){
        	petBuyImage[i] = Globe.getImage("game/pets/buy0"+(i+1)+".png");
        }
        //ʹ��ͼƬ
//        petUseImage = new Image[2];
//        for(int i=0; i<petUseImage.length;i++){
//            petUseImage[i] = Globe.download.creatImage("game/pets/use0"+(i+1)+".png");
//        }
        //��ͷ
        arrowImage = new Image[2];
        for(int i=0; i<arrowImage.length;i++){
        	arrowImage[i] = Globe.getImage("game/pets/arrow0"+(i+1)+".png");
        }
        //���г�
        petNameFly = new String[] {"a1", "a2", "c2", "b2", "c1", "b1", "a3", "a4"};
        petMotionFly = new Motion[petNameFly.length];
        for(int i=0; i<petNameFly.length; i++){
        	String pet = "/game/pets/" + petNameFly[i] + ".anu";
        	petMotionFly[i] = new Motion(pet, 0, 0);
        }
        //½�س�
        petNameLand = new String[] {"a1", "b1", "c1", "d1", "e1", "f", "g", "h"};
        petMotionLand = new Motion[petNameLand.length];
        for(int i=0; i<petNameLand.length; i++){
            String pet = "/game/pets/land/" + petNameLand[i] + ".anu";
        	petMotionLand[i] = new Motion(pet, 0, 0);
        }
        okImage = new Image[2];
//        backImage = new Image[2];
        for (int i = 1; i < 3; i++) {
        	okImage[i-1] = Globe.getImage("game/pets/ok0"+ i + ".png");
//        	backImage[i-1] = Globe.download.creatImage("game/pets/back0"+ i + ".png");
		}
        //ѡ���ͼƬ
        selectImage = Globe.getImage("game/pets/select.png");
//        selectedImage = Globe.download.creatImage("stageSelect/subselect.png");

        try {
            rectAnimationData = MSpriteLoader.loadMSprite("/selectHero/rect1.anu",true,ResourceLoader.getInstance());
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

	public void update() {
		// TODO Auto-generated method stub
		indexFrame++;
        indexFrame=(indexFrame+6)%6;
        //����ѡ���������ֵ�仯
        if(LWGameCanvas.iskeyPressed(Globe.M_KEY_LEFT)){
        	if(0 == petSelectIndex || 1 == petSelectIndex){
        		petFlyIndex--;
        	//}else if(1 == petSelectIndex){
        		petLandIndex--;
        	}else if(2 == petSelectIndex){
        		petConfirmIndex--;
        	}
        }else if(LWGameCanvas.iskeyPressed(Globe.M_KEY_RIGHT)){
        	if(0 == petSelectIndex || 1 == petSelectIndex){
        		petFlyIndex++;
        	//}else if(1 == petSelectIndex){
        		petLandIndex++;
        	}else if(2 == petSelectIndex){
        		petConfirmIndex++;
        	}
        }else if(LWGameCanvas.iskeyPressed(Globe.M_KEY_UP)){
        	petSelectIndex--;
        }else if(LWGameCanvas.iskeyPressed(Globe.M_KEY_DOWN)){
        	petSelectIndex++;
        }

        petFlyIndex = petFlyIndex < 0 ? 0 : petFlyIndex;
        petFlyIndex = petFlyIndex >= petNameFly.length ? petNameFly.length - 1 : petFlyIndex;

        petLandIndex = petLandIndex < 0 ? 0 : petLandIndex;
        petLandIndex = petLandIndex >= petNameLand.length ? petNameLand.length - 1 : petLandIndex;

        petConfirmIndex = (petConfirmIndex+2) % 2;
        petSelectIndex = (petSelectIndex+3) % 3;

        //��ת�������
        if(LWGameCanvas.iskeyPressed(Globe.M_KEY_OK)){
        	GameVariables.sumPet = 0;
			if (GameVariables.isFlyPetGot[petFlyIndex] && 0 == petSelectIndex) {
				GameVariables.sumPet++;
				GameVariables.initPet[0][0] = 1;
				GameVariables.initPet[0][1] = petFlyIndex;
			}
			if (GameVariables.isLandPetGot[petLandIndex] && 1 == petSelectIndex) {
				GameVariables.sumPet++;
				GameVariables.initPet[1][0] = 1;
				GameVariables.initPet[1][1] = petLandIndex;
			}

        	if(petSelectIndex == 0){
        		if(GameVariables.isFlyPetGot[petFlyIndex]){
        			petSelectIndex ++;
        			//LWGameCanvas.switchToScreen(new StageScreen(0));
        			//LoadingScreen.loadIndex = 3;
    				//LWGameCanvas.switchToScreen(new LoadingScreen(GameVariables.LOADING_SCREEN_ID));
        		}else{
                    GameVariables.initPet[0][0] = 0;
        			GameVariables.initPet[0][1] = petFlyIndex;
        			ConfirmScreen.returnScreen = this;
        			ConfirmScreen.buyIndex = petFlyIndex + GameVariables.isLandPetGot.length + 5;
        			LWGameCanvas.addScreen(new ConfirmScreen(0));
        		}
        	}else if(petSelectIndex == 1){
        		if(GameVariables.isLandPetGot[petLandIndex]){
        			petSelectIndex ++;
        			//LWGameCanvas.switchToScreen(new StageScreen(0));
        			//LoadingScreen.loadIndex = 3;
    				//LWGameCanvas.switchToScreen(new LoadingScreen(GameVariables.LOADING_SCREEN_ID));
        		}else{
                    GameVariables.initPet[1][0] = 0;
        			GameVariables.initPet[1][1] = petLandIndex;
        			ConfirmScreen.returnScreen = this;
        			ConfirmScreen.buyIndex = petLandIndex + 5;
        			LWGameCanvas.addScreen(new ConfirmScreen(0));
        		}
			} else if (petSelectIndex == 2 && petConfirmIndex == 0) {
				LoadingScreen.loadIndex = 3;
				LWGameCanvas.switchToScreen(new LoadingScreen(GameVariables.LOADING_SCREEN_ID));
			}else if (petSelectIndex == 2 && petConfirmIndex == 1) {
//				LWGameCanvas.switchToScreen(new SelectingHeroScreen(0));
				LoadingScreen.loadIndex = 3;
				LWGameCanvas.switchToScreen(new LoadingScreen(GameVariables.LOADING_SCREEN_ID));
			}
        }
        //ѡ��ؿ�
        if(LWGameCanvas.iskeyPressed(Globe.M_KEY_1)){
            //LWGameCanvas.switchToScreen(new StageScreen(0));
        	LoadingScreen.loadIndex = 3;
			LWGameCanvas.switchToScreen(new LoadingScreen(GameVariables.LOADING_SCREEN_ID));
        }
        //����ѡ��Ӣ��
		if(LWGameCanvas.iskeyPressed(Globe.M_KEY_0)){
//            LWGameCanvas.switchToScreen(new SelectingHeroScreen(0));
			LoadingScreen.loadIndex = 1;
			LWGameCanvas.switchToScreen(new LoadingScreen(GameVariables.LOADING_SCREEN_ID));
        }
		LWGameCanvas.keyReset();
		////System.out.println("petFlyIndex:"+petFlyIndex + ", petLandIndex:" + petLandIndex);

	}

	int moveIndex;

	private Image mmImage;
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		MSimpleAnimationPlayer player2 = new MSimpleAnimationPlayer(rectAnimationData, -200, -200);
		 //���Ƴ���ѡ��ͼƬ��������
		 int top = 10;
		 //���Ʊ���������ѡ��ͼ
//		 g.drawImage(petDownImage[0], 0, 0, 20);
	     g.drawImage(petDownImage[1], 0, 0, 20);
	     //���Ʒ��г�
	     int paddingLeft = 0;
	     int paddingTop = 140 + top;

	     for(int i=0; i< 4; i++){
	    	 int index = moveIndex / 4 * 4 + i;
	    	 if(index >= petNameFly.length) break;
	    	 paddingLeft = i*130; // i%5*96
//	    	 g.drawImage(petBgImage, 85 + paddingLeft, paddingTop, 20);
	    	 //���Ƶ���
			if (GameVariables.isFlyPetGot[index]) {
//				g.drawImage(petYuanImage[0], 85 + paddingLeft + 10, paddingTop - 22, 20);
                if(!(GameVariables.initPet[0][1] % 4 == i&&(GameVariables.initPet[0][0] == 1&&((moveIndex < 4 && GameVariables.initPet[0][1] < 4)||GameVariables.initPet[0][1] > 4)))) {
                    //����ʹ�ð�ť
//                    if(petFlyIndex % 4 == i) {
//                        if(petSelectIndex == 0){
//                            g.drawImage(petUseImage[1], 80 + paddingLeft + 10, paddingTop + 42, 20);
//                        }else{
//                            g.drawImage(petUseImage[0], 80 + paddingLeft + 10, paddingTop + 42, 20);
//                        }
//                    } else {
//                        g.drawImage(petUseImage[0], 80 + paddingLeft + 10, paddingTop + 42, 20);
//                    }
                }
//                else {
//                    g.drawImage(petUseImage[0], 85 + paddingLeft + 10, paddingTop + 42, 20);
//                }

			} else {
//				g.drawImage(petYuanImage[1], 85 + paddingLeft + 10, paddingTop - 22, 20);
                //���ƹ���ť
                if (petFlyIndex % 4 == i) {
                    if(petSelectIndex == 0){
                        g.drawImage(petBuyImage[1], 60 + paddingLeft + 10, paddingTop + 30, 20);
                    }else {
                        g.drawImage(petBuyImage[0], 60 + paddingLeft + 10, paddingTop + 30, 20);
                    }
                } else if (petFlyIndex % 4 != i) {
                    g.drawImage(petBuyImage[0], 60 + paddingLeft + 10, paddingTop + 30, 20);
                }
			}

			//���Ƴ���
	    	 petMotionFly[index].keepId(0);
	    	 petMotionFly[index].update(70 + paddingLeft + 40, paddingTop - 18);
	    	 petMotionFly[index].draw(g);
//             player2 = new MSimpleAnimationPlayer(rectAnimationData, 90 + paddingLeft, paddingTop - 60);
	    	 //����ѡ���
	    	 if (petFlyIndex % 4 == i){
	    		 if(petSelectIndex == 0){
//	    			if (indexFrame % 3 == 0) {
//	    				g.drawImage(selectedImage, 90 + paddingLeft, paddingTop - 80, Globe.ANCHOR_T_L);
//					}
                     player2.setSpriteX(120 + paddingLeft);
                     player2.setSpriteY(paddingTop - 40);
	    		 }
	    	 }
	    	 if (GameVariables.initPet[0][0] == 1) {
	    		 	if (moveIndex < 4 && GameVariables.initPet[0][1] < 4 ) {

	    		 		g.drawImage(selectImage, 115 + GameVariables.initPet[0][1] * 126, 160, Globe.ANCHOR_T_L);
					} else if (moveIndex < 4){

					} else if (GameVariables.initPet[0][1] >= 4){
//						g.drawImage(selectImage, 115, 160, Globe.ANCHOR_T_L);
                        g.drawImage(selectImage, 115 + (GameVariables.initPet[0][1]-4) * 126, 160, Globe.ANCHOR_T_L);
                            }
                        }
                    }
		 /*//���Ƽ�ͷ
	     if(petNameFly.length > 5){
	    	 if(petFlyIndex < 5){
	    		 g.drawImage(arrowImage[1], 588-indexFrame, paddingTop - 20, 20);
	    	 }else{
	    		 g.drawImage(arrowImage[0], 35+indexFrame, paddingTop - 20, 20);
	    	 }
	     }*/
	     //����½�س�
		 paddingLeft = 0;
		 paddingTop += 158;
		 for(int i=0; i< 4; i++){
			 int index = moveIndex / 4 * 4 + i;
	    	 if(index >= petNameLand.length) break;
	    	 paddingLeft = i*126;
//	    	 g.drawImage(petBgImage, 85 + paddingLeft, paddingTop, 20);
	    	 //���Ƶ���
			if (GameVariables.isLandPetGot[index]) {
//				g.drawImage(petYuanImage[0], 85 + paddingLeft + 10, paddingTop - 22, 20);
                if(!(GameVariables.initPet[1][1] % 4 == i && (GameVariables.initPet[1][0] == 1&&((moveIndex < 4 && GameVariables.initPet[1][1] < 4)||GameVariables.initPet[1][1] > 4)))){
                    //����ʹ�ð�ť
//                    if(petLandIndex % 4 == i){
//                        if(petSelectIndex == 1){
//                            g.drawImage(petUseImage[1], 85 + paddingLeft + 10, paddingTop + 42, 20);
//                        }else {
//                            g.drawImage(petUseImage[0], 85 + paddingLeft + 10, paddingTop + 42, 20);
//                        }
//                    } else {
//                        g.drawImage(petUseImage[0], 85 + paddingLeft + 10, paddingTop + 42, 20);
//                    }
                }
//                else {
//                    g.drawImage(petUseImage[0], 85 + paddingLeft + 10, paddingTop + 42, 20);
//                }
			} else {
//				g.drawImage(petYuanImage[1], 85 + paddingLeft + 10, paddingTop - 22, 20);
                //���ƹ���ť
                if (petLandIndex % 4 == i) {
                    if(petSelectIndex == 1){
                        g.drawImage(petBuyImage[1], 65 + paddingLeft + 10, paddingTop + 5, 20);
                    }else{
                        g.drawImage(petBuyImage[0], 65 + paddingLeft + 10, paddingTop + 5, 20);
                    }

                } else if (petLandIndex % 4 != i) {
                    g.drawImage(petBuyImage[0], 65 + paddingLeft + 10, paddingTop + 5, 20);
                }
			}

			//���Ƴ���
	    	 petMotionLand[index].keepId(0);
	    	 petMotionLand[index].update(85 + paddingLeft + 40, paddingTop - 18);
	    	 petMotionLand[index].draw(g);
	    	//����ѡ���
	    	 if (petLandIndex % 4 == i){
	    		 if(petSelectIndex == 1){
//	    			if (indexFrame % 3 == 0) {
//	    				g.drawImage(selectedImage, 95 + paddingLeft, paddingTop - 80, Globe.ANCHOR_T_L);
//					}
                     player2.setSpriteX(120 + paddingLeft);
                     player2.setSpriteY(paddingTop - 40);
	    		 }
	    	 }
			if (GameVariables.initPet[1][0] == 1) {
				if (moveIndex < 4 && GameVariables.initPet[1][1] < 4 ) {

    		 		g.drawImage(selectImage, 115 + GameVariables.initPet[1][1] * 126, 320, Globe.ANCHOR_T_L);
				} else if (moveIndex < 4){

				} else if (GameVariables.initPet[1][1] >= 4){
//					g.drawImage(selectImage, 115, 320, Globe.ANCHOR_T_L);
                    g.drawImage(selectImage, 115 + (GameVariables.initPet[1][1]-4) * 126, 320, Globe.ANCHOR_T_L);
                        }
                    }
                }

		 //���Ƽ�ͷ
		 moveIndex = petFlyIndex > petLandIndex ? petFlyIndex : petLandIndex;
		 if(petNameLand.length > 4){
			 if(moveIndex < 4){
				 g.drawImage(arrowImage[1], 588-indexFrame, paddingTop - 100, 20);
			 }else{
				 g.drawImage(arrowImage[0], 35+indexFrame, paddingTop - 100, 20);
			 }
		 }
		/* //����ѡ���
		 for (int i = 0; i < GameVariables.initPet.length; i++) {
			 if (GameVariables.initPet[i][0] == 1) {
				g.drawImage(selectImage, 115 + (GameVariables.initPet[i][1]+5)/5*5 * 96, i * 160 + 160, Globe.ANCHOR_T_L);
			 }
		 }*/
		 //������ʾ����
		 int color = g.getColor();
		 g.setColor(0xffffff);
		 //g.setFont(Globe.BigBoldFont);
		 g.drawString("������ʹӢ���Զ�������Եõ��������", 90, 5+paddingTop + Globe.currentFont.getHeight()*3, 20);
		 //g.drawString("�� �� �л�½�س���ѡ��ͬʱӵ�з��С�½�س�", 90, paddingTop + 100 + Globe.currentFont.getHeight() * 2, 20);
		 //g.drawString("��\"1\"����������ѡ��", 90, paddingTop + 110 + Globe.currentFont.getHeight() * 3, 20);
		 g.setColor(color);

		 //����ȷ��������
		 g.drawImage(okImage[0], Globe.SW / 2 - 85, Globe.SH / 2 + 140, 20);
//		 g.drawImage(backImage[0], Globe.SW / 2 - 150, Globe.SH / 2 + 125, 20);
		 if (petSelectIndex == 2) {
			 g.drawImage(okImage[1], Globe.SW / 2 - 85, Globe.SH / 2 + 140, 20);
//			 g.drawImage(petDownImage[2], Globe.SW / 2 + 40+indexFrame, Globe.SH / 2 + 135, Graphics.HCENTER|Graphics.VCENTER);
		}
//         else if (petConfirmIndex == 1 && petSelectIndex == 2) {
//			g.drawImage(okImage[1], Globe.SW / 2 - 90, Globe.SH / 2 + 130, 20);
//			g.drawImage(petDownImage[2], Globe.SW / 2 - 170+indexFrame, Globe.SH / 2 + 135, Graphics.HCENTER|Graphics.VCENTER);
//		}

        player2.setAnimation(0);
        player2.setFrame((num+1)%player2.getFrameCount());
        if(countNum++%3==0){
            num++;
        }
        player2.drawFrame(g);

        if(petSelectIndex==2){
            g.drawImage(indexImage, 380 + indexFrame, 445, Graphics.HCENTER | Graphics.VCENTER);
        }

	}

	public void clear() {
		// TODO Auto-generated method stub
		selectImage = null;
//		selectedImage = null;
		petSelectIndex = 0;

//		petMotionFly = null;
        for (int i=0; i<petMotionFly.length; i++){
            petMotionFly[i].motionData=null;
            for(int j=0; j<petMotionFly[i].vecMotionData.size();j++){
                petMotionFly[i].vecMotionData.removeElementAt(j);
            }
            petMotionFly[i] = null;
        }
        petMotionFly = null;
        for(int i=0; i<petMotionLand.length;i++){
            petMotionLand[i].motionData=null;
            for(int j=0; j<petMotionLand[i].vecMotionData.size();j++){
                petMotionLand[i].vecMotionData.removeElementAt(j);
            }
            petMotionLand[i]=null;
        }
		petMotionLand = null;
		petDownImage = null;
//        petBuyImage=null;
//        petUseImage=null;


        //����ͼƬ
//        petBgImage = null;

//        for(int i=0; i<petYuanImage.length;i++){
//            petYuanImage[i] = null;
//        }
//        petYuanImage = null;
        //����ͼƬ
        petBuyImage = new Image[2];
        for(int i=0; i<petBuyImage.length;i++){
            petBuyImage[i] = Globe.getImage("game/pets/buy0"+(i+1)+".png");
        }
        //ʹ��ͼƬ
//        for(int i=0; i<petUseImage.length;i++){
//            petUseImage[i] = null;
//        }
//        petUseImage = null;
        //��ͷ
        for(int i=0; i<arrowImage.length;i++){
            arrowImage[i] = null;
        }
        arrowImage = null;
        //���г�
        for(int i=0; i<petNameFly.length; i++){
            petNameFly[i] = null;
        }
        petNameFly = null;

//        petMotionFly = new Motion[petNameFly.length];
//        for(int i=0; i<petNameFly.length; i++){
//            String pet = "/game/pets/" + petNameFly[i] + ".anu";
//            petMotionFly[i] = new Motion(pet, 0, 0);
//        }
        //½�س�
        for(int i=0; i<petNameLand.length; i++){
            petNameLand[i] = null;
        }
        petNameLand = null;
//        petMotionLand = new Motion[petNameLand.length];
//        for(int i=0; i<petNameLand.length; i++){
//            String pet = "/game/pets/" + petNameLand[i] + ".anu";
//            petMotionLand[i] = new Motion(pet, 0, 0);
//        }
//        okImage = new Image[2];
//        backImage = new Image[2];
        for (int i = 1; i < 3; i++) {
            okImage[i-1] = null;
//            backImage[i-1] = null;
        }
        okImage = null;
//        backImage = null;

        rectAnimationData = null;

        indexImage = null;
        //ѡ���ͼƬ
//        selectImage = Globe.download.creatImage("game/pets/select.png");
//        selectedImage = Globe.download.creatImage("stageSelect/subselect.png");
        Runtime.getRuntime().gc();
	}

}
