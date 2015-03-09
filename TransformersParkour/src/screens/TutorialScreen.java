package screens;

import javax.microedition.lcdui.Graphics;

import Entry.LWGameCanvas;
import common.GameVariables;
import common.Globe;
import common.Screen;
import elements.Hero;

public class TutorialScreen extends Screen {
	//��������
	int tutorialType;
	//���ش���
	public static Screen returnScreen;
	//��ʼ��
	public static final int TUTORIALTYPE_INIT=0;
	//��
	public static final int TUTORIALTYPE_SHIELD=1;
	//��
	public static final int TUTORIALTYPE_CLOUD=2;
	//��ʯ
	public static final int TUTORIALTYPE_MAGNET=3;
	//����
	public static final int TUTORIALTYPE_FLY=4;
	//����
	public static final int TUTORIALTYPE_END=5;
	//��ͣ
	public static final int TUTORIALTYPE_PAUSE=6;
	//��ʾ�ı���Ϣ
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
			tutorialInfo = "��Ϸ�У����� Ϊ��Ծ����������������";
			break;
		case TUTORIALTYPE_SHIELD:
			tutorialInfo = "�޵�״̬���ɷ������⹥��������1��������";
			break;
		case TUTORIALTYPE_CLOUD:
			tutorialInfo = "�ٻ����ƣ���Ӷ�������һ��ƽ��������2��������";
			break;
		case TUTORIALTYPE_MAGNET:
			tutorialInfo = "ʹ�ô�ʯ���Զ��������ߣ�����3��������";
			break;
		case TUTORIALTYPE_FLY:
			tutorialInfo = "����״̬������һ���ϰ�������OK��������";
			break;
		case TUTORIALTYPE_PAUSE:
			tutorialInfo = "��Ϸ��ͣ��˼��һ�£��������������� ,�ٰ��¡���������Ϸ����";
			break;
		case TUTORIALTYPE_END:
			tutorialInfo = "�̳̽�������ʼ����ܿ�ɣ�����OK�����˳��̳̣�";
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
		case TUTORIALTYPE_SHIELD: //����
			if(LWGameCanvas.iskeyPressed(Globe.M_KEY_1)) {
				GamingScreen.hero.setState(Hero.STAGE_INVINCIBLE);
				tutorialAction();
			}
			break;
		case TUTORIALTYPE_CLOUD: //����
			if(LWGameCanvas.iskeyPressed(Globe.M_KEY_2)) {
				GamingScreen.isFillYun = true;
				tutorialAction();
			}
			break;
		case TUTORIALTYPE_MAGNET: //��ʯ
			if(LWGameCanvas.iskeyPressed(Globe.M_KEY_3)) {
				GamingScreen.isFillYun = true;
				if (!GamingScreen.hero.isXiJin) {
					GamingScreen.hero.setState(Hero.STAGE_XIJIN);
				}
				tutorialAction();
			}
			break;
		case TUTORIALTYPE_FLY: //����
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
