package iptvNet;


import Entry.LWGameCanvas;
import org.json.me.JSONException;

import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import java.io.IOException;


public class The9InputScreen {
	private static int SCREEN_W = 640;
	private static int SCREEN_H = 530;
	
	private static int KEY_UP = -1;
	private static int KEY_DOWN = -2;
	private static int KEY_LEFT = -3;
	private static int KEY_RIGHT = -4;
	
	private static int KEY_0 = 48;
	private static int KEY_1 = 49;
	private static int KEY_2 = 50;
	private static int KEY_3 = 51;
	private static int KEY_4 = 52;
	private static int KEY_5 = 53;
	private static int KEY_6 = 54;
	private static int KEY_7 = 55;
	private static int KEY_8 = 56;
	private static int KEY_9 = 57;
	private static int KEY_OK = -5;
	private static int KEY_SOFT_R0 = -7;// right soft key
	private static int KEY_SOFT_R1 = 7;// right soft key
	private static int KEY_SOFT_R2 = -31;// right soft key
	private static int KEY_SOFT_R3 = -8;// right soft key
	

	private static int INPUT_STRING_MAX_LENGHT=8;

	private Image img[];
	
	private final int STAGE_INPUT_RECHARGE = 0;//��ֵ����
	private final int STAGE_INPUT_PASSWORD = 1;//����ͯ������
	private int stage = STAGE_INPUT_RECHARGE;
	
	private NetHander netHander;
	private boolean hasVerificationCode = false;
	private boolean isPayEnd = false;
	private boolean isPayOk = false;
	private String inputString = "";
	
	private String question;
	private String answer;
	
	/**
	 * ���߼۸�
	 */
	private int price = 0;
	/**
	 * ��Ҫ��ֵ
	 */
	private int rechargeNum = 0;
	private String wareName = "";
	
	private String showInfo = "";
	private boolean isShow = false;
	private int showInfoIndex = 0;
	private long showStartTime = 0;
	
	
	/**
	 * ѡ��Ľ���
	 */
	private int selectIndex = 0;
	private int selectIndexUD = 0;
	
	public The9InputScreen(NetHander nHander, int price, int rechargeNum, String wareName){
		this.netHander = nHander;
		this.price = price;
		this.rechargeNum = rechargeNum;
		this.wareName = wareName;
		init();
	}
	
	public void update(int keycode) {
		// TODO Auto-generated method stub
		if(isPayEnd){
			return;
		}
		switch(stage){
		case STAGE_INPUT_RECHARGE:
			updateStageRecharge(keycode);
			break;
		case STAGE_INPUT_PASSWORD:
			updateStagePassword(keycode);
			break;
		}
		updateShowInfo(keycode);
	}


	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		if(isPayEnd){
			return;
		}
		g.drawImage(img[0], SCREEN_W>>1, SCREEN_H>>1, Graphics.RIGHT|Graphics.VCENTER);
		g.drawRegion(img[0], 0,0,img[0].getWidth(),img[0].getHeight(),
				2,SCREEN_W>>1, SCREEN_H>>1, Graphics.LEFT|Graphics.VCENTER);
		switch(stage){
		case STAGE_INPUT_RECHARGE:
			drawRecharge(g);
			break;
		case STAGE_INPUT_PASSWORD:
			drawPassword(g);
			break;
		}
		drawShowInfo(g);
	}
	
	private void setPayEnd(boolean isEnd){
		isPayEnd = isEnd;
		clear();
	}
	
	private void setPayOK(boolean isOk){
		isPayOk = isOk;
	}
	
	private void clear() {
		// TODO Auto-generated method stub
		if(img!=null){
			for(int i = 0;i<img.length;i++){
				img[i] = null;
			}
			img = null;
		}
	}

	private void init() {
			// TODO Auto-generated method stub
			inputString = "";
			hasVerificationCode = false;
			setPayEnd(false);
			setPayOK(false);
			try {
				hasVerificationCode = netHander.hasVerificationCode();
				question = netHander.getQuestion();
				answer = netHander.getAnswer();
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IptvNetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			stage = STAGE_INPUT_RECHARGE;
//			if(hasVerificationCode){
//				selectIndexUD = 0;
//			}else{
				selectIndexUD = 1;
                if(LWGameCanvas.rmidlet.getAppProperty("IsButtonOnOK").equals("true")) {
                    selectIndex = 0;
                }else {
                    selectIndex = 1;
                }
//			}
			img = new Image[7];
			try {
				img[0] = Image.createImage("/the9Input/bg.jpg");
				img[1] = Image.createImage("/the9Input/4.png");
				img[2] = Image.createImage("/the9Input/5.png");
				img[3] = Image.createImage("/the9Input/sr.png");
				img[4] = Image.createImage("/the9Input/2_1.png");
				img[5] = Image.createImage("/the9Input/7.png");
                img[6] = Image.createImage("/the9Input/2_2.png");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	//		hasVerificationCode = false;
		}

	private void updateStageRecharge(int keycode){
		if(isShow){
			return;
		}
		if(keycode==KEY_LEFT){
			if(selectIndexUD==1){
				selectIndex--;
			}
			
		}else if(keycode==KEY_RIGHT){
			if(selectIndexUD==1){
				selectIndex++;
			}
		}else if(keycode==KEY_UP){
			if(hasVerificationCode){
				if(selectIndexUD==1){
					selectIndexUD--;
				}
			}
		}else if(keycode==KEY_DOWN){
			if(hasVerificationCode){
				if(selectIndexUD==0){
					selectIndexUD++;
				}
			}
		}
		selectIndex = (selectIndex+2)%2;
		if(selectIndexUD==0){
			if(hasVerificationCode){
				int keyTemp[] = {KEY_0,KEY_1,KEY_2,KEY_3,KEY_4,KEY_5,KEY_6,KEY_7,KEY_8,KEY_9};
				for(int i = 0;i<10;i++){
					if(keycode==keyTemp[i]){
						if(inputString.length()<INPUT_STRING_MAX_LENGHT){
							inputString+=(i+"");
						}
						break;
					}
				}
			}
			if(keycode==KEY_OK){
				if(hasVerificationCode){
					if(inputString.equals(answer)){
						inputString = "";//��һ�ε���,passwordΪ�գ�����ɹ�����ʾû��ͯ��
						payPassWord();
					}else{
						setShow("���벻��ȷ������������");
					}
				}else{
					payPassWord();
				}
			}
		}
		
		if(keycode==KEY_OK){
			if(selectIndexUD==1){
				if(selectIndex==0){
					if(hasVerificationCode){
						if(inputString.equals(answer)){
							inputString = "";//��һ�ε���,passwordΪ�գ�����ɹ�����ʾû��ͯ��
							payPassWord();
						}else{
							setShow("���벻��ȷ������������");
						}
					}else{
						payPassWord();
					}
				}else if(selectIndex==1){
					setPayEnd(true);
					setPayOK(false);
				}
			}
		}else if(keycode==KEY_SOFT_R0||keycode==KEY_SOFT_R1||keycode==KEY_SOFT_R2||keycode==KEY_SOFT_R3){
			if(selectIndexUD==0){
				if(hasVerificationCode){//�������֤��
					if(inputString.length()>0){
						inputString = inputString.substring(0, inputString.length()-1);
					}
				}
			}
		}
	}

	private void updateStagePassword(int keycode){
		if(isShow){
			return;
		}
		if(keycode==KEY_LEFT){
			if(selectIndexUD==1){
				selectIndex--;
			}
			
		}else if(keycode==KEY_RIGHT){
			if(selectIndexUD==1){
				selectIndex++;
			}
		}else if(keycode==KEY_UP){
			if(selectIndexUD==1){
				selectIndexUD--;
			}
		}else if(keycode==KEY_DOWN){
			if(selectIndexUD==0){
				selectIndexUD++;
			}
		}
		selectIndex = (selectIndex+2)%2;
		if(selectIndexUD==0){
			int keyTemp[] = {KEY_0,KEY_1,KEY_2,KEY_3,KEY_4,KEY_5,KEY_6,KEY_7,KEY_8,KEY_9};
			for(int i = 0;i<10;i++){
				if(keycode==keyTemp[i]){
					if(inputString.length()<INPUT_STRING_MAX_LENGHT){
						inputString+=(i+"");
					}
					break;
				}
			}
			if(keycode==KEY_OK){
				int temp = payPassWord();
				if(temp==1){
					setShow("����������������������");
				}
			}
		}
		
		if(keycode==KEY_OK){
			if(selectIndexUD==1){
				if(selectIndex==0){
					int temp = payPassWord();
					if(temp==1){
						setShow("����������������������");
					}
				}else if(selectIndex==1){
					setPayEnd(true);
					setPayOK(false);
				}
			}
		}else if(keycode==KEY_SOFT_R0||keycode==KEY_SOFT_R1||keycode==KEY_SOFT_R2||keycode==KEY_SOFT_R3){
			if(selectIndexUD==0){
				if(inputString.length()>0){
					inputString = inputString.substring(0, inputString.length()-1);
				}
			}
		}
		
	}

	private void drawShowInfo(Graphics g){
		if(isShow){
			g.drawImage(img[5], SCREEN_W>>1, SCREEN_H>>1, Graphics.HCENTER|Graphics.VCENTER);
		}
	}
	
	private void setStagePassword(){
		stage = STAGE_INPUT_PASSWORD;
		if(img==null){
			img = new Image[7];
			try {
				img[0] = Image.createImage("/the9Input/bg.jpg");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		try {
			img[1] = Image.createImage("/the9Input/3.png");
			img[2] = Image.createImage("/the9Input/1.png");
			img[3] = Image.createImage("/the9Input/sr.png");
			img[4] = Image.createImage("/the9Input/2_1.png");
			img[5] = Image.createImage("/the9Input/7.png");
            img[6] = Image.createImage("/the9Input/2_2.png");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		selectIndex = 0;
		selectIndexUD = 0;
		inputString = "";
	}
	
	private void setShow(String str){
		isShow = true;
		showInfo = str;
		showInfoIndex = 0;
		showStartTime = System.currentTimeMillis();
	}
	
	private void updateShowInfo(int keycode){
		if(isShow){
			showInfoIndex++;
			if(showInfoIndex==40||(showInfoIndex>10&&keycode!=0)||(System.currentTimeMillis()-showStartTime>500&&keycode!=0)){
				isShow = false;
				showInfoIndex = 0;
				inputString = "";
			}
		}
	}

	
	private void drawPassword(Graphics g){
		
		int startY = SCREEN_H/2;
		g.drawImage(img[1], SCREEN_W>>1, startY-60, Graphics.HCENTER|Graphics.BOTTOM);
		g.drawImage(img[2], SCREEN_W>>1, startY, Graphics.HCENTER|Graphics.BOTTOM);
		g.drawImage(img[3], (SCREEN_W>>1), startY+20, Graphics.TOP|Graphics.HCENTER);
		g.setFont(Font.getFont(0, 1, 16));
		g.setColor(0x000000);
		String temp = "";
		for(int i = 0;i<inputString.length();i++){
			temp+="*";
		}
		g.drawString(temp, SCREEN_W>>1, startY+68,  Graphics.BOTTOM|Graphics.HCENTER);
		g.drawImage(img[4], (SCREEN_W>>1)-100, startY+100, Graphics.TOP|Graphics.HCENTER);
        g.drawImage(img[6], (SCREEN_W>>1)+120, startY+100, Graphics.TOP|Graphics.HCENTER);
		g.setColor(0xffff00);
		
		int w = 150;
		int h = 60;
		if(selectIndexUD==0){
			g.drawRect((SCREEN_W>>1)-70-1, startY+43-h/2-1, w+2+165, h+2);
			g.drawRect((SCREEN_W>>1)-70+1, startY+43-h/2+1, w-2+165, h-2);
			g.drawRect((SCREEN_W>>1)-70, startY+43-h/2, w+165, h);
		}else{
			g.drawRect((SCREEN_W>>1)-120-w/2+(selectIndex*240)-1, startY+122-h/2-1, w+2, h+2);
			g.drawRect((SCREEN_W>>1)-120-w/2+(selectIndex*240)+1, startY+122-h/2+1, w-2, h-2);
			g.drawRect((SCREEN_W>>1)-120-w/2+(selectIndex*240), startY+122-h/2, w, h);
		}
	}
	
	private void drawRecharge(Graphics g){
		int startY = SCREEN_H/2;
		g.drawImage(img[1], SCREEN_W>>1, startY+60, Graphics.HCENTER|Graphics.BOTTOM);
		g.setFont(Font.getFont(0, 1, 16));
		g.setColor(0x000000);
//		g.drawLine(0, startY-120, 640, startY-120);
		g.drawString(""+rechargeNum, (SCREEN_W>>1)+90, startY-160, Graphics.HCENTER|Graphics.TOP);
//		g.drawString(""+rechargeNum, (SCREEN_W>>1)+35, startY-98, Graphics.HCENTER|Graphics.TOP);
		if(hasVerificationCode){
			g.drawImage(img[2], SCREEN_W>>1, startY, Graphics.HCENTER|Graphics.BOTTOM);
			g.drawImage(img[3], (SCREEN_W>>1)-55, startY+20, Graphics.TOP|Graphics.LEFT);
			g.setColor(0x000000);
//			g.drawLine(0, startY+62, 640, startY+62);
			g.drawString(""+question, (SCREEN_W>>1)-60, startY+62, Graphics.BOTTOM|Graphics.RIGHT);
			g.drawString(""+inputString,  (SCREEN_W>>1)-50, startY+62, Graphics.BOTTOM|Graphics.LEFT);
		}
		g.drawImage(img[4], (SCREEN_W>>1)-100, startY+100, Graphics.TOP|Graphics.HCENTER);
        g.drawImage(img[6], (SCREEN_W>>1)+120, startY+100, Graphics.TOP|Graphics.HCENTER);
		g.setColor(0xffff00);
		int w = 150;
		int h = 60;
		if(selectIndexUD==0){
			g.drawRect((SCREEN_W>>1)-70-1, startY+43-h/2-1, w+2+165, h+2);
			g.drawRect((SCREEN_W>>1)-70+1, startY+43-h/2+1, w-2+165, h-2);
			g.drawRect((SCREEN_W>>1)-70, startY+43-h/2, w+165, h);
		}else{
			g.drawRect((SCREEN_W>>1)-120-w/2+(selectIndex*240)-1, startY+122-h/2-1, w+2, h+2);
			g.drawRect((SCREEN_W>>1)-120-w/2+(selectIndex*240)+1, startY+122-h/2+1, w-2, h-2);
			g.drawRect((SCREEN_W>>1)-120-w/2+(selectIndex*240), startY+122-h/2, w, h);
		}
	}
	
	private int payPassWord(){
		int ret = 2;
		try {
			ret = netHander.topupAndConsumeMoney(price, wareName, inputString);
			if(ret==0){
				setPayEnd(true);
				setPayOK(true);
			}else if(ret==1){
				setStagePassword();
			}else if(ret==2){
				setPayEnd(true);
				setPayOK(false);
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			setPayEnd(true);
			setPayOK(false);
			e.printStackTrace();
		} catch (IptvNetException e) {
			// TODO Auto-generated catch block
			setPayEnd(true);
			setPayOK(false);
			e.printStackTrace();
		}
		return ret;
	}
	
	/**
	 * 
	 * @return trueΪ֧���ɹ�,flaseΪ֧��ʧ��
	 */
	public boolean isPayOk(){
		return isPayOk;
	}
	
	/**
	 * 
	 * @return trueΪ��֤��Ҳͯ��֧��������ɣ�falseΪ��δ���
	 */
	public boolean isPayEnd(){
		return isPayEnd;
	}

	
	/**
	 * �˽ӿ�Ԥ��,Ĭ��ֵ��640*530,��������С��������ߴ磬���Ե�����������޸�
	 * @param w
	 * @param h
	 */
	public static void setScreenWidthAndHeight(int w,int h){
		SCREEN_W = w;
		SCREEN_H = h;
	}
	
	/**
	 *  �˽ӿ�Ԥ��,���ð�����ֵ�����л����еļ�ֵ���Ѿ����ú��ˣ��˽ӿ�Ԥ����
	 * @param key ������Ԫ�����·���ļ�ֱ��˳��ֱ���
	 * �ϣ��£����ң����ּ�0-9��ȷ�ϼ������ؼ�1�����ؼ�2,���ؼ�3,���ؼ�4
	 */
	public static void setKeyCode(int[]key){
		KEY_UP = key[0];
		KEY_DOWN = key[1];
		KEY_LEFT = key[2];
		KEY_RIGHT = key[3];
		KEY_0 = key[4];
		KEY_1 = key[5];
		KEY_2 = key[6];
		KEY_3 = key[7];
		KEY_4 = key[8];
		KEY_5 = key[9];
		KEY_6 = key[10];
		KEY_7 = key[11];
		KEY_8 = key[12];
		KEY_9 = key[13];
		KEY_OK = key[14];
		KEY_SOFT_R0 = key[15];
		KEY_SOFT_R1 = key[16];
		KEY_SOFT_R2 = key[17];
		KEY_SOFT_R3 = key[18];
	}
	
	/**
	 * �˽ӿ�Ԥ����Ĭ��ֵ��8λ�����ô˷��������޸������ַ�������󳤶�
	 * @param lenght Ҫ�޸ĵ��ַ������볤�ȣ�Ĭ��ֵ��8λ��
	 */
	public static void setInputStringMaxLength(int lenght){
		INPUT_STRING_MAX_LENGHT = lenght;
	}
	
}
